package com.jdhs.project.font.page.controller;

import com.jdhs.common.utils.bean.BeanUtils;
import com.jdhs.common.utils.redis.RedisCache;
import com.jdhs.framework.web.controller.BaseController;
import com.jdhs.framework.web.domain.AjaxResult;
import com.jdhs.project.font.page.domain.PcLoginDto;
import com.jdhs.project.system.banner.domain.FontBanner;
import com.jdhs.project.system.banner.service.IFontBannerService;
import com.jdhs.project.system.fenlei.domain.FontGoodsFenlei;
import com.jdhs.project.system.fenlei.service.IFontGoodsFenleiService;
import com.jdhs.project.system.goods.domain.FontGoods;
import com.jdhs.project.system.goods.service.IFontGoodsService;
import com.jdhs.project.system.preuser.domain.FontPreuser;
import com.jdhs.project.system.preuser.service.IFontPreuserService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 商品管理Controller
 * 
 * @author jdhs
 * @date 2022-05-11
 */
@Controller
@RequestMapping("")
public class FontIndexController extends BaseController
{
    private String prefix = "font";

    @Autowired
    private RedisCache redisCache;

    @Resource
    private IFontPreuserService fontPreuserService;

    @Autowired
    private IFontGoodsFenleiService fontGoodsFenleiService;

    @Autowired
    private IFontBannerService fontBannerService;

    @Autowired
    private IFontGoodsService fontGoodsService;

    @GetMapping("/index.html")
    public String index(ModelMap mmap, HttpSession session)
    {
        /*用户*/
        FontPreuser user = (FontPreuser)session.getAttribute("user");
        mmap.put("user",user);
        mmap.put("goodsCount", 0);
        mmap.put("total", 0);
        /*分类*/
        FontGoodsFenlei fontGoodsFenlei = new FontGoodsFenlei();
        fontGoodsFenlei.setGrade(1l);
        List<FontGoodsFenlei> list = fontGoodsFenleiService.selectFontGoodsFenleiList(fontGoodsFenlei);
        mmap.put("categories", list);

        fontGoodsFenlei.setGrade(2l);
        List<FontGoodsFenlei> list2 = fontGoodsFenleiService.selectFontGoodsFenleiList(fontGoodsFenlei);
        mmap.put("categoryTwos", list2);

        List<FontBanner> banners = fontBannerService.selectFontBannerList(new FontBanner());

        FontGoods goods = new FontGoods();
        goods.setJbStatus(2);
        List<FontGoods> cheaper = fontGoodsService.selectFontGoodsList(goods);
        goods.setJbStatus(1);
        List<FontGoods> chosen = fontGoodsService.selectFontGoodsList(goods);

        mmap.addAttribute("goodsCount","0");
        mmap.addAttribute("cartGoods",null);
        mmap.addAttribute("total",0);
        mmap.addAttribute("banners",banners);
        mmap.addAttribute("cheaper",cheaper);
        mmap.addAttribute("goodsAll","");
        mmap.addAttribute("chosen",chosen);
        return prefix + "/index";
    }

    @GetMapping("/pc/head.html")
    public String commonHead()
    {
        return prefix + "/common/head";
    }

    @GetMapping("/pc/features.html")
    public String features()
    {
        return prefix + "/common/features";
    }

    @GetMapping("/pc/footer.html")
    public String footer()
    {
        return prefix + "/common/footer";
    }

    @PermissionAnnotation
    @GetMapping("/goodsList.html")
    public String goodsList()
    {
        return prefix + "/goodsList";
    }


    @GetMapping("/pclogin.html")
    public String pcloginPage()
    {
        return prefix + "/login";
    }

    @PostMapping("/pclogin")
    @ResponseBody
    public AjaxResult pcloginAjax(@RequestBody PcLoginDto pcLoginDto, HttpSession session){
        FontPreuser fontPreuser = new FontPreuser();
        BeanUtils.copyProperties(pcLoginDto,fontPreuser);
        FontPreuser _p = fontPreuserService.pcLogin(fontPreuser);
        if (null != _p){
            session.setAttribute("user",_p);
            String token = System.currentTimeMillis()+"";
            redisCache.setCacheObject(token,_p.getUserId().toString(),10, TimeUnit.MINUTES);
            return AjaxResult.success(token);
        }

        return AjaxResult.error("账户或密码错误");
    }

