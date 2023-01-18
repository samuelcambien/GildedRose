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
            // wrong usage
            new Item("test item", 4, -7),
            new Item("test item", 0, -7),
            new Item("test item", 4, 52),
            new Item("test item", 0, 52),
        };
    }

    @Test
    void sellinDecreases() {
        assertEquals(3, items[0].sellIn);
        assertEquals(-1, items[2].sellIn);
        assertEquals(-4, items[3].sellIn);
        assertEquals(3, items[6].sellIn);
        assertEquals(-1, items[7].sellIn);
        assertEquals(3, items[8].sellIn);
        assertEquals(-1, items[9].sellIn);
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

    @Test
    void wrongUsage() {
        assertEquals(-7, items[6].quality);
        assertEquals(-7, items[7].quality);
        assertEquals(51, items[8].quality);
        assertEquals(50, items[9].quality);
    }
}
