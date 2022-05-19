package com.jdhs.project.system.fenlei.service;

import java.util.List;
import com.jdhs.project.system.fenlei.domain.FontGoodsFenlei;

/**
 * 商品分类Service接口
 * 
 * @author jdhs
 * @date 2022-05-13
 */
public interface IFontGoodsFenleiService 
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
     * 批量删除商品分类
     * 
     * @param ids 需要删除的商品分类主键集合
     * @return 结果
     */
    public int deleteFontGoodsFenleiByIds(String ids);

    /**
     * 删除商品分类信息
     * 
     * @param id 商品分类主键
     * @return 结果
     */
    public int deleteFontGoodsFenleiById(Long id);

    FontGoodsFenlei selectFontGoodsFenleiByName(String categoryId);
}
