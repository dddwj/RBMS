package com.ecust.utms.model;

import javax.validation.constraints.Email;

public class Teacher {

    private String TID;//教职工ID
    private String Name;//姓名
    private String Passwd;//密码
    private Integer DeptID;//院系ID

    public String getTID() {
        return TID;
    }

    public void setTID(String TID) {
        this.TID = TID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPasswd() {
        return Passwd;
    }

    public void setPasswd(String passwd) {
        Passwd = passwd;
    }

    public Integer getDeptID() {
        return DeptID;
    }

    public void setDeptID(Integer deptID) {
        DeptID = deptID;
    }

}
