package com.gildedrose.itemtype;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gildedrose.GildedRoseTest;
import com.gildedrose.Item;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class BackstagePassTest extends GildedRoseTest {

    @Configuration
    static class TestConfig {

        // regular
        @Bean
        public Item backstagePass1() {
            return new Item(BackstagePass.NAME, 11, 0);
        }
        @Bean
        public Item backstagePass2() {
            return new Item(BackstagePass.NAME, 11, 49);
        }

        // double increase
        @Bean
        public Item backstagePass3() {
            return new Item(BackstagePass.NAME, 10, 0);
        }
        @Bean
        public Item backstagePass4() {
            return new Item(BackstagePass.NAME, 6, 3);
        }

        // triple increase
        @Bean
        public Item backstagePass5() {
            return new Item(BackstagePass.NAME, 5, 0);
        }
        @Bean
        public Item backstagePass6() {
            return new Item(BackstagePass.NAME, 1, 3);
        }

        // after sell date
        @Bean
        public Item backstagePass7() {
            return new Item(BackstagePass.NAME, 0, 3);
        }
        @Bean
        public Item backstagePass8() {
            return new Item(BackstagePass.NAME, -1, 47);
        }

        // max quality limit
        @Bean
        public Item backstagePass9() {
            return new Item(BackstagePass.NAME, 11, 50);
        }
        @Bean
        public Item backstagePass10() {
            return new Item(BackstagePass.NAME, 1, 48);
        }
    }

    @Test
    void sellinDecreases() {
        assertEquals(10, getNamedItem("backstagePass1").sellIn);
        assertEquals(9, getNamedItem("backstagePass3").sellIn);
        assertEquals(5, getNamedItem("backstagePass4").sellIn);
        assertEquals(4, getNamedItem("backstagePass5").sellIn);
        assertEquals(0, getNamedItem("backstagePass6").sellIn);
        assertEquals(-1, getNamedItem("backstagePass7").sellIn);
        assertEquals(-2, getNamedItem("backstagePass8").sellIn);
    }

    @Test
    void qualityIncrease() {
        assertEquals(1, getNamedItem("backstagePass1").quality);
        assertEquals(50, getNamedItem("backstagePass2").quality);
    }

    @Test
    void qualityIncreasesDouble10DaysOrLess() {
        assertEquals(2, getNamedItem("backstagePass3").quality);
        assertEquals(5, getNamedItem("backstagePass4").quality);
    }

    @Test
    void qualityIncreasesTriple5DaysOrLess() {
        assertEquals(3, getNamedItem("backstagePass5").quality);
        assertEquals(6, getNamedItem("backstagePass6").quality);
    }

    @Test
    void qualityDropsAfterSellDate() {
        assertEquals(0, getNamedItem("backstagePass7").quality);
        assertEquals(0, getNamedItem("backstagePass8").quality);
    }

    @Test
    void maxQuality() {
        assertEquals(50, getNamedItem("backstagePass9").quality);
        assertEquals(50, getNamedItem("backstagePass10").quality);
    }
}
