package com.onlinetutorialspoint.pojo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student", catalog = "onlinetutorialspoint"
)
public class Student implements java.io.Serializable {

    private Integer id;
    private String name;
    private Integer rollnumber;
    private Byte gender;
    private String class_;
    private Date lastupdated;

    public Student() {
    }

    public Student(String name, Integer rollnumber, Byte gender, String class_, Date lastupdated) {
        this.name = name;
        this.rollnumber = rollnumber;
        this.gender = gender;
        this.class_ = class_;
        this.lastupdated = lastupdated;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name", length = 50)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "rollnumber")
    public Integer getRollnumber() {
        return this.rollnumber;
    }

    public void setRollnumber(Integer rollnumber) {
        this.rollnumber = rollnumber;
    }

    @Column(name = "gender")
    public Byte getGender() {
        return this.gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    @Column(name = "class", length = 50)
    public String getClass_() {
        return this.class_;
    }

    public void setClass_(String class_) {
        this.class_ = class_;
    }

}
