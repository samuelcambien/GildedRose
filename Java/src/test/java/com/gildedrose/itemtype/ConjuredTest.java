package com.gildedrose.itemtype;

import static com.gildedrose.ItemType.CONJURED;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gildedrose.GildedRoseTest;
import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

class ConjuredTest extends GildedRoseTest {

    // regular
    private final Item conjuredItem1 = new Item(CONJURED.getName(), 4, 3);
    private final Item conjuredItem2 = new Item(CONJURED.getName(), 3, 2);

    // after sell date
    private final Item conjuredItem3 = new Item(CONJURED.getName(), 0, 4);
    private final Item conjuredItem4 = new Item(CONJURED.getName(), -3, 47);

    // botom limit
    private final Item conjuredItem5 = new Item(CONJURED.getName(), 4, 1);
    private final Item conjuredItem6 = new Item(CONJURED.getName(), -3, 2);

    @Override
    public Item[] getItems() {
        return new Item[] {
            conjuredItem1,
            conjuredItem2,
            conjuredItem3,
            conjuredItem4,
            conjuredItem5,
            conjuredItem6,
        };
    }

    @Test
    void sellinDecreases() {
        assertEquals(3, conjuredItem1.sellIn);
        assertEquals(-1, conjuredItem3.sellIn);
        assertEquals(-4, conjuredItem4.sellIn);
    }

    @Test
    void qualityDecreases() {
        assertEquals(1, conjuredItem1.quality);
        assertEquals(0, conjuredItem2.quality);
    }

    @Test
    void qualityDecreasesDoubleAfterSellDate() {
        assertEquals(0, conjuredItem3.quality);
        assertEquals(43, conjuredItem4.quality);
    }

    @Test
    void qualityAlwaysPositive() {
        assertEquals(0, conjuredItem5.quality);
        assertEquals(0, conjuredItem6.quality);
    }
}
