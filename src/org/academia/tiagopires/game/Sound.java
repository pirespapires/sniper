package org.academia.tiagopires.game;

import java.io.*;
import java.net.URL;

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
        InputStream in;
        URL soundURL = Sound.class.getResource(path.startsWith("/")?path:"/" + path);

      //  System.out.println("opening " + path);

        if (soundURL == null) {
            //System.out.println("opening from file");
            in = new FileInputStream(path);
        } else {
            //System.out.println("opening from jar");
            in = soundURL.openStream();
        }

        // create an audiostream from the inputstream
        AudioStream audioStream = new AudioStream(in);

        // play the audio clip with the audioplayer class
        AudioPlayer.player.start(audioStream);
    }
}

