package com.cf.tool.service;

import com.cf.tool.util.IpRegionUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @program: tool
 * @description: IP查询地区API-Service层
 * @author: cf
 * @create: 2019-05-09 14:56
 */

@Service
public class IpAddressService {

    public String getAddressByIp(String ip) {
        String region = null;
        try {
            region = IpRegionUtils.getAddresses(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return region;
    }
}
