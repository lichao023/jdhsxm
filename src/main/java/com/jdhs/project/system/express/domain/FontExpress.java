package com.jdhs.project.system.express.domain;

import com.jdhs.framework.aspectj.lang.annotation.Excel;
import com.jdhs.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 快递对象 font_express
 * 
 * @author jdhs
 * @date 2022-05-15
 */
public class FontExpress extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 快递ID */
    private Long id;

    /** 快递名称 */
    @Excel(name = "快递名称")
    private String expressName;

    /** 快递价格 */
    @Excel(name = "快递价格")
    private Long expressPrice;

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
            .append("expressName", getExpressName())
            .append("expressPrice", getExpressPrice())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
