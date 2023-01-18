package com.gildedrose.itemtype;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gildedrose.GildedRoseTest;
import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

class DefaultItemTest extends GildedRoseTest {

    @Override
    public Item[] getItems() {
        return new Item[] {
            // regular
            new Item("test item", 4, 3),
            new Item("test item", 3, 1),
            // after sell date
            new Item("test item", 0, 4),
            new Item("test item", -3, 47),
            // bottom limit
            new Item("test item", 4, 0),
            new Item("test item", -3, 1),
        };
    }

    @Test
    void sellinDecreases() {
        assertEquals(3, items[0].sellIn);
        assertEquals(-1, items[2].sellIn);
        assertEquals(-4, items[3].sellIn);
    }

    @Test
    void qualityDecreases() {
        assertEquals(2, items[0].quality);
        assertEquals(0, items[1].quality);
    }

    @Test
    void qualityDecreasesDoubleAfterSellDate() {
        assertEquals(2, items[2].quality);
        assertEquals(45, items[3].quality);
    }

    @Test
    void qualityAlwaysPositive() {
        assertEquals(0, items[4].quality);
        assertEquals(0, items[5].quality);
    }
}
