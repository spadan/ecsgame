package com.zhenai.ecsgame.framwork.gameEngine;

import com.zhenai.ecsgame.component.HealthComponent;
import com.zhenai.ecsgame.component.PositionComponent;
import com.zhenai.ecsgame.component.ShapeComponent;
import com.zhenai.ecsgame.framwork.constant.Constant;
import com.zhenai.ecsgame.framwork.constant.ImageHolder;
import com.zhenai.ecsgame.framwork.entity.IEntity;
import com.zhenai.ecsgame.framwork.gameEngine.bean.Position;
import com.zhenai.ecsgame.framwork.gameEngine.bean.Size;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

/**
 * @author xiongLiang
 * @date 2020/1/15 15:55
 */
@Component
public class GameBoard extends JFrame {
    Image iBuffer;
    Graphics gBuffer;
    Collection<IEntity> entities = new ArrayList<>();

    public GameBoard() {
        this.setTitle("飞机大战");
        this.setSize(Constant.BOARD_WIDTH, Constant.BOARD_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(200, 200);
        this.setResizable(false);
        this.setVisible(true);
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
        gBuffer.setColor(Color.RED);
        for (IEntity entity : entities) {
            PositionComponent positionComponent = entity.getComponent(PositionComponent.class);
            ShapeComponent shapeComponent = entity.getComponent(ShapeComponent.class);
            Position position = positionComponent.getPosition();
            int x = position.getX();
            int y = position.getY();
            Size size = shapeComponent.getSize();
            int width = size.getWidth();
            int height = size.getHeight();
            String imageName = shapeComponent.getImageName();
            BufferedImage image = ImageHolder.get(imageName);
            if (image == null) {
                int hp = Optional.ofNullable(entity.getComponent(HealthComponent.class))
                                 .map(HealthComponent::getHp)
                                 .orElse(0);
                image = ImageHolder.get(imageName + "_" + hp);
            }
            gBuffer.drawImage(image, x, y, width, height, null);
        }
        g.drawImage(iBuffer, 0, 0, this);
    }

    public void repaint(Collection<? extends IEntity> iEntities) {
        this.entities.clear();
        this.entities.addAll(iEntities);
        this.repaint();
        this.revalidate();
    }
}
