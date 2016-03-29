/*
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.api.map;

import com.flowpowered.math.vector.Vector2i;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.map.color.MapColor;
import org.spongepowered.api.map.font.MapFont;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.Color;

import java.awt.Image;

/**
 * A representation of the canvas (pixel surface) of a map.
 */
public interface MapCanvas extends DataSerializable {

    /**
     * Returns the width and height of the map's canvas.
     *
     * <p>The x value is the width and the y value is the height.</p>
     *
     * @return The map canvas's size
     */
    Vector2i getSize();

    /**
     * Sets the specified pixel to the exact {@link MapColor} given.
     *
     * <p>The coordinates start with 0,0 as the top left corner moving right
     * and down.</p>
     *
     * @param position The coordinates of the pixel to set
     * @param color The color to set the pixel to
     * @throws IndexOutOfBoundsException If the coordinates are greater than
     *         the width and height of the map's canvas
     */
    default void setPixelExact(Vector2i position, MapColor color) {
        setPixelExact(position.getX(), position.getY(), color);
    }

    /**
     * Sets the specified pixel to the exact {@link MapColor} given.
     *
     * <p>The coordinates start with 0,0 as the top left corner moving right
     * and down.</p>
     *
     * @param x The x coordinate of the pixel
     * @param y The y coordinate of the pixel
     * @param color The color to set the pixel to
     * @throws IndexOutOfBoundsException If the coordinates are greater than
     *         the width and height of the map's canvas
     */
    void setPixelExact(int x, int y, MapColor color);

    /**
     * Sets the specified pixel to the {@link MapColor} that is most similar to the {@link Color} provided.
     *
     * <p>The coordinates start with 0,0 as the top left corner moving right
     * and down.</p>
     *
     * @param position The coordinates of the pixel to set
     * @param color The color to be matched before setting the pixel to the closest {@link MapColor}
     * @throws IndexOutOfBoundsException If the coordinates are greater than
     *         the width and height of the map's canvas
     */
    default void setPixelSimilar(Vector2i position, Color color) {
        setPixelSimilar(position.getX(), position.getY(), color);
    }

    /**
     * Sets the specified pixel to the {@link MapColor} that is most similar to the {@link Color} provided.
     *
     * <p>The coordinates start with 0,0 as the top left corner moving right
     * and down.</p>
     *
     * @param x The x coordinate of the pixel
     * @param y The y coordinate of the pixel
     * @param color The color to be matched before setting the pixel to the closest {@link MapColor}
     * @throws IndexOutOfBoundsException If the coordinates are greater than
     *         the width and height of the map's canvas
     */
    void setPixelSimilar(int x, int y, Color color);

    /**
     * Returns the {@link MapColor} at the specified pixel. An unset pixel will be returned as
     * {@link org.spongepowered.api.map.color.MapPalette#AIR}
     *
     * The coordinates start with 0,0 as the top left corner moving right and
     * down.
     *
     * @param position The coordinates of the pixel to get
     * @return The color of the pixel at the specified coordinates
     * @throws IndexOutOfBoundsException If the coordinates are greater than or equal to
     * the width and height of the map's canvas
     */
    default MapColor getPixel(Vector2i position) {
        return getPixel(position.getX(), position.getY());
    }

    /**
     * Returns the {@link MapColor} at the specified pixel. An unset pixel will be returned as
     * {@link org.spongepowered.api.map.color.MapPalette#AIR}
     *
     * The coordinates start with 0,0 as the top left corner moving right and
     * down.
     *
     * @param x The x coordinate of the pixel to get
     * @param y The y coordinate of the pixel to get
     * @return The color of the pixel at the specified coordinates
     * @throws IndexOutOfBoundsException If the coordinates are greater than or equal to
     * the width and height of the map's canvas
     */
    MapColor getPixel(int x, int y);

    /**
     * Create an {@link Image} out of the map allowing it to be viewed outside
     * the game in conventional image viewers and shared on the web. Simply
     * converts indexes in the map's canvas to the RGB values they represent.
     *
     * @return The rendered image
     */
    Image toImage();

    /**
     * Draws an image to the map, clipping it if it goes out of bounds.
     *
     * @param x The top left x coordinate on the map
     * @param y The top left y coordinate on the map
     * @param image The image to draw
     */
    void drawImage(int x, int y, Image image);

    /**
     * Draws text to the map, handling colors but not formatting.
     *
     * <p>Clips text that goes out of bounds at the character before it's out of bounds.</p>
     *
     * @param x The top left x coordinate of the drawn text
     * @param y The top left y coordinate of the drawn text
     * @param text The text to draw
     * @param font The font to use when drawing the text
     *
     * @throws IllegalArgumentException If the font is missing a character used
     *         by the Text provided
     */
    void drawText(int x, int y, Text text, MapFont font);

}
