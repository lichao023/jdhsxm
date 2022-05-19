package com.jdhs.project.system.preuser.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jdhs.project.system.preuser.mapper.FontPreuserMapper;
import com.jdhs.project.system.preuser.domain.FontPreuser;
import com.jdhs.project.system.preuser.service.IFontPreuserService;
import com.jdhs.common.utils.text.Convert;

/**
 * 前端用户Service业务层处理
 * 
 * @author jdhs
 * @date 2022-05-12
 */
@Service
public class FontPreuserServiceImpl implements IFontPreuserService 
{
    @Autowired
    private FontPreuserMapper fontPreuserMapper;

    /**
     * 查询前端用户
     * 
     * @param userId 前端用户主键
     * @return 前端用户
     */
    @Override
    public FontPreuser selectFontPreuserByUserId(Long userId)
    {
        return fontPreuserMapper.selectFontPreuserByUserId(userId);
    }

    /**
     * 查询前端用户列表
     * 
     * @param fontPreuser 前端用户
     * @return 前端用户
     */
    @Override
    public List<FontPreuser> selectFontPreuserList(FontPreuser fontPreuser)
    {
        return fontPreuserMapper.selectFontPreuserList(fontPreuser);
    }

    /**
     * 新增前端用户
     * 
     * @param fontPreuser 前端用户
     * @return 结果
     */
    @Override
    public int insertFontPreuser(FontPreuser fontPreuser)
    {
        return fontPreuserMapper.insertFontPreuser(fontPreuser);
    }

    /**
     * 修改前端用户
     * 
     * @param fontPreuser 前端用户
     * @return 结果
     */
    @Override
    public int updateFontPreuser(FontPreuser fontPreuser)
    {
        return fontPreuserMapper.updateFontPreuser(fontPreuser);
    }

    /**
     * 批量删除前端用户
     * 
     * @param userIds 需要删除的前端用户主键
     * @return 结果
     */
    @Override
    public int deleteFontPreuserByUserIds(String userIds)
    {
        return fontPreuserMapper.deleteFontPreuserByUserIds(Convert.toStrArray(userIds));
    }

    /**
     * 删除前端用户信息
     * 
     * @param userId 前端用户主键
     * @return 结果
     */
    @Override
    public int deleteFontPreuserByUserId(Long userId)
    {
        return fontPreuserMapper.deleteFontPreuserByUserId(userId);
    }

    @Override
    public FontPreuser pcLogin(FontPreuser fontPreuser) {
        return fontPreuserMapper.pcLogin(fontPreuser);
    }
}
