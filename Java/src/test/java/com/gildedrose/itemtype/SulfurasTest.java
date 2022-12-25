package com.gildedrose.itemtype;

import static com.gildedrose.ItemType.SULFURAS;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gildedrose.GildedRoseTest;
import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

class SulfurasTest extends GildedRoseTest {

    private final Item sulfuras1 = new Item(SULFURAS.getName(), 0, 80);
    private final Item sulfuras2 = new Item(SULFURAS.getName(), 7, 80);
    private final Item sulfuras3 = new Item(SULFURAS.getName(), -4, 80);

    @Override
    protected Item[] getItems() {
        return new Item[] {
            sulfuras1,
            sulfuras2,
            sulfuras3,
        };
    }

    @Test
    void noChanges() {
        assertEquals(0, sulfuras1.sellIn);
        assertEquals(7, sulfuras2.sellIn);
        assertEquals(-4, sulfuras3.sellIn);
        assertEquals(80, sulfuras1.quality);
        assertEquals(80, sulfuras2.quality);
        assertEquals(80, sulfuras3.quality);
    }
}
