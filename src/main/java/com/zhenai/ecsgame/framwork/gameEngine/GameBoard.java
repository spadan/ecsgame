package com.zhenai.ecsgame.framwork.gameEngine;

import com.google.common.collect.Lists;
import com.zhenai.ecsgame.component.HealthComponent;
import com.zhenai.ecsgame.component.ImageComponent;
import com.zhenai.ecsgame.component.PositionComponent;
import com.zhenai.ecsgame.framwork.constant.Constant;
import com.zhenai.ecsgame.framwork.constant.ImageHolder;
import com.zhenai.ecsgame.framwork.entity.IEntity;
import com.zhenai.ecsgame.framwork.gameEngine.bean.Position;
import com.zhenai.ecsgame.framwork.gameEngine.bean.Size;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.*;

/**
 * @author xiongLiang
 * @date 2020/1/15 15:55
 */
@Component
public class GameBoard extends JPanel {
    Image iBuffer;
    Graphics gBuffer;
    Collection<? extends IEntity> entities = new ArrayList<>();

    public GameBoard() {
        JFrame frame = new JFrame();
        frame.add(this);
        frame.setTitle("飞机大战");
        frame.setSize(Constant.BOARD_WIDTH, Constant.BOARD_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        if (iBuffer == null) {
            iBuffer = createImage(this.getSize().width, this.getSize().height);
            gBuffer = iBuffer.getGraphics();
        }
        gBuffer.setColor(getBackground());
        gBuffer.fillRect(0, 0, this.getSize().width, this.getSize().height);
        super.paint(gBuffer);
        List<ImageData> imageDataList = Lists.newArrayList();
        ImageData imageData;
        Collection<? extends IEntity> list = entities;
        for (IEntity entity : list) {
            PositionComponent positionComponent = entity.getComponent(PositionComponent.class);
            ImageComponent shapeComponent = entity.getComponent(ImageComponent.class);
            Position position = positionComponent.getPosition();
            int x = position.getX();
            int y = position.getY();
            Size size = shapeComponent.getSize();
            int w = size.getWidth();
            int h = size.getHeight();
            String imageName = shapeComponent.getImageName();
            BufferedImage image = ImageHolder.get(imageName);
            if (image == null) {
                int hp = Optional.ofNullable(entity.getComponent(HealthComponent.class))
                                 .map(HealthComponent::getHp)
                                 .orElse(0);
                image = ImageHolder.get(imageName + "_" + hp);
            }
            imageData = new ImageData(image, x, y, w, h, shapeComponent.getLayer());
            imageDataList.add(imageData);
        }
        imageDataList.sort(Comparator.comparingInt(e -> e.layer));
        imageDataList.forEach(e -> gBuffer.drawImage(e.image, e.x, e.y, e.w, e.h, null));
        g.drawImage(iBuffer, 0, 0, this);
    }

    public void repaint(Collection<? extends IEntity> iEntities) {
        this.entities = iEntities;
        this.repaint();
        this.revalidate();
    }

    private static class ImageData {
        private BufferedImage image;
        private int x;
        private int y;
        private int w;
        private int h;
        private int layer;

        public ImageData(BufferedImage image, int x, int y, int w, int h, int layer) {
            this.image = image;
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
            this.layer = layer;
        }

    }

}
