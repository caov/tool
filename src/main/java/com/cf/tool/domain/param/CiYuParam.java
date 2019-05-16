package com.cf.tool.domain.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @program: tool
 * @description: 词语API请求参数实体类
 * @author: cf
 * @create: 2019-05-15 10:32
 */
@Data
@ApiModel
public class CiYuParam extends PageParam{

    @NotNull
    @ApiModelProperty(value="词语",example = "即是",required = true)
    private String word;
}
