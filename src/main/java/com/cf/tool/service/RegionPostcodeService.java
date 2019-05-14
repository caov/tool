package com.cf.tool.service;

import com.cf.tool.dao.RegionPostcodeDao;
import com.cf.tool.domain.dto.RegionPostcodeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: tool
 * @description: 地区邮编API-service层
 * @author: cf
 * @create: 2019-05-14 17:44
 */

@Service
public class RegionPostcodeService {

    @Autowired
    private RegionPostcodeDao regionPostcodeDao;

    public List<RegionPostcodeDTO> getRegionPostcode(String province, String city, String district) {
        return regionPostcodeDao.getRegionPostcode(province, city, district);
    }
}
