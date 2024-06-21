package com.service;

import com.config.SpringConfig;
import com.dao.AreaDao;
import com.domain.Area;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class AreaServiceTest {

    @Autowired
    private AreaService areaService;

    @Test
    public void findByParentIdTest(){
        for (Area area : areaService.findByParentId(0)) {
            System.out.println(area);
        }

    }

    @Test
    public void findByNameTest(){
        Area area = areaService.findByName("湖北省");
        System.out.println(area.getArea_id());
    }
}
