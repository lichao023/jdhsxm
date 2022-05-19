package com.jdhs.project.system.order.controller;

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
import com.jdhs.project.system.order.domain.FontOrder;
import com.jdhs.project.system.order.service.IFontOrderService;
import com.jdhs.framework.web.controller.BaseController;
import com.jdhs.framework.web.domain.AjaxResult;
import com.jdhs.common.utils.poi.ExcelUtil;
import com.jdhs.framework.web.page.TableDataInfo;

/**
 * 订单Controller
 * 
 * @author jdhs
 * @date 2022-05-15
 */
@Controller
@RequestMapping("/system/order")
public class FontOrderController extends BaseController
{
    private String prefix = "system/order";

    @Autowired
    private IFontOrderService fontOrderService;

    @RequiresPermissions("system:order:view")
    @GetMapping()
    public String order()
    {
        return prefix + "/order";
    }

    /**
     * 查询订单列表
     */
    @RequiresPermissions("system:order:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FontOrder fontOrder)
    {
        startPage();
        List<FontOrder> list = fontOrderService.selectFontOrderList(fontOrder);
        return getDataTable(list);
    }

    /**
     * 导出订单列表
     */
    @RequiresPermissions("system:order:export")
    @Log(title = "订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FontOrder fontOrder)
    {
        List<FontOrder> list = fontOrderService.selectFontOrderList(fontOrder);
        ExcelUtil<FontOrder> util = new ExcelUtil<FontOrder>(FontOrder.class);
        return util.exportExcel(list, "订单数据");
    }

    /**
     * 新增订单
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存订单
     */
    @RequiresPermissions("system:order:add")
    @Log(title = "订单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FontOrder fontOrder)
    {
        return toAjax(fontOrderService.insertFontOrder(fontOrder));
    }

    /**
     * 修改订单
     */
    @RequiresPermissions("system:order:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        FontOrder fontOrder = fontOrderService.selectFontOrderById(id);
        mmap.put("fontOrder", fontOrder);
        return prefix + "/edit";
    }

    /**
     * 修改保存订单
     */
    @RequiresPermissions("system:order:edit")
    @Log(title = "订单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FontOrder fontOrder)
    {
        return toAjax(fontOrderService.updateFontOrder(fontOrder));
    }

    /**
     * 删除订单
     */
    @RequiresPermissions("system:order:remove")
    @Log(title = "订单", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(fontOrderService.deleteFontOrderByIds(ids));
    }
}
