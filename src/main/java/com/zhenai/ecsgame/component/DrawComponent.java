package com.zhenai.ecsgame.component;

import com.zhenai.ecsgame.framwork.component.AbstractComponent;
import com.zhenai.ecsgame.framwork.entity.IEntity;
import com.zhenai.ecsgame.framwork.gameEngine.bean.Size;

/**
 * @Auther: haitong.zhang
 * @Date: 2020/01/03/10:51
 * @Description:形状信息模块
 */
public class DrawComponent extends AbstractComponent {
    private String text;
    private String imageName;
    private Size size;

    public DrawComponent(IEntity entity) {
        super(entity);
    }

    public DrawComponent(IEntity entity, int width, int height) {
        super(entity);
        this.size = new Size(width, height);
    }

    public DrawComponent(IEntity entity, int width, int height, String text) {
        super(entity);
        this.size = new Size(width, height);
        this.text = text;
    }

    public Size getSize() {
        return size;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}
