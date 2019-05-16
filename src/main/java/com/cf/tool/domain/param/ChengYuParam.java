package com.cf.tool.domain.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @program: tool
 * @description: 成语API-请求参数实体类
 * @author: cf
 * @create: 2019-05-14 10:55
 */
@Data
@ApiModel
public class ChengYuParam extends PageParam{
    @NotNull
    @ApiModelProperty(value="成语",example = "安然无恙",required = true)
    private String word;
}
