package io.renren.modules.article.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.renren.common.page.PageData;
import io.renren.common.service.impl.CrudServiceImpl;
import io.renren.common.utils.Result;
import io.renren.modules.article.dao.ArticlePriceInfoDao;
import io.renren.modules.article.dto.ArticlePriceInfoDTO;
import io.renren.modules.article.entity.ArticlePriceInfoEntity;
import io.renren.modules.article.service.ArticlePriceInfoService;
import io.renren.modules.article.vo.ArticlePriceInfoListVo;
import io.renren.modules.article.vo.ArticlePriceInfoVo;
import io.renren.modules.sys.dao.SysDictDataDao;
import io.renren.modules.sys.entity.SysDictDataEntity;
import io.renren.modules.sys.service.SysDictDataService;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 物品价格表
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-06-06
 */
@Service
public class ArticlePriceInfoServiceImpl extends CrudServiceImpl<ArticlePriceInfoDao, ArticlePriceInfoEntity, ArticlePriceInfoDTO> implements ArticlePriceInfoService {

    @Resource
    SysDictDataService sysDictDataService;

    @Override
    public QueryWrapper<ArticlePriceInfoEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");
        String article_id = (String)params.get("article_id");

        QueryWrapper<ArticlePriceInfoEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);
        wrapper.eq(StringUtils.isNotBlank(article_id), "article_id", article_id);

        return wrapper;
    }


    @Override
    public Result<List<ArticlePriceInfoListVo>> getDataApp() {
        List<ArticlePriceInfoListVo> resList=new ArrayList<>();
        List<ArticlePriceInfoVo> dataApp = baseDao.getDataApp();


        List<SysDictDataEntity> articleType = sysDictDataService.listByType("article_type");


        Map<String, List<ArticlePriceInfoVo>> collect = dataApp.stream().collect(Collectors.groupingBy(ArticlePriceInfoVo::getType));

        articleType.forEach(info->{
            ArticlePriceInfoListVo listVo=new ArticlePriceInfoListVo();
            listVo.setTitle(info.getDictLabel());
            listVo.setDataList(collect.get(info.getDictValue()));
            resList.add(listVo);
        });

        return new Result<List<ArticlePriceInfoListVo>>().ok(resList);
    }

    @Override
    public PageData<ArticlePriceInfoDTO> getDataAppByArticleId(Map<String, Object> params) {

        IPage<ArticlePriceInfoEntity> page = baseDao.selectPage(
                getPage(params, "update_time", false),
                getWrapper(params)
        );


        return getPageData(page, currentDtoClass());
    }
}