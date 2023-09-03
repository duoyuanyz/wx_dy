package io.renren.modules.article.controller;

import io.renren.common.annotation.LogOperation;
import io.renren.common.constant.Constant;
import io.renren.common.page.PageData;
import io.renren.common.utils.ExcelUtils;
import io.renren.common.utils.Result;
import io.renren.common.validator.AssertUtils;
import io.renren.common.validator.ValidatorUtils;
import io.renren.common.validator.group.AddGroup;
import io.renren.common.validator.group.DefaultGroup;
import io.renren.common.validator.group.UpdateGroup;
import io.renren.modules.article.dto.ArticleInfoDTO;
import io.renren.modules.article.dto.ArticlePriceInfoDTO;
import io.renren.modules.article.entity.ArticleInfoEntity;
import io.renren.modules.article.excel.ArticleInfoExcel;
import io.renren.modules.article.service.ArticleInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * 物品表
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-06-06
 */
@RestController
@RequestMapping("article/articleinfo")
@Api(tags="物品表")
public class ArticleInfoController {
    @Autowired
    private ArticleInfoService articleInfoService;

    @GetMapping("listAll")
    @ApiOperation("信息")
    @RequiresPermissions("article:articlepriceinfo:page")
    public Result<List<ArticleInfoEntity>> listAll(){
        List<ArticleInfoEntity> articleInfoEntities = articleInfoService.listAll();

        return new Result<List<ArticleInfoEntity>>().ok(articleInfoEntities);
    }

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
        @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
        @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String")
    })
    @RequiresPermissions("article:articleinfo:page")
    public Result<PageData<ArticleInfoDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params){
        PageData<ArticleInfoDTO> page = articleInfoService.page(params);

        return new Result<PageData<ArticleInfoDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    @RequiresPermissions("article:articleinfo:info")
    public Result<ArticleInfoDTO> get(@PathVariable("id") Long id){
        ArticleInfoDTO data = articleInfoService.get(id);

        return new Result<ArticleInfoDTO>().ok(data);
    }

    @PostMapping
    @ApiOperation("保存")
    @LogOperation("保存")
    @RequiresPermissions("article:articleinfo:save")
    public Result save(@RequestBody ArticleInfoDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        articleInfoService.save(dto);

        return new Result();
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("修改")
    @RequiresPermissions("article:articleinfo:update")
    public Result update(@RequestBody ArticleInfoDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        articleInfoService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @ApiOperation("删除")
    @LogOperation("删除")
    @RequiresPermissions("article:articleinfo:delete")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        articleInfoService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @ApiOperation("导出")
    @LogOperation("导出")
    @RequiresPermissions("article:articleinfo:export")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<ArticleInfoDTO> list = articleInfoService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, list, ArticleInfoExcel.class);
    }

}