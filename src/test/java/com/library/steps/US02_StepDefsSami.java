package com.library.steps;

import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US02_StepDefsSami {

    LoginPage loginPage = new LoginPage();
    DashBoardPage dashBoardPage = new DashBoardPage();
    String actualResult;


    @Given("the {string} on the home page Sami")
    public void the_on_the_home_page_sy(String librarian) {
        loginPage.login(librarian);
        BrowserUtil.waitFor(2);
    }
    @When("the librarian gets borrowed books number Sami")
    public void the_librarian_gets_borrowed_books_number_sy() {

        actualResult=dashBoardPage.borrowedBooksNumber.getText();

    }
    @Then("borrowed books number information must match with DB Sami")
    public void borrowed_books_number_information_must_match_with_db_sy() {

        DB_Util.runQuery("select count(*) from book_borrow where is_returned=0");
        String expectedResult = DB_Util.getFirstRowFirstColumn();
        Assert.assertTrue(actualResult.equals(expectedResult));

    }

}
