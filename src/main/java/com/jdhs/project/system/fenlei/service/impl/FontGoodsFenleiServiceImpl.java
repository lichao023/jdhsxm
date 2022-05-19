package com.jdhs.project.system.fenlei.service.impl;

import java.util.List;
import com.jdhs.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jdhs.project.system.fenlei.mapper.FontGoodsFenleiMapper;
import com.jdhs.project.system.fenlei.domain.FontGoodsFenlei;
import com.jdhs.project.system.fenlei.service.IFontGoodsFenleiService;
import com.jdhs.common.utils.text.Convert;

/**
 * 商品分类Service业务层处理
 * 
 * @author jdhs
 * @date 2022-05-13
 */
@Service
public class FontGoodsFenleiServiceImpl implements IFontGoodsFenleiService 
{
    @Autowired
    private FontGoodsFenleiMapper fontGoodsFenleiMapper;

    /**
     * 查询商品分类
     * 
     * @param id 商品分类主键
     * @return 商品分类
     */
    @Override
    public FontGoodsFenlei selectFontGoodsFenleiById(Long id)
    {
        return fontGoodsFenleiMapper.selectFontGoodsFenleiById(id);
    }

    /**
     * 查询商品分类列表
     * 
     * @param fontGoodsFenlei 商品分类
     * @return 商品分类
     */
    @Override
    public List<FontGoodsFenlei> selectFontGoodsFenleiList(FontGoodsFenlei fontGoodsFenlei)
    {
        return fontGoodsFenleiMapper.selectFontGoodsFenleiList(fontGoodsFenlei);
    }

    /**
     * 新增商品分类
     * 
     * @param fontGoodsFenlei 商品分类
     * @return 结果
     */
    @Override
    public int insertFontGoodsFenlei(FontGoodsFenlei fontGoodsFenlei)
    {
        fontGoodsFenlei.setCreateTime(DateUtils.getNowDate());
        return fontGoodsFenleiMapper.insertFontGoodsFenlei(fontGoodsFenlei);
    }

    /**
     * 修改商品分类
     * 
     * @param fontGoodsFenlei 商品分类
     * @return 结果
     */
    @Override
    public int updateFontGoodsFenlei(FontGoodsFenlei fontGoodsFenlei)
    {
        fontGoodsFenlei.setUpdateTime(DateUtils.getNowDate());
        return fontGoodsFenleiMapper.updateFontGoodsFenlei(fontGoodsFenlei);
    }

    /**
     * 批量删除商品分类
     * 
     * @param ids 需要删除的商品分类主键
     * @return 结果
     */
    @Override
    public int deleteFontGoodsFenleiByIds(String ids)
    {
        return fontGoodsFenleiMapper.deleteFontGoodsFenleiByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商品分类信息
     * 
     * @param id 商品分类主键
     * @return 结果
     */
    @Override
    public int deleteFontGoodsFenleiById(Long id)
    {
        return fontGoodsFenleiMapper.deleteFontGoodsFenleiById(id);
    }

    @Override
    public FontGoodsFenlei selectFontGoodsFenleiByName(String name) {
        return fontGoodsFenleiMapper.selectFontGoodsFenleiByName(name);
    }
}
