package com.gildedrose;

import java.util.function.Consumer;

public class ItemType {

    private final String name;
    private final Consumer<Item> qualityUpdater;
    private final Consumer<Item> sellinUpdater;

    public ItemType(String name, Consumer<Item> qualityUpdater, Consumer<Item> sellinUpdater) {
        this.name = name;
        this.qualityUpdater = qualityUpdater;
        this.sellinUpdater = sellinUpdater;
    }

    public String getName() {
        return name;
    }

    public Consumer<Item> getQualityUpdater() {
        return qualityUpdater;
    }

    public Consumer<Item> getSellinUpdater() {
        return sellinUpdater;
    }
}
