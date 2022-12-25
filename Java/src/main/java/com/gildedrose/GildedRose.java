package com.gildedrose;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

class GildedRose {

    public static final QualityUpdater DEFAULT_QUALITY_UPDATER = item -> item.sellIn > 0 ? -1 : -2;

    Item[] items;
    private final Map<String, ItemType> itemTypes;

    public GildedRose(Item[] items) {
        this.items = items;
        this.itemTypes = Stream.of(ItemType.values())
                               .collect(toMap(ItemType::getName, identity()));
    }

    public void updateQuality() {
        for (Item item : items) {
            Optional.ofNullable(itemTypes.get(item.name))
                    .map(ItemType::getQualityUpdater)
                    .orElse(DEFAULT_QUALITY_UPDATER)
                    .accept(item);
        }
    }
}
