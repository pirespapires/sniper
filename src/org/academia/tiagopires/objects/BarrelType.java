package org.academia.tiagopires.objects;

/**
 * Created by itsamepires on 08-02-2016.
 */
public enum BarrelType {
    METAL(5, "resources/barrel1.png"),
    WOOD(3, "resources/barrel2.png"),
    PLASTIC(2, "resources/barrel3.png");


    private int maxDamage;
    private String path;

    public String getPath() {
        return path;
    }

    BarrelType(int maxDamage, String path) {
        this.maxDamage = maxDamage;
        this.path = path;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

}
