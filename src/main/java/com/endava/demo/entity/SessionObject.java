package com.endava.demo.entity;

import com.endava.demo.service.LoginInfo;

public class SessionObject {

    public SessionObject() {
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public LoginInfo getLoginInfo() {
        return loginInfo;
    }

    public void setLoginInfo(LoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    private Session session;
    private LoginInfo loginInfo;

    public SessionObject(Session session, LoginInfo loginInfo) {
        this.session = session;
        this.loginInfo = loginInfo;
    }
}
