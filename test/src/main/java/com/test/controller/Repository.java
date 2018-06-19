package com.test.controller;

import com.test.dao.GirlRepository;
import com.test.pojo.Girls;
import com.test.pojo.Result;
import com.test.srevice.GirlService;
import com.test.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class Repository {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 查询所有女生
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girls> girlList() {
        return girlRepository.findAll();
    }


    /**
     * 添加一个女生
     */
    @PostMapping(value = "/save")
    public Result<Girls> girlAdd(@Valid Girls girls, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Result result = ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
            return result;
        }
        Result result = ResultUtil.success(girlRepository.save(girls));
        return result;
    }

    /**
     * 查询一个女生
     */
    /*@GetMapping(value = "/girls/{id}")
    public Girls girlFindOne(@PathVariable("id") Integer id) {

        return girlRepository.fin(id);
    }*/

    /**
     * 更新数据
     * put应该使用form-urlencoded方法测试
     */
    @PutMapping(value = "/update/{id}")
    public Girls girlsUpdate(@PathVariable("id") Integer id,
                             Girls girls) {
        girls.setId(id);
        return girlRepository.save(girls);
    }

    /**
     * 删除特定id
     * @param id
     */
    @DeleteMapping(value = "/delete/{id}")
    public void girlDelete(@PathVariable("id") Integer id) {
        girlRepository.deleteById(id);
    }

    @DeleteMapping(value = "/age/delete/{id}")
    public void girlDeleteByAge(@PathVariable("id") Integer id) {
        girlRepository.findByAge(id);
    }

    @PostMapping(value = "/grils/save")
    public void saveGirls() {
        girlService.insertTwo();
    }
}
