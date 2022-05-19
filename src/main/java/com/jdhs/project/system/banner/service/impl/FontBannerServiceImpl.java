package com.jdhs.project.system.banner.service.impl;

import java.util.List;
import com.jdhs.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jdhs.project.system.banner.mapper.FontBannerMapper;
import com.jdhs.project.system.banner.domain.FontBanner;
import com.jdhs.project.system.banner.service.IFontBannerService;
import com.jdhs.common.utils.text.Convert;

/**
 * banner图Service业务层处理
 * 
 * @author jdhs
 * @date 2022-05-14
 */
@Service
public class FontBannerServiceImpl implements IFontBannerService 
{
    @Autowired
    private FontBannerMapper fontBannerMapper;

    /**
     * 查询banner图
     * 
     * @param id banner图主键
     * @return banner图
     */
    @Override
    public FontBanner selectFontBannerById(Long id)
    {
        return fontBannerMapper.selectFontBannerById(id);
    }

    /**
     * 查询banner图列表
     * 
     * @param fontBanner banner图
     * @return banner图
     */
    @Override
    public List<FontBanner> selectFontBannerList(FontBanner fontBanner)
    {
        return fontBannerMapper.selectFontBannerList(fontBanner);
    }

    /**
     * 新增banner图
     * 
     * @param fontBanner banner图
     * @return 结果
     */
    @Override
    public int insertFontBanner(FontBanner fontBanner)
    {
        fontBanner.setCreateTime(DateUtils.getNowDate());
        return fontBannerMapper.insertFontBanner(fontBanner);
    }

    /**
     * 修改banner图
     * 
     * @param fontBanner banner图
     * @return 结果
     */
    @Override
    public int updateFontBanner(FontBanner fontBanner)
    {
        fontBanner.setUpdateTime(DateUtils.getNowDate());
        return fontBannerMapper.updateFontBanner(fontBanner);
    }

    /**
     * 批量删除banner图
     * 
     * @param ids 需要删除的banner图主键
     * @return 结果
     */
    @Override
    public int deleteFontBannerByIds(String ids)
    {
        return fontBannerMapper.deleteFontBannerByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除banner图信息
     * 
     * @param id banner图主键
     * @return 结果
     */
    @Override
    public int deleteFontBannerById(Long id)
    {
        return fontBannerMapper.deleteFontBannerById(id);
    }
}
