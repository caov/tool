package com.cf.tool.domain.dto;

import lombok.Data;

/**
 * @program: tool
 * @description: 歇后语查询实体类
 * @author: cf
 * @create: 2019-05-10 09:55
 */
@Data
public class XieHouYuDTO {

    //语面
    private String riddle;
    //语底
    private String answer;

}
