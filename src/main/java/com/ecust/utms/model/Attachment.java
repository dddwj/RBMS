package com.ecust.utms.model;

public class Attachment {

    private Integer ATID;//附件ID
    private String ATPath;//附件路径
    private Integer CID;//课程ID
    private String ATName; //附件名称

    public String getATPath() {
        return ATPath;
    }

    public void setATPath(String ATPath) {
        this.ATPath = ATPath;
    }

    public Integer getAID() {
        return CID;
    }

    public void setAID(Integer AID) {
        this.CID = AID;
    }

    public Integer getATID() {
        return ATID;
    }

    public void setATID(Integer ATID) {
        this.ATID = ATID;
    }

    public String getATName() {
        return ATName;
    }

    public void setATName(String ATName) {
        this.ATName = ATName;
    }

    @Override
    public String toString() {
        return "Attachment{" +
                "ATID=" + ATID +
                ", ATPath='" + ATPath + '\'' +
                ", CID=" + CID +
                ", ATName='" + ATName + '\'' +
                '}';
    }
}
