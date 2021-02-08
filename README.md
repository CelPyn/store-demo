# STORE-DEMO

## Setup

Checkout branch feature/exercise-start.

```
git checkout -t origin/feature/exercise-start
```

## 1. BasketItem

The demo implemented `DefaultBasketItem#getSubTotal()`. Test the given implementation, only the happy flow suffices.

## 2. DefaultBasketService

The demo has a bug in it's `#add()` method that breaks immutability. Use the provided
test `BasketServiceTest#immutabiliy()` to fix it.

Hint: `ArrayList` has a constructor which allows you to copy an existing list.