    @PermissionAnnotation
    @PostMapping("/pc/getuserInfo")
    @ResponseBody
    public AjaxResult getuserInfo(String token){
        String useIdStr = redisCache.getCacheObject(token).toString();
        Long id = Long.valueOf(useIdStr);
        FontPreuser preuser = fontPreuserService.selectFontPreuserByUserId(id);
        return AjaxResult.success(preuser);
    }

    @GetMapping("/register.html")
    public String registerPage()
    {
        return prefix + "/register";
    }

    @PostMapping("/pc/register")
    @ResponseBody
    public AjaxResult register(@RequestBody FontPreuser user){
        fontPreuserService.insertFontPreuser(user);
        return AjaxResult.success();
    }

    @GetMapping("/pc/goodsDetail/{id}")
    public String goodsDetail( HttpSession session,ModelMap mmap,@PathVariable("id") Long id){

        // 获取用户 ID
        FontPreuser user = (FontPreuser) session.getAttribute("user");
        if (null == user){
            return prefix + "/login";
        }
        FontGoodsFenlei fontGoodsFenlei = new FontGoodsFenlei();
        fontGoodsFenlei.setGrade(1l);
        List<FontGoodsFenlei> list = fontGoodsFenleiService.selectFontGoodsFenleiList(fontGoodsFenlei);
        mmap.put("categories", list);

        fontGoodsFenlei.setGrade(2l);
        List<FontGoodsFenlei> list2 = fontGoodsFenleiService.selectFontGoodsFenleiList(fontGoodsFenlei);
        mmap.put("categoryTwos", list2);


        //商品详情
        FontGoods goods =  fontGoodsService.selectFontGoodsById(id);
        String categoryId = goods.getCategoryId();
        Long sellerId = goods.getSellerId();
        FontGoodsFenlei category = fontGoodsFenleiService.selectFontGoodsFenleiByName(categoryId);
//        FontGoodsFenlei category = fontGoodsFenleiService.selectFontGoodsFenleiById(categoryId);
        FontPreuser fontPreuser = fontPreuserService.selectFontPreuserByUserId(sellerId);
        mmap.put("user",user);
        mmap.addAttribute("goodsId",id);
        mmap.addAttribute("goods",goods);
        mmap.addAttribute("category",category);
        mmap.addAttribute("seller",fontPreuser);
        return prefix + "/goodsDetail";
    }


    @GetMapping("/pc/personInfo")
    public String personInfo( HttpSession session,ModelMap mmap){
        // 获取用户 ID
        FontPreuser user = (FontPreuser) session.getAttribute("user");
        if (null == user){
            return prefix + "/login";
        }
        user = fontPreuserService.selectFontPreuserByUserId(user.getUserId());
        mmap.put("user",user);
        FontGoodsFenlei fontGoodsFenlei = new FontGoodsFenlei();
        fontGoodsFenlei.setGrade(1l);
        List<FontGoodsFenlei> list1 = fontGoodsFenleiService.selectFontGoodsFenleiList(fontGoodsFenlei);
        mmap.put("categories", list1);

        fontGoodsFenlei.setGrade(2l);
        List<FontGoodsFenlei> list2 = fontGoodsFenleiService.selectFontGoodsFenleiList(fontGoodsFenlei);
        mmap.put("categoryTwos", list2);

        return prefix + "/personInfo";
    }

    @PostMapping("/pc/updateUser")
    @ResponseBody
    public AjaxResult updateUser(@RequestBody FontPreuser user){
        fontPreuserService.updateFontPreuser(user);
        return AjaxResult.success();
    }

    @GetMapping("/pc/search.html")
    public String searchResult(ModelMap mmap, HttpSession session,String search){
        FontPreuser user = (FontPreuser) session.getAttribute("user");
        if (null == user){
            return prefix + "/login";
        }
        user = fontPreuserService.selectFontPreuserByUserId(user.getUserId());
        mmap.put("user",user);
        mmap.addAttribute("sName",search);
        List<FontGoods> list = fontGoodsService.selectFontGoodsByName(search);
        mmap.addAttribute("goodsCount",list.size());
        mmap.addAttribute("search",list);

        FontGoodsFenlei fontGoodsFenlei = new FontGoodsFenlei();
        fontGoodsFenlei.setGrade(1l);
        List<FontGoodsFenlei> list1 = fontGoodsFenleiService.selectFontGoodsFenleiList(fontGoodsFenlei);
        mmap.put("categories", list1);

        fontGoodsFenlei.setGrade(2l);
        List<FontGoodsFenlei> list2 = fontGoodsFenleiService.selectFontGoodsFenleiList(fontGoodsFenlei);
        mmap.put("categoryTwos", list2);
        return prefix + "/search";
    }

