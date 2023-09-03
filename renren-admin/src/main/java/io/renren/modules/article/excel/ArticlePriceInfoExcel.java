package io.renren.modules.article.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 物品价格表
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-06-06
 */
@Data
public class ArticlePriceInfoExcel {
    @Excel(name = "")
    private Integer id;
    @Excel(name = "物品关联id")
    private Integer articleId;
    @Excel(name = "价格")
    private BigDecimal price;
    @Excel(name = "是否删除")
    private Integer deleted;
    @Excel(name = "")
    private Date createTime;
    @Excel(name = "")
    private Date updateTime;

}