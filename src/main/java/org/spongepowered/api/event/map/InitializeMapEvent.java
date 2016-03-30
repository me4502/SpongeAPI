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
package org.spongepowered.api.event.map;

import org.spongepowered.api.data.Transaction;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.eventgencore.annotation.PropertySettings;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.map.MapView;

import javax.annotation.Nullable;

/**
 * Represents an event that is triggered when a {@link org.spongepowered.api.item.ItemTypes#MAP}
 * is initialized and replaced with a {@link org.spongepowered.api.item.ItemTypes#FILLED_MAP}.
 */
public interface InitializeMapEvent extends Event, Cancellable {

    /**
     * Called before {@link ReplaceMapItem}, by setting {@link #setUsingDefaultBehavior}
     * in this event, plugins can override the creation of a new map on the disk
     * and provide customized maps at initialization time. Plugins should use {@link ReplaceMapItem}
     * to set their own {@link MapView} if overriding vanilla map creation logic.
     *
     * <p>Cancelling this event will prevent any {@link MapView} from being created
     * and will stop {@link ReplaceMapItem} from being fired. This allows for maps
     * to be disabled or have their initialization overridden by cancelling {@link CreateMapView}.</p>
     */
    interface CreateMapView extends InitializeMapEvent {

        /**
         * Gets if a new {@link MapView} will be created on the disk.
         *
         * @return If a new map will be created on the disk
         */
        boolean isUsingDefaultBehavior();

        /**
         * Sets if the map will be created with default Minecraft initialization logic
         * which will create a new map data file stored on the disk with the world.
         *
         * <p>If a plugin wishes to provide a different map view, the plugin should
         * provide false to this method, then modify the map view in the {@link ReplaceMapItem}
         * event.</p>
         *
         * @param createMapView True to let default map creation logic run
         */
        void setUsingDefaultBehavior(boolean createMapView);

    }

    /**
     * This is called after the view is set, but before modifications to the
     * player's inventory take place.
     *
     * <p>Plugins can use this event to grab a handle into the newly created
     * {@link MapView}, or simply override vanilla behavior by cancelling this
     * event and using the new {@link MapView} elsewhere</p>
     */
    interface ReplaceMapItem extends InitializeMapEvent {

        /**
         * Gets the {@link ItemStack} of the map being initialized.
         *
         * <p>Note: This is where you could attach a custom {@link MapView} through data
         * after changing the {@link MapView} creation logic to avoid creating the {@link MapView}.
         * If a plugin does not attach a {@link MapView} after cancelling the default logic
         * the player will end up with a {@link org.spongepowered.api.item.ItemTypes#FILLED_MAP}
         * in an undefined state, as no data was ever initialized or attached.</p>
         *
         * @return The map being initialized
         */
        Transaction<ItemStackSnapshot> getInitializedStack();

    }

}
