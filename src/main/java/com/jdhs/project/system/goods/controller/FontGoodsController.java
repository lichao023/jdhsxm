package com.jdhs.project.system.goods.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.jdhs.framework.aspectj.lang.annotation.Log;
import com.jdhs.framework.aspectj.lang.enums.BusinessType;
import com.jdhs.project.system.goods.domain.FontGoods;
import com.jdhs.project.system.goods.service.IFontGoodsService;
import com.jdhs.framework.web.controller.BaseController;
import com.jdhs.framework.web.domain.AjaxResult;
import com.jdhs.common.utils.poi.ExcelUtil;
import com.jdhs.framework.web.page.TableDataInfo;

/**
 * 商品管理Controller
 * 
 * @author jdhs
 * @date 2022-05-13
 */
@Controller
@RequestMapping("/system/goods")
public class FontGoodsController extends BaseController
{
    private String prefix = "system/goods";

    @Autowired
    private IFontGoodsService fontGoodsService;

    @RequiresPermissions("system:goods:view")
    @GetMapping()
    public String goods()
    {
        return prefix + "/goods";
    }

    /**
     * 查询商品管理列表
     */
    @RequiresPermissions("system:goods:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FontGoods fontGoods)
    {
        startPage();
        List<FontGoods> list = fontGoodsService.selectFontGoodsList(fontGoods);
        return getDataTable(list);
    }

    /**
     * 导出商品管理列表
     */
    @RequiresPermissions("system:goods:export")
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
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存商品管理
     */
    @RequiresPermissions("system:goods:add")
    @Log(title = "商品管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FontGoods fontGoods)
    {
        return toAjax(fontGoodsService.insertFontGoods(fontGoods));
    }

    /**
     * 修改商品管理
     */
    @RequiresPermissions("system:goods:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        FontGoods fontGoods = fontGoodsService.selectFontGoodsById(id);
        mmap.put("fontGoods", fontGoods);
        return prefix + "/edit";
    }

    /**
     * 修改保存商品管理
     */
    @RequiresPermissions("system:goods:edit")
    @Log(title = "商品管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FontGoods fontGoods)
    {
        return toAjax(fontGoodsService.updateFontGoods(fontGoods));
    }

    /**
     * 删除商品管理
     */
    @RequiresPermissions("system:goods:remove")
    @Log(title = "商品管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(fontGoodsService.deleteFontGoodsByIds(ids));
    }
}
