package com.moontidef.qqlogin;

import com.moontidef.qqlogin.utils.Util;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Controller {

    public StackPane rootNode;
    public Button closeBtn;
    public Button minimizeBtn;
    public Button settingBtn;
    public Button cancelBtn;
    public Button checkBtn;
    public Button closeBtn2;
    public Button minimizeBtn2;
    public PasswordField passwordField;
    public ImageView img_lock;
    public Line line2;
    public TextField accountTextField;
    public ImageView img_pg;
    public Line line1;
    public Pane bottomPane;
    public Button loginBtn;
    @FXML
    Pane settingPane;
    @FXML
    Pane loginPane;
    private boolean flipping;


    // 初始化
    @FXML
    private void initialize() {
        accountTextField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                img_pg.setImage(Util.getImg(this, "pg_blue.png"));
                line1.setStyle("-fx-stroke: #12b7f5");
            } else {
                img_pg.setImage(Util.getImg(this, "pg_raw.png"));
                line1.setStyle("-fx-stroke: #e5e5e5");
            }
        });

        passwordField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                img_lock.setImage(Util.getImg(this, "lock_blue.png"));
                line2.setStyle("-fx-stroke: #12b7f5");

            } else {
                img_lock.setImage(Util.getImg(this, "lock_raw.png"));
                line2.setStyle("-fx-stroke: #e5e5e5");

            }
        });

        bottomPane.onMouseClickedProperty().set(event -> bottomPane.requestFocus());


        System.out.println("HelloController initialize");
//        System.out.println();

    }


    // 旋转
    private void flipAnimation(Pane showPane, Pane hidePane, boolean dir) {
        if (flipping) {
            return;
        }
        flipping = true;
        // 隐藏当前显示的界面
        Duration duration = Duration.millis(500); // 旋转时间
        RotateTransition hideRt = new RotateTransition(duration, hidePane); // 旋转动画
        hideRt.setAxis(Rotate.Y_AXIS); // 旋转轴
        hideRt.setFromAngle(0); // 旋转起始角度
        hideRt.setToAngle(dir ? -90 : 90); // 旋转结束角度
        hideRt.setOnFinished(event -> {
            hidePane.setVisible(false);
            showPane.setVisible(true);
        });

        ScaleTransition hideSt = new ScaleTransition(duration, hidePane); // 缩放动画
        hideSt.setFromX(1); // 缩放起始比例
        hideSt.setToX(0.6); // 缩放结束比例
        hideSt.setFromY(1); // 缩放起始比例
        hideSt.setToY(0.6); // 缩放结束比例

        ParallelTransition hidePt = new ParallelTransition(hideRt, hideSt); // 并行动画

        // 显示下一个界面
        RotateTransition showRt = new RotateTransition(duration, showPane);
        showRt.setAxis(Rotate.Y_AXIS);
        showRt.setFromAngle(dir ? 90 : -90);
        showRt.setToAngle(0);

        ScaleTransition showSt = new ScaleTransition(duration, showPane); // 缩放动画
        showSt.setFromX(0.6); // 缩放起始比例
        showSt.setToX(1.0); // 缩放结束比例
        showSt.setFromY(0.6); // 缩放起始比例
        showSt.setToY(1); // 缩放结束比例

        ParallelTransition showPt = new ParallelTransition(showRt, showSt); // 并行动画

        SequentialTransition st = new SequentialTransition(hidePt, showPt); //
        st.setOnFinished(event -> flipping = false);
        st.play();
    }


    public void changeToSetting(ActionEvent actionEvent) {
        // 旋转动画
        flipAnimation(settingPane, loginPane, false);

    }

    public void changeToLogin(ActionEvent actionEvent) {
        // 旋转动画
        flipAnimation(loginPane, settingPane, true);
    }

    // 关闭窗口
    public void closeWindow(ActionEvent actionEvent) {
        System.exit(0);
    }

    // 最小化窗口
    public void minimizeWindow(ActionEvent actionEvent) {
//        rootNode.getScene().getWindow().hide();
        Stage stage = (Stage) rootNode.getScene().getWindow();
        stage.setIconified(true);
        System.out.println("minimizeWindow");
    }

    public boolean loginBtnClicked()
    {
        String account = accountTextField.getText();
        String password = passwordField.getText();
        if (account.equals("ABC") && password.equals("123456"))
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("登录成功");
            alert.setHeaderText("登录成功");
            alert.setContentText("欢迎使用本系统");
            alert.showAndWait();

            return true;
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("登录失败");
            alert.setHeaderText("登录失败");
            alert.setContentText("账号或密码错误");
            alert.showAndWait();

            return false;
        }
    }

}