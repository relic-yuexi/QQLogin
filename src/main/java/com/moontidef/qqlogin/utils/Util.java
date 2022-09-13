package com.moontidef.qqlogin.utils;

import javafx.scene.image.Image;

import java.net.URL;

public class Util {
    private Util() {
    }

    public static String getResourceUrl(String path) {
        return Util.class.getResource(path).toExternalForm();
    }

    /**
     * 获得图片文件，
     *
     * @param o        当前的class，传入this即可
     * @param fileName 图片名+扩展名
     * @return 图片image
     */
    public static Image getImg(Object o, String fileName) {
        URL res = o.getClass().getResource("img");
        if (fileName.contains(".")) {
            String temp = res.toString() + "/" + fileName;
            return new Image(temp);
        }
        return null;
    }


}
