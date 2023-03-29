
Feature: As a data consumer, I want UI and DB book categories are match OT
@wip @db @ui
  Scenario: verify book categories with DB OT
    Given the "librarian" on the home page OT
    When the user navigates to "Books" page OT
    And the user clicks book categories OT
    Then verify book categories must match book_categories table from db OT