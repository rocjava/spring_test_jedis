package com.penn.test.vo;

import java.io.Serializable;

public class PersonVo implements Serializable{

    private static final long serialVersionUID = 12342424623242343L;

    private String userName;

    private Integer age;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "PersonVo{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}
