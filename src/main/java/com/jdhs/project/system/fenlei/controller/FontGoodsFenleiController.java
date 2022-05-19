package com.jdhs.project.system.fenlei.controller;

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
import com.jdhs.project.system.fenlei.domain.FontGoodsFenlei;
import com.jdhs.project.system.fenlei.service.IFontGoodsFenleiService;
import com.jdhs.framework.web.controller.BaseController;
import com.jdhs.framework.web.domain.AjaxResult;
import com.jdhs.common.utils.poi.ExcelUtil;
import com.jdhs.framework.web.page.TableDataInfo;

/**
 * 商品分类Controller
 * 
 * @author jdhs
 * @date 2022-05-13
 */
@Controller
@RequestMapping("/system/fenlei")
public class FontGoodsFenleiController extends BaseController
{
    private String prefix = "system/fenlei";

    @Autowired
    private IFontGoodsFenleiService fontGoodsFenleiService;

    @RequiresPermissions("system:fenlei:view")
    @GetMapping()
    public String fenlei()
    {
        return prefix + "/fenlei";
    }

    /**
     * 查询商品分类列表
     */
    @RequiresPermissions("system:fenlei:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FontGoodsFenlei fontGoodsFenlei)
    {
        startPage();
        List<FontGoodsFenlei> list = fontGoodsFenleiService.selectFontGoodsFenleiList(fontGoodsFenlei);
        return getDataTable(list);
    }

    /**
     * 导出商品分类列表
     */
    @RequiresPermissions("system:fenlei:export")
    @Log(title = "商品分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FontGoodsFenlei fontGoodsFenlei)
    {
        List<FontGoodsFenlei> list = fontGoodsFenleiService.selectFontGoodsFenleiList(fontGoodsFenlei);
        ExcelUtil<FontGoodsFenlei> util = new ExcelUtil<FontGoodsFenlei>(FontGoodsFenlei.class);
        return util.exportExcel(list, "商品分类数据");
    }

    /**
     * 新增商品分类
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        FontGoodsFenlei fontGoodsFenlei = new FontGoodsFenlei();
        fontGoodsFenlei.setGrade(1l);
        List<FontGoodsFenlei> list = fontGoodsFenleiService.selectFontGoodsFenleiList(fontGoodsFenlei);
        mmap.put("gradeOnes", list);
        return prefix + "/add";
    }

    /**
     * 新增保存商品分类
     */
    @RequiresPermissions("system:fenlei:add")
    @Log(title = "商品分类", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FontGoodsFenlei fontGoodsFenlei)
    {
        if (fontGoodsFenlei.getGrade() == 1L){
            fontGoodsFenlei.setPid(0L);
        }
        return toAjax(fontGoodsFenleiService.insertFontGoodsFenlei(fontGoodsFenlei));
    }

    /**
     * 修改商品分类
     */
    @RequiresPermissions("system:fenlei:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        FontGoodsFenlei fontGoodsFenlei = fontGoodsFenleiService.selectFontGoodsFenleiById(id);
        mmap.put("fontGoodsFenlei", fontGoodsFenlei);
        return prefix + "/edit";
    }

    /**
     * 修改保存商品分类
     */
    @RequiresPermissions("system:fenlei:edit")
    @Log(title = "商品分类", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FontGoodsFenlei fontGoodsFenlei)
    {
        return toAjax(fontGoodsFenleiService.updateFontGoodsFenlei(fontGoodsFenlei));
    }

    /**
     * 删除商品分类
     */
    @RequiresPermissions("system:fenlei:remove")
    @Log(title = "商品分类", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(fontGoodsFenleiService.deleteFontGoodsFenleiByIds(ids));
    }
}
