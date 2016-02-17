package org.academia.tiagopires.utils;

import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by itsamepires on 10-02-2016.
 */
public final class PictureUtils {
    private PictureUtils() {
    }

    public static int[] getPictureDimensions(String path) {
        int[] result = new int[2];
        Picture picture = new Picture(0, 0, path);
        result[0] = picture.getWidth();
        result[1] = picture.getHeight();
        return result;
    }


}
