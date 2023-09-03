package io.renren.modules.article.service;

import io.renren.common.page.PageData;
import io.renren.common.service.CrudService;
import io.renren.common.utils.Result;
import io.renren.modules.article.dto.ArticlePriceInfoDTO;
import io.renren.modules.article.entity.ArticlePriceInfoEntity;
import io.renren.modules.article.vo.ArticlePriceInfoListVo;
import io.renren.modules.article.vo.ArticlePriceInfoVo;

import java.util.List;
import java.util.Map;

/**
 * 物品价格表
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-06-06
 */
public interface ArticlePriceInfoService extends CrudService<ArticlePriceInfoEntity, ArticlePriceInfoDTO> {
    Result<List<ArticlePriceInfoListVo>> getDataApp();

    PageData<ArticlePriceInfoDTO>  getDataAppByArticleId(Map<String, Object> params);
}