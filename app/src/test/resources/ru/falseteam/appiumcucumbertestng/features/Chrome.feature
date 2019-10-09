@bvt
Feature: Chrome

  Scenario: complete FRW of Chrome
    Given welcome page appears
    When set checkbox to disabled at the welcome page
    Then click continue button at the welcome page

    Given turbo page appears
    When set switch to disabled at the turbo page
    Then click continue button at the turbo page

    # this step is only exists at ru-RU locale
    Given search engine page appears
    When set radio button to Google at the search engine page
    Then click OK button at the search engine page

    Given sync page appears
    When click no thanks button at the sync page
    Then main page of Chrome appears