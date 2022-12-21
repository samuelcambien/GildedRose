package com.gildedrose;

import static org.springframework.boot.SpringApplication.run;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.context.ApplicationContext;

public abstract class GildedRoseTest {

    private static ApplicationContext context;

    @BeforeAll
    public static void setUp() {
        context = run(GildedRose.class);
        context.getBean(GildedRose.class)
               .updateQuality();
    }

    protected static Item getNamedItem(String name) {
        return context.getBean(name, Item.class);
    }
}
