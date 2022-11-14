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
        PeerBridge.rtcConnection.startVideoSource();
    }

    @FXML
    protected void onCallBtnClick(){
        System.out.println("Call button clicked");
        PeerBridge.rtcConnection.createOffer();
    }
    @FXML
    private VideoView localVideoView;


    public HelloController() {

    }
    public void initialize() {
        System.out.println("init");
        PeerBridge.rtcConnection.setVideoTrackSink(localVideoView::setVideoFrame);
        System.out.println("finish init");

    }
}