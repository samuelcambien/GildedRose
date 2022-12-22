package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;

public abstract class GildedRoseTest {

    @BeforeEach
    public void setUp() {
        new GildedRose(getItems()).updateQuality();
    }

    protected abstract Item[] getItems();
}
