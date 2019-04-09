package com.bedrock.boss_zp.model;

public class ContactsBean {

    String name;
    String mgrMsg;
    String chatDate;

    public ContactsBean(){}

    public ContactsBean(String name, String mgrMsg, String chatDate) {
        this.name = name;
        this.mgrMsg = mgrMsg;
        this.chatDate = chatDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMgrMsg() {
        return mgrMsg;
    }

    public void setMgrMsg(String mgrMsg) {
        this.mgrMsg = mgrMsg;
    }

    public String getChatDate() {
        return chatDate;
    }

    public void setChatDate(String chatDate) {
        this.chatDate = chatDate;
    }
}
