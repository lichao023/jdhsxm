package com.jdhs.project.system.goods.service;

import java.util.List;
import com.jdhs.project.system.goods.domain.FontGoods;

/**
 * 商品管理Service接口
 * 
 * @author jdhs
 * @date 2022-05-13
 */
public interface IFontGoodsService 
{
    /**
     * 查询商品管理
     * 
     * @param id 商品管理主键
     * @return 商品管理
     */
    public FontGoods selectFontGoodsById(Long id);

    /**
     * 查询商品管理列表
     * 
     * @param fontGoods 商品管理
     * @return 商品管理集合
     */
    public List<FontGoods> selectFontGoodsList(FontGoods fontGoods);

    /**
     * 新增商品管理
     * 
     * @param fontGoods 商品管理
     * @return 结果
     */
    public int insertFontGoods(FontGoods fontGoods);

    /**
     * 修改商品管理
     * 
     * @param fontGoods 商品管理
     * @return 结果
     */
    public int updateFontGoods(FontGoods fontGoods);

    /**
     * 批量删除商品管理
     * 
     * @param ids 需要删除的商品管理主键集合
     * @return 结果
     */
    public int deleteFontGoodsByIds(String ids);

    /**
     * 删除商品管理信息
     * 
     * @param id 商品管理主键
     * @return 结果
     */
    public int deleteFontGoodsById(Long id);

    List<FontGoods> selectFontGoodsByName(String search);
}
