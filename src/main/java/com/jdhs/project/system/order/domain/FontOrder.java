package com.jdhs.project.system.order.domain;

import com.jdhs.framework.aspectj.lang.annotation.Excel;
import com.jdhs.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 订单对象 font_order
 * 
 * @author jdhs
 * @date 2022-05-15
 */
public class FontOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单详情ID */
    private Long id;

    /** 订单ID */
    @Excel(name = "订单ID")
    private Long orderId;

    /** 订单号 */
    @Excel(name = "订单号")
    private String orderNum;

    /** 商品ID */
    @Excel(name = "商品ID")
    private Long goodsId;

    /** 卖家名称 */
    @Excel(name = "卖家名称")
    private String sellerName;

    /** 卖家ID */
    @Excel(name = "卖家ID")
    private Long sellerId;

    /** 买家名称 */
    @Excel(name = "买家名称")
    private String buyName;

    /** 买家ID */
    @Excel(name = "买家ID")
    private Long buyId;

    /** 快递ID */
    @Excel(name = "快递ID")
    private Long expressId;

    /** 快递名称 */
    @Excel(name = "快递名称")
    private String expressName;

    /** 快递价格 */
    @Excel(name = "快递价格")
    private Long expressPrice;

    /** 商品图片 */
    @Excel(name = "商品图片")
    private String goodsImg;

    /** 商品数量 */
    @Excel(name = "商品数量")
    private Long buyCount;

    /** 商品价格 */
    @Excel(name = "商品价格")
    private Long goodsPrice;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String goodsName;

    /** 订单状态 */
    @Excel(name = "订单状态")
    private String orderStatus;

    /** 快递单号 */
    @Excel(name = "快递单号")
    private String expressNum;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setOrderId(Long orderId)
    {
        this.orderId = orderId;
    }

    public Long getOrderId()
    {
        return orderId;
    }
    public void setOrderNum(String orderNum)
    {
        this.orderNum = orderNum;
    }

    public String getOrderNum()
    {
        return orderNum;
    }
    public void setGoodsId(Long goodsId)
    {
        this.goodsId = goodsId;
    }

    public Long getGoodsId()
    {
        return goodsId;
    }
    public void setSellerName(String sellerName)
    {
        this.sellerName = sellerName;
    }

    public String getSellerName()
    {
        return sellerName;
    }
    public void setSellerId(Long sellerId)
    {
        this.sellerId = sellerId;
    }

    public Long getSellerId()
    {
        return sellerId;
    }
    public void setBuyName(String buyName)
    {
        this.buyName = buyName;
    }

    public String getBuyName()
    {
        return buyName;
    }
    public void setBuyId(Long buyId)
    {
        this.buyId = buyId;
    }

    public Long getBuyId()
    {
        return buyId;
    }
    public void setExpressId(Long expressId)
    {
        this.expressId = expressId;
    }

    public Long getExpressId()
    {
        return expressId;
    }
    public void setExpressName(String expressName)
    {
        this.expressName = expressName;
    }

    public String getExpressName()
    {
        return expressName;
    }
    public void setExpressPrice(Long expressPrice)
    {
        this.expressPrice = expressPrice;
    }

    public Long getExpressPrice()
    {
        return expressPrice;
    }
    public void setGoodsImg(String goodsImg)
    {
        this.goodsImg = goodsImg;
    }

    public String getGoodsImg()
    {
        return goodsImg;
    }
    public void setBuyCount(Long buyCount)
    {
        this.buyCount = buyCount;
    }

    public Long getBuyCount()
    {
        return buyCount;
    }
    public void setGoodsPrice(Long goodsPrice)
    {
        this.goodsPrice = goodsPrice;
    }

    public Long getGoodsPrice()
    {
        return goodsPrice;
    }
    public void setGoodsName(String goodsName)
    {
        this.goodsName = goodsName;
    }

    public String getGoodsName()
    {
        return goodsName;
    }
    public void setOrderStatus(String orderStatus)
    {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatus()
    {
        return orderStatus;
    }
    public void setExpressNum(String expressNum)
    {
        this.expressNum = expressNum;
    }

    public String getExpressNum()
    {
        return expressNum;
    }
    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag()
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orderId", getOrderId())
            .append("orderNum", getOrderNum())
            .append("goodsId", getGoodsId())
            .append("sellerName", getSellerName())
            .append("sellerId", getSellerId())
            .append("buyName", getBuyName())
            .append("buyId", getBuyId())
            .append("expressId", getExpressId())
            .append("expressName", getExpressName())
            .append("expressPrice", getExpressPrice())
            .append("goodsImg", getGoodsImg())
            .append("buyCount", getBuyCount())
            .append("goodsPrice", getGoodsPrice())
            .append("goodsName", getGoodsName())
            .append("orderStatus", getOrderStatus())
            .append("expressNum", getExpressNum())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
