package stepDefinations;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import java.util.List;
import java.util.Map;
import pageObjects.allPagesObject;

public class favourites_steps {
    allPagesObject allPages;

    @Given("^User is on Adds homepage$")
    public void user_is_on_Adds_homepage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        allPages = new allPagesObject();
        allPages.homePage.verifyHomePage();
    }

    @When("^I click on \"([^\"]*)\" link under \"([^\"]*)\"$")
    public void i_click_on_link_under(String Category, String Section) throws Throwable {
        allPages = new allPagesObject();
        allPages.homePage.navigateToCategory(Section,Category);
    }

    @When("^I click on \"([^\"]*)\" link$")
    public void i_click_on_link(String Subcategory) throws Throwable {
        allPages = new allPagesObject();
        allPages.homePage.clickOnSubcategory(Subcategory);
    }


    @Then("^I click on \"([^\"]*)\" from result page$")
    public void i_click_on_from_result_page(String add) throws Throwable {
        allPages = new allPagesObject();
        allPages.resultPage.clickOnAdvertisement(add);
    }


    @When("I click on \"([^\"]*)\" link under \"([^\"]*)\" section$")
    public void iClickOnLinkUnderSection(String Category, String Section) {
         allPages = new allPagesObject();
        allPages.homePage.navigateToCategory(Section,Category);
    }

    @Then("am navigated to \"([^\"]*)\" details page$")
    public void amNavigatedToDetailsPage(String add) {
        allPages = new allPagesObject();
        allPages.addPage.verifyAdd(add);
    }

    @And("I click on Add to Memo")
    public void iClickOnAddToMemo() {
        allPages = new allPagesObject();
        allPages.addPage.addToFavourites();
    }

    @Then("I navigate to Adds result page")
    public void iNavigateToAddsResultPage() {
        allPages = new allPagesObject();
        allPages.resultPage.verifyResultPage();
    }

    @And("I select first \"([^\"]*)\" advertisements in result page$")
    public void iSelectFirstAdvertisementsInResultPage(String count) {
        allPages = new allPagesObject();
        allPages.resultPage.selectRandomAds(Integer.parseInt(count));
    }

    @And("I click on Add selected to Memo")
    public void iClickOnAddSelectedToMemo() {
        allPages = new allPagesObject();
        allPages.resultPage.addSelectedToMemo();
    }

    @And("I go to Memo and verify advertisements count as \"([^\"]*)\"$")
    public void iGoToMemoAndVerifyAdvertisementsCountAs(String count) {
        allPages = new allPagesObject();
        allPages.memoPage.navigateToMemo();
        allPages.memoPage.verifyAddsCount(Integer.parseInt(count));
    }

    @Then("I go to Memo and verify \"([^\"]*)\"$")
    public void iGoToMemoAndVerify(String add) {
        allPages = new allPagesObject();
        allPages.memoPage.navigateToMemo();
        allPages.memoPage.verifyAdd(add);
    }

    @Then("I remove an Add and from Memo and verify the adds count")
    public void iRemoveAnAddAndFromMemoAndVerifyTheAddsCount() {
        allPages = new allPagesObject();
        allPages.memoPage.removeAddFromMemo();
    }
}
