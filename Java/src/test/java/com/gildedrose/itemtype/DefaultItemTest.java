package com.gildedrose.itemtype;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gildedrose.GildedRoseTest;
import com.gildedrose.Item;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class DefaultItemTest extends GildedRoseTest {

    @Configuration
    static class TestConfig {

        // regular
        @Bean
        Item defaultItem1() {
            return new Item("test item", 4, 3);
        }
        @Bean
        Item defaultItem2() {
            return new Item("test item", 3, 1);
        }

        // after sell date
        @Bean
        Item defaultItem3() {
            return new Item("test item", 0, 4);
        }
        @Bean
        Item defaultItem4() {
            return new Item("test item", -3, 47);
        }

        // bottom limit
        @Bean
        Item defaultItem5() {
            return new Item("test item", 4, 0);
        }
        @Bean
        Item defaultItem6() {
            return new Item("test item", -3, 1);
        }
    }

    @Test
    void sellinDecreases() {
        assertEquals(3, getNamedItem("defaultItem1").sellIn);
        assertEquals(-1, getNamedItem("defaultItem3").sellIn);
        assertEquals(-4, getNamedItem("defaultItem4").sellIn);
    }

    @Test
    void qualityDecreases() {
        assertEquals(2, getNamedItem("defaultItem1").quality);
        assertEquals(0, getNamedItem("defaultItem2").quality);
    }

    @Test
    void qualityDecreasesDoubleAfterSellDate() {
        assertEquals(2, getNamedItem("defaultItem3").quality);
        assertEquals(45, getNamedItem("defaultItem4").quality);
    }

    @Test
    void qualityAlwaysPositive() {
        assertEquals(0, getNamedItem("defaultItem5").quality);
        assertEquals(0, getNamedItem("defaultItem6").quality);
    }
}
