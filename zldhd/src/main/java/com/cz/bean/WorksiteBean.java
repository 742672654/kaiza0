package com.cz.bean;

public class WorksiteBean {

    private int  id;
    private int comid;
    private String  worksite_name;//工作站名称
    private String  description;
    private int  net_type;//工作站网络环境，0：流量，1：宽带
    private String  host_name;
    private String  host_memory;
    private String  host_internal;
    private int  upload_time;
    private int  state;//状态 0：正常 1：禁用


    //TODO 下面是配置信息
    private String u_id;
    private boolean military; //军车是否免费
    private boolean card; //是否显示月卡用户


    public WorksiteBean(){}


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getComid() {
        return comid;
    }
    public void setComid(int comid) {
        this.comid = comid;
    }
    public String getWorksite_name() {
        return worksite_name;
    }
    public void setWorksite_name(String worksite_name) {
        this.worksite_name = worksite_name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getNet_type() {
        return net_type;
    }
    public void setNet_type(int net_type) {
        this.net_type = net_type;
    }
    public String getHost_name() {
        return host_name;
    }
    public void setHost_name(String host_name) {
        this.host_name = host_name;
    }
    public String getHost_memory() {
        return host_memory;
    }
    public void setHost_memory(String host_memory) {
        this.host_memory = host_memory;
    }
    public String getHost_internal() {
        return host_internal;
    }
    public void setHost_internal(String host_internal) {
        this.host_internal = host_internal;
    }
    public int getUpload_time() {
        return upload_time;
    }
    public void setUpload_time(int upload_time) {
        this.upload_time = upload_time;
    }
    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }
    public String getU_id() {
        return u_id;
    }
    public void setU_id(String u_id) {
        this.u_id = u_id;
    }
    public boolean isMilitary() {
        return military;
    }
    public void setMilitary(boolean military) {
        this.military = military;
    }
    public boolean isCard() {
        return card;
    }
    public void setCard(boolean card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "WorksiteBean{" +
                "u_id=" + u_id +
                "id=" + id +
                ", comid=" + comid +
                ", worksite_name='" + worksite_name + '\'' +
                ", description='" + description + '\'' +
                ", net_type=" + net_type +
                ", host_name='" + host_name + '\'' +
                ", host_memory='" + host_memory + '\'' +
                ", host_internal='" + host_internal + '\'' +
                ", upload_time=" + upload_time +
                ", state=" + state +
                ", military=" + military +
                ", card=" + card +
                '}';
    }

}
