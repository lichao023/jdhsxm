package com.jdhs.project.system.order.service;

import java.util.List;
import com.jdhs.project.system.order.domain.FontOrder;

/**
 * 订单Service接口
 * 
 * @author jdhs
 * @date 2022-05-15
 */
public interface IFontOrderService 
{
    /**
     * 查询订单
     * 
     * @param id 订单主键
     * @return 订单
     */
    public FontOrder selectFontOrderById(Long id);

    /**
     * 查询订单列表
     * 
     * @param fontOrder 订单
     * @return 订单集合
     */
    public List<FontOrder> selectFontOrderList(FontOrder fontOrder);

    /**
     * 新增订单
     * 
     * @param fontOrder 订单
     * @return 结果
     */
    public int insertFontOrder(FontOrder fontOrder);

    /**
     * 修改订单
     * 
     * @param fontOrder 订单
     * @return 结果
     */
    public int updateFontOrder(FontOrder fontOrder);

    /**
     * 批量删除订单
     * 
     * @param ids 需要删除的订单主键集合
     * @return 结果
     */
    public int deleteFontOrderByIds(String ids);

    /**
     * 删除订单信息
     * 
     * @param id 订单主键
     * @return 结果
     */
    public int deleteFontOrderById(Long id);
}
