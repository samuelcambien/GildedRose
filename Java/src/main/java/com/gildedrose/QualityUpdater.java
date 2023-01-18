package com.gildedrose;

import static java.lang.Math.max;
import static java.lang.Math.min;

import java.util.function.Consumer;

/**
 * This Consumer will:
 * - first update the quality of a given item by adding the amount given by
 * {@link QualityUpdater#getAmount(Item)} to the existing quality. This amount can be negative.
 *   - for increasing quality (positive amount), the resulting quality will be capped at {@link QualityUpdater#MAX_QUALITY},
 *     unless the initial quality is already above this limit, in that case it won't be changed
 *   - for decreasing quality (negative amount), the resulting quality will not become negative,
 *     unless the initial quality is already negative, in that case it won't be changed
 * - then decrease the sellin property of the item by 1.
 */
@FunctionalInterface
public interface QualityUpdater extends Consumer<Item> {

    int MAX_QUALITY = 50;

    @Override
    default void accept(Item item) {
        int amount = getAmount(item);
        if (amount > 0 && item.quality < MAX_QUALITY) {
            item.quality = min(MAX_QUALITY, item.quality + amount);
        }
        if (amount < 0 && item.quality > 0) {
            item.quality = max(0, item.quality + amount);
        }
        item.sellIn--;
    }

    int getAmount(Item item);
}
