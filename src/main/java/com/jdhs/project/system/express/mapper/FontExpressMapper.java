package com.jdhs.project.system.express.mapper;

import java.util.List;
import com.jdhs.project.system.express.domain.FontExpress;

/**
 * 快递Mapper接口
 * 
 * @author jdhs
 * @date 2022-05-15
 */
public interface FontExpressMapper 
{
    /**
     * 查询快递
     * 
     * @param id 快递主键
     * @return 快递
     */
    public FontExpress selectFontExpressById(Long id);

    /**
     * 查询快递列表
     * 
     * @param fontExpress 快递
     * @return 快递集合
     */
    public List<FontExpress> selectFontExpressList(FontExpress fontExpress);

    /**
     * 新增快递
     * 
     * @param fontExpress 快递
     * @return 结果
     */
    public int insertFontExpress(FontExpress fontExpress);

    /**
     * 修改快递
     * 
     * @param fontExpress 快递
     * @return 结果
     */
    public int updateFontExpress(FontExpress fontExpress);

    /**
     * 删除快递
     * 
     * @param id 快递主键
     * @return 结果
     */
    public int deleteFontExpressById(Long id);

    /**
     * 批量删除快递
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFontExpressByIds(String[] ids);
}
