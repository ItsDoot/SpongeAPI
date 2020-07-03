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
package org.spongepowered.api.item;

import org.spongepowered.api.CatalogKey;
import org.spongepowered.api.CatalogType;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.text.translation.Translatable;
import org.spongepowered.api.util.annotation.CatalogedBy;

import java.util.Optional;

/**
 * A type of item.
 */
@CatalogedBy(ItemTypes.class)
public interface ItemType extends CatalogType, Translatable, DataHolder.Immutable<ItemType> {

    /**
     * Attempts to retrieve the {@link ItemType} based on the key given.
     *
     * @param key The catalog key
     * @return The found item type, if available
     */
    static Optional<ItemType> get(CatalogKey key) {
        return Sponge.getRegistry().getCatalogRegistry().get(ItemType.class, key);
    }

    /**
     * Gets the corresponding {@link BlockType} of this item if one exists.
     *
     *  @return The Block
     */
    Optional<BlockType> getBlock();

    /**
     * Gets the container item of this item if one exists.
     * <p>e.g. {@link ItemTypes#BUCKET} for {@link ItemTypes#WATER_BUCKET}</p>
     *
     * @return The container item.
     */
    Optional<ItemType> getContainer();

    /**
     * Gets the default maximum quantity for
     * {@link ItemStack}s of this item.
     *
     * @return Max stack quantity
     */
    int getMaxStackQuantity();
}
