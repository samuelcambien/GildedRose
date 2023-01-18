package com.gildedrose.itemtype;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gildedrose.GildedRoseTest;
import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

class ConjuredTest extends GildedRoseTest {

    @Override
    public Item[] getItems() {
        return new Item[] {
            // regular
            new Item("Conjured Mana Cake", 4, 3),
            new Item("Conjured Mana Cake", 3, 2),
            // after sell date
            new Item("Conjured Mana Cake", 0, 4),
            new Item("Conjured Mana Cake", -3, 47),
            // botom limit
            new Item("Conjured Mana Cake", 4, 1),
            new Item("Conjured Mana Cake", -3, 2),
            // wrong usage
            new Item("Conjured Mana Cake", 4, -7),
            new Item("Conjured Mana Cake", 0, -7),
            new Item("Conjured Mana Cake", 4, 52),
            new Item("Conjured Mana Cake", 0, 52),
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
        assertEquals(1, items[0].quality);
        assertEquals(0, items[1].quality);
    }

    @Test
    void qualityDecreasesDoubleAfterSellDate() {
        assertEquals(0, items[2].quality);
        assertEquals(43, items[3].quality);
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
        assertEquals(50, items[8].quality);
        assertEquals(48, items[9].quality);
    }
}
