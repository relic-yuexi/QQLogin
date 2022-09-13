package com.moontidef.qqlogin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {

    private double oldStageX;
    private double oldStageY;
    private double oldScreenX;
    private double oldScreenY;


    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));


        Scene scene = new Scene(fxmlLoader.load(), null);

        scene.setCamera(new PerspectiveCamera()); // 透视相机

        stage.initStyle(StageStyle.TRANSPARENT); // 透明

        stage.setScene(scene);
        stage.show();

        // 鼠标按下事件
        scene.setOnMousePressed(event -> {
            oldStageX = stage.getX();
            oldStageY = stage.getY();
            oldScreenX = event.getScreenX();
            oldScreenY = event.getScreenY();
        });

        // 鼠标拖拽
        scene.setOnMouseDragged(event -> {
            //新位置
            //拖拽前后的鼠标差值加上原始窗体坐标值
            stage.setX(event.getScreenX() - oldScreenX + oldStageX);
            stage.setY(event.getScreenY() - oldScreenY + oldStageY);
        });


    }
}