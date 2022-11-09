package com.example.jfxrtc;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import dev.onvoid.webrtc.demo.javafx.control.VideoView;


public class HelloController {

    @FXML
    private Label welcomeText;

    @FXML
    private VBox vBox;


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void onStartBtnClick(){
        PeerBridge.rtcConnection.setVideoTrackSink(localVideoView::setVideoFrame);
        PeerBridge.rtcConnection.startVideoSource();
    }
    @FXML
    private VideoView localVideoView;


    public HelloController() {

    }
}