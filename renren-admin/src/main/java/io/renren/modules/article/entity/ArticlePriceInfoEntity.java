package io.renren.modules.article.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("article_price_info")
public class ArticlePriceInfoEntity {

    /**
     * 
     */
    @TableId(type = IdType.AUTO)
	private Integer id;
    /**
     * 物品关联id
     */
	private Integer articleId;
    /**
     * 价格
     */
	private BigDecimal price;
    /**
     * 是否删除
     */
	private Integer deleted;
    /**
     * 
     */
	private Date createTime;
    /**
     * 
     */
	private Date updateTime;
}