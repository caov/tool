package com.cf.tool.domain.dto;

import lombok.Data;

/**
 * @program: tool
 * @description: 汉字API-数据库实体类
 * @author: cf
 * @create: 2019-05-14 10:43
 */
@Data
public class ZiDTO {

    //字
    private String word;
    //旧体字
    private String oldword;
    //笔画数
    private String strokes;
    //拼音
    private String pinyin;
    //部首
    private String radicals;
}
