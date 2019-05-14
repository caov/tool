package com.cf.tool.service;

import com.cf.tool.dao.ChengYuDao;
import com.cf.tool.domain.dto.ChengYuDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: tool
 * @description: 成语API-service层
 * @author: cf
 * @create: 2019-05-14 10:55
 */
@Service
public class ChengYuService {

    @Autowired
    private ChengYuDao chengYuDao;

    public List<ChengYuDTO> getChengYuMessageByWord(String word) {
        return chengYuDao.getChengYuMessageByWord(word);
    }
}
