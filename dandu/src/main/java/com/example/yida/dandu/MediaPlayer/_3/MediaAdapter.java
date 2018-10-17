package com.example.yida.dandu.MediaPlayer._3;

import com.example.yida.dandu.MediaPlayer._1.Mp3Player;
import com.example.yida.dandu.MediaPlayer._1.Mp4Playered;
import com.example.yida.dandu.MediaPlayer._2.Mp4Player;
import com.example.yida.dandu.MediaPlayer._2.VlcPlayer;

/**
 * Created by yida on 2018/8/9.
 */

public class MediaAdapter implements Mp3Player {
    Mp4Playered mMp4Playered;

    public MediaAdapter(String audioType) {

        if (audioType.equalsIgnoreCase("vlc")) {
            mMp4Playered = new VlcPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")) {
            mMp4Playered = new Mp4Player();
        }

    }


    @Override
    public void play(String audioType, String filename) {
        if (audioType.equalsIgnoreCase("vlc")) {
            mMp4Playered.playVlc(filename);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            mMp4Playered.playMp4(filename);
        }

    }
}
