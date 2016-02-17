package org.academia.tiagopires.game;

import java.io.*;

import sun.audio.*;

/**
 * Created by PiresPaPires on 14/02/2016.
 */
public class Sound {

    /**
     * A simple Java sound file example (i.e., Java code to play a sound file).
     * AudioStream and AudioPlayer code comes from a javaworld.com example.
     *
     * @author alvin alexander, devdaily.com.
     */

    public static void sound(String path)
            throws Exception {
        // open the sound file as a Java input stream
        String gongFile = path;
        InputStream in = new FileInputStream(gongFile);

        // create an audiostream from the inputstream
        AudioStream audioStream = new AudioStream(in);

        // play the audio clip with the audioplayer class
        AudioPlayer.player.start(audioStream);
    }
}

