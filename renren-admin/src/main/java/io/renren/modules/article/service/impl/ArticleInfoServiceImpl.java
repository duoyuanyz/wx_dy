package io.renren.modules.article.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.common.service.impl.CrudServiceImpl;
import io.renren.modules.article.dao.ArticleInfoDao;
import io.renren.modules.article.dto.ArticleInfoDTO;
import io.renren.modules.article.entity.ArticleInfoEntity;
import io.renren.modules.article.service.ArticleInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 物品表
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-06-06
 */
@Service
public class ArticleInfoServiceImpl extends CrudServiceImpl<ArticleInfoDao, ArticleInfoEntity, ArticleInfoDTO> implements ArticleInfoService {

    @Override
    public QueryWrapper<ArticleInfoEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<ArticleInfoEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


    @Override
    public List<ArticleInfoEntity> listAll() {
        QueryWrapper<ArticleInfoEntity> qw=new QueryWrapper<>();
        qw.eq("deleted",0);
        qw.orderByAsc("type","sort");


        return baseDao.selectList(qw);
    }
}