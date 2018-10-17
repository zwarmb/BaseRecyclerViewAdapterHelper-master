package com.example.yida.dandu.MediaPlayer._2;

import android.util.Log;

import com.example.yida.dandu.MediaPlayer._1.Mp4Playered;

/**
 * Created by yida on 2018/8/9.
 */

public class Mp4Player implements Mp4Playered{
    @Override
    public void playMp4(String filename) {
        Log.e("Mp4Player", " mp4 filename " + filename);
    }

    @Override
    public void playVlc(String filename) {

    }
}
