package com.gildedrose.itemtype;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gildedrose.GildedRoseTest;
import com.gildedrose.Item;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

class AgedBrieTest extends GildedRoseTest {

    @TestConfiguration
    static class TestConfig {

        // regular
        @Bean
        public Item agedBrie1() {
            return new Item(AgedBrie.NAME, 3, 0);
        }
        @Bean
        public Item agedBrie2() {
            return new Item(AgedBrie.NAME, 3, 3);
        }
        @Bean
        public Item agedBrie3() {
            return new Item(AgedBrie.NAME, 3, 49);
        }

        // after sell date
        @Bean
        public Item agedBrie4() {
            return new Item(AgedBrie.NAME, 0, 3);
        }
        @Bean
        public Item agedBrie5() {
            return new Item(AgedBrie.NAME, -3, 7);
        }

        // max quality limit
        @Bean
        public Item agedBrie6() {
            return new Item(AgedBrie.NAME, 3, 50);
        }
        @Bean
        public Item agedBrie7() {
            return new Item(AgedBrie.NAME, 0, 49);
        }
        @Bean
        public Item agedBrie8() {
            return new Item(AgedBrie.NAME, -3, 50);
        }
    }

    @Test
    void sellinDecreases() {
        assertEquals(2, getNamedItem("agedBrie1").sellIn);
        assertEquals(-1, getNamedItem("agedBrie4").sellIn);
        assertEquals(-4, getNamedItem("agedBrie5").sellIn);
    }

    @Test
    void qualityIncreases() {
        assertEquals(1, getNamedItem("agedBrie1").quality);
        assertEquals(4, getNamedItem("agedBrie2").quality);
        assertEquals(50, getNamedItem("agedBrie3").quality);
    }

    @Test
    void qualityIncreasesDoubleAfterSellDate() {
        assertEquals(5, getNamedItem("agedBrie4").quality);
        assertEquals(9, getNamedItem("agedBrie5").quality);
    }

    @Test
    void maxQualityLimit() {
        assertEquals(50, getNamedItem("agedBrie6").quality);
        assertEquals(50, getNamedItem("agedBrie7").quality);
        assertEquals(50, getNamedItem("agedBrie8").quality);
    }
}
