package com.cf.tool.controller;

import com.cf.tool.domain.dto.PoetryDTO;
import com.cf.tool.domain.param.PoetryParam;
import com.cf.tool.service.PoetryService;
import com.cf.tool.util.ApiResult;
import com.cf.tool.util.JsonUtils;
import com.cf.tool.util.PageResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @program: tool
 * @description: 唐诗宋词api控制类
 * @author: cf
 * @create: 2019-05-09 10:02
 */
@RestController
@Api(value = "PoetryController", description = "唐诗宋词API")
@RequestMapping("/api/poetry")
public class PoetryController extends BaseController{

    @Autowired
    private PoetryService poetryService;

    @ApiOperation(value = "根据诗词标题或作者或内容查询诗词", response = PoetryDTO.class)
    @PostMapping("getPoetryByParam")
    public ApiResult<PageResult<PoetryDTO>> getPoetryByParam(@RequestBody @Valid PoetryParam param){ //@Valid 用来验证参数是否符合要求，比如是否为空
        log.info("getPoetryByParam param:{}", JsonUtils.toJSON(param));
        //我们只需要PageHelper.startPage，然后紧跟着查询并返回一个list对象，然后用list对象创建一个PageInfo对象。
        PageHelper.startPage(param.getPageNumber(), param.getPageSize());
        List<PoetryDTO> respList = poetryService.getPoetryByParam(param.getParam());
        PageInfo<PoetryDTO> pageInfo = new PageInfo<>(respList);
        return ApiResult.ofPage(respList, pageInfo.getTotal());
    }
}
