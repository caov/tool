package com.cf.tool.dao;

import com.cf.tool.domain.dto.CiYuDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CiYuDao {

    @Select("select ci as word,explanation from ci where ci like CONCAT('%',#{word},'%')")
    List<CiYuDTO> getCiYuMessageByWord(@Param("word") String word);
}
