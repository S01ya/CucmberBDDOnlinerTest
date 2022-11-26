package com.cucumber.steps;
import com.it_academy.cucmber.testNG.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;

public class NavigationStepdefs {

    private HomePage homePage = new HomePage();

    @Given("the user opens Onliner website")
    public void the_user_opens_onliner_website() {
        homePage.openOnlinerWebsite();
    }

    @When("the user check that {string} section exist")
    public void theUserCheckThatSectionExist(String section) {
        homePage.assertMainNavigationLinkEnabled(section);
    }
    @When("the  user hover to {string} section")
    public void theUserHoverToSection(String section) {
        homePage.hoverToMainNavigationLink(section);
    }
    @Then("the dropdown submenu  of {string} is appear contains table {string} {string} {string}")
    public void theDropdownSubmenuOfAutoIsAppearContainsTable
            (String section, String tableNameCity, String tableNamePrice, String tableNameCar) {
        SoftAssertions softy = new SoftAssertions();
        softy.assertThat(homePage.dropdownSubmenuIsActive())
                .as("Page title '%s' is not displayed", section)
                .isTrue();
        softy.assertThat(homePage.getTableCities())
                .as("the table of %s from submenu %s is empty", tableNameCity, section)
                .isNotEmpty();
        softy.assertThat(homePage.getTablePriceInAuto())
                .as("the table of %s from submenu %s is empty", tableNamePrice, section)
                .isNotEmpty();
        softy.assertThat(homePage.getTableCarsBrand())
                .as("the table of %s from submenu %s is empty", tableNameCar, section)
                .isNotEmpty();
        softy.assertAll();
    }

    @Then("the dropdown submenu  of {string} is appear and contains table {string} {string} {string}")
    public void theDropdownSubmenuFlatsIsAppearAndContainsTable(String section, String tableNameCity, String roomsCount, String prise) {
        SoftAssertions softy = new SoftAssertions();
        softy.assertThat(homePage.dropdownSubmenuIsActive())
                .as("Page title '%s' is not displayed", section)
                .isTrue();
        softy.assertThat(homePage.getTableCityInFlats())
                .as("the table of %s from submenu %s is empty", tableNameCity, section)
                .isNotEmpty();
        softy.assertThat(homePage.getTableRoomsCount())
                .as("the table of %s from submenu %s is empty", roomsCount, section)
                .isNotEmpty();
        softy.assertThat(homePage.getTablePriceInFlats())
                .as("the table of %s from submenu %s is empty", prise, section)
                .isNotEmpty();
        softy.assertAll();
    }
}
