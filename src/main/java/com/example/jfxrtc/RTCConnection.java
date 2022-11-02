package com.example.jfxrtc;

import dev.onvoid.webrtc.*;
import dev.onvoid.webrtc.media.MediaStream;
import dev.onvoid.webrtc.media.MediaStreamTrack;
import dev.onvoid.webrtc.media.audio.*;
import dev.onvoid.webrtc.media.video.VideoDeviceSource;
import dev.onvoid.webrtc.media.video.VideoTrack;
import dev.onvoid.webrtc.media.MediaDevices;
import javafx.scene.media.MediaPlayer;

import java.util.ArrayList;
import java.util.List;

//Create
public class RTCConnection implements PeerConnectionObserver{

    private static RTCPeerConnection peerConnection;
//    private static VideoDeviceSource videoDeviceSource; // until i see the need for this again
//    private static VideoTrack videoTrack;




    RTCConnection(){
        // Stun Server configuration
        RTCConfiguration rtcConfiguration = new RTCConfiguration();
        RTCIceServer stunServer = new RTCIceServer();
        stunServer.urls.add("stun:stun.l.google.com:19302");
        rtcConfiguration.iceServers.add(stunServer);

        //create peer connection
        PeerConnectionFactory peerConnectionFactory = new PeerConnectionFactory();
        peerConnection = peerConnectionFactory.createPeerConnection(rtcConfiguration, this);


        //************************** Create Local Video And Audio Track ******************************//
        VideoDeviceSource videoDeviceSource = new VideoDeviceSource();
        videoDeviceSource.setVideoCaptureDevice(MediaDevices.getVideoCaptureDevices().get(0));
        VideoTrack videoTrack = peerConnectionFactory.createVideoTrack("video", videoDeviceSource);


        AudioTrackSource audioSource =  peerConnectionFactory.createAudioSource(new AudioOptions());
        AudioTrack audioTrack = peerConnectionFactory.createAudioTrack("audioTrack", audioSource);

        //***************** Adding Audio and Video Track to media Stream - on PeerConnection **************//

        List<String> streamIds = new ArrayList<>();
        streamIds.add("stream-0");

        //Consider Making Context Static
        RTCRtpSender videoSender = peerConnection.addTrack(videoTrack, streamIds);
        RTCRtpSender audioSender = peerConnection.addTrack(audioTrack, streamIds);






    }


    public RTCPeerConnection getPeerConnection() {
        return peerConnection;
    }

    public void createOffer(){
        peerConnection.createOffer(new RTCOfferOptions(), new CreateSessionDescriptionObserver() {
            @Override
            public void onSuccess(RTCSessionDescription rtcSessionDescription) {
                peerConnection.setLocalDescription(rtcSessionDescription, new SetSessionDescriptionObserver() {
                    @Override
                    public void onSuccess() {

                        //send to peer
                        System.out.println(rtcSessionDescription);
                    }

                    @Override
                    public void onFailure(String s) {
                        System.out.println("set local description failure");
                    }
                });
            }

            @Override
            public void onFailure(String s) {

            }
        });
    }


    @Override
    public void onSignalingChange(RTCSignalingState state) {
        PeerConnectionObserver.super.onSignalingChange(state);
    }

    @Override
    public void onConnectionChange(RTCPeerConnectionState state) {
        PeerConnectionObserver.super.onConnectionChange(state);
    }

    @Override
    public void onIceConnectionChange(RTCIceConnectionState state) {
        PeerConnectionObserver.super.onIceConnectionChange(state);
    }

    @Override
    public void onStandardizedIceConnectionChange(RTCIceConnectionState state) {
        PeerConnectionObserver.super.onStandardizedIceConnectionChange(state);
    }

    @Override
    public void onIceConnectionReceivingChange(boolean receiving) {
        PeerConnectionObserver.super.onIceConnectionReceivingChange(receiving);
    }

    @Override
    public void onIceGatheringChange(RTCIceGatheringState state) {
        PeerConnectionObserver.super.onIceGatheringChange(state);
    }

    @Override
    public void onIceCandidate(RTCIceCandidate rtcIceCandidate) {
        System.out.println("onIceCandidate");

    }

    @Override
    public void onIceCandidateError(RTCPeerConnectionIceErrorEvent event) {
        PeerConnectionObserver.super.onIceCandidateError(event);
    }

    @Override
    public void onIceCandidatesRemoved(RTCIceCandidate[] candidates) {
        PeerConnectionObserver.super.onIceCandidatesRemoved(candidates);
    }

    @Override
    public void onAddStream(MediaStream stream) {
        System.out.println("onAddStream");
        PeerConnectionObserver.super.onAddStream(stream);
    }

    @Override
    public void onRemoveStream(MediaStream stream) {
        PeerConnectionObserver.super.onRemoveStream(stream);
    }

    @Override
    public void onDataChannel(RTCDataChannel dataChannel) {
        PeerConnectionObserver.super.onDataChannel(dataChannel);
    }

    @Override
    public void onRenegotiationNeeded() {
        PeerConnectionObserver.super.onRenegotiationNeeded();
    }

    @Override
    public void onAddTrack(RTCRtpReceiver receiver, MediaStream[] mediaStreams) {
        PeerConnectionObserver.super.onAddTrack(receiver, mediaStreams);
    }

    @Override
    public void onRemoveTrack(RTCRtpReceiver receiver) {
        PeerConnectionObserver.super.onRemoveTrack(receiver);
    }

    @Override
    public void onTrack(RTCRtpTransceiver transceiver) {
        PeerConnectionObserver.super.onTrack(transceiver);
    }


}
