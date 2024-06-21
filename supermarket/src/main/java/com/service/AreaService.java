package com.service;

import com.domain.Area;

import java.util.List;

public interface AreaService {
    List<Area> findByParentId(int ParentId);

    Area findByName(String name);
}
