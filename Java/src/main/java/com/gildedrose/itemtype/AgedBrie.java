package com.gildedrose.itemtype;

import static com.gildedrose.GildedRose.DEFAULT_QUALITY_UPDATER;

import com.gildedrose.ItemType;
import com.gildedrose.QualityUpdater;

public class AgedBrie extends ItemType {

    public static final String NAME = "Aged Brie";
    public static final QualityUpdater QUALITY_UPDATER = item -> -DEFAULT_QUALITY_UPDATER.getAmount(item);

    public AgedBrie() {
        super(NAME, QUALITY_UPDATER);
    }
}
