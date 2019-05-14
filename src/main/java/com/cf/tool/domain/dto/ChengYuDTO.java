package com.cf.tool.domain.dto;

import lombok.Data;

/**
 * @program: tool
 * @description: 成语API-数据库查询实体类
 * @author: cf
 * @create: 2019-05-14 10:56
 */
@Data
public class ChengYuDTO {
    //成语
    private String word;
    //成语拼音
    private String pinyin;
    //成语释义
    private String explanation;
    //成语出处
    private String derivation;
    //成语示例
    private String example;

}
