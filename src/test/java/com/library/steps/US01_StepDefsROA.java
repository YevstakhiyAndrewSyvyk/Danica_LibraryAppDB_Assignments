package com.library.steps;

import com.library.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class US01_StepDefsROA {

    List<String> actAllColumnNames;

    @When("Execute query to get all columns ROA")
    public void executeQueryToGetAllColumnsROA() {

        DB_Util.runQuery("select * from users");
        actAllColumnNames = DB_Util.getAllColumnNamesAsList();
        System.out.println("actAllColumnNames = " + actAllColumnNames);
    }

    @Then("verify the below columns are listed in result ROA")
    public void verifyTheBelowColumnsAreListedInResultROA(List<String> expected) {

        Assert.assertEquals(actAllColumnNames,expected);


    }
}
