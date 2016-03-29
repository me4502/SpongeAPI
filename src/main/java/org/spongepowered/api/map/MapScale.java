package org.spongepowered.api.map;

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.util.annotation.CatalogedBy;

/**
 * Represents a specific block to map pixel scaling ratio.
 */
@CatalogedBy(MapScales.class)
public interface MapScale extends CatalogType {
    
    /**
     * Gets the number of blocks in the world per colored pixel on a map.
     *
     * @return The number of blocks per pixel
     */
    int getBlocksPerPixel();
}
