package com.cf.tool.dao;

import com.cf.tool.domain.dto.ChengYuDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ChengYuDao {

    @Select("select word,pinyin,explanation,derivation,example from chengyu where word like CONCAT('%',#{word},'%')")
    List<ChengYuDTO> getChengYuMessageByWord(@Param("word") String word);
}
