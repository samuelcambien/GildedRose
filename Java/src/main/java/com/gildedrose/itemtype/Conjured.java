package com.gildedrose.itemtype;

import static com.gildedrose.GildedRose.DEFAULT_QUALITY_UPDATER;
import static com.gildedrose.GildedRose.DEFAULT_SELLIN_UPDATER;

import com.gildedrose.ItemType;
import com.gildedrose.QualityUpdater;
import org.springframework.stereotype.Component;

@Component
public class Conjured extends ItemType {

    public static final String NAME = "Conjured Mana Cake";
    public static final QualityUpdater QUALITY_UPDATER = item -> 2 * DEFAULT_QUALITY_UPDATER.getAmount(item);

    public Conjured() {
        super(NAME, QUALITY_UPDATER, DEFAULT_SELLIN_UPDATER);
    }
}
