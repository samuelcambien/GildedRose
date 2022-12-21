package com.gildedrose.itemtype;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gildedrose.GildedRoseTest;
import com.gildedrose.Item;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

class ConjuredTest extends GildedRoseTest {

    @TestConfiguration
    static class testConfig {

        // regular
        @Bean
        Item conjuredItem1() {
            return new Item(Conjured.NAME, 4, 3);
        }
        @Bean
        Item conjuredItem2() {
            return new Item(Conjured.NAME, 3, 2);
        }

        // after sell date
        @Bean
        Item conjuredItem3() {
            return new Item(Conjured.NAME, 0, 4);
        }
        @Bean
        Item conjuredItem4() {
            return new Item(Conjured.NAME, -3, 47);
        }

        // botom limit
        @Bean
        Item conjuredItem5() {
            return new Item(Conjured.NAME, 4, 1);
        }
        @Bean
        Item conjuredItem6() {
            return new Item(Conjured.NAME, -3, 2);
        }
    }

    @Test
    void sellinDecreases() {
        assertEquals(3, getNamedItem("conjuredItem1").sellIn);
        assertEquals(-1, getNamedItem("conjuredItem3").sellIn);
        assertEquals(-4, getNamedItem("conjuredItem4").sellIn);
    }

    @Test
    void qualityDecreases() {
        assertEquals(1, getNamedItem("conjuredItem1").quality);
        assertEquals(0, getNamedItem("conjuredItem2").quality);
    }

    @Test
    void qualityDecreasesDoubleAfterSellDate() {
        assertEquals(0, getNamedItem("conjuredItem3").quality);
        assertEquals(43, getNamedItem("conjuredItem4").quality);
    }

    @Test
    void qualityAlwaysPositive() {
        assertEquals(0, getNamedItem("conjuredItem5").quality);
        assertEquals(0, getNamedItem("conjuredItem6").quality);
    }
}
