package com.cf.tool.controller;

import com.cf.tool.domain.dto.ChengYuDTO;
import com.cf.tool.domain.dto.XieHouYuDTO;
import com.cf.tool.domain.dto.ZiDTO;
import com.cf.tool.domain.param.ChengYuParam;
import com.cf.tool.domain.param.ZiParam;
import com.cf.tool.service.ChengYuService;
import com.cf.tool.service.ZiService;
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
 * @description: 成语API-Controller层
 * @author: cf
 * @create: 2019-05-09 14:36
 */
@RestController
@Api(value = "ZiController", description = "成语API")
@RequestMapping("/api/chengyu")
public class ChengYuController extends BaseController{

    @Autowired
    private ChengYuService chengYuService;

    @ApiOperation(value = "查询成语信息")
    @PostMapping("getChengYuMessageByWord")
    public ApiResult<PageResult<ChengYuDTO>> getChengYuMessageByWord(@RequestBody @Valid ChengYuParam param){
        log.info("getChengYuMessageByWord param:{}", JsonUtils.toJSON(param));
        PageHelper.startPage(param.getPageNumber(),param.getPageSize());
        List<ChengYuDTO> dtoList = chengYuService.getChengYuMessageByWord(param.getWord());
        PageInfo<ChengYuDTO> pageInfo = new PageInfo<>(dtoList);
        return ApiResult.ofPage(dtoList,pageInfo.getTotal());
    }
}
