package com.zhenai.ecsgame.framwork.gameEngine;

import com.zhenai.ecsgame.framwork.entity.IEntity;

/**
 * @Auther: haitong.zhang
 * @Date: 2019/12/30/15:42
 * @Description:
 */
public class NotifyBean {

    public enum Opt{
        Notify_Add,
        Notify_Remove
    }

    private Opt opt;
    private IEntity entity;

    public NotifyBean(Opt opt, IEntity entity) {
        this.opt = opt;
        this.entity = entity;
    }

    public Opt getOpt() {
        return opt;
    }

    public void setOpt(Opt opt) {
        this.opt = opt;
    }

    public IEntity getEntity() {
        return entity;
    }

    public void setEntity(IEntity entity) {
        this.entity = entity;
    }
}
