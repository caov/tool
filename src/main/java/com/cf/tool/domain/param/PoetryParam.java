package com.cf.tool.domain.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @program: tool
 * @description: 唐诗宋词请求参数实体类
 * @author: cf
 * @create: 2019-05-09 10:01
 */
@Data
@ApiModel(value = "唐诗宋词请求参数模型")
public class PoetryParam extends PageParam{

    @NotNull(message = "查询参数不能为空")
    @ApiModelProperty(value = "诗词题目、作业、内容",example = "沁园春", required = true)
    private String param;

}
