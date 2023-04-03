@US02_Sami @ui@db
Feature: As a librarian, I want to know borrowed books number Sami

  Scenario: verify the total amount of borrowed books Sami
    Given the "librarian" on the home page Sami
    When the librarian gets borrowed books number Sami
    Then borrowed books number information must match with DB Sami