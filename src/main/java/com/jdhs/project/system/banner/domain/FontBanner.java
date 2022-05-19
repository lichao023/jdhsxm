package com.jdhs.project.system.banner.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jdhs.framework.aspectj.lang.annotation.Excel;
import com.jdhs.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * banner图对象 font_banner
 * 
 * @author jdhs
 * @date 2022-05-14
 */
public class FontBanner extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 分类ID */
    @Excel(name = "分类ID")
    private Long categoryId;

    /** 卖家ID */
    @Excel(name = "卖家ID")
    private Long sellerId;

    /** 名称 */
    @Excel(name = "名称")
    private String bannerName;

    /** 价格 */
    @Excel(name = "价格")
    private BigDecimal bannerPrice;

    /** 详情 */
    @Excel(name = "详情")
    private String bannerDetail;

    /** 库存 */
    @Excel(name = "库存")
    private Long bannerNumber;

    /**  */
    @Excel(name = "")
    private String img1;

    /**  */
    @Excel(name = "")
    private String img2;

    /**  */
    @Excel(name = "")
    private String img3;

    /** 是否卖出 */
    @Excel(name = "是否卖出")
    private Integer sellStatus;

    /**  */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "", width = 30, dateFormat = "yyyy-MM-dd")
    private Date created;

    /**  */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updated;

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
    public void setCategoryId(Long categoryId)
    {
        this.categoryId = categoryId;
    }

    public Long getCategoryId()
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
    public void setBannerName(String bannerName)
    {
        this.bannerName = bannerName;
    }

    public String getBannerName()
    {
        return bannerName;
    }
    public void setBannerPrice(BigDecimal bannerPrice)
    {
        this.bannerPrice = bannerPrice;
    }

    public BigDecimal getBannerPrice()
    {
        return bannerPrice;
    }
    public void setBannerDetail(String bannerDetail)
    {
        this.bannerDetail = bannerDetail;
    }

    public String getBannerDetail()
    {
        return bannerDetail;
    }
    public void setBannerNumber(Long bannerNumber)
    {
        this.bannerNumber = bannerNumber;
    }

    public Long getBannerNumber()
    {
        return bannerNumber;
    }
    public void setImg1(String img1)
    {
        this.img1 = img1;
    }

    public String getImg1()
    {
        return img1;
    }
    public void setImg2(String img2)
    {
        this.img2 = img2;
    }

    public String getImg2()
    {
        return img2;
    }
    public void setImg3(String img3)
    {
        this.img3 = img3;
    }

    public String getImg3()
    {
        return img3;
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
            .append("bannerName", getBannerName())
            .append("bannerPrice", getBannerPrice())
            .append("bannerDetail", getBannerDetail())
            .append("bannerNumber", getBannerNumber())
            .append("img1", getImg1())
            .append("img2", getImg2())
            .append("img3", getImg3())
            .append("sellStatus", getSellStatus())
            .append("created", getCreated())
            .append("updated", getUpdated())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
