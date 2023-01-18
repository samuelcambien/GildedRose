package com.gildedrose.itemtype;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gildedrose.GildedRoseTest;
import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

class AgedBrieTest extends GildedRoseTest {

    @Override
    protected Item[] getItems() {
        return new Item[] {
            // regular
            new Item("Aged Brie", 3, 0),
            new Item("Aged Brie", 3, 3),
            new Item("Aged Brie", 3, 49),
            // after sell date
            new Item("Aged Brie", 0, 3),
            new Item("Aged Brie", -3, 7),
            // max quality limit
            new Item("Aged Brie", 3, 50),
            new Item("Aged Brie", 0, 49),
            new Item("Aged Brie", -3, 50),
            // wrong usage
            new Item("Aged Brie", 4, -7),
            new Item("Aged Brie", 0, -7),
            new Item("Aged Brie", 4, 52),
            new Item("Aged Brie", 0, 52),
        };
    }

    @Test
    void sellinDecreases() {
        assertEquals(2, items[0].sellIn);
        assertEquals(-1, items[3].sellIn);
        assertEquals(-4, items[4].sellIn);
        assertEquals(3, items[8].sellIn);
        assertEquals(-1, items[9].sellIn);
        assertEquals(3, items[10].sellIn);
        assertEquals(-1, items[11].sellIn);
    }

    @Test
    void qualityIncreases() {
        assertEquals(1, items[0].quality);
        assertEquals(4, items[1].quality);
        assertEquals(50, items[2].quality);
    }

    @Test
    void qualityIncreasesDoubleAfterSellDate() {
        assertEquals(5, items[3].quality);
        assertEquals(9, items[4].quality);
    }

    @Test
    void maxQualityLimit() {
        assertEquals(50, items[5].quality);
        assertEquals(50, items[6].quality);
        assertEquals(50, items[7].quality);
    }

    @Test
    void wrongUsage() {
        assertEquals(-6, items[8].quality);
        assertEquals(-5, items[9].quality);
        assertEquals(52, items[10].quality);
        assertEquals(52, items[11].quality);
    }
}
