package com.example.jfxrtc;

import dev.onvoid.webrtc.media.MediaDevices;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import dev.onvoid.webrtc.demo.javafx.control.VideoView;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

//        VBox root = new VBox();
//        root.setPadding(new Insets(10));
//        root.setSpacing(8);
//
//        VideoView localVideoView = new VideoView();
//        localVideoView.setLayoutX(100);
//        localVideoView.setLayoutY(100);
//
//        root.getChildren().add(localVideoView);
//
//        PeerBridge.rtcConnection.setVideoTrackSink(localVideoView::setVideoFrame);
//        PeerBridge.rtcConnection.startVideoSource();
//
//        stage.setTitle("WebRTC");
//        stage.setScene(new Scene(root, 300, 275));
//        stage.show();


    }


    public static void main(String[] args) {

        launch();
    }
}