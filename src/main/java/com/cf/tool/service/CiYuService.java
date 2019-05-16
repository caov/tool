package com.cf.tool.service;

import com.cf.tool.dao.CiYuDao;
import com.cf.tool.domain.dto.CiYuDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: tool
 * @description: 词语API-service层
 * @author: cf
 * @create: 2019-05-15 10:34
 */
@Service
public class CiYuService {

    @Autowired
    private CiYuDao ciYuDao;

    public List<CiYuDTO> getCiYuMessageByWord(String word) {
        return ciYuDao.getCiYuMessageByWord(word);
    }
}
