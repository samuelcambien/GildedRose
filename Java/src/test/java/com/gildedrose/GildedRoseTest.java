package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;

public abstract class GildedRoseTest {

    protected Item[] items = getItems();

    @BeforeEach
    public void setUp() {
        new GildedRose(items).updateQuality();
    }

    protected abstract Item[] getItems();
}
