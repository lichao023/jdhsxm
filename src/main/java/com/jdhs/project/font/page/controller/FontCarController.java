package com.jdhs.project.font.page.controller;

import com.jdhs.common.utils.redis.RedisCache;
import com.jdhs.framework.web.controller.BaseController;
import com.jdhs.framework.web.domain.AjaxResult;
import com.jdhs.project.system.express.domain.FontExpress;
import com.jdhs.project.system.express.service.IFontExpressService;
import com.jdhs.project.system.fenlei.domain.FontGoodsFenlei;
import com.jdhs.project.system.fenlei.service.IFontGoodsFenleiService;
import com.jdhs.project.system.goods.domain.FontGoods;
import com.jdhs.project.system.goods.service.IFontGoodsService;
import com.jdhs.project.system.order.domain.FontOrder;
import com.jdhs.project.system.order.service.IFontOrderService;
import com.jdhs.project.system.preuser.domain.FontPreuser;
import com.jdhs.project.system.preuser.service.IFontPreuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 商品管理Controller
 * 
 * @author jdhs
 * @date 2022-05-11
 */
@Controller
@RequestMapping("")
public class FontCarController extends BaseController
{
    private String prefix = "font";

    @Autowired
    private RedisCache redisCache;

    @Resource
    private IFontPreuserService fontPreuserService;

    @Autowired
    private IFontGoodsFenleiService fontGoodsFenleiService;

    @Autowired
    private IFontGoodsService fontGoodsService;

    @Autowired
    private IFontExpressService fontExpressService;

    @GetMapping("/pc/cardetail/{id}")
    public String toCart(@PathVariable Long id, ModelMap mmap, HttpSession session){
        // 获取用户 ID
        FontPreuser user = (FontPreuser) session.getAttribute("user");
        if (null == user){
            return prefix + "/pclogin.html";
        }
        FontGoodsFenlei fontGoodsFenlei = new FontGoodsFenlei();
        fontGoodsFenlei.setGrade(1l);
        List<FontGoodsFenlei> list1 = fontGoodsFenleiService.selectFontGoodsFenleiList(fontGoodsFenlei);
        mmap.put("categories", list1);

        fontGoodsFenlei.setGrade(2l);
        List<FontGoodsFenlei> list2 = fontGoodsFenleiService.selectFontGoodsFenleiList(fontGoodsFenlei);
        mmap.put("categoryTwos", list2);
        List<FontExpress> expresses = fontExpressService.selectFontExpressList(new FontExpress());
        mmap.addAttribute("expresses",expresses);
        FontGoods goods = fontGoodsService.selectFontGoodsById(id);
        mmap.addAttribute("cartGood",goods);
        return prefix + "/frontCart";
    }

    @GetMapping("/pc/orderSub")
    public String orderSub(Long goodsId, Long expressId, HttpSession session,ModelMap mmap){
        // 获取用户 ID
        FontPreuser user = (FontPreuser) session.getAttribute("user");
        if (null == user){
            return prefix + "/pclogin.html";
        }
        mmap.put("user", user);
        FontGoodsFenlei fontGoodsFenlei = new FontGoodsFenlei();
        fontGoodsFenlei.setGrade(1l);
        List<FontGoodsFenlei> list1 = fontGoodsFenleiService.selectFontGoodsFenleiList(fontGoodsFenlei);
        mmap.put("categories", list1);
        fontGoodsFenlei.setGrade(2l);
        List<FontGoodsFenlei> list2 = fontGoodsFenleiService.selectFontGoodsFenleiList(fontGoodsFenlei);
        mmap.put("categoryTwos", list2);

        FontGoods goods = fontGoodsService.selectFontGoodsById(goodsId);
        mmap.addAttribute("cartGood",goods);
        FontExpress express = fontExpressService.selectFontExpressById(expressId);
        mmap.addAttribute("express",express);
        Long total = express.getExpressPrice()+goods.getPrice();
        mmap.addAttribute("totalPrice",total);
        return prefix + "/checkout";
    }

