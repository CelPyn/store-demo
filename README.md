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

## 3. DefaultCatalogService

### 3.1 Obvious Implementation

Complete the implementation of `CatalogService#getAll()` and use an obvious implementation to test it.

Hint: ProductRepository

### 3.2 Triangulation

### 3.2.1

`CatalogService#getById()` takes a `String` argument. But the type of the id propery in Product is an `int`!
Complete the implementation to convert the String to an int and return the correct `Product`.

If you cannot find a product that matches the query, return null.

Make sure to test the happy flow, and the not found flow!

### 3.2.2

Write a test case that tests what happens when you pass a null value to `CatalogService#getById()`. Then, change the
code so that `CatalogService#getById()` throws an `IllegalArgumentException` when attempting to pass a null argument.

### 3.2.3

In 3.2.1 you were told to return null if you could not find a product. Returning null is not a good practice. Throw
a `NoSuchElementException` instead!

Re-run all your previous tests and fix them where needed!

