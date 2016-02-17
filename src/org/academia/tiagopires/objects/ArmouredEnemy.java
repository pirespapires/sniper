package org.academia.tiagopires.objects;

/**
 * Created by itsamepires on 05-02-2016.
 */
public class ArmouredEnemy extends Enemy {

    private int armor;

    public ArmouredEnemy(int health, int armour) {
        super(health,"resources/soldier2.png");
        this.armor = armour;
    }


    @Override
    public void hit(int bulletDamage) throws Exception {

        while (bulletDamage > 0) {
            if (armor <= 0) {
                super.hit(bulletDamage);
                return;
            } else {
                armor--;
                bulletDamage--;

            }
        }
    }

    @Override
    public String getMessage() {
        return "ArmouredEnemy{" +
                "armor=" + armor + "health="+ getHealth()+
                '}';
    }
}
