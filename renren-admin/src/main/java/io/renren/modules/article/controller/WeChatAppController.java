package io.renren.modules.article.controller;

import io.renren.common.constant.Constant;
import io.renren.common.page.PageData;
import io.renren.common.utils.Result;
import io.renren.modules.article.dto.ArticlePriceInfoDTO;
import io.renren.modules.article.service.ArticlePriceInfoService;
import io.renren.modules.article.vo.ArticlePriceInfoListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Map;


/**
 * 物品价格表
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-06-06
 */
@RestController
@RequestMapping("weChatApp")
@Api(tags="物品价格表")
public class WeChatAppController {
    @Autowired
    private ArticlePriceInfoService articlePriceInfoService;

    @GetMapping("getDataApp")
    @ApiOperation("小程序获取每个物品最新数据")
    public Result<List<ArticlePriceInfoListVo>> getDataApp(){
        Result<List<ArticlePriceInfoListVo>> data = articlePriceInfoService.getDataApp();

        return data;
    }

    @GetMapping("getDataAppByArticleId")
    @ApiOperation("小程序获取指定物品最新数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
            @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int"),
            @ApiImplicitParam(name = "article_id", value = "指定物品id", paramType = "query",required = true, dataType="int")
    })
    public Result<PageData<ArticlePriceInfoDTO>> getDataAppByArticleId(@ApiIgnore @RequestParam Map<String, Object> params){

        return new Result<PageData<ArticlePriceInfoDTO>>().ok(articlePriceInfoService.getDataAppByArticleId(params));
    }


}