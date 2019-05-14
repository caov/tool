package com.cf.tool.controller;

import com.cf.tool.domain.param.IpParam;
import com.cf.tool.service.IpAddressService;
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
 * @description: IP查询地区API-Controller层
 * @author: cf
 * @create: 2019-05-09 14:42
 */
@RestController
@Api(value = "IpAddressController", description = "IP查询地区API")
@RequestMapping("/api/ipAddress")
public class IpAddressController extends BaseController {

    @Autowired
    private IpAddressService ipAddressService;

    @ApiOperation(value = "根据IP查询地区")
    @PostMapping("getAddressByIp")
    public ApiResult<String> getAddressByIp(@RequestBody @Valid IpParam param){ //@Valid 用来验证参数是否符合要求，比如是否为空
        log.info("getAddressByIp param:{}", JsonUtils.toJSON(param));
        return ApiResult.ok(ipAddressService.getAddressByIp(param.getIp()));
    }
}
