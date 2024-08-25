import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;

public class Main {

    WebDriver driver;

    public static void main(String[] args) {
        Main main = new Main();
        main.launchBrowser();
    }

    public void launchBrowser() {
        System.setProperty("webdriver.chrome.driver",
                "/Users/bdstockairm/Downloads/chromedriver-mac-arm64/chromedriver");

        driver = new ChromeDriver();
        driver.get("https://myalice-automation-test.netlify.app/");

        performActionOnLoginPage();
    }

    private void delay(Integer second) {
        try {
            Thread.sleep((long)second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private  void setTextAndPerformAction(Actions actions, String text) {
        actions.click();
        actions.sendKeys(text);
        actions.build().perform();
    }

    private void clickOnButton(Actions actions, WebElement button) {
        actions.moveToElement(button);
        actions.click();
        actions.build().perform();
    }

    private void performActionOnLoginPage() {
        Actions actions = new Actions(driver);
        WebElement loginTitle = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/h2"));

        if (!loginTitle.isDisplayed()) {
            System.out.println("Login page is not displayed.");
        } else {
            System.out.println("User in on Login screen.");

            delay(1);
            actions.moveToElement(driver.findElement(By.id("username")));
            setTextAndPerformAction(actions,"testuser");

            // select and type password
            delay(1);
            actions.moveToElement(driver.findElement(By.id("password")));
            setTextAndPerformAction(actions,"password");

            // select and click Login Button
            delay(2);
            clickOnButton(actions, driver.findElement(By.id("login-btn")));

            performActionsOnSearchPage();
        }
    }

    private void performActionsOnSearchPage() {
        Actions actions = new Actions(driver);
        WebElement searchTextArea = driver.findElement(By.id("manga-search"));
        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/button"));

        if (!searchTextArea.isDisplayed()) {
            System.out.println("User is not in Search Screen");
        } else {
            System.out.println("User in on Search screen.");

            actions.moveToElement(searchTextArea);

            delay(1);
            setTextAndPerformAction(actions, "Naruto");

            delay(1);
            clickOnButton(actions, searchButton);

            delay(1);
            searchTextArea.clear();
            actions.moveToElement(searchTextArea);

            delay(1);
            setTextAndPerformAction(actions, "One Piece");

            delay(1);
            clickOnButton(actions, searchButton);

            delay(1);
            searchTextArea.clear();
            actions.moveToElement(searchTextArea);

            delay(1);
            setTextAndPerformAction(actions, "Seven Deadly Sins");

            delay(1);
            clickOnButton(actions, searchButton);

            delay(1);
            actions.moveToElement(searchTextArea);
            searchTextArea.clear();
            setTextAndPerformAction(actions, " ");

            delay(1);
            clickOnButton(actions, searchButton);

            // check if details button exist or not
            boolean isDetailsButtonPresent = !driver.findElements(By.xpath("//span[contains(text(),'Details')]")).isEmpty();
            if (isDetailsButtonPresent) {
                delay(1);
                WebElement detailsButton = driver.findElement(By.xpath("(//span[contains(text(),'Details')])[1]"));
                clickOnButton(actions, detailsButton);

                delay(2);
                WebElement closeButton = driver.findElement(By.xpath("//button[contains(text(),'Close')]"));
                closeButton.click();
            }
        }
    }
}