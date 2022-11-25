Feature: As a user
  I want to get ability to navigate to sections
  "Дома и квартиры" from Onliner main page and to have there
  submenu with sections:
  "cities",
  "number of rooms",
  "prise"
  So that I can

  @smoke
  Scenario: HousesAndFlats sections should contains appropriate columns
    Given the user opens Onliner website
    When the user check that "Дома и квартиры" section exist
    And the  user hover to "Дома и квартиры" section
    Then the dropdown submenu  of "Дома и квартиры" is appear and contains table "cities" "number of rooms" "prise"

