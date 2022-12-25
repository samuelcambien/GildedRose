package com.gildedrose;

import java.util.stream.Stream;

class GildedRose {

    public static final QualityUpdater DEFAULT_QUALITY_UPDATER = item -> item.sellIn > 0 ? -1 : -2;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            Stream.of(ItemType.values())
                  .filter(itemType -> itemType.getName().equals(item.name))
                  .map(ItemType::getQualityUpdater)
                  .findAny()
                  .orElse(DEFAULT_QUALITY_UPDATER)
                  .accept(item);
        }
    }
}
