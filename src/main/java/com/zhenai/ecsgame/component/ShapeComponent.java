package com.zhenai.ecsgame.component;

import com.zhenai.ecsgame.framwork.component.AbstractComponent;
import com.zhenai.ecsgame.framwork.entity.IEntity;
import com.zhenai.ecsgame.framwork.gameEngine.bean.Size;

/**
 * @Auther: haitong.zhang
 * @Date: 2020/01/03/10:51
 * @Description:形状信息模块
 */
public class ShapeComponent extends AbstractComponent {
    private String imageName;
    private Size size;


    public ShapeComponent(IEntity entity) {
        super(entity);
    }

    public ShapeComponent(IEntity entity, int width, int height) {
        super(entity);
        this.size = new Size(width, height);
    }

    public ShapeComponent(IEntity entity, int width, int height, String imageName) {
        super(entity);
        this.size = new Size(width, height);
        this.imageName = imageName;
    }

    public Size getSize() {
        return size;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}
