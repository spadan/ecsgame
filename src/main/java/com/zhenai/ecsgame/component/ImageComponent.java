package com.zhenai.ecsgame.component;

import com.zhenai.ecsgame.framwork.component.AbstractComponent;
import com.zhenai.ecsgame.framwork.entity.IEntity;
import com.zhenai.ecsgame.framwork.gameEngine.bean.Size;

/**
 * @Auther: haitong.zhang
 * @Date: 2020/01/03/10:51
 * @Description:形状信息模块
 */
public class ImageComponent extends AbstractComponent {
    private String imageName;
    private Size size;
    /**
     * 层级
     */
    private int layer;


    public ImageComponent(IEntity entity) {
        super(entity);
    }

    public ImageComponent(IEntity entity, int width, int height) {
        super(entity);
        this.size = new Size(width, height);
    }

    public ImageComponent(IEntity entity, int width, int height, int layer, String imageName) {
        super(entity);
        this.size = new Size(width, height);
        this.layer = layer;
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

    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }
}
