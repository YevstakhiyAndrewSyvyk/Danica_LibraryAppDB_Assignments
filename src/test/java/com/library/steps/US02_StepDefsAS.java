
package com.library.steps;

import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class US02_StepDefsAS {

    String actualBorrowedBookNumbers;
    LoginPage loginPage = new LoginPage();

    DashBoardPage dashBoardPage = new DashBoardPage();


    @Given("the {string} on the home page AS")
    public void the_on_the_home_page_as(String user) {
        loginPage.login(user);
        BrowserUtil.waitFor(3);
    }
    @When("the librarian gets borrowed books number AS")
    public void the_librarian_gets_borrowed_books_number_as() {
        actualBorrowedBookNumbers = dashBoardPage.borrowedBooksNumber.getText();
        System.out.println("actualBorrowedBookNumbers = " + actualBorrowedBookNumbers);
    }
    @Then("borrowed books number information must match with DB AS")
    public void borrowed_books_number_information_must_match_with_db_as() {

        String query = "select count(*) from book_borrow\n" +
                "where is_returned = 0";

        DB_Util.runQuery(query);

        String expectedBorrowedBookNumbers= DB_Util.getFirstRowFirstColumn();
        System.out.println("expectedBorrowedBookNumbers = " + expectedBorrowedBookNumbers);

        Assert.assertEquals(actualBorrowedBookNumbers,expectedBorrowedBookNumbers);
    }


}
