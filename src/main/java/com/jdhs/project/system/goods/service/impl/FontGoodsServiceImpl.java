package com.jdhs.project.system.goods.service.impl;

import java.util.List;
import com.jdhs.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jdhs.project.system.goods.mapper.FontGoodsMapper;
import com.jdhs.project.system.goods.domain.FontGoods;
import com.jdhs.project.system.goods.service.IFontGoodsService;
import com.jdhs.common.utils.text.Convert;

/**
 * 商品管理Service业务层处理
 * 
 * @author jdhs
 * @date 2022-05-13
 */
@Service
public class FontGoodsServiceImpl implements IFontGoodsService 
{
    @Autowired
    private FontGoodsMapper fontGoodsMapper;

    /**
     * 查询商品管理
     * 
     * @param id 商品管理主键
     * @return 商品管理
     */
    @Override
    public FontGoods selectFontGoodsById(Long id)
    {
        return fontGoodsMapper.selectFontGoodsById(id);
    }

    /**
     * 查询商品管理列表
     * 
     * @param fontGoods 商品管理
     * @return 商品管理
     */
    @Override
    public List<FontGoods> selectFontGoodsList(FontGoods fontGoods)
    {
        return fontGoodsMapper.selectFontGoodsList(fontGoods);
    }

    /**
     * 新增商品管理
     * 
     * @param fontGoods 商品管理
     * @return 结果
     */
    @Override
    public int insertFontGoods(FontGoods fontGoods)
    {
        fontGoods.setCreateTime(DateUtils.getNowDate());
        return fontGoodsMapper.insertFontGoods(fontGoods);
    }

    /**
     * 修改商品管理
     * 
     * @param fontGoods 商品管理
     * @return 结果
     */
    @Override
    public int updateFontGoods(FontGoods fontGoods)
    {
        fontGoods.setUpdateTime(DateUtils.getNowDate());
        return fontGoodsMapper.updateFontGoods(fontGoods);
    }

    /**
     * 批量删除商品管理
     * 
     * @param ids 需要删除的商品管理主键
     * @return 结果
     */
    @Override
    public int deleteFontGoodsByIds(String ids)
    {
        return fontGoodsMapper.deleteFontGoodsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商品管理信息
     * 
     * @param id 商品管理主键
     * @return 结果
     */
    @Override
    public int deleteFontGoodsById(Long id)
    {
        return fontGoodsMapper.deleteFontGoodsById(id);
    }

    @Override
    public List<FontGoods> selectFontGoodsByName(String search) {
        return fontGoodsMapper.selectFontGoodsByName(search);
    }
}
