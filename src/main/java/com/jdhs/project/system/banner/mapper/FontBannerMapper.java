package com.jdhs.project.system.banner.mapper;

import java.util.List;
import com.jdhs.project.system.banner.domain.FontBanner;

/**
 * banner图Mapper接口
 * 
 * @author jdhs
 * @date 2022-05-14
 */
public interface FontBannerMapper 
{
    /**
     * 查询banner图
     * 
     * @param id banner图主键
     * @return banner图
     */
    public FontBanner selectFontBannerById(Long id);

    /**
     * 查询banner图列表
     * 
     * @param fontBanner banner图
     * @return banner图集合
     */
    public List<FontBanner> selectFontBannerList(FontBanner fontBanner);

    /**
     * 新增banner图
     * 
     * @param fontBanner banner图
     * @return 结果
     */
    public int insertFontBanner(FontBanner fontBanner);

    /**
     * 修改banner图
     * 
     * @param fontBanner banner图
     * @return 结果
     */
    public int updateFontBanner(FontBanner fontBanner);

    /**
     * 删除banner图
     * 
     * @param id banner图主键
     * @return 结果
     */
    public int deleteFontBannerById(Long id);

    /**
     * 批量删除banner图
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFontBannerByIds(String[] ids);
}