    @GetMapping("/pc/subheading.html/{jb_status}")
    public String subheading(ModelMap mmap, HttpSession session,@PathVariable Integer jb_status){
        FontPreuser user = (FontPreuser) session.getAttribute("user");
        if (null == user){
            return prefix + "/login";
        }
        user = fontPreuserService.selectFontPreuserByUserId(user.getUserId());
        mmap.put("user",user);
        FontGoods fontGoods = new FontGoods();
        fontGoods.setJbStatus(jb_status);
        List<FontGoods> list = fontGoodsService.selectFontGoodsList(fontGoods);
        mmap.addAttribute("goodsCount",list.size());
        mmap.addAttribute("search",list);
        mmap.addAttribute("subStatus",jb_status);

        FontGoodsFenlei fontGoodsFenlei = new FontGoodsFenlei();
        fontGoodsFenlei.setGrade(1l);
        List<FontGoodsFenlei> list1 = fontGoodsFenleiService.selectFontGoodsFenleiList(fontGoodsFenlei);
        mmap.put("categories", list1);

        fontGoodsFenlei.setGrade(2l);
        List<FontGoodsFenlei> list2 = fontGoodsFenleiService.selectFontGoodsFenleiList(fontGoodsFenlei);
        mmap.put("categoryTwos", list2);
        return prefix + "/subheading";
    }

    @GetMapping("/pc/catelist.html/{type}")
    public String subheading(ModelMap mmap, HttpSession session,@PathVariable Long type){
        FontPreuser user = (FontPreuser) session.getAttribute("user");
        if (null == user){
            return prefix + "/login";
        }
        user = fontPreuserService.selectFontPreuserByUserId(user.getUserId());
        mmap.put("user",user);
        FontGoods fontGoods = new FontGoods();
        FontGoodsFenlei category = fontGoodsFenleiService.selectFontGoodsFenleiById(type);
        fontGoods.setCategoryId(category.getName());
        List<FontGoods> list = fontGoodsService.selectFontGoodsList(fontGoods);
        mmap.addAttribute("goodsCount",list.size());
        mmap.addAttribute("search",list);


        FontGoodsFenlei _fontGoodsFenlei = fontGoodsFenleiService.selectFontGoodsFenleiById(type);
        mmap.put("category", _fontGoodsFenlei);

        FontGoodsFenlei fontGoodsFenlei = new FontGoodsFenlei();
        fontGoodsFenlei.setPid(type);
        List<FontGoodsFenlei> flist2 = fontGoodsFenleiService.selectFontGoodsFenleiList(fontGoodsFenlei);
        mmap.put("categoryTwos", flist2);


        fontGoodsFenlei.setGrade(1l);
        List<FontGoodsFenlei> list1 = fontGoodsFenleiService.selectFontGoodsFenleiList(fontGoodsFenlei);
        mmap.put("categories", list1);

        return prefix + "/cate_list";
    }



    @GetMapping("/pc/logout.html")
    public String logout(ModelMap mmap, HttpSession session)
    {
        /*用户*/
        FontPreuser user = (FontPreuser)session.getAttribute("user");
        session.removeAttribute("user");
        mmap.put("user",null);
        mmap.put("goodsCount", 0);
        mmap.put("total", 0);
        /*分类*/
        FontGoodsFenlei fontGoodsFenlei = new FontGoodsFenlei();
        fontGoodsFenlei.setGrade(1l);
        List<FontGoodsFenlei> list = fontGoodsFenleiService.selectFontGoodsFenleiList(fontGoodsFenlei);
        mmap.put("categories", list);

        fontGoodsFenlei.setGrade(2l);
        List<FontGoodsFenlei> list2 = fontGoodsFenleiService.selectFontGoodsFenleiList(fontGoodsFenlei);
        mmap.put("categoryTwos", list2);

        List<FontBanner> banners = fontBannerService.selectFontBannerList(new FontBanner());

        FontGoods goods = new FontGoods();
        goods.setJbStatus(2);
        List<FontGoods> cheaper = fontGoodsService.selectFontGoodsList(goods);
        goods.setJbStatus(1);
        List<FontGoods> chosen = fontGoodsService.selectFontGoodsList(goods);

        mmap.addAttribute("goodsCount","0");
        mmap.addAttribute("cartGoods",null);
        mmap.addAttribute("total",0);
        mmap.addAttribute("banners",banners);
        mmap.addAttribute("cheaper",cheaper);
        mmap.addAttribute("goodsAll","");
        mmap.addAttribute("chosen",chosen);
        return prefix + "/index";
    }

}
