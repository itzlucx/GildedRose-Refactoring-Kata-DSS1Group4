## Test Strategy

Tests are organized by item type, covering all rules from the specification:

- **Normal items**: quality decrease, sell date behavior, boundaries, multiple days
- **Aged Brie**: quality increase, max quality (50), faster increase after sell date
- **Sulfuras**: quality and sellIn never change
- **Backstage Passes**: tiered increases (>10, <=10, <=5 days), drop to zero after concert, max quality (50)

Each category was committed separately to show progression.

## Challenges

- **Understanding the existing code**: The original code uses deeply nested
  if-statements which made it initially difficult to trace all the rules
  at once.

- **Backstage Pass tiers**: The tiered quality increase logic (>10, <=10, <=5 days)
  was easy to misread in the nested if-structure, so extra care was needed
  to write the correct expected values.
