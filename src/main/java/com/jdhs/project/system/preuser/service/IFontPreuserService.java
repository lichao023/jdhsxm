package com.jdhs.project.system.preuser.service;

import java.util.List;
import com.jdhs.project.system.preuser.domain.FontPreuser;

/**
 * 前端用户Service接口
 * 
 * @author jdhs
 * @date 2022-05-12
 */
public interface IFontPreuserService 
{
    /**
     * 查询前端用户
     * 
     * @param userId 前端用户主键
     * @return 前端用户
     */
    public FontPreuser selectFontPreuserByUserId(Long userId);

    /**
     * 查询前端用户列表
     * 
     * @param fontPreuser 前端用户
     * @return 前端用户集合
     */
    public List<FontPreuser> selectFontPreuserList(FontPreuser fontPreuser);

    /**
     * 新增前端用户
     * 
     * @param fontPreuser 前端用户
     * @return 结果
     */
    public int insertFontPreuser(FontPreuser fontPreuser);

    /**
     * 修改前端用户
     * 
     * @param fontPreuser 前端用户
     * @return 结果
     */
    public int updateFontPreuser(FontPreuser fontPreuser);

    /**
     * 批量删除前端用户
     * 
     * @param userIds 需要删除的前端用户主键集合
     * @return 结果
     */
    public int deleteFontPreuserByUserIds(String userIds);

    /**
     * 删除前端用户信息
     * 
     * @param userId 前端用户主键
     * @return 结果
     */
    public int deleteFontPreuserByUserId(Long userId);

    /**
     * 登录
     * @param fontPreuser
     * @return
     */
    FontPreuser pcLogin(FontPreuser fontPreuser);
}
