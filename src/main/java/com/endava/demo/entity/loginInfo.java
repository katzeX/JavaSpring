package com.endava.demo.entity;

public class loginInfo {

    private int loginCount;

    public int getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(int loginCount) {
        this.loginCount = loginCount;
    }

    public String getPreviousLoginTime() {
        return previousLoginTime;
    }

    public void setPreviousLoginTime(String previousLoginTime) {
        this.previousLoginTime = previousLoginTime;
    }

    private String previousLoginTime;
    public loginInfo(int loginCount, String previousLoginTime) {
        this.loginCount = loginCount;
        this.previousLoginTime = previousLoginTime;
    }


}
