package com.cf.tool.service;

import com.cf.tool.dao.ZiDao;
import com.cf.tool.domain.dto.ZiDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: tool
 * @description: 汉字API-service层
 * @author: cf
 * @create: 2019-05-14 10:39
 */
@Service
public class ZiService {

    @Autowired
    private ZiDao ziDao;

    public ZiDTO getZiMessage(String word) {
        return ziDao.getZiMessage(word);
    }
}
