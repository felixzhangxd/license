package com.firebugsoft.license.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public final class ImageUtil {
    private ImageUtil() {}

    /** 图片二值化 */
    public static BufferedImage imageBinary(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage binary = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int rgb = image.getRGB(i, j);
                binary.setRGB(i, j, rgb);
            }
        }
        return binary;
    }

    /** 图片灰度化 */
    public static BufferedImage imageGray(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage gray = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int rgb = image.getRGB(i, j);
                gray.setRGB(i, j, rgb);
            }
        }
        return gray;
    }

    public static void main(String[] args) throws IOException {
        BufferedImage image = ImageIO.read(new File("E:\\duck.jpg"));
        BufferedImage binary = imageBinary(image);
        ImageIO.write(binary, "jpg", new File("E:\\duck-binary.jpg"));
        BufferedImage gray = imageGray(image);
        ImageIO.write(gray, "jpg", new File("E:\\duck-gray.jpg"));
    }

}
