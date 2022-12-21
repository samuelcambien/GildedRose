package com.gildedrose.itemtype;

import static com.gildedrose.GildedRose.DEFAULT_SELLIN_UPDATER;

import com.gildedrose.QualityUpdater;
import com.gildedrose.ItemType;

public class BackstagePass extends ItemType {

    public static final String NAME = "Backstage passes to a TAFKAL80ETC concert";
    public static final QualityUpdater QUALITY_UPDATER = item -> {
        if (item.sellIn <= 0) {
            return -item.quality;
        } else if (item.sellIn <= 5) {
            return 3;
        } else if (item.sellIn <= 10) {
            return 2;
        } else {
            return 1;
        }
    };

    public BackstagePass() {
        super(NAME, QUALITY_UPDATER, DEFAULT_SELLIN_UPDATER);
    }
}
