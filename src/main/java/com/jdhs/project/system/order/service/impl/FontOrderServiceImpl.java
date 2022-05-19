package com.jdhs.project.system.order.service.impl;

import java.util.List;
import com.jdhs.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jdhs.project.system.order.mapper.FontOrderMapper;
import com.jdhs.project.system.order.domain.FontOrder;
import com.jdhs.project.system.order.service.IFontOrderService;
import com.jdhs.common.utils.text.Convert;

/**
 * 订单Service业务层处理
 * 
 * @author jdhs
 * @date 2022-05-15
 */
@Service
public class FontOrderServiceImpl implements IFontOrderService 
{
    @Autowired
    private FontOrderMapper fontOrderMapper;

    /**
     * 查询订单
     * 
     * @param id 订单主键
     * @return 订单
     */
    @Override
    public FontOrder selectFontOrderById(Long id)
    {
        return fontOrderMapper.selectFontOrderById(id);
    }

    /**
     * 查询订单列表
     * 
     * @param fontOrder 订单
     * @return 订单
     */
    @Override
    public List<FontOrder> selectFontOrderList(FontOrder fontOrder)
    {
        return fontOrderMapper.selectFontOrderList(fontOrder);
    }

    /**
     * 新增订单
     * 
     * @param fontOrder 订单
     * @return 结果
     */
    @Override
    public int insertFontOrder(FontOrder fontOrder)
    {
        fontOrder.setCreateTime(DateUtils.getNowDate());
        return fontOrderMapper.insertFontOrder(fontOrder);
    }

    /**
     * 修改订单
     * 
     * @param fontOrder 订单
     * @return 结果
     */
    @Override
    public int updateFontOrder(FontOrder fontOrder)
    {
        fontOrder.setUpdateTime(DateUtils.getNowDate());
        return fontOrderMapper.updateFontOrder(fontOrder);
    }

    /**
     * 批量删除订单
     * 
     * @param ids 需要删除的订单主键
     * @return 结果
     */
    @Override
    public int deleteFontOrderByIds(String ids)
    {
        return fontOrderMapper.deleteFontOrderByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除订单信息
     * 
     * @param id 订单主键
     * @return 结果
     */
    @Override
    public int deleteFontOrderById(Long id)
    {
        return fontOrderMapper.deleteFontOrderById(id);
    }
}
