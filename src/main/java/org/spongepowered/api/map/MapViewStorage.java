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

import com.google.common.collect.ImmutableCollection;
import org.spongepowered.api.item.inventory.ItemStack;

import java.util.Optional;

/**
 * Represents a container for {@link MapView}s. Provides methods to create new
 * {@link MapView}s and to retrieve existing {@link MapView}s without attaching
 * them to a specific {@link ItemStack}.
 */
public interface MapViewStorage {

    /**
     * Creates a new map view from the given {@link MapSettings}. For the
     * creation of the MapCreationSettings please see
     * {@link MapSettings.Builder}.
     *
     * <p>After creating the {@link MapView} the {@link MapSettings} provided
     * is no longer a live MapSettings object. To modify the settings on the
     * newly created MapView, you must use {@link MapView#getSettings()} to
     * get a mutable MapSettings instance.</p>
     *
     * @param settings The settings to use when creating the map view
     * @return The map view, if creation was successful
     */
    Optional<MapView> createMap(MapSettings settings);

    /**
     * Returns a {@link MapView} for a map.
     *
     * @param mapId The id of the map view
     * @return The map view, if found
     */
    Optional<MapView> getMap(String mapId);

    /**
     * Returns an unmodifiable collection of all the {@link MapView}s available
     * the {@link MapView}s themselves are modifiable and are not copies.
     *
     * @return A collection of all the maps available
     */
    ImmutableCollection<MapView> getMaps();

    /**
     * Deletes the provided map's file from the disk.
     *
     * @param mapId The id of the map to delete
     * @return True if the operation was successful, false otherwise
     */
    boolean deleteMap(String mapId);

}
