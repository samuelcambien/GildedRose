package com.gildedrose;

import static java.lang.Math.max;
import static java.lang.Math.min;

import java.util.function.Consumer;

/**
 * This Consumer will:
 * - first update the quality of a given item by adding the amount given by
 * {@link QualityUpdater#getAmount(Item)} to the existing quality. This amount can be negative. The resulting
 * quality will always be capped at {@link QualityUpdater#MAX_QUALITY} and will never be negative.
 * - then decrease the sellin property of the item by 1.
 */
@FunctionalInterface
public interface QualityUpdater extends Consumer<Item> {

    int MAX_QUALITY = 50;

    @Override
    default void accept(Item item) {
        item.quality = max(0, min(MAX_QUALITY, item.quality + getAmount(item)));
        item.sellIn--;
    }

    int getAmount(Item item);
}
