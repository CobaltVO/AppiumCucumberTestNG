@bvt
Feature: Chrome

  Scenario: complete FRW of Chrome
    Given welcome page appears
    When set checkbox to disabled at the welcome page
    Then click continue button at the welcome page

    Given turbo page appears
    When set switch to disabled at the turbo page
    Then click continue button at the turbo page
