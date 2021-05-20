# STORE-DEMO

## Setup

Run `mvn clean install` to get the dependencies in your project.

## 1. Implementing and testing the domain

Product is a simple pojo. Write a test that creates a product, and validates the correct data is returned on each of the
methods in Product.

BasketItem has a method `getSubtotal()`, but the implementation doesn't seem quite right. Test it and fix the
implementation.

## 2. Implementing and testing the repository

The implementation of the ProductRepository is incomplete. Using TDD, write tests of the current implementation, then
fix it to achieve the desired result.

`getAll` should be fairly straightforward. Just return all the products in the repository.

`getById` should return exactly one result, which matches the passed integer. Write tests for both existing and
non-existing products.

`findByCategory` should return a list of Products which match a given category.

`findByName` should return a list of Products which match a given name.

(Note: `ProductRepository.find` is optional to implement if you'd like to take on the challenge of writing an
implementation of a predicate.)

## 3. Implementing and testing the services

We're starting to get into a stage where we have services with dependencies (`ProductRepository`). Make sure to mock
these dependencies!

### 3.1 BasketService

The add method takes a basket, a product and a quantity. Complete the implementation in a TDD way and test every edge
case.

You should at least have the following tests:

- Adding a product to an empty basket
- Adding a product to a basket which contains one item of a different Id
- Adding a product to a basket which contains one item with the same Id
- Adding a null product to a basket

The remove method does the opposite of the add method. Implement it and test the following cases:

- Removing a product from an empty basket
- Removing a product from a basket which does not contain products with the passed id
- Removing a quantity of products from a basket which contains a lesser amount of that product than are requested to be
  deleted.

After this, write a test that first adds a couple of products, then removes them again, then validate that the basket is
empty.

### 3.2 CatalogService

The CatalogService has a of couple methods that need implementations. Implement them and test as much cases as you can.

Be sure to mock your dependencies!

### 3.3 PayService

The PayService takes a basket and returns the amount of money you need to pay for the entire basket. Implement and test
this functionality.

## 4. Testing the entire thing

Create a test class that tests what you previously implemented. This time around, don't mock anything.

Test at least one flow:

- Search for two different products in the catalog.
- Add them in certain quantities to an empty basket.
- Ask the payService to calculate the total cost and validate that it's right.

If you implemented the previous steps correctly, you should not have to make any changes to your business logic!

