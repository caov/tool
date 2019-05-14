package com.cf.tool.domain.dto;

import lombok.Data;

/**
 * @program: tool
 * @description: 地区邮编数据库查询实体类
 * @author: cf
 * @create: 2019-05-14 17:41
 */
@Data
public class RegionPostcodeDTO {
    //邮编
    private String code;

    //省
    private String province;

    //地级市
    private String city;

    //市县
    private String district;

    //镇乡村
    private String area;
}
