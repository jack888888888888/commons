package com.medicine.business.mapper;

import com.medicine.business.domain.TbJournalism;

import java.util.List;

/**
 * 新闻Mapper接口
 *
 * @author medicine
 * @date 2024-05-26
 */
public interface TbJournalismMapper
{
    /**
     * 查询新闻
     *
     * @param id 新闻主键
     * @return 新闻
     */
    public TbJournalism selectTbJournalismById(Long id);

    /**
     * 查询新闻列表
     *
     * @param tbJournalism 新闻
     * @return 新闻集合
     */
    public List<TbJournalism> selectTbJournalismList(TbJournalism tbJournalism);

    /**
     * 新增新闻
     *
     * @param tbJournalism 新闻
     * @return 结果
     */
    public int insertTbJournalism(TbJournalism tbJournalism);

    /**
     * 修改新闻
     *
     * @param tbJournalism 新闻
     * @return 结果
     */
    public int updateTbJournalism(TbJournalism tbJournalism);

    /**
     * 删除新闻
     *
     * @param id 新闻主键
     * @return 结果
     */
    public int deleteTbJournalismById(Long id);

    /**
     * 批量删除新闻
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbJournalismByIds(Long[] ids);
}
