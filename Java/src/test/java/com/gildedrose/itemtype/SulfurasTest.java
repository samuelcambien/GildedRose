package com.gildedrose.itemtype;

import static com.gildedrose.ItemType.SULFURAS;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gildedrose.GildedRoseTest;
import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

class SulfurasTest extends GildedRoseTest {

    @Override
    protected Item[] getItems() {
        return new Item[] {
            // regular
            new Item(SULFURAS.getName(), 0, 80),
            new Item(SULFURAS.getName(), 7, 80),
            new Item(SULFURAS.getName(), -4, 80),
            // wrong usage
            new Item(SULFURAS.getName(), 0, 88),
            new Item(SULFURAS.getName(), 7, 88),
            new Item(SULFURAS.getName(), -4, 88),
            new Item(SULFURAS.getName(), 0, -11),
            new Item(SULFURAS.getName(), 7, -11),
            new Item(SULFURAS.getName(), -4, -11),
        };
    }

    @Test
    void noChanges() {
        assertEquals(0, items[0].sellIn);
        assertEquals(7, items[1].sellIn);
        assertEquals(-4, items[2].sellIn);
        assertEquals(0, items[3].sellIn);
        assertEquals(7, items[4].sellIn);
        assertEquals(-4, items[5].sellIn);
        assertEquals(0, items[6].sellIn);
        assertEquals(7, items[7].sellIn);
        assertEquals(-4, items[8].sellIn);

        assertEquals(80, items[0].quality);
        assertEquals(80, items[1].quality);
        assertEquals(80, items[2].quality);
        assertEquals(88, items[3].quality);
        assertEquals(88, items[4].quality);
        assertEquals(88, items[5].quality);
        assertEquals(-11, items[6].quality);
        assertEquals(-11, items[7].quality);
        assertEquals(-11, items[8].quality);
    }
}
