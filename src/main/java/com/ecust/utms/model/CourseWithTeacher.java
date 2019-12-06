package com.ecust.utms.model;

public class CourseWithTeacher {

    private Integer CID;
    private String CName;
    private String Term;
    private String TName;

    public Integer getCID() {
        return CID;
    }

    public void setCID(Integer CID) {
        this.CID = CID;
    }

    public String getCName() {
        return CName;
    }

    public void setCName(String CName) {
        this.CName = CName;
    }

    public String getTerm() {
        return Term;
    }

    public void setTerm(String term) {
        Term = term;
    }

    public String getTName() {
        return TName;
    }

    public void setTName(String TName) {
        this.TName = TName;
    }

    @Override
    public String toString() {
        return "CourseWithTeacher{" +
                "CID=" + CID +
                ", CName='" + CName + '\'' +
                ", Term='" + Term + '\'' +
                ", TName='" + TName + '\'' +
                '}';
    }
}
