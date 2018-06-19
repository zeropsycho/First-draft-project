package com.test.dao;

import com.test.pojo.Girls;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<Girls, Integer> {

    //通过年龄配置
    public List<Girls> findByAge(Integer age);
}
