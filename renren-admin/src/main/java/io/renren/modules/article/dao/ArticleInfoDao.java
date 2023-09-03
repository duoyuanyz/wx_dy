package io.renren.modules.article.dao;

import io.renren.common.dao.BaseDao;
import io.renren.modules.article.entity.ArticleInfoEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 物品表
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-06-06
 */
@Mapper
public interface ArticleInfoDao extends BaseDao<ArticleInfoEntity> {
	
}