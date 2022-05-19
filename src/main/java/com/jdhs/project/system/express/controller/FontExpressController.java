package com.jdhs.project.system.express.controller;

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
import com.jdhs.project.system.express.domain.FontExpress;
import com.jdhs.project.system.express.service.IFontExpressService;
import com.jdhs.framework.web.controller.BaseController;
import com.jdhs.framework.web.domain.AjaxResult;
import com.jdhs.common.utils.poi.ExcelUtil;
import com.jdhs.framework.web.page.TableDataInfo;

/**
 * 快递Controller
 * 
 * @author jdhs
 * @date 2022-05-15
 */
@Controller
@RequestMapping("/system/express")
public class FontExpressController extends BaseController
{
    private String prefix = "system/express";

    @Autowired
    private IFontExpressService fontExpressService;

    @RequiresPermissions("system:express:view")
    @GetMapping()
    public String express()
    {
        return prefix + "/express";
    }

    /**
     * 查询快递列表
     */
    @RequiresPermissions("system:express:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FontExpress fontExpress)
    {
        startPage();
        List<FontExpress> list = fontExpressService.selectFontExpressList(fontExpress);
        return getDataTable(list);
    }

    /**
     * 导出快递列表
     */
    @RequiresPermissions("system:express:export")
    @Log(title = "快递", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FontExpress fontExpress)
    {
        List<FontExpress> list = fontExpressService.selectFontExpressList(fontExpress);
        ExcelUtil<FontExpress> util = new ExcelUtil<FontExpress>(FontExpress.class);
        return util.exportExcel(list, "快递数据");
    }

    /**
     * 新增快递
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存快递
     */
    @RequiresPermissions("system:express:add")
    @Log(title = "快递", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FontExpress fontExpress)
    {
        return toAjax(fontExpressService.insertFontExpress(fontExpress));
    }

    /**
     * 修改快递
     */
    @RequiresPermissions("system:express:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        FontExpress fontExpress = fontExpressService.selectFontExpressById(id);
        mmap.put("fontExpress", fontExpress);
        return prefix + "/edit";
    }

    /**
     * 修改保存快递
     */
    @RequiresPermissions("system:express:edit")
    @Log(title = "快递", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FontExpress fontExpress)
    {
        return toAjax(fontExpressService.updateFontExpress(fontExpress));
    }

    /**
     * 删除快递
     */
    @RequiresPermissions("system:express:remove")
    @Log(title = "快递", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(fontExpressService.deleteFontExpressByIds(ids));
    }
}
