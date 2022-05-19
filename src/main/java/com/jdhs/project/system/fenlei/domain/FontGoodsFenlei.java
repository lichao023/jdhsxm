package com.jdhs.project.system.fenlei.domain;

import com.jdhs.framework.aspectj.lang.annotation.Excel;
import com.jdhs.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 商品分类对象 font_goods_fenlei
 * 
 * @author jdhs
 * @date 2022-05-13
 */
public class FontGoodsFenlei extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 类型 */
    @Excel(name = "类型")
    private Long grade;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 付ID */
    @Excel(name = "付ID")
    private Long pid;

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
    public void setGrade(Long grade)
    {
        this.grade = grade;
    }

    public Long getGrade()
    {
        return grade;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setPid(Long pid)
    {
        this.pid = pid;
    }

    public Long getPid()
    {
        return pid;
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
            .append("grade", getGrade())
            .append("name", getName())
            .append("pid", getPid())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
