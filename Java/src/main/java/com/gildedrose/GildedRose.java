package com.gildedrose;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

import com.gildedrose.itemtype.AgedBrie;
import com.gildedrose.itemtype.BackstagePass;
import com.gildedrose.itemtype.Sulfuras;

public class GildedRose {

    public static final QualityUpdater DEFAULT_QUALITY_UPDATER = item -> item.sellIn > 0 ? -1 : -2;
    public static final Consumer<Item> DEFAULT_SELLIN_UPDATER = item -> item.sellIn--;

    Item[] items;
    private Map<String, ItemType> itemTypes;

    public GildedRose(Item[] items) {
        this.items = items;
        setItemTypes(
            new AgedBrie(),
            new BackstagePass(),
            new Sulfuras()
        );
    }

    public void setItemTypes(ItemType... itemTypes) {
        this.itemTypes = Stream.of(itemTypes)
                               .collect(toMap(ItemType::getName, identity()));
    }

    public void updateQuality() {
        for (Item item : items) {
            Optional<ItemType> itemType = Optional.ofNullable(itemTypes.get(item.name));
            itemType.map(ItemType::getQualityUpdater)
                    .orElse(DEFAULT_QUALITY_UPDATER)
                    .accept(item);
            itemType.map(ItemType::getSellinUpdater)
                    .orElse(DEFAULT_SELLIN_UPDATER)
                    .accept(item);
        }
    }
}
