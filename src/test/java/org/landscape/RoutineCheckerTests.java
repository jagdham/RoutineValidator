package org.landscape;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RoutineCheckerTests {
//    @ParameterType("red|blue|yellow")  // regexp
//    public Date DateParameter(String date){  // type, name (from method)
//        SimpleDateFormat parser = new SimpleDateFormat("yyyy-mm-dd");
//        Date date = parser.parse(input);
//    }
    RoutineChecker checker;
    public static Routine buildRoutine(double amount, int year, int month, int day) {
        return new Routine.RoutineBuilder()
                .amount(amount)
                .date(new Date(year, month, day))
                .build();
    }


    @Given("I have \"\"{int}-{int}-{int}\"\" \"\"{int}-{int}-{int}\"\" and \"\"{int}-{int}-{int}\"\"")
    public void i_have_and(Integer year1, Integer month1, Integer date1, Integer year2, Integer month2, Integer date2, Integer year3, Integer month3, Integer date3) {
        Routine initial = buildRoutine(100, year1, month1, date1);
        Routine adjustment = buildRoutine(100, year2, month2, date2);
        Routine finalRoutine = buildRoutine(100, year3, month3, date3);
        checker = new RoutineChecker(initial, adjustment, finalRoutine);
    }
    @Then("Validator should return {int}")
    public void validator_should_return(int expectedCode) {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(checker.validate(), expectedCode);
    }


    @Given("I have three amount as {int}, {int} and {int}")
    public void i_have_three_amount_as_and(Integer initialAmount, Integer adjustmentAmount, Integer finalAmount) {
        // Write code here that turns the phrase above into concrete actions
        Routine initial = buildRoutine(initialAmount, 2022, 12, 01);
        Routine adjustment = buildRoutine(adjustmentAmount, 2022, 12, 05);
        Routine finalRoutine = buildRoutine(finalAmount, 2022, 12, 10);
        checker = new RoutineChecker(initial, adjustment, finalRoutine);
    }
    @Then("It should return {int} as per amount rule")
    public void it_should_return_as_per_amount_rule(Integer expectedCode) {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(checker.validate(), expectedCode);
    }
}
