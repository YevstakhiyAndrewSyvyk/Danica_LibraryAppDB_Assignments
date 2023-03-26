package com.library.steps;

import com.library.pages.BookPage;
import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.List;

public class US04_StepDefs {
    LoginPage loginPage=new LoginPage();
    BookPage bookPage = new BookPage();
    String searchBookName;
    List<String> actuallist;

    @Given("the user logged in as {string}")
    public void theUserLoggedInAs(String user) {
        loginPage.login(user);
        BrowserUtil.waitFor(4);
    }

    @And("the user navigates to {string} page")
    public void theUserNavigatesToPage(String moduleName) {
        new DashBoardPage().navigateModule(moduleName);
    }
    @When("the user searches for {string} book")
    public void theUserSearchesForBook(String searchValue) {
        bookPage.search.sendKeys(searchValue + Keys.ENTER);
        this.searchBookName = searchValue;
    }

    @And("the user clicks edit book button")
    public void theUserClicksEditBookButton() {
        bookPage.editBook(searchBookName).click();
    }

    @Then("book information must match the Database")
    public void bookInformationMustMatchTheDatabase() {
        //expectedlist = [Fast & Furious, 09123456, 2023, Mina K, Action and Adventure, This book is for database testing.]

        actuallist = bookPage.getEditBookAllInfo();
        DB_Util.runQuery("select books.name ,isbn,year,author,bc.name, books.description from books join book_categories bc on books.book_category_id = bc.id where books.name = '" + searchBookName + "'");
        List<String> expectedlist = DB_Util.getRowDataAsList(1);
        System.out.println("expectedlist = " + expectedlist);
        Assert.assertEquals(expectedlist, actuallist);

    }


}
