package com.cf.tool.service;

import com.cf.tool.dao.PoetryDao;
import com.cf.tool.domain.dto.PoetryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: tool
 * @description: 唐诗宋词API-Service层
 * @author: cf
 * @create: 2019-05-09 10:03
 */
@Service
public class PoetryService {

    @Autowired
    private PoetryDao poetryDao;

    public List<PoetryDTO> getPoetryByParam(String param) {
        return poetryDao.getPoetryByParam(param);
    }
}
