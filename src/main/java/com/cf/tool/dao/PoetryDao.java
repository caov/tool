package com.cf.tool.dao;

import com.cf.tool.domain.dto.PoetryDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PoetryDao {

    List<PoetryDTO> getPoetryByParam(@Param("param")String param);
}
