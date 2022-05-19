package com.jdhs.project.system.goods.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jdhs.framework.aspectj.lang.annotation.Excel;
import com.jdhs.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 商品管理对象 font_goods
 * 
 * @author jdhs
 * @date 2022-05-13
 */
public class FontGoods extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 商品ID */
    private Long id;

    /** 分类ID */
    @Excel(name = "分类ID")
    private String categoryId;

    /** 卖家ID */
    @Excel(name = "卖家ID")
    private Long sellerId;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String goodsName;

    /** 价格 */
    @Excel(name = "价格")
    private Long price;

    /** 原价格 */
    @Excel(name = "原价格")
    private Long originalPrice;

    /** 描述 */
    @Excel(name = "描述")
    private String goodsDetail;

    /** 数量 */
    @Excel(name = "数量")
    private Long goodsNumber;

    /** 热度 */
    @Excel(name = "热度")
    private Long heat;

    /** 图片1 */
    @Excel(name = "图片1")
    private String picture1;

    /** 图片2 */
    @Excel(name = "图片2")
    private String picture2;

    /** 图片3 */
    @Excel(name = "图片3")
    private String picture3;

    /** 图片4 */
    @Excel(name = "图片4")
    private String picture4;

    /** 图片5 */
    @Excel(name = "图片5")
    private String picture5;

    /** 精选1 白菜2 */
    @Excel(name = "精选1 白菜2")
    private Integer jbStatus;

    /** 售出0 还有1 */
    @Excel(name = "售出0 还有1")
    private Integer sellStatus;

    /** 上架时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上架时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date created;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updated;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String goodsTxt;

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
    public void setCategoryId(String categoryId)
    {
        this.categoryId = categoryId;
    }

    public String getCategoryId()
    {
        return categoryId;
    }
    public void setSellerId(Long sellerId)
    {
        this.sellerId = sellerId;
    }

    public Long getSellerId()
    {
        return sellerId;
    }
    public void setGoodsName(String goodsName)
    {
        this.goodsName = goodsName;
    }

    public String getGoodsName()
    {
        return goodsName;
    }
    public void setPrice(Long price)
    {
        this.price = price;
    }

    public Long getPrice()
    {
        return price;
    }
    public void setOriginalPrice(Long originalPrice)
    {
        this.originalPrice = originalPrice;
    }

    public Long getOriginalPrice()
    {
        return originalPrice;
    }
    public void setGoodsDetail(String goodsDetail)
    {
        this.goodsDetail = goodsDetail;
    }

    public String getGoodsDetail()
    {
        return goodsDetail;
    }
    public void setGoodsNumber(Long goodsNumber)
    {
        this.goodsNumber = goodsNumber;
    }

    public Long getGoodsNumber()
    {
        return goodsNumber;
    }
    public void setHeat(Long heat)
    {
        this.heat = heat;
    }

    public Long getHeat()
    {
        return heat;
    }
    public void setPicture1(String picture1)
    {
        this.picture1 = picture1;
    }

    public String getPicture1()
    {
        return picture1;
    }
    public void setPicture2(String picture2)
    {
        this.picture2 = picture2;
    }

    public String getPicture2()
    {
        return picture2;
    }
    public void setPicture3(String picture3)
    {
        this.picture3 = picture3;
    }

    public String getPicture3()
    {
        return picture3;
    }
    public void setPicture4(String picture4)
    {
        this.picture4 = picture4;
    }

    public String getPicture4()
    {
        return picture4;
    }
    public void setPicture5(String picture5)
    {
        this.picture5 = picture5;
    }

    public String getPicture5()
    {
        return picture5;
    }
    public void setJbStatus(Integer jbStatus)
    {
        this.jbStatus = jbStatus;
    }

    public Integer getJbStatus()
    {
        return jbStatus;
    }
    public void setSellStatus(Integer sellStatus)
    {
        this.sellStatus = sellStatus;
    }

    public Integer getSellStatus()
    {
        return sellStatus;
    }
    public void setCreated(Date created)
    {
        this.created = created;
    }

    public Date getCreated()
    {
        return created;
    }
    public void setUpdated(Date updated)
    {
        this.updated = updated;
    }

    public Date getUpdated()
    {
        return updated;
    }
    public void setGoodsTxt(String goodsTxt)
    {
        this.goodsTxt = goodsTxt;
    }

    public String getGoodsTxt()
    {
        return goodsTxt;
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
            .append("categoryId", getCategoryId())
            .append("sellerId", getSellerId())
            .append("goodsName", getGoodsName())
            .append("price", getPrice())
            .append("originalPrice", getOriginalPrice())
            .append("goodsDetail", getGoodsDetail())
            .append("goodsNumber", getGoodsNumber())
            .append("heat", getHeat())
            .append("picture1", getPicture1())
            .append("picture2", getPicture2())
            .append("picture3", getPicture3())
            .append("picture4", getPicture4())
            .append("picture5", getPicture5())
            .append("jbStatus", getJbStatus())
            .append("sellStatus", getSellStatus())
            .append("created", getCreated())
            .append("updated", getUpdated())
            .append("goodsTxt", getGoodsTxt())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
