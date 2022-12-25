package com.gildedrose;

import static com.gildedrose.GildedRose.DEFAULT_QUALITY_UPDATER;

import java.util.function.Consumer;

public enum ItemType {

    AGED_BRIE(
        "Aged Brie",
        (QualityUpdater) item -> -DEFAULT_QUALITY_UPDATER.getAmount(item)
    ),
    BACKSTAGE_PASS(
        "Backstage passes to a TAFKAL80ETC concert",
        (QualityUpdater) item -> {
            if (item.sellIn <= 0) {
                return -item.quality;
            } else if (item.sellIn <= 5) {
                return 3;
            } else if (item.sellIn <= 10) {
                return 2;
            } else {
                return 1;
            }
        }
    ),
    CONJURED(
        "Conjured Mana Cake",
        (QualityUpdater) item -> 2 * DEFAULT_QUALITY_UPDATER.getAmount(item)
    ),
    SULFURAS(
        "Sulfuras, Hand of Ragnaros",
        item -> {}
    );

    private final String name;
    private final Consumer<Item> qualityUpdater;

    ItemType(String name, Consumer<Item> qualityUpdater) {
        this.name = name;
        this.qualityUpdater = qualityUpdater;
    }

    public String getName() {
        return name;
    }

    public Consumer<Item> getQualityUpdater() {
        return qualityUpdater;
    }
}
