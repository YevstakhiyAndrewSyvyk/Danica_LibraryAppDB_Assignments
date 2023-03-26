package com.library.pages;

import com.library.utility.BrowserUtil;
import com.library.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class BookPage extends BasePage {

    @FindBy(xpath = "//table/tbody/tr")
    public List<WebElement> allRows;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement search;

    @FindBy(id = "book_categories")
    public WebElement mainCategoryElement;

    @FindBy(name = "name")
    public WebElement bookName;


    @FindBy(xpath = "(//input[@type='text'])[4]")
    public WebElement author;

    @FindBy(xpath = "//div[@class='portlet-title']//a")
    public WebElement addBook;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveChanges;

    @FindBy(xpath = "//div[@class='toast-message']")
    public WebElement toastMessage;

    @FindBy(name = "year")
    public WebElement year;

    @FindBy(name = "isbn")
    public WebElement isbn;

    @FindBy(id = "book_group_id")
    public WebElement categoryDropdown;



    @FindBy(id = "description")
    public WebElement description;



    public WebElement editBook(String book) {
        String xpath = "//td[3][.='" + book + "']/../td/a";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }

    public WebElement borrowBook(String book) {
        String xpath = "//td[3][.='" + book + "']/../td/a";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }


    //line 67-94 created by -Mina
    @FindBy(id = "book_group_id")
    public WebElement editBook_bookCategory;

    public List<String> getEditBookAllInfo(){
        BrowserUtil.waitFor(3);
        //getText() ---> will return text from provided element
        //for input boxes, to get the text, we can use getAttribute( value )
        String bookName_UI = bookName.getAttribute("value");
        String isbn_UI= isbn.getAttribute("value");
        String year_UI= year.getAttribute("value");
        String author_UI= author.getAttribute("value");
        String description_UI= description.getAttribute("value");

        Select select = new Select(editBook_bookCategory);
        String category_UI= select.getFirstSelectedOption().getText();

        List<String> actuallist= new ArrayList<>();
        actuallist.add(bookName_UI);
        actuallist.add(isbn_UI);
        actuallist.add(year_UI);
        actuallist.add(author_UI);
        actuallist.add(category_UI);
        actuallist.add(description_UI);

        System.out.println("actual list "+actuallist);
        return actuallist;
    }




}
