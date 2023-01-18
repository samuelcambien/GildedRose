package com.gildedrose.itemtype;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gildedrose.GildedRoseTest;
import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

class BackstagePassTest extends GildedRoseTest {

    @Override
    protected Item[] getItems() {
        return new Item[] {
            // regular
            new Item("Backstage passes to a TAFKAL80ETC concert", 11, 0),
            new Item("Backstage passes to a TAFKAL80ETC concert", 11, 49),
            // double increase
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 0),
            new Item("Backstage passes to a TAFKAL80ETC concert", 6, 3),
            // triple increase
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 0),
            new Item("Backstage passes to a TAFKAL80ETC concert", 1, 3),
            // after sell date
            new Item("Backstage passes to a TAFKAL80ETC concert", 0, 3),
            new Item("Backstage passes to a TAFKAL80ETC concert", -1, 47),
            // max quality limit
            new Item("Backstage passes to a TAFKAL80ETC concert", 11, 50),
            new Item("Backstage passes to a TAFKAL80ETC concert", 1, 48),
            // wrong usage
            new Item("Backstage passes to a TAFKAL80ETC concert", 4, -7),
            new Item("Backstage passes to a TAFKAL80ETC concert", 0, -7),
            new Item("Backstage passes to a TAFKAL80ETC concert", 4, 52),
            new Item("Backstage passes to a TAFKAL80ETC concert", 0, 52),
        };
    }

    @Test
    void sellinDecreases() {
        assertEquals(10, items[0].sellIn);
        assertEquals(9, items[2].sellIn);
        assertEquals(5, items[3].sellIn);
        assertEquals(4, items[4].sellIn);
        assertEquals(0, items[5].sellIn);
        assertEquals(-1, items[6].sellIn);
        assertEquals(-2, items[7].sellIn);
        assertEquals(3, items[10].sellIn);
        assertEquals(-1, items[11].sellIn);
        assertEquals(3, items[12].sellIn);
        assertEquals(-1, items[13].sellIn);
    }

    @Test
    void qualityIncrease() {
        assertEquals(1, items[0].quality);
        assertEquals(50, items[1].quality);
    }

    @Test
    void qualityIncreasesDouble10DaysOrLess() {
        assertEquals(2, items[2].quality);
        assertEquals(5, items[3].quality);
    }

    @Test
    void qualityIncreasesTriple5DaysOrLess() {
        assertEquals(3, items[4].quality);
        assertEquals(6, items[5].quality);
    }

    @Test
    void qualityDropsAfterSellDate() {
        assertEquals(0, items[6].quality);
        assertEquals(0, items[7].quality);
    }

    @Test
    void maxQuality() {
        assertEquals(50, items[8].quality);
        assertEquals(50, items[9].quality);
    }

    @Test
    void wrongUsage() {
        assertEquals(-4, items[10].quality);
        assertEquals(0, items[11].quality);
        assertEquals(52, items[12].quality);
        assertEquals(0, items[13].quality);
    }
}
