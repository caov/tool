package com.cf.tool.domain.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @program: tool
 * @description: 歇后语请求参数实体类
 * @author: cf
 * @create: 2019-05-10 09:56
 */
@Data
@ApiModel(value = "歇后语请求参数模型")
public class XieHouYuParam extends PageParam{

    @NotNull
    @ApiModelProperty(value = "语面",example = "狗咬吕洞宾", required=true)
    private String riddle;
}
