package com.gildedrose.itemtype;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gildedrose.GildedRoseTest;
import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

class DefaultItemTest extends GildedRoseTest {

    // regular
    private final Item defaultItem1 = new Item("test item", 4, 3);
    private final Item defaultItem2 = new Item("test item", 3, 1);

    // after sell date
    private final Item defaultItem3 = new Item("test item", 0, 4);
    private final Item defaultItem4 = new Item("test item", -3, 47);

    // bottom limit
    private final Item defaultItem5 = new Item("test item", 4, 0);
    private final Item defaultItem6 = new Item("test item", -3, 1);

    @Override
    public Item[] getItems() {
        return new Item[] {
            defaultItem1,
            defaultItem2,
            defaultItem3,
            defaultItem4,
            defaultItem5,
            defaultItem6,
        };
    }

    @Test
    void sellinDecreases() {
        assertEquals(3, defaultItem1.sellIn);
        assertEquals(-1, defaultItem3.sellIn);
        assertEquals(-4, defaultItem4.sellIn);
    }

    @Test
    void qualityDecreases() {
        assertEquals(2, defaultItem1.quality);
        assertEquals(0, defaultItem2.quality);
    }

    @Test
    void qualityDecreasesDoubleAfterSellDate() {
        assertEquals(2, defaultItem3.quality);
        assertEquals(45, defaultItem4.quality);
    }

    @Test
    void qualityAlwaysPositive() {
        assertEquals(0, defaultItem5.quality);
        assertEquals(0, defaultItem6.quality);
    }
}
