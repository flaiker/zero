/******************************************************************************
 * Copyright 2016 Fabian Lupa                                                 *
 ******************************************************************************/

package com.flaiker.zero.entities;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.MathUtils;
import com.flaiker.zero.Game;
import com.flaiker.zero.box2d.AbstractBox2dObject;

/**
 * Base class for entities
 * <p>
 * Entities are dynamic game objects possibly loaded as a spawn from a map using the {@link
 * com.flaiker.zero.tiles.RegistrableSpawn}-annotation.
 */
public abstract class AbstractEntity extends AbstractBox2dObject {
    public static final TextureAtlas ENTITY_TEXTURE_ATLAS = new TextureAtlas("atlases/entities.atlas");

    public AbstractEntity() {
        super(ENTITY_TEXTURE_ATLAS);
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        // update the sprite's position and rotation to the box2d body properties
        setSpritePosition(body.getPosition().x - getEntityWidth() / 2f, body.getPosition().y - getEntityHeight() / 2f);
        setSpriteRotation(MathUtils.radiansToDegrees * body.getAngle());
    }

    protected void setSpritePosition(float xMeter, float yMeter) {
        sprite.setPosition(xMeter * Game.PIXEL_PER_METER, yMeter * Game.PIXEL_PER_METER);
    }

    protected void setSpriteX(float xMeter) {
        sprite.setX(xMeter * Game.PIXEL_PER_METER);
    }

    protected void setSpriteY(float yMeter) {
        sprite.setY(yMeter * Game.PIXEL_PER_METER);
    }

    protected void setSpriteRotation(float degrees) {
        sprite.setRotation(degrees);
    }
}
