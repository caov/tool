package com.cf.tool.domain.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotNull;

/**
 * @program: tool
 * @description: IP查询地区请求参数实体类
 * @author: cf
 * @create: 2019-05-09 15:00
 */
@Data
@ApiModel
public class IpParam {

    @NotNull(message = "ip地址不能为空")
    @ApiModelProperty(value = "ip地址",example = "14.215.177.38", required = true)
    private String ip;

}
