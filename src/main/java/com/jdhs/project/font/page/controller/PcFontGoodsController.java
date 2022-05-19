package com.jdhs.project.font.page.controller;

import com.jdhs.common.utils.poi.ExcelUtil;
import com.jdhs.framework.aspectj.lang.annotation.Log;
import com.jdhs.framework.aspectj.lang.enums.BusinessType;
import com.jdhs.framework.web.controller.BaseController;
import com.jdhs.framework.web.domain.AjaxResult;
import com.jdhs.framework.web.page.TableDataInfo;
import com.jdhs.project.system.express.domain.FontExpress;
import com.jdhs.project.system.express.service.IFontExpressService;
import com.jdhs.project.system.fenlei.domain.FontGoodsFenlei;
import com.jdhs.project.system.fenlei.service.IFontGoodsFenleiService;
import com.jdhs.project.system.goods.domain.FontGoods;
import com.jdhs.project.system.goods.service.IFontGoodsService;
import com.jdhs.project.system.preuser.domain.FontPreuser;
import com.jdhs.project.system.preuser.service.IFontPreuserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品管理Controller
 * 
 * @author jdhs
 * @date 2022-05-13
 */
@Controller
@RequestMapping("/pc/goods")
public class PcFontGoodsController extends BaseController
{
    private String prefix = "font";

    @Autowired
    private IFontGoodsService fontGoodsService;

    @Resource
    private IFontPreuserService fontPreuserService;

    @Autowired
    private IFontGoodsFenleiService fontGoodsFenleiService;

    @GetMapping()
    public String goods(ModelMap mmap,HttpSession session)
    {
        FontPreuser user = (FontPreuser) session.getAttribute("user");
        if (null == user){
            return prefix + "/login";
        }
        user = fontPreuserService.selectFontPreuserByUserId(user.getUserId());
        mmap.put("user",user);

        FontGoodsFenlei fontGoodsFenlei = new FontGoodsFenlei();
        fontGoodsFenlei.setGrade(2L);
        List<FontGoodsFenlei> flist2 = fontGoodsFenleiService.selectFontGoodsFenleiList(fontGoodsFenlei);
        mmap.put("categoryTwos", flist2);


        fontGoodsFenlei.setGrade(1l);
        List<FontGoodsFenlei> list1 = fontGoodsFenleiService.selectFontGoodsFenleiList(fontGoodsFenlei);
        mmap.put("categories", list1);
        return prefix + "/pcMGoodsList";
    }

    /**
     * 查询商品管理列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HttpSession session)
    {
        startPage();
        FontPreuser user = (FontPreuser) session.getAttribute("user");
        FontGoods fontGoods = new FontGoods();fontGoods.setSellerId(user.getUserId());
        List<FontGoods> list = fontGoodsService.selectFontGoodsList(fontGoods);
        return getDataTable(list);
    }

    /**
     * 导出商品管理列表
     */
    @Log(title = "商品管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FontGoods fontGoods)
    {
        List<FontGoods> list = fontGoodsService.selectFontGoodsList(fontGoods);
        ExcelUtil<FontGoods> util = new ExcelUtil<FontGoods>(FontGoods.class);
        return util.exportExcel(list, "商品管理数据");
    }

    /**
     * 新增商品管理
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        FontGoodsFenlei fontGoodsFenlei = new FontGoodsFenlei();
        fontGoodsFenlei.setGrade(2l);
        List<FontGoodsFenlei> list2 = fontGoodsFenleiService.selectFontGoodsFenleiList(fontGoodsFenlei);
        mmap.put("categoryTwos", list2);
        return prefix + "/goodsadd";
    }

    /**
     * 新增保存商品管理
     */
    @Log(title = "商品管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FontGoods fontGoods, HttpSession session)
    {
        FontPreuser user = (FontPreuser) session.getAttribute("user");
        fontGoods.setSellerId(user.getUserId());
        return toAjax(fontGoodsService.insertFontGoods(fontGoods));
    }

    /**
     * 修改商品管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        FontGoodsFenlei fontGoodsFenlei = new FontGoodsFenlei();
        fontGoodsFenlei.setGrade(2l);
        List<FontGoodsFenlei> list2 = fontGoodsFenleiService.selectFontGoodsFenleiList(fontGoodsFenlei);
        mmap.put("categoryTwos", list2);
        FontGoods fontGoods = fontGoodsService.selectFontGoodsById(id);
        mmap.put("fontGoods", fontGoods);
        return prefix + "/goodsedit";
    }

    /**
     * 修改保存商品管理
     */
    @Log(title = "商品管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FontGoods fontGoods,HttpSession session)
    {
        FontPreuser user = (FontPreuser) session.getAttribute("user");
        fontGoods.setSellerId(user.getUserId());
        return toAjax(fontGoodsService.updateFontGoods(fontGoods));
    }

    /**
     * 删除商品管理
     */
    @Log(title = "商品管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(fontGoodsService.deleteFontGoodsByIds(ids));
    }



}
