package com.cf.tool.dao;

import com.cf.tool.domain.dto.PoetryDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PoetryDao {

    @Select(" select content as poetryContent,title as poetryTitle,author as poetryAuthor from poetries where title LIKE concat(concat('%',#{param}),'%')\n" +
            "        or content LIKE concat(concat('%',#{param}),'%') or author LIKE concat(concat('%',#{param}),'%')")
    List<PoetryDTO> getPoetryByParam(@Param("param")String param);
}
