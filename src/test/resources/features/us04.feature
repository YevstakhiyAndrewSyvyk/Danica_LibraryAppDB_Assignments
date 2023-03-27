@US04@ui@db
Feature: As a data consumer, I want UI and DB book information are match.

  Scenario Outline: Verify book information with DB
    Given the user logged in as "librarian" MY
    And the user navigates to "Books" page MY
    When the user searches for "<search book name>" book MY
    And  the user clicks edit book button MY
    Then book information must match the Database MY
    Examples:
      | search book name    |
      | Fast & Furious      |
      | Behind Closed Doors |
      | The Silent Patient  |