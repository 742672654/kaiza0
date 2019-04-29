package com.cz.bean;

public class LoginUserBean {

    private String uuid; //仅仅是在存日志的时候使用

    private String account;
    private String password;
    private String ip;
    private double edition; //版本号

    private String login_time;
    private String out_time;






    public LoginUserBean(){};

    public LoginUserBean(String account0, String password0, String ip0,int edition0) {
        this.account = account0;
        this.password = password0;
        this.ip = ip0;
        this.edition=edition0;
    }

    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    public String getLogin_time() {
        return login_time;
    }
    public void setLogin_time(String login_time) {
        this.login_time = login_time;
    }
    public String getOut_time() {
        return out_time;
    }
    public void setOut_time(String out_time) {
        this.out_time = out_time;
    }
    public String getUuid() {
        return uuid;
    }
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    public double getEdition() {
        return edition;
    }
    public void setEdition(double edition) {
        this.edition = edition;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "uuid='" + uuid + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", ip='" + ip + '\'' +
                ", edition=" + edition +
                ", login_time='" + login_time + '\'' +
                ", out_time='" + out_time + '\'' +
                '}';
    }
}
