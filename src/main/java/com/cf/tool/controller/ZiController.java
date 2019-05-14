package com.cf.tool.controller;

import com.cf.tool.domain.dto.ZiDTO;
import com.cf.tool.domain.param.ZiParam;
import com.cf.tool.service.ZiService;
import com.cf.tool.util.ApiResult;
import com.cf.tool.util.JsonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @program: tool
 * @description: 汉字API-Controller层
 * @author: cf
 * @create: 2019-05-09 14:37
 */
@RestController
@Api(value = "ZiController", description = "汉字API")
@RequestMapping("/api/zi")
public class ZiController extends BaseController {

    @Autowired
    private ZiService ziService;

    @ApiOperation(value = "查询汉字信息")
    @PostMapping("getZiMessage")
    public ApiResult<ZiDTO> getZiMessage(@RequestBody @Valid ZiParam param){
        log.info("getZiMessage param:{}", JsonUtils.toJSON(param));
        return ApiResult.ok(ziService.getZiMessage(param.getWord()));
    }

}
