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
            new Item(SULFURAS.getName(), 0, 80),
            new Item(SULFURAS.getName(), 7, 80),
            new Item(SULFURAS.getName(), -4, 80),
        };
    }

    @Test
    void noChanges() {
        assertEquals(0, items[0].sellIn);
        assertEquals(7, items[1].sellIn);
        assertEquals(-4, items[2].sellIn);
        assertEquals(80, items[0].quality);
        assertEquals(80, items[1].quality);
        assertEquals(80, items[2].quality);
    }
}
