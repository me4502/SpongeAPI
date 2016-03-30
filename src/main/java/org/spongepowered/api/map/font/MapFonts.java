package org.spongepowered.api.map.font;

import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

/**
 * A list of all the api provided fonts.
 */
public final class MapFonts {

    /**
     * Represents a default base font for use when drawing on maps
     */
    public static final MapFont DEFAULT = DummyObjectProvider.createFor(MapFont.class, "DEFAULT");

    private MapFonts() {
    }

}
