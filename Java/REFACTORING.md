# Refactoring

The goal was to improve the structure of `GildedRose.java` without changing its
behavior. The 16 tests from Exercise 6 were used as a safety net: they were run
after every step and stayed green the whole time. As required by the kata,
`Item.java` was not changed.

## Steps

1. **Constants** — the item names (`"Aged Brie"`, `"Sulfuras..."`,
   `"Backstage passes..."`) were repeated many times. They were replaced with
   constants to remove duplication and avoid typos.
2. **for-each + `updateItem`** — the index-based `for` loop was replaced with a
   `for (Item item : items)` loop, and the per-item logic was moved into its own
   `updateItem` method. This separates the loop from the update rules.
3. **Split by item type** — the deeply nested if-statements were replaced with
   one method per item type (`updateAgedBrie`, `updateBackstagePass`,
   `updateNormalItem`). Sulfuras returns early since it never changes. The
   repeated quality limits (never below 0, never above 50) were extracted into
   the helper methods `increaseQuality` / `decreaseQuality`.

## Result

The nested if-statements are gone. Each item type's rules now live in their own
method that reads almost like the specification, so the code is much easier to
read and to extend with new item types.

## Challenges

- **Keeping the exact order** of the original logic (change quality, then
  decrease `sellIn`, then handle the after-sell-date case) so the behavior and
  the tests stayed unchanged.
- **Backstage pass tiers** — the `< 11` and `< 6` day checks had to happen
  before `sellIn` was decreased, otherwise the +2 / +3 tiers would shift by a day.
