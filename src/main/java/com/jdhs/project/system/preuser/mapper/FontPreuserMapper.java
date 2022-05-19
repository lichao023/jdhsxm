package com.jdhs.project.system.preuser.mapper;

import java.util.List;
import com.jdhs.project.system.preuser.domain.FontPreuser;
import org.apache.ibatis.annotations.Select;

/**
 * 前端用户Mapper接口
 * 
 * @author jdhs
 * @date 2022-05-12
 */
public interface FontPreuserMapper 
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
     * 删除前端用户
     * 
     * @param userId 前端用户主键
     * @return 结果
     */
    public int deleteFontPreuserByUserId(Long userId);

    /**
     * 批量删除前端用户
     * 
     * @param userIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFontPreuserByUserIds(String[] userIds);

    @Select("select user_id userId,user_name userName,password,real_name realName,address,phone from font_preuser where user_name = #{userName} and password = #{password} limit 1 ")
    FontPreuser pcLogin(FontPreuser fontPreuser);
}
