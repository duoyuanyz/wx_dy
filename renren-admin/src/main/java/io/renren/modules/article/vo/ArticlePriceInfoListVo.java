package io.renren.modules.article.vo;

import lombok.Data;

import java.util.List;

@Data
public class ArticlePriceInfoListVo {
    private String title;
    private List<ArticlePriceInfoVo> dataList;
}
