package com.medicine.business.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.medicine.common.annotation.Excel;
import com.medicine.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 新闻对象 tb_journalism
 *
 * @author medicine
 * @date 2024-05-26
 */
public class TbJournalism extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 新闻id */
    private Long id;

    /** 类型 */
    @Excel(name = "类型")
    private String type;

    /** 内容 */
    @Excel(name = "内容")
    private String contents;

    /** 热度 */
    @Excel(name = "热度")
    private Integer heat;

    /** 发布日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发布日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date releaseTime;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setType(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }
    public void setContents(String contents)
    {
        this.contents = contents;
    }

    public String getContents()
    {
        return contents;
    }
    public void setHeat(Integer heat)
    {
        this.heat = heat;
    }

    public Integer getHeat()
    {
        return heat;
    }
    public void setReleaseTime(Date releaseTime)
    {
        this.releaseTime = releaseTime;
    }

    public Date getReleaseTime()
    {
        return releaseTime;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("type", getType())
            .append("contents", getContents())
            .append("heat", getHeat())
            .append("releaseTime", getReleaseTime())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
