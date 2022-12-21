package com.gildedrose.itemtype;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gildedrose.GildedRoseTest;
import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

class BackstagePassTest extends GildedRoseTest {

    // regular
    private final Item backstagePass1 = new Item(BackstagePass.NAME, 11, 0);
    private final Item backstagePass2 = new Item(BackstagePass.NAME, 11, 49);

    // double increase
    private final Item backstagePass3 = new Item(BackstagePass.NAME, 10, 0);
    private final Item backstagePass4 = new Item(BackstagePass.NAME, 6, 3);

    // triple increase
    private final Item backstagePass5 = new Item(BackstagePass.NAME, 5, 0);
    private final Item backstagePass6 = new Item(BackstagePass.NAME, 1, 3);

    // after sell date
    private final Item backstagePass7 = new Item(BackstagePass.NAME, 0, 3);
    private final Item backstagePass8 = new Item(BackstagePass.NAME, -1, 47);

    // max quality limit
    private final Item backstagePass9 = new Item(BackstagePass.NAME, 11, 50);
    private final Item backstagePass10 = new Item(BackstagePass.NAME, 1, 48);

    @Override
    protected Item[] getItems() {
        return new Item[] {
            backstagePass1,
            backstagePass2,
            backstagePass3,
            backstagePass4,
            backstagePass5,
            backstagePass6,
            backstagePass7,
            backstagePass8,
            backstagePass9,
            backstagePass10,
        };
    }

    @Test
    void sellinDecreases() {
        assertEquals(10, backstagePass1.sellIn);
        assertEquals(9, backstagePass3.sellIn);
        assertEquals(5, backstagePass4.sellIn);
        assertEquals(4, backstagePass5.sellIn);
        assertEquals(0, backstagePass6.sellIn);
        assertEquals(-1, backstagePass7.sellIn);
        assertEquals(-2, backstagePass8.sellIn);
    }

    @Test
    void qualityIncrease() {
        assertEquals(1, backstagePass1.quality);
        assertEquals(50, backstagePass2.quality);
    }

    @Test
    void qualityIncreasesDouble10DaysOrLess() {
        assertEquals(2, backstagePass3.quality);
        assertEquals(5, backstagePass4.quality);
    }

    @Test
    void qualityIncreasesTriple5DaysOrLess() {
        assertEquals(3, backstagePass5.quality);
        assertEquals(6, backstagePass6.quality);
    }

    @Test
    void qualityDropsAfterSellDate() {
        assertEquals(0, backstagePass7.quality);
        assertEquals(0, backstagePass8.quality);
    }

    @Test
    void maxQuality() {
        assertEquals(50, backstagePass9.quality);
        assertEquals(50, backstagePass10.quality);
    }
}
