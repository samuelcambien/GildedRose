package com.gildedrose;

import java.util.function.Consumer;

public class ItemType {

    private final String name;
    private final Consumer<Item> qualityUpdater;

    public ItemType(String name, Consumer<Item> qualityUpdater) {
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
