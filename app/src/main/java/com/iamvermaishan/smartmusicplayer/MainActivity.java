package com.iamvermaishan.smartmusicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.GestureOverlayView.OnGesturePerformedListener;
import android.gesture.Prediction;
import android.view.View;
import android.widget.Toast;
import android.gesture.Gesture;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import kotlinx.coroutines.JobKt;


public class MainActivity extends AppCompatActivity  implements  OnGesturePerformedListener {

    private GestureLibrary objGestureLib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();


        objGestureLib = GestureLibraries.fromRawResource(this, R.raw.gestures);
        if (!objGestureLib.load()) {
            finish();
        }

        GestureOverlayView objGestureOverlay = (GestureOverlayView) findViewById(R.id.widgetGestures);
        objGestureOverlay.addOnGesturePerformedListener(this);


    }

    public void play_music(String url) {



        MediaPlayer mediaPlayer = new MediaPlayer();
        try {

            mediaPlayer.setDataSource(url);
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {

                    mediaPlayer.start();
                    mediaPlayer.getCurrentPosition();
                }
            });

            mediaPlayer.prepare();


        } catch (IOException e) {

            e.printStackTrace();

        }
    }


    @Override
    public void onGesturePerformed(GestureOverlayView gestureOverlayView, Gesture gesture) {

        ArrayList<Prediction> objPrediction = objGestureLib.recognize(gesture);

        if (objPrediction.size() > 0 && objPrediction.get(0).score > 1) {

            String geastureName = objPrediction.get(0).name;

            Toast.makeText(this, geastureName, Toast.LENGTH_SHORT).show();



       if(Objects.equals(geastureName,"a")){
           play_music("https://firebasestorage.googleapis.com/v0/b/smartmusicplayer-e89f3.appspot.com/o/Naruto%20Shipp%C5%ABden%20OST%20-%20Floating%20Dead%20Leaves%20(Ochibabune)(MP3_320K).mp3?alt=media&token=86e4d266-3d78-49dd-a95f-95460f922f71");
       }
        else if(Objects.equals(geastureName,"pentagon")){
            play_music("https://firebasestorage.googleapis.com/v0/b/smartmusicplayer-e89f3.appspot.com/o/Imagine%20Dragons%20-%20Believer.mp3?alt=media&token=5a73a44f-dbec-4d87-b2d8-63fe3edd3dcf");
        }
        else if(Objects.equals(geastureName,"square")){

            play_music("https://firebasestorage.googleapis.com/v0/b/smartmusicplayer-e89f3.appspot.com/o/SSC%2016%20Furgen.mp3?alt=media&token=6ab648e2-f24b-4fde-a8a5-7d229a7a0d90");
       }
        else if(Objects.equals(geastureName,"c")){
           play_music("https://firebasestorage.googleapis.com/v0/b/smartmusicplayer-e89f3.appspot.com/o/Imagine-Dragons-JID-Enemy.mp3?alt=media&token=d4683a7a-f4e5-4d39-ac07-8c22a08003f9");
       }
        else if(Objects.equals(geastureName,"z")){
            play_music("https://firebasestorage.googleapis.com/v0/b/smartmusicplayer-e89f3.appspot.com/o/Maroon%205%20Girls%20Like%20You.mp3?alt=media&token=da953ac7-b4ff-4fad-8ccc-31ddcb896ab2");
       }
       else if(Objects.equals(geastureName,"b")){
           play_music("https://firebasestorage.googleapis.com/v0/b/smartmusicplayer-e89f3.appspot.com/o/02_beete_lamhe%5B1%5D.mp3?alt=media&token=c77b0edd-df55-40b1-b13c-5a01d08bae14");
       }

       else if(Objects.equals(geastureName,"m")){
           play_music("https://firebasestorage.googleapis.com/v0/b/smartmusicplayer-e89f3.appspot.com/o/Duncan-Laurence-Arcade-ft.-FLETCHER_OpraDre.com_.mp3?alt=media&token=291cabd1-6a7b-4d28-bff4-902d936ba122");
       }
       else if(Objects.equals(geastureName,"s")){

           play_music("https://firebasestorage.googleapis.com/v0/b/smartmusicplayer-e89f3.appspot.com/o/Halsey%20-%20Without%20Me%20(320%20%20kbps).mp3?alt=media&token=4e697d30-cc04-41c1-afd3-d61cf6347a6e");
       }

        }
    }
}