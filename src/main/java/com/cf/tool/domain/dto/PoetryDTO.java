package com.cf.tool.domain.dto;

import lombok.Data;

/**
 * @program: tool
 * @description: 唐诗宋词数据库实体类
 * @author: cf
 * @create: 2019-05-09 09:59
 */
@Data //lombok的注解，在编译后，自动生成相应的方法。消除了代码的冗余，ctrl+F12快捷键可以看到实现的方法
public class PoetryDTO {

    //作者
    private String poetryAuthor;

    //诗词内容
    private String poetryContent;

    //诗词题目
    private String poetryTitle;


}
