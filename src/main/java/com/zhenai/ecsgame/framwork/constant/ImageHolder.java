package com.zhenai.ecsgame.framwork.constant;

import com.google.common.collect.Maps;
import org.apache.commons.io.FilenameUtils;
import org.springframework.util.ResourceUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Map;

/**
 * @author xiongLiang
 * @date 2020/1/16 14:57
 */
public class ImageHolder {
    private static Map<String, BufferedImage> imageMap;

    static {
        imageMap = Maps.newHashMap();
        String path = "F:\\xiongliang\\ecsgame\\src\\main\\resources\\image\\";
        try {
            File[] files = ResourceUtils.getFile(path).listFiles();
            if (files != null) {
                for (File file : files) {
                    BufferedImage image = ImageIO.read(file);
                    imageMap.put(FilenameUtils.getBaseName(file.getName()), image);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage get(String name) {
        return imageMap.get(name);
    }

    public static void main(String[] args) {

    }

}
