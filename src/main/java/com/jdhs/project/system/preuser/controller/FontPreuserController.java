package com.jdhs.project.system.preuser.controller;

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
import com.jdhs.project.system.preuser.domain.FontPreuser;
import com.jdhs.project.system.preuser.service.IFontPreuserService;
import com.jdhs.framework.web.controller.BaseController;
import com.jdhs.framework.web.domain.AjaxResult;
import com.jdhs.common.utils.poi.ExcelUtil;
import com.jdhs.framework.web.page.TableDataInfo;

/**
 * 前端用户Controller
 * 
 * @author jdhs
 * @date 2022-05-12
 */
@Controller
@RequestMapping("/system/preuser")
public class FontPreuserController extends BaseController
{
    private String prefix = "system/preuser";

    @Autowired
    private IFontPreuserService fontPreuserService;

    @RequiresPermissions("system:preuser:view")
    @GetMapping()
    public String preuser()
    {
        return prefix + "/preuser";
    }

    /**
     * 查询前端用户列表
     */
    @RequiresPermissions("system:preuser:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FontPreuser fontPreuser)
    {
        startPage();
        List<FontPreuser> list = fontPreuserService.selectFontPreuserList(fontPreuser);
        return getDataTable(list);
    }

    /**
     * 导出前端用户列表
     */
    @RequiresPermissions("system:preuser:export")
    @Log(title = "前端用户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FontPreuser fontPreuser)
    {
        List<FontPreuser> list = fontPreuserService.selectFontPreuserList(fontPreuser);
        ExcelUtil<FontPreuser> util = new ExcelUtil<FontPreuser>(FontPreuser.class);
        return util.exportExcel(list, "前端用户数据");
    }

    /**
     * 新增前端用户
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存前端用户
     */
    @RequiresPermissions("system:preuser:add")
    @Log(title = "前端用户", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FontPreuser fontPreuser)
    {
        return toAjax(fontPreuserService.insertFontPreuser(fontPreuser));
    }

    /**
     * 修改前端用户
     */
    @RequiresPermissions("system:preuser:edit")
    @GetMapping("/edit/{userId}")
    public String edit(@PathVariable("userId") Long userId, ModelMap mmap)
    {
        FontPreuser fontPreuser = fontPreuserService.selectFontPreuserByUserId(userId);
        mmap.put("fontPreuser", fontPreuser);
        return prefix + "/edit";
    }

    /**
     * 修改保存前端用户
     */
    @RequiresPermissions("system:preuser:edit")
    @Log(title = "前端用户", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FontPreuser fontPreuser)
    {
        return toAjax(fontPreuserService.updateFontPreuser(fontPreuser));
    }

    /**
     * 删除前端用户
     */
    @RequiresPermissions("system:preuser:remove")
    @Log(title = "前端用户", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(fontPreuserService.deleteFontPreuserByUserIds(ids));
    }
}
