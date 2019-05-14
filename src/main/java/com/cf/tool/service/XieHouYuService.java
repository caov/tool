package com.cf.tool.service;

import com.cf.tool.dao.XieHouYuDao;
import com.cf.tool.domain.dto.XieHouYuDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: tool
 * @description: 歇后语API-Service层
 * @author: cf
 * @create: 2019-05-10 09:48
 */
@Service
public class XieHouYuService {

    @Autowired
    private XieHouYuDao xieHouYuDao;

    public List<XieHouYuDTO> getXieHouYuByRiddle(String riddle) {
        return xieHouYuDao.getXieHouYuByRiddle(riddle);
    }
}
