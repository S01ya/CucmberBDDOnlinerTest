Feature:  I want to get ability to navigate to sections
  "Автобарахолка" from Onliner main page and to have there
  submenu with sections:
  "prise",
  "cities",
  "brands"
  So that I can

  @smoke
  Scenario: AutoBaraholka sections should contains appropriate columns
    Given the user opens Onliner website
    When the user check that "Автобарахолка" section exist
    And the  user hover to "Автобарахолка" section
    Then the dropdown submenu  of "Автобарахолка" is appear contains table "city" "price" "car"