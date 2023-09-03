package io.renren.modules.article.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import java.math.BigDecimal;

/**
 * 物品价格表
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-06-06
 */
@Data
@ApiModel(value = "物品价格表")
public class ArticlePriceInfoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "")
	private Integer id;

	@ApiModelProperty(value = "物品关联id")
	private Integer articleId;

	@ApiModelProperty(value = "价格")
	private BigDecimal price;

	@ApiModelProperty(value = "是否删除")
	private Integer deleted;

	@ApiModelProperty(value = "")
	private Date createTime;

	@ApiModelProperty(value = "")
	private Date updateTime;


}