@US04@ui@db
Feature: As a data consumer, I want UI and DB book information are match.

  Scenario Outline: Verify book information with DB
    Given the user logged in as "librarian"
    And the user navigates to "Books" page
    When the user searches for "<search book name>" book
    And  the user clicks edit book button
    Then book information must match the Database
    Examples:
      | search book name    |
      | Fast & Furious      |
      | Behind Closed Doors |
      | The Silent Patient  |