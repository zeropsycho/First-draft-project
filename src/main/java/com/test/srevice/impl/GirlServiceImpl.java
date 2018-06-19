package com.test.srevice.impl;

import com.test.dao.GirlRepository;
import com.test.pojo.Girls;
import com.test.srevice.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class GirlServiceImpl implements GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo() {
        Girls girls = new Girls();
        girls.setAge(15);
        girls.setName("A");
        girlRepository.save(girls);

        Girls girls1 = new Girls();
        girls1.setName("BBBBBBBBBB");
        girls1.setAge(19);
        girlRepository.save(girls1);
        int i = 1 / 0;
    }

    @Override
    public void getGirl() {
        List<Girls> girls = girlRepository.findAll();
        for (int i = 0; i < girls.size(); i++) {

        }
    }
}
