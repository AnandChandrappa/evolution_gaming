# new feature
# Tags: optional
@EvolutionGaming
Feature: Validating Favourites scenarios
  As a user I should be able to search Adds and add them to Favourites and remove

  Background: Open browser
    Given User is on Adds homepage

#  Scenario Outline: Search Addvertisement through navigation and add to Favourites
#    When I click on "<Category>" link under "<Section>" section
#    And I click on "<Subcategory>" link
#    Then I navigate to Adds result page
#    And I click on "<add>" from result page
#    Then am navigated to "<add>" details page
#    And I click on Add to Memo
#    Then I go to Memo and verify "<add>"
#    Examples:
#      | Category  | Section     | Subcategory | add                          |
#      | Cars      | transport   | Kia         | Please do not disturb buyers |
#      | Apartment | Real Estate | Madona      | A young couple wants to rent |

  Scenario Outline: Search Advertisements through navigation and add to Favourites and verify count
    When I click on "<Category>" link under "<Section>" section
    And I click on "<Subcategory>" link
    Then I navigate to Adds result page
    And I select first "<count>" advertisements in result page
    And I click on Add selected to Memo
    And I go to Memo and verify advertisements count as "<count>"
    Examples:
      | Category | Section      | Subcategory | count |
      | Plumbing | Construction | Boilers     | 3     |


  Scenario: To verify funcationality of remove adds from favourites
    When I click on "Special clothing" link under "Clothes" section
    Then I navigate to Adds result page
    And I select first "4" advertisements in result page
    And I click on Add selected to Memo
    And I go to Memo and verify advertisements count as "4"
    Then I remove an Add and from Memo and verify the adds count
