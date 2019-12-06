package com.ecust.utms.model;

public class Student {

    private String SID;//学生ID
    private String Name;//姓名
    private String Passwd;//密码
    private String Major;//专业
    private Integer DeptID;//院系ID

    public String getSID() {
        return SID;
    }

    public void setSID(String SID) {
        this.SID = SID;
    }

    public String getMajor() {
        return Major;
    }

    public void setMajor(String major) {
        Major = major;
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
