package com.dao;

import com.domain.Area;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AreaDao {

    @Select("select * from dou_area where parent_id=#{parentId}")
    List<Area> selectByParentId(int parentId);

    @Select("select * from dou_area where name=#{name}")
    Area selectByName(String name);

}
