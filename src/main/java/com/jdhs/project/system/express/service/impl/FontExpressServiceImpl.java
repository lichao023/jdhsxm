package com.jdhs.project.system.express.service.impl;

import java.util.List;
import com.jdhs.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jdhs.project.system.express.mapper.FontExpressMapper;
import com.jdhs.project.system.express.domain.FontExpress;
import com.jdhs.project.system.express.service.IFontExpressService;
import com.jdhs.common.utils.text.Convert;

/**
 * 快递Service业务层处理
 * 
 * @author jdhs
 * @date 2022-05-15
 */
@Service
public class FontExpressServiceImpl implements IFontExpressService 
{
    @Autowired
    private FontExpressMapper fontExpressMapper;

    /**
     * 查询快递
     * 
     * @param id 快递主键
     * @return 快递
     */
    @Override
    public FontExpress selectFontExpressById(Long id)
    {
        return fontExpressMapper.selectFontExpressById(id);
    }

    /**
     * 查询快递列表
     * 
     * @param fontExpress 快递
     * @return 快递
     */
    @Override
    public List<FontExpress> selectFontExpressList(FontExpress fontExpress)
    {
        return fontExpressMapper.selectFontExpressList(fontExpress);
    }

    /**
     * 新增快递
     * 
     * @param fontExpress 快递
     * @return 结果
     */
    @Override
    public int insertFontExpress(FontExpress fontExpress)
    {
        fontExpress.setCreateTime(DateUtils.getNowDate());
        return fontExpressMapper.insertFontExpress(fontExpress);
    }

    /**
     * 修改快递
     * 
     * @param fontExpress 快递
     * @return 结果
     */
    @Override
    public int updateFontExpress(FontExpress fontExpress)
    {
        fontExpress.setUpdateTime(DateUtils.getNowDate());
        return fontExpressMapper.updateFontExpress(fontExpress);
    }

    /**
     * 批量删除快递
     * 
     * @param ids 需要删除的快递主键
     * @return 结果
     */
    @Override
    public int deleteFontExpressByIds(String ids)
    {
        return fontExpressMapper.deleteFontExpressByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除快递信息
     * 
     * @param id 快递主键
     * @return 结果
     */
    @Override
    public int deleteFontExpressById(Long id)
    {
        return fontExpressMapper.deleteFontExpressById(id);
    }
}
