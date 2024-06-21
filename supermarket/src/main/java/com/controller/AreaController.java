package com.controller;


import com.domain.Area;
import com.service.AreaService;
import com.utils.Code;
import com.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/areas")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @GetMapping("/{parentId}")
    public Result getAreaInfo(@PathVariable int parentId){
        List<Area> areas = areaService.findByParentId(parentId);
        return new Result(Code.GET_OK,areas);
    }

    @PostMapping
    public Result getAreaId(String name){
        Area area = areaService.findByName(name);
//        System.out.println(name);
        return new Result(Code.GET_OK,area);
    }

}
