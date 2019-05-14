package com.cf.tool.dao;

import com.cf.tool.domain.dto.XieHouYuDTO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @program: tool
 * @description: 歇后语API-Dao层
 * @author: cf
 * @create: 2019-05-10 09:48
 */
public interface XieHouYuDao {

    @Select("select riddle,answer from xiehouyu where riddle like CONCAT('%',#{riddle},'%')")
    List<XieHouYuDTO> getXieHouYuByRiddle(String riddle);
}
