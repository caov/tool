package com.cf.tool.dao;

import com.cf.tool.domain.dto.ZiDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ZiDao {

    @Select("select word,oldword,strokes,pinyin,radicals from zi where word = #{word}")
    ZiDTO getZiMessage(@Param("word") String word);
}
