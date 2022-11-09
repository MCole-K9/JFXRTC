module com.example.jfxrtc {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires webrtc.java;
    requires webrtc.java.demo.javafx;


    opens com.example.jfxrtc to javafx.fxml;
    exports com.example.jfxrtc;
}