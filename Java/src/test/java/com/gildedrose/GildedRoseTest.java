package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    @Test
    void normal_item_quality_decreases_by_one_before_sell_date() {
        Item[] items = new Item[] { new Item("foo", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, items[0].quality);
        assertEquals(4, items[0].sellIn);
    }

    @Test
    void normal_item_quality_decreases_twice_as_fast_after_sell_date() {
        Item[] items = new Item[] { new Item("foo", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, items[0].quality);
    }

    @Test
    void normal_item_quality_never_goes_below_zero() {
        Item[] items = new Item[] { new Item("foo", 5, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, items[0].quality);
    }

    @Test
    void normal_item_quality_never_goes_below_zero_after_sell_date() {
        Item[] items = new Item[] { new Item("foo", 0, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, items[0].quality);
    }

    @Test
    void normal_item_quality_decreases_correctly_over_multiple_days() {
        Item[] items = new Item[] { new Item("foo", 3, 10) };
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < 3; i++)
        {
            app.updateQuality();
        }
        assertEquals(7, items[0].quality);
    }

    @Test
    void normal_item_quality_decreases_twice_on_last_sell_day() {
        Item[] items = new Item[] { new Item("foo", 1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, items[0].quality);
        app.updateQuality();
        assertEquals(7, items[0].quality);
    }

    @Test
    void aged_brie_increases_in_quality() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, items[0].quality);
    }

    @Test
    void aged_brie_quality_never_exceeds_50() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, items[0].quality);
    }

    @Test
    void aged_brie_increases_twice_as_fast_after_sell_date() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, items[0].quality);
    }

}
