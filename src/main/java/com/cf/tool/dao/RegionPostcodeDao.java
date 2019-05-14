package com.cf.tool.dao;

import com.cf.tool.domain.dto.RegionPostcodeDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RegionPostcodeDao {

    @Select("select code,province,city,district,area from zip_code where province = #{province} and city = #{city} and district = #{district} group by code")
    List<RegionPostcodeDTO> getRegionPostcode(@Param("province") String province, @Param("city") String city, @Param("district") String district);
}
