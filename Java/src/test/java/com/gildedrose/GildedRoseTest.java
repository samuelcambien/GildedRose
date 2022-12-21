package com.gildedrose;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.context.ApplicationContext;

public abstract class GildedRoseTest {

    private static ApplicationContext context;

    @BeforeAll
    public static void setUp() {
        context = GildedRose.start();
        context.getBean(GildedRose.class)
               .updateQuality();
    }

    protected static Item getNamedItem(String name) {
        return context.getBean(name, Item.class);
    }
}
