package org.academia.tiagopires.objects;

/**
 * Created by itsamepires on 08-02-2016.
 */
public interface Destroyable {



    public abstract void hit(int damage) throws Exception;

    public abstract boolean isDestroyed();

    public abstract void delete() throws Exception;

    public abstract Representation getRepresentation();

}
