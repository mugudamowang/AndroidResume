package com.example.teamresume;

import java.io.Serializable;

//person实体类

public class Person implements Serializable {
    private String name;
    private String gender;
    private Integer age;
    private String remark;
    private String skill;

    public Person(String name, String gender, Integer age, String remark, String skill) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.remark = remark;
        this.skill = skill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
