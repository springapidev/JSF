package com.coderbd.bean;

import com.coderbd.entity.Test;
import com.coderbd.repo.TestRepo;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;



@ViewScoped
@ManagedBean
public class TestBean {

    @Autowired
    private TestRepo repo;

    private List<Test> test;

    public String hello() {
        return "Hello world from Server. Time now: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
    }

    public List<Test> getTest() {
        test=new ArrayList<>();
        test=repo.findAll();
        System.out.println("Size: "+test.size());
                
        return test;
    }

    public void setTest(List<Test> test) {
        this.test = test;
    }

}
