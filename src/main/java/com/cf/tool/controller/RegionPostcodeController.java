package com.cf.tool.controller;

import com.cf.tool.domain.dto.ChengYuDTO;
import com.cf.tool.domain.dto.RegionPostcodeDTO;
import com.cf.tool.domain.param.ChengYuParam;
import com.cf.tool.domain.param.RegionPostcodeParam;
import com.cf.tool.service.RegionPostcodeService;
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
 * @description: 地区邮编查询API-Controller层
 * @author: cf
 * @create: 2019-05-09 14:44
 */
@RestController
@Api(value = "RegionPostcodeController", description = "地区邮编API")
@RequestMapping("/api/regionPostcode")
public class RegionPostcodeController extends BaseController{

    @Autowired
    private RegionPostcodeService regionPostcodeService;

    @ApiOperation(value = "查询地区邮编")
    @PostMapping("getRegionPostcode")
    public ApiResult<List<RegionPostcodeDTO>> getRegionPostcode(@RequestBody @Valid RegionPostcodeParam param){
        log.info("getRegionPostcode param:{}", JsonUtils.toJSON(param));
        return ApiResult.ok(regionPostcodeService.getRegionPostcode(param.getProvince(),param.getCity(),param.getDistrict()));
    }

}
