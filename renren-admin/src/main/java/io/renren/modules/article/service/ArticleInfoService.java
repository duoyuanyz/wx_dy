package io.renren.modules.article.service;

import io.renren.common.service.CrudService;
import io.renren.modules.article.dto.ArticleInfoDTO;
import io.renren.modules.article.entity.ArticleInfoEntity;

import java.util.List;

/**
 * 物品表
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-06-06
 */
public interface ArticleInfoService extends CrudService<ArticleInfoEntity, ArticleInfoDTO> {

    List<ArticleInfoEntity> listAll();
}