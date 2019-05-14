package com.cf.tool.domain.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @program: tool
 * @description: 汉字API-请求参数实体类
 * @author: cf
 * @create: 2019-05-14 10:41
 */
@Data
@ApiModel
public class ZiParam {

    @NotNull
    @ApiModelProperty(value="汉字",example = "国",required = true)
    private String word;
}
