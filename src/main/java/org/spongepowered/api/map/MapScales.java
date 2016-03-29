package org.spongepowered.api.map;

import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

/**
 * An enumeration of all the possible vanilla {@link MapScales}s.
 */
public class MapScales {

    //SORTFIELDS:ON

    /**
     * The default scale of a newly crafted map, this scale represents a 1:1 block to pixel ratio.
     */
    public static final MapScale SCALE_BASE = DummyObjectProvider.createFor(MapScale.class, "SCALE_BASE");

    /**
     * Represents a 4:1 block to pixel ratio scaling.
     */
    public static final MapScale SCALE_1 = DummyObjectProvider.createFor(MapScale.class, "SCALE_1");

    /**
     * Represents a 16:1 block to pixel ratio scaling, 4x4 blocks (1/16 chunk) per map pixel.
     */
    public static final MapScale SCALE_2 = DummyObjectProvider.createFor(MapScale.class, "SCALE_2");

    /**
     * Represents a 64:1 block to pixel ratio scaling, 8x8 blocks (1/4 chunk) per map pixel.
     */
    public static final MapScale SCALE_3 = DummyObjectProvider.createFor(MapScale.class, "SCALE_3");

    /**
     * Represents a 256:1 block to pixel ratio scaling, 16x16 blocks (1 chunk) per map pixel.
     */
    public static final MapScale SCALE_4 = DummyObjectProvider.createFor(MapScale.class, "SCALE_4");

    //SORTFIELDS:OFF

    private MapScales() {
    }
}
