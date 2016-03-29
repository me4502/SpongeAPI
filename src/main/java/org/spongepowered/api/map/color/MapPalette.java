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

import com.google.common.collect.ImmutableCollection;
import org.spongepowered.api.map.util.MapPaletteFactory;
import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

/**
 * A representation of the palette of a map. This provides a set of constants
 * that hold the named based colors in a map, along with methods to retrieve
 * the full listing of all the colors and their shades.
 */
public final class MapPalette {

    // SORTFIELDS:ON

    public static final MapColor AIR = DummyObjectProvider.createFor(MapColor.class, "AIR");
    public static final MapColor GRASS = DummyObjectProvider.createFor(MapColor.class, "GRASS");
    public static final MapColor SAND = DummyObjectProvider.createFor(MapColor.class, "SAND");
    public static final MapColor CLOTH = DummyObjectProvider.createFor(MapColor.class, "CLOTH");
    public static final MapColor TNT = DummyObjectProvider.createFor(MapColor.class, "TNT");
    public static final MapColor ICE = DummyObjectProvider.createFor(MapColor.class, "ICE");
    public static final MapColor IRON = DummyObjectProvider.createFor(MapColor.class, "IRON");
    public static final MapColor FOLIAGE = DummyObjectProvider.createFor(MapColor.class, "FOLIAGE");
    public static final MapColor SNOW = DummyObjectProvider.createFor(MapColor.class, "SNOW");
    public static final MapColor CLAY = DummyObjectProvider.createFor(MapColor.class, "CLAY");
    public static final MapColor DIRT = DummyObjectProvider.createFor(MapColor.class, "DIRT");
    public static final MapColor STONE = DummyObjectProvider.createFor(MapColor.class, "STONE");
    public static final MapColor WATER = DummyObjectProvider.createFor(MapColor.class, "WATER");
    public static final MapColor WOOD = DummyObjectProvider.createFor(MapColor.class, "WOOD");
    public static final MapColor QUARTZ = DummyObjectProvider.createFor(MapColor.class, "QUARTZ");
    public static final MapColor ADOBE = DummyObjectProvider.createFor(MapColor.class, "ADOBE");
    public static final MapColor MAGENTA = DummyObjectProvider.createFor(MapColor.class, "MAGENTA");
    public static final MapColor LIGHT_BLUE = DummyObjectProvider.createFor(MapColor.class, "LIGHT_BLUE");
    public static final MapColor YELLOW = DummyObjectProvider.createFor(MapColor.class, "YELLOW");
    public static final MapColor LIME = DummyObjectProvider.createFor(MapColor.class, "LIME");
    public static final MapColor PINK = DummyObjectProvider.createFor(MapColor.class, "PINK");
    public static final MapColor GRAY = DummyObjectProvider.createFor(MapColor.class, "GRAY");
    public static final MapColor SILVER = DummyObjectProvider.createFor(MapColor.class, "SILVER");
    public static final MapColor CYAN = DummyObjectProvider.createFor(MapColor.class, "CYAN");
    public static final MapColor PURPLE = DummyObjectProvider.createFor(MapColor.class, "PURPLE");
    public static final MapColor BLUE = DummyObjectProvider.createFor(MapColor.class, "BLUE");
    public static final MapColor BROWN = DummyObjectProvider.createFor(MapColor.class, "BROWN");
    public static final MapColor GREEN = DummyObjectProvider.createFor(MapColor.class, "GREEN");
    public static final MapColor RED = DummyObjectProvider.createFor(MapColor.class, "RED");
    public static final MapColor BLACK = DummyObjectProvider.createFor(MapColor.class, "BLACK");
    public static final MapColor GOLD = DummyObjectProvider.createFor(MapColor.class, "GOLD");
    public static final MapColor DIAMOND = DummyObjectProvider.createFor(MapColor.class, "DIAMOND");
    public static final MapColor LAPIS = DummyObjectProvider.createFor(MapColor.class, "LAPIS");
    public static final MapColor EMERALD = DummyObjectProvider.createFor(MapColor.class, "EMERALD");
    public static final MapColor OBSIDIAN = DummyObjectProvider.createFor(MapColor.class, "OBSIDIAN");
    public static final MapColor NETHERRACK = DummyObjectProvider.createFor(MapColor.class, "NETHERRACK");

    // SORTFIELDS:OFF

    /**
     * Returns all the possible {@link MapColor}s available, including the
     * shaded colors.
     *
     * @return All the map colors including shades
     */
    public static ImmutableCollection<MapColor> getAll() {
        return factory.getAll();
    }

    /**
     * Returns all the possible named {@link MapColor}s available, this is
     * basically just all the static entries in {@link MapPalette} but in an
     * {@link ImmutableCollection<MapColor>}.
     *
     * @return All the named map colors
     */
    public static ImmutableCollection<MapColor> getAllNamed() {
        return factory.getAllNamed();
    }

    /**
     * Returns a {@link MapColor} from all the colors (including shades) based
     * on the palette index. This allows easy lookup of colors from a raw map.
     *
     * @param colorIndex The index of the color in the map palette
     * @return The object represented by that color
     */
    public static MapColor getByIndex(int colorIndex) {
        return factory.getByIndex(colorIndex);
    }

    /**
     * Gets a new {@link MapColor} with the specified shaded value from the
     * <b>base color</b> of the color provided.
     *
     * <p>If the value has already been created it will load a cached entry.
     * This is not based on the color itself but rather the unshaded version of
     * the color provided, this helps ensure consistency.</p>
     *
     * @param base The base color, not required to be an actual base color
     * @param shade The shade to apply
     * @return The shaded color
     */
    public static MapColor getShade(MapColor base, MapShade shade) {
        return factory.getShade(base, shade);
    }

    private static final MapPaletteFactory factory = null;

    private MapPalette() {
    }
}
