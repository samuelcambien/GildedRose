package com.gildedrose.itemtype;

import static com.gildedrose.ItemType.CONJURED;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gildedrose.GildedRoseTest;
import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

class ConjuredTest extends GildedRoseTest {

    @Override
    public Item[] getItems() {
        return new Item[] {
            // regular
            new Item(CONJURED.getName(), 4, 3),
            new Item(CONJURED.getName(), 3, 2),
            // after sell date
            new Item(CONJURED.getName(), 0, 4),
            new Item(CONJURED.getName(), -3, 47),
            // botom limit
            new Item(CONJURED.getName(), 4, 1),
            new Item(CONJURED.getName(), -3, 2),
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
}
