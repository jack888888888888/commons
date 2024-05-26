package com.medicine.web.controller.business;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.medicine.common.annotation.Log;
import com.medicine.common.core.controller.BaseController;
import com.medicine.common.core.domain.AjaxResult;
import com.medicine.common.enums.BusinessType;
import com.medicine.business.domain.TbJournalism;
import com.medicine.business.service.ITbJournalismService;
import com.medicine.common.utils.poi.ExcelUtil;
import com.medicine.common.core.page.TableDataInfo;

/**
 * 新闻Controller
 *
 * @author medicine
 * @date 2024-05-26
 */
@RestController
@RequestMapping("/business/journalism")
public class TbJournalismController extends BaseController
{
    @Autowired
    private ITbJournalismService tbJournalismService;

    /**
     * 查询新闻列表
     */
    @PreAuthorize("@ss.hasPermi('business:journalism:list')")
    @GetMapping("/list")
    public TableDataInfo list(TbJournalism tbJournalism)
    {
        startPage();
        List<TbJournalism> list = tbJournalismService.selectTbJournalismList(tbJournalism);
        return getDataTable(list);
    }

    /**
     * 导出新闻列表
     */
    @PreAuthorize("@ss.hasPermi('business:journalism:export')")
    @Log(title = "新闻", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TbJournalism tbJournalism)
    {
        List<TbJournalism> list = tbJournalismService.selectTbJournalismList(tbJournalism);
        ExcelUtil<TbJournalism> util = new ExcelUtil<TbJournalism>(TbJournalism.class);
        util.exportExcel(response, list, "新闻数据");
    }

    /**
     * 获取新闻详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:journalism:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tbJournalismService.selectTbJournalismById(id));
    }

    /**
     * 新增新闻
     */
    @PreAuthorize("@ss.hasPermi('business:journalism:add')")
    @Log(title = "新闻", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TbJournalism tbJournalism)
    {
        return toAjax(tbJournalismService.insertTbJournalism(tbJournalism));
    }

    /**
     * 修改新闻
     */
    @PreAuthorize("@ss.hasPermi('business:journalism:edit')")
    @Log(title = "新闻", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TbJournalism tbJournalism)
    {
        return toAjax(tbJournalismService.updateTbJournalism(tbJournalism));
    }

    /**
     * 删除新闻
     */
    @PreAuthorize("@ss.hasPermi('business:journalism:remove')")
    @Log(title = "新闻", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tbJournalismService.deleteTbJournalismByIds(ids));
    }
}
