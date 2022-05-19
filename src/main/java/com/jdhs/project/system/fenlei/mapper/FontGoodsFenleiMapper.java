package com.jdhs.project.system.fenlei.mapper;

import java.util.List;
import com.jdhs.project.system.fenlei.domain.FontGoodsFenlei;

/**
 * 商品分类Mapper接口
 * 
 * @author jdhs
 * @date 2022-05-13
 */
public interface FontGoodsFenleiMapper 
{
    /**
     * 查询商品分类
     * 
     * @param id 商品分类主键
     * @return 商品分类
     */
    public FontGoodsFenlei selectFontGoodsFenleiById(Long id);

    /**
     * 查询商品分类列表
     * 
     * @param fontGoodsFenlei 商品分类
     * @return 商品分类集合
     */
    public List<FontGoodsFenlei> selectFontGoodsFenleiList(FontGoodsFenlei fontGoodsFenlei);

    /**
     * 新增商品分类
     * 
     * @param fontGoodsFenlei 商品分类
     * @return 结果
     */
    public int insertFontGoodsFenlei(FontGoodsFenlei fontGoodsFenlei);

    /**
     * 修改商品分类
     * 
     * @param fontGoodsFenlei 商品分类
     * @return 结果
     */
    public int updateFontGoodsFenlei(FontGoodsFenlei fontGoodsFenlei);

    /**
     * 删除商品分类
     * 
     * @param id 商品分类主键
     * @return 结果
     */
    public int deleteFontGoodsFenleiById(Long id);

    /**
     * 批量删除商品分类
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFontGoodsFenleiByIds(String[] ids);

    FontGoodsFenlei selectFontGoodsFenleiByName(String name);
}
