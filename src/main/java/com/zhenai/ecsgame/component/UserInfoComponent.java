package com.zhenai.ecsgame.component;

import com.zhenai.ecsgame.framwork.component.AbstractComponent;
import com.zhenai.ecsgame.framwork.entity.IEntity;

/**
 * @Auther: haitong.zhang
 * @Date: 2020/01/03/10:51
 * @Description:身份信息模块
 */
public class UserInfoComponent extends AbstractComponent {


    public UserInfoComponent(IEntity entity, String userName, String id, UserType userType) {
        super(entity);
        this.userName = userName;
        this.id = id;
        this.userType = userType;
    }

    private String userName;

    private String id;

    private UserType userType;



    public String getUserName() {
        return userName;
    }

    public String getId() {
        return id;
    }

    public UserType getUserType() {
        return userType;
    }

    public enum UserType{
        /**
         * 机器人
         */
        Robot,
        /**
         * 玩家
         */
        Player;

    }



}
