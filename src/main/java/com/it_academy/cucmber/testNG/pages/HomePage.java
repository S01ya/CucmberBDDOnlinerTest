package com.it_academy.cucmber.testNG.pages;

import com.it_academy.cucmber.testNG.driver.DriverManager;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;
public class HomePage extends BasePage {

    private static final String ONLINER_URL = "https://www.onliner.by/";
    private static final String MAIN_NAVIGATION_LINK_XPATH_PATTERN =
            "//*[contains(@class, 'main-navigation__text') and contains(text(), '%s')]";
    //  //*[contains(@class, 'main-navigation__text') and contains(text(), 'Дома и квартиры')]
    private static final String DROPDOWN_SUBMENU_ACTIVE_XPATH = "//li[@class = 'b-main-navigation__item " +
            "b-main-navigation__item_arrow b-main-navigation__item_active']";
    private static final String SUBMENU_SECTION_CITIES = "//li[@class='b-main-navigation__dropdown-advert-item']" +
            "/a[contains(@href,'city')]";        //'city'
    private static final String SUBMENU_SECTION_CARS_PRISE = "//li[@class='b-main-navigation__dropdown-advert-item']/a[contains(@href,'https://ab.onliner.by/?price')]";
    private static final String SUBMENU_SECTION_CARS = "//li[@class='b-main-navigation__dropdown-advert-item']/a[contains(@href,'minsk')]/../../../following-sibling::div";
    private static final String SUBMENU_FLATS_SECTION_CITIES = "//a[contains(@href, 'onliner.by/pk')]/span[contains(text(),'Минск')]/../../..";
private static final String SUBMENU_FLATS_SECTION_ROOMS = "//li[@class = 'b-main-navigation__dropdown-advert-item']/a[contains(@href,'room')]";
    private static final String SUBMENU_SECTION_FLATS_PRISE = "//li[@class = 'b-main-navigation__dropdown-advert-item']/a[contains(@href,'currency=usd')]";
    public void openOnlinerWebsite() {
        DriverManager.getDriver().get(ONLINER_URL);
    }

    public void assertMainNavigationLinkEnabled(String link) {
        waitForElementVisible(By.xpath(format(MAIN_NAVIGATION_LINK_XPATH_PATTERN, link))).isEnabled();
    }

    public HomePage hoverToMainNavigationLink(String link) {
        navigateToElement(By.xpath(format(MAIN_NAVIGATION_LINK_XPATH_PATTERN, link)));
        return new HomePage();
    }

    private List<String> tableItemsGetText(String xpath) {
        List<String> tableItems = waitForElementsVisible(By.xpath(format
                (xpath))).stream()
                .map(el -> el.getText())
                .collect(Collectors.toList());
        System.out.println(tableItems);
        return tableItems;
    }

    public boolean dropdownSubmenuIsActive() {
        return isElementDisplayed(By.xpath(DROPDOWN_SUBMENU_ACTIVE_XPATH));
    }

    public List<String> getTableCities() {
        return tableItemsGetText(SUBMENU_SECTION_CITIES);
    }

    public List<String> getTablePriceInAuto() {
        return tableItemsGetText(SUBMENU_SECTION_CARS_PRISE);
    }
    public List<String> getTableCarsBrand() {
        return tableItemsGetText (SUBMENU_SECTION_CARS);
    }

    public List<String> getTableCityInFlats() {
        return tableItemsGetText(SUBMENU_FLATS_SECTION_CITIES);
    }

    public List<String> getTablePriceInFlats() {
        return tableItemsGetText(SUBMENU_SECTION_FLATS_PRISE);
    }
    public List<String> getTableRoomsCount() {
        return tableItemsGetText(SUBMENU_FLATS_SECTION_ROOMS);
    }
}



