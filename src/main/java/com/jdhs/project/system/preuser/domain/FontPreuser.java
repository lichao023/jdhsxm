package com.jdhs.project.system.preuser.domain;

import com.jdhs.framework.aspectj.lang.annotation.Excel;
import com.jdhs.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 前端用户对象 font_preuser
 * 
 * @author jdhs
 * @date 2022-05-15
 */
public class FontPreuser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long userId;

    /** 用户名 */
    @Excel(name = "用户名")
    private String userName;

    /** 密码 */
    @Excel(name = "密码")
    private String password;

    /** 昵称(企业名称) */
    @Excel(name = "昵称(企业名称)")
    private String realName;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String phone;

    /** 用户类型 */
    @Excel(name = "用户类型")
    private String userType;

    /** 企业名称 */
    @Excel(name = "企业名称")
    private String qymc;

    /** 统一社会信用代码 */
    @Excel(name = "统一社会信用代码")
    private String tydm;

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserName()
    {
        return userName;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPassword()
    {
        return password;
    }
    public void setRealName(String realName)
    {
        this.realName = realName;
    }

    public String getRealName()
    {
        return realName;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPhone()
    {
        return phone;
    }
    public void setUserType(String userType)
    {
        this.userType = userType;
    }

    public String getUserType()
    {
        return userType;
    }
    public void setQymc(String qymc)
    {
        this.qymc = qymc;
    }

    public String getQymc()
    {
        return qymc;
    }
    public void setTydm(String tydm)
    {
        this.tydm = tydm;
    }

    public String getTydm()
    {
        return tydm;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("userName", getUserName())
            .append("password", getPassword())
            .append("realName", getRealName())
            .append("address", getAddress())
            .append("phone", getPhone())
            .append("userType", getUserType())
            .append("qymc", getQymc())
            .append("tydm", getTydm())
            .toString();
    }
}