    @Autowired
    private IFontOrderService fontOrderService;

    @PostMapping("/pc/orderCreate")
    @ResponseBody
    public AjaxResult orderCreate(Long expressId,Long goodsId,HttpSession session) {
        // 从 session 中获取会员信息
        FontPreuser user = (FontPreuser)session.getAttribute("user");
        // 创建订单
        FontExpress express = fontExpressService.selectFontExpressById(expressId);
        FontGoods goods = fontGoodsService.selectFontGoodsById(goodsId);
        FontPreuser sellerUser = fontPreuserService.selectFontPreuserByUserId(goods.getSellerId());

        FontOrder fontOrder = new FontOrder();
        fontOrder.setOrderNum(System.currentTimeMillis()+"");
        fontOrder.setGoodsId(goods.getId());
        fontOrder.setSellerName(sellerUser.getRealName());
        fontOrder.setSellerId(sellerUser.getUserId());
        fontOrder.setBuyName(user.getRealName());
        fontOrder.setBuyId(user.getUserId());
        fontOrder.setExpressId(express.getId());
        fontOrder.setExpressName(express.getExpressName());
        fontOrder.setExpressPrice(express.getExpressPrice());
        fontOrder.setGoodsImg(goods.getPicture1());
        fontOrder.setBuyCount(1L);
        fontOrder.setGoodsPrice(goods.getPrice());
        fontOrder.setGoodsName(goods.getGoodsName());
        fontOrder.setOrderStatus("1");
        fontOrderService.insertFontOrder(fontOrder);
        return AjaxResult.success(fontOrder);
    }

    @GetMapping("/pc/myBuyOrder.html")
    public String myBuyOrder(HttpSession session,ModelMap mmap) {
        // 从 session 中获取会员信息
        FontPreuser user = (FontPreuser)session.getAttribute("user");
        if (null == user){
            return prefix + "/login";
        }
        FontGoodsFenlei fontGoodsFenlei = new FontGoodsFenlei();
        fontGoodsFenlei.setGrade(1l);
        List<FontGoodsFenlei> list1 = fontGoodsFenleiService.selectFontGoodsFenleiList(fontGoodsFenlei);
        mmap.put("categories", list1);

        fontGoodsFenlei.setGrade(2l);
        List<FontGoodsFenlei> list2 = fontGoodsFenleiService.selectFontGoodsFenleiList(fontGoodsFenlei);
        mmap.put("categoryTwos", list2);

        FontOrder fontOrder = new FontOrder();
        fontOrder.setBuyId(user.getUserId());
        List<FontOrder> orderList = fontOrderService.selectFontOrderList(fontOrder);
        mmap.put("orderList",orderList);
        mmap.put("user",user);
        return prefix + "/personorder";
    }

    @GetMapping("/pc/mySeOrder.html")
    public String mySeOrder(HttpSession session,ModelMap mmap) {
        // 从 session 中获取会员信息
        FontPreuser user = (FontPreuser)session.getAttribute("user");
        if (null == user){
            return prefix + "/login";
        }
        FontGoodsFenlei fontGoodsFenlei = new FontGoodsFenlei();
        fontGoodsFenlei.setGrade(1l);
        List<FontGoodsFenlei> list1 = fontGoodsFenleiService.selectFontGoodsFenleiList(fontGoodsFenlei);
        mmap.put("categories", list1);

        fontGoodsFenlei.setGrade(2l);
        List<FontGoodsFenlei> list2 = fontGoodsFenleiService.selectFontGoodsFenleiList(fontGoodsFenlei);
        mmap.put("categoryTwos", list2);

        FontOrder fontOrder = new FontOrder();
        fontOrder.setSellerId(user.getUserId());
        List<FontOrder> orderList = fontOrderService.selectFontOrderList(fontOrder);
        mmap.put("orderList",orderList);
        mmap.put("user",user);
        return prefix + "/personorder2";
    }

    @GetMapping("/pc/completed.html")
    public String paySuccess() {
        return prefix + "/completed";
    }
}
