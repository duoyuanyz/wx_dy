package io.renren.modules.article.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 物品表
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-06-06
 */
@Data
@TableName("article_info")
public class ArticleInfoEntity {

    /**
     * 主键
     */

    @TableId(type = IdType.AUTO)
	private Integer id;
    /**
     * 物品名称
     */
	private String name;
    /**
     * 排序
     */
	private Integer sort;
    /**
     * 物品类型
     */
	private String type;
    /**
     * 是否删除
     */
	private Integer deleted;
}