package com.gildedrose.itemtype;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gildedrose.GildedRoseTest;
import com.gildedrose.Item;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class SulfurasTest extends GildedRoseTest {

    @Configuration
    static class TestConfig {
        @Bean
        Item sulfuras1() {
            return new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        }
        @Bean
        Item sulfuras2() {
            return new Item("Sulfuras, Hand of Ragnaros", 7, 80);
        }
        @Bean
        Item sulfuras3() {
            return new Item("Sulfuras, Hand of Ragnaros", -4, 80);
        }
    }

    @Test
    void noChanges() {
        assertEquals(0, getNamedItem("sulfuras1").sellIn);
        assertEquals(7, getNamedItem("sulfuras2").sellIn);
        assertEquals(-4, getNamedItem("sulfuras3").sellIn);
        assertEquals(80, getNamedItem("sulfuras1").quality);
        assertEquals(80, getNamedItem("sulfuras2").quality);
        assertEquals(80, getNamedItem("sulfuras3").quality);
    }
}
