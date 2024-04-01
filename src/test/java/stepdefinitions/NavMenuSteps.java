package stepdefinitions;

import components.NavMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.When;

public class NavMenuSteps {

    private final NavMenu navMenu = new NavMenu();

    @When("I click on the menu item \"([^\"]*)\"$")
    public void clickOnMenuItem(String menuItem) {
        navMenu.clickNavMenuItem(menuItem);
    }
}
