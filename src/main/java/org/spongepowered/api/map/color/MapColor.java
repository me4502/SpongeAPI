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
package org.spongepowered.api.map.color;

import com.google.common.base.Optional;
import org.spongepowered.api.util.Color;

public interface MapColor {

    /**
     * Returns the corresponding {@link Color} for this {@link MapColor}.
     *
     * @return The RGB color of this map color
     */
    Color getColor();

    /**
     * Creates a shaded representation of this color's <b>base color</b> using
     * {@link MapPalette#getShade(MapColor, MapShade)} which will create a new
     * instance if needed or return a cached instance for previously created
     * shades.
     *
     * @param newShading The shading to use on the new variant of this color
     * @return The new map color with the specified shading
     */
    MapColor createShade(MapShade newShading);

    /**
     * Returns the shading of this color.
     *
     * @return The shade of this color
     */
    MapShade getShade();

    /**
     * Returns the name of this color, only the entries in {@link MapPalette}
     * have names.
     *
     * @return The name of this color, {@link Optional#absent()} otherwise
     */
    Optional<String> getName();
}