package com.jdhs.project.system.goods.mapper;

import java.util.List;
import com.jdhs.project.system.goods.domain.FontGoods;
import org.apache.ibatis.annotations.Param;

/**
 * 商品管理Mapper接口
 * 
 * @author jdhs
 * @date 2022-05-13
 */
public interface FontGoodsMapper 
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
     * 删除商品管理
     * 
     * @param id 商品管理主键
     * @return 结果
     */
    public int deleteFontGoodsById(Long id);

    /**
     * 批量删除商品管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFontGoodsByIds(String[] ids);

    List<FontGoods> selectFontGoodsByName(@Param(value = "search") String search);
}
