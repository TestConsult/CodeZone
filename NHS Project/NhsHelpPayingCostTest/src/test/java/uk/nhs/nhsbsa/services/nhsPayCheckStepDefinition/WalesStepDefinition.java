package uk.nhs.nhsbsa.services.nhsPayCheckStepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import uk.nhs.nhsbsa.services.Pages.*;
import uk.nhs.nhsbsa.services.fileUtil.Props;
import uk.nhs.nhsbsa.services.support.WorldHelper;

public class WalesStepDefinition {
    private WorldHelper helper;
    private HomePage homePage;
    private WhereYouLivePage whereYouLivePage;
    private DateOfBirthPage dateOfBirthPage;
    private PartnersPage partnersPage;
    String countryName = Props.getConfig("country-name");
    String dayValue = Props.getConfig("day-of-birth");
    String monthvalue = Props.getConfig("month-of-birth");
    String yearvalue = Props.getConfig("year-of-birth");
    String option = Props.getConfig("answer-option");
    String universalCreditOption = Props.getConfig("paid-credit-option");
    String amount = Props.getConfig("exact-amount");
    String helpStatusMessage = Props.getConfig("help-message");
    String claimAnswer = Props.getConfig("claim-question");
    private QualifyingPage qualifyingPage;


    public WalesStepDefinition(WorldHelper helper) {
        this.helper = helper;
    }

    @Given("^I am person from wales$")
    public void iAmPersonFromWales() throws Throwable {
        dateOfBirthPage = helper.getBasePage().
               loadNhsCheckerApplication()
               .clickOnStartButton().
                selectCountry(countryName);

    }

    @When("^I put my circumstances in the checker tool$")
    public void iPutMyCircumstancesInTheCheckerTool() throws Throwable {
        
      qualifyingPage =dateOfBirthPage.
                inputYourDateOfBirth(dayValue,monthvalue,yearvalue)
                 .answerPartnerQuestion(option).
                  answerBenefitAndTaxCreditQuestion(option).
                  answerUniversalCreditQuestion(universalCreditOption)
                  .answerClaimQuestion(claimAnswer)
                  .answerTakeHomePayQuestion(amount);

    }

    @Then("^I should get a result whether I will get help or not$")
    public void iShouldGetAResultWhetherIWillGetHelpOrNot() throws Throwable {
        Assert.assertTrue(qualifyingPage.validateClaimStatus(helpStatusMessage));

    }
}
