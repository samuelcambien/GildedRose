package com.gildedrose.itemtype;

import com.gildedrose.ItemType;
import org.springframework.stereotype.Component;

@Component
public class Sulfuras extends ItemType {

    public static final String NAME = "Sulfuras, Hand of Ragnaros";

    public Sulfuras() {
        super(NAME, item -> {}, item -> {});
    }
}
