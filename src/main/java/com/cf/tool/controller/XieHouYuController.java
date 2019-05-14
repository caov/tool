package com.cf.tool.controller;

import com.cf.tool.domain.dto.XieHouYuDTO;
import com.cf.tool.domain.param.XieHouYuParam;
import com.cf.tool.service.XieHouYuService;
import com.cf.tool.util.ApiResult;
import com.cf.tool.util.JsonUtils;
import com.cf.tool.util.PageResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @program: tool
 * @description: 歇后语API-Controller层
 * @author: cf
 * @create: 2019-05-09 14:39
 */
@RestController
@Api(value = "XieHouYuController", description = "歇后语API")
@RequestMapping("/api/xiehouyu")
public class XieHouYuController extends BaseController{

    @Autowired
    private XieHouYuService xieHouYuService;

    @ApiOperation(value = "根据语面查询歇后语")
    @PostMapping("getXieHouYuByRiddle")
    public ApiResult<PageResult<XieHouYuDTO>> getXieHouYuByRiddle(@RequestBody @Valid XieHouYuParam param){ //@Valid 用来验证参数是否符合要求，比如是否为空
        log.info("getXieHouYuByRiddle param:{}", JsonUtils.toJSON(param));
        PageHelper.startPage(param.getPageNumber(),param.getPageSize());
        List<XieHouYuDTO> dtoList = xieHouYuService.getXieHouYuByRiddle(param.getRiddle());
        PageInfo<XieHouYuDTO> pageInfo = new PageInfo<>(dtoList);
        return ApiResult.ofPage(dtoList,pageInfo.getTotal());
    }

}
