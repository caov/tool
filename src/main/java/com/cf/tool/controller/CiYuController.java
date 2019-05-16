package com.cf.tool.controller;

import com.cf.tool.domain.dto.ChengYuDTO;
import com.cf.tool.domain.dto.CiYuDTO;
import com.cf.tool.domain.param.ChengYuParam;
import com.cf.tool.domain.param.CiYuParam;
import com.cf.tool.service.ChengYuService;
import com.cf.tool.service.CiYuService;
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
 * @description: 词语API-Controller层
 * @author: cf
 * @create: 2019-05-09 14:40
 */
@RestController
@Api(value = "CiYuController", description = "词语API")
@RequestMapping("/api/ciyu")
public class CiYuController extends BaseController{

    @Autowired
    private CiYuService ciYuService;

    @ApiOperation(value = "查询词语信息")
    @PostMapping("getCiYuMessageByWord")
    public ApiResult<PageResult<CiYuDTO>> getCiYuMessageByWord(@RequestBody @Valid CiYuParam param){
        log.info("getCiYuMessageByWord param:{}", JsonUtils.toJSON(param));
        PageHelper.startPage(param.getPageNumber(),param.getPageSize());
        List<CiYuDTO> dtoList = ciYuService.getCiYuMessageByWord(param.getWord());
        PageInfo<CiYuDTO> pageInfo = new PageInfo<>(dtoList);
        return ApiResult.ofPage(dtoList,pageInfo.getTotal());
    }
}
