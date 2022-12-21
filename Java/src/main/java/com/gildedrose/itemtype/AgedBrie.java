package com.gildedrose.itemtype;

import static com.gildedrose.GildedRose.DEFAULT_QUALITY_UPDATER;
import static com.gildedrose.GildedRose.DEFAULT_SELLIN_UPDATER;

import java.util.function.Consumer;

import com.gildedrose.Item;
import com.gildedrose.ItemType;
import com.gildedrose.QualityUpdater;
import org.springframework.stereotype.Component;

@Component
public class AgedBrie extends ItemType {

    public static final String NAME = "Aged Brie";
    public static final QualityUpdater QUALITY_UPDATER = item -> -DEFAULT_QUALITY_UPDATER.getAmount(item);

    public AgedBrie() {
        super(NAME, QUALITY_UPDATER, DEFAULT_SELLIN_UPDATER);
    }
}
