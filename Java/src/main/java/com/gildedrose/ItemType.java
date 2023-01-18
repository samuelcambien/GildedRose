package com.gildedrose;

import java.util.function.Consumer;

public class ItemType {

    private static final QualityUpdater DEFAULT_QUALITY_UPDATER = item -> item.sellIn > 0 ? -1 : -2;

    private final Consumer<Item> qualityUpdater;

    private ItemType(Consumer<Item> qualityUpdater) {
        this.qualityUpdater = qualityUpdater;
    }

    public void update(Item item) {
        this.qualityUpdater.accept(item);
    }

    public static ItemType forName(String name) {
        switch (name) {
            case "Aged Brie":
                return new ItemType(
                    (QualityUpdater) item -> -DEFAULT_QUALITY_UPDATER.getAmount(item)
                );
            case "Backstage passes to a TAFKAL80ETC concert":
                return new ItemType(
                    (QualityUpdater) item -> item.sellIn <= 0 ? -item.quality : item.sellIn <= 5 ? 3 : item.sellIn <= 10 ? 2 : 1
                );
            case "Conjured Mana Cake":
                return new ItemType(
                    (QualityUpdater) item -> 2 * DEFAULT_QUALITY_UPDATER.getAmount(item)
                );
            case "Sulfuras, Hand of Ragnaros":
                return new ItemType(
                    item -> {}
                );
            default:
                return new ItemType(DEFAULT_QUALITY_UPDATER);
        }
    }
}
