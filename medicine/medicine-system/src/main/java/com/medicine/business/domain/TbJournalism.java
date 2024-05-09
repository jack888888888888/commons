package com.medicine.business.domain;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.medicine.common.core.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.medicine.common.annotation.Excel;

/**
 * 新闻对象 tb_journalism
 *
 * @author medicine
 * @date 2024-04-27
 */
@Data
@TableName("tb_journalism")
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

}
