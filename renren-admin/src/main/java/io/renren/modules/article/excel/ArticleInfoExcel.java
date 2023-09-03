package io.renren.modules.article.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * 物品表
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-06-06
 */
@Data
public class ArticleInfoExcel {
    @Excel(name = "主键")
    private Integer id;
    @Excel(name = "物品名称")
    private String name;
    @Excel(name = "排序")
    private Integer sort;
    @Excel(name = "物品类型")
    private String type;
    @Excel(name = "是否删除")
    private Integer deleted;

}