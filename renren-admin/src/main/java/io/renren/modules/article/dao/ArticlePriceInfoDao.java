package io.renren.modules.article.dao;

import io.renren.common.dao.BaseDao;
import io.renren.modules.article.entity.ArticlePriceInfoEntity;
import io.renren.modules.article.vo.ArticlePriceInfoVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 物品价格表
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-06-06
 */
@Mapper
public interface ArticlePriceInfoDao extends BaseDao<ArticlePriceInfoEntity> {
    List<ArticlePriceInfoVo> getDataApp();
	
}