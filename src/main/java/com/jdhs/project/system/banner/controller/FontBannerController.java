package com.jdhs.project.system.banner.controller;

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
import com.jdhs.project.system.banner.domain.FontBanner;
import com.jdhs.project.system.banner.service.IFontBannerService;
import com.jdhs.framework.web.controller.BaseController;
import com.jdhs.framework.web.domain.AjaxResult;
import com.jdhs.common.utils.poi.ExcelUtil;
import com.jdhs.framework.web.page.TableDataInfo;

/**
 * banner图Controller
 * 
 * @author jdhs
 * @date 2022-05-14
 */
@Controller
@RequestMapping("/system/banner")
public class FontBannerController extends BaseController
{
    private String prefix = "system/banner";

    @Autowired
    private IFontBannerService fontBannerService;

    @RequiresPermissions("system:banner:view")
    @GetMapping()
    public String banner()
    {
        return prefix + "/banner";
    }

    /**
     * 查询banner图列表
     */
    @RequiresPermissions("system:banner:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FontBanner fontBanner)
    {
        startPage();
        List<FontBanner> list = fontBannerService.selectFontBannerList(fontBanner);
        return getDataTable(list);
    }

    /**
     * 导出banner图列表
     */
    @RequiresPermissions("system:banner:export")
    @Log(title = "banner图", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FontBanner fontBanner)
    {
        List<FontBanner> list = fontBannerService.selectFontBannerList(fontBanner);
        ExcelUtil<FontBanner> util = new ExcelUtil<FontBanner>(FontBanner.class);
        return util.exportExcel(list, "banner图数据");
    }

    /**
     * 新增banner图
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存banner图
     */
    @RequiresPermissions("system:banner:add")
    @Log(title = "banner图", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FontBanner fontBanner)
    {
        return toAjax(fontBannerService.insertFontBanner(fontBanner));
    }

    /**
     * 修改banner图
     */
    @RequiresPermissions("system:banner:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        FontBanner fontBanner = fontBannerService.selectFontBannerById(id);
        mmap.put("fontBanner", fontBanner);
        return prefix + "/edit";
    }

    /**
     * 修改保存banner图
     */
    @RequiresPermissions("system:banner:edit")
    @Log(title = "banner图", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FontBanner fontBanner)
    {
        return toAjax(fontBannerService.updateFontBanner(fontBanner));
    }

    /**
     * 删除banner图
     */
    @RequiresPermissions("system:banner:remove")
    @Log(title = "banner图", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(fontBannerService.deleteFontBannerByIds(ids));
    }
}
