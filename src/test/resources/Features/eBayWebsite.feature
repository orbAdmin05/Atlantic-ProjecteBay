Feature: eBay commercial website


  @iPhoneCheckout_test
  Scenario:A user purchase an iPhone 14 online
    Given a user on a given website to purchase the item
    When user see the search results upon a search for iPhone 14 from the search bar
    And the user performs the required steps upon adding the item to the cart to purchase
    And the user adding the shipping address to continue purchase
    Then user will reach at "Checkout"

  @dailyDeals_test
  Scenario: A user check fall daily deals
    Given a user is on the eBay Home Page
    And user navigate to daily Deals
    When user click on daily deals to check fall products
    Then the fall feature is "Pssst! First Deals of Fall are Here"

  @camerasBrand_test
  Scenario: A user check cameras brand
    Given user is in eBay home page
    And user navigate to electronics
    When user performs required steps to find cameras brand
    Then the brand name is "Nikon Digital Cameras"

  @findbooksStores_test
  Scenario: A user looking for a online store books of valor
    Given a user is on the given website
    And user navigate to stores
    When user performs required steps to find the stores
    Then the online store is "BOOKS OF VALOR"

  @careers_test
  Scenario: A user check the careers portal
    Given user open ebay home page
    And user navigate to careers link
    When user performs required steps to find the desired job
    Then the job title is "Senior iOS Engineer"

  @filtering_test
   Scenario: A user check the products filtering on the page
    Given user navigate to ebay home page
    And user search the product
    When user apply the filtering
    Then user check the filter result

  @productRemoved_test
  Scenario: A user remove a product from the cart
    Given user is on the ebay search page
    And user search the required product
    And user add a product to the cart
    When user remove the product from the cart
    Then user see the message "You don't have any items in your cart."

  @policies_test
   Scenario: A user read the payment services policies
    Given user is in the ebay home page
     And user navigate to policies
     When user performs all the required steps
     Then user will see the article "14. Payment Services"

  @ukdomainprice_test
    Scenario: A user use eBay united kingdom domain
      Given a user is on the ebay home page
      And user navigate to united kingdom's page
      When user add an item to the cart
      Then user pay in euro instead of dollar which is "£14.15"

  @eBayratecard_test
    Scenario: A user want to check global rate card
      Given a user open ebay home page
      And user open up affiliates service
      When user perform required steps to find rate card table
      Then user see "Rate card as of August 24 2020:" table


