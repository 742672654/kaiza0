package com;

import java.util.HashMap;
import java.util.Map;

public class Static_bean {


    /**
     * TODO 登录，返回个人信息
     * @param username 账号
     * @param password 密码
     * @param edition 版本号
     * @param type 1是手动登录，2是自动登录
     * @param out 固定值json
     */
    public final static String login = "http://tm.banxie.net:30002/collectorlogin/login";


    /**
     * TODO 获取当前用户对应的停车场工作站
     * @param comid 停车场ID 21733
     * @param action 固定值queryworksite
     * @param out 固定值json
     */
    public final static String worksiteinfo = "http://47.111.11.222:8081/zld/worksiteinfo.do";




}
