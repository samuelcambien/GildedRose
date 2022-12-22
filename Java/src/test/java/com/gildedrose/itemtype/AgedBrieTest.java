package com.gildedrose.itemtype;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gildedrose.GildedRoseTest;
import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

class AgedBrieTest extends GildedRoseTest {

    // regular
    private final Item agedBrie1 = new Item("Aged Brie", 3, 0);
    private final Item agedBrie2 = new Item("Aged Brie", 3, 3);
    private final Item agedBrie3 = new Item("Aged Brie", 3, 49);

    // after sell date
    private final Item agedBrie4 = new Item("Aged Brie", 0, 3);
    private final Item agedBrie5 = new Item("Aged Brie", -3, 7);

    // max quality limit
    private final Item agedBrie6 = new Item("Aged Brie", 3, 50);
    private final Item agedBrie7 = new Item("Aged Brie", 0, 49);
    private final Item agedBrie8 = new Item("Aged Brie", -3, 50);

    @Override
    protected Item[] getItems() {
        return new Item[] {
            agedBrie1,
            agedBrie2,
            agedBrie3,
            agedBrie4,
            agedBrie5,
            agedBrie6,
            agedBrie7,
            agedBrie8,
        };
    }

    @Test
    void sellinDecreases() {
        assertEquals(2, agedBrie1.sellIn);
        assertEquals(-1, agedBrie4.sellIn);
        assertEquals(-4, agedBrie5.sellIn);
    }

    @Test
    void qualityIncreases() {
        assertEquals(1, agedBrie1.quality);
        assertEquals(4, agedBrie2.quality);
        assertEquals(50, agedBrie3.quality);
    }

    @Test
    void qualityIncreasesDoubleAfterSellDate() {
        assertEquals(5, agedBrie4.quality);
        assertEquals(9, agedBrie5.quality);
    }

    @Test
    void maxQualityLimit() {
        assertEquals(50, agedBrie6.quality);
        assertEquals(50, agedBrie7.quality);
        assertEquals(50, agedBrie8.quality);
    }
}
