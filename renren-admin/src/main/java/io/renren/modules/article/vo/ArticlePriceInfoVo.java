package io.renren.modules.article.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 物品价格表
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-06-06
 */
@Data
public class ArticlePriceInfoVo {
	private Integer id;
	private String name;

	private BigDecimal price;

	private String date;

    private String time;
    private String type;

}