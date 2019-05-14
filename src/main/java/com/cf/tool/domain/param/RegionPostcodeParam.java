package com.cf.tool.domain.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @program: tool
 * @description: 地区邮编请求参数实体类
 * @author: cf
 * @create: 2019-05-14 17:38
 */
@Data
@ApiModel
public class RegionPostcodeParam {

    @NotNull
    @ApiModelProperty(value="省",example = "江西省",required = true)
    private String province;
    @NotNull
    @ApiModelProperty(value="地级市",example = "上饶市",required = true)
    private String city;
    @NotNull
    @ApiModelProperty(value="区市县",example = "鄱阳县",required = true)
    private String district;
}
