package com.example.myapplication

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val playbtn =  findViewById<ImageButton>(R.id.playButton)
        val pausebtn =  findViewById<ImageButton>(R.id.pauseButton)
        val stopbtn =  findViewById<ImageButton>(R.id.pauseButton)
        val playbtn2 =  findViewById<ImageButton>(R.id.playButton2)
        val pausebtn2 =  findViewById<ImageButton>(R.id.pauseButton2)
        val stopbtn2 =  findViewById<ImageButton>(R.id.stopButton2)

        playbtn.setOnClickListener{
           if (mediaPlayer == null) {
               mediaPlayer = MediaPlayer.create(this, R.raw.song_money)
           }
            mediaPlayer?.start()
        }

        pausebtn.setOnClickListener{
           if (mediaPlayer?.isPlaying == true){
            mediaPlayer?.pause()
        } else {
            mediaPlayer?.start()
           }

        stopbtn.setOnClickListener{
            mediaPlayer?.stop()
            mediaPlayer = null
        }
//====================================================================

    }
        playbtn2.setOnClickListener{
            if (mediaPlayer == null) {
                mediaPlayer = MediaPlayer.create(this, R.raw.song_solo)
            }
            mediaPlayer?.start()
        }

        pausebtn2.setOnClickListener{
            if (mediaPlayer?.isPlaying == true){
                mediaPlayer?.pause()
            } else {
                mediaPlayer?.start()
            }

            stopbtn2.setOnClickListener{
                mediaPlayer?.stop()
                mediaPlayer = null
            }


        }

    fun onStop() {
        super.onStop()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}
}