package Test;

import Base.BaseTest;
import Pages.ButtonsPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ElementsTest extends BaseTest {
   // Before se izvrsava pre svakog testa i unutar te metode ubacujem sta ocekujem da se uradi pre svakog test
    @BeforeMethod
    public void setUpPage(){
        driver.manage().window().maximize();
        driver.navigate().to(homePageUrl);
    }

    @Test
    public void textBoxHappyFlow() throws InterruptedException {
        String FullName= excelReader.getStringData("textBox",1,0);
        String Email = excelReader.getStringData("textBox",1,1);
        String CurrentAddress = excelReader.getStringData("textBox",1,2);
        String PermanentAddress = excelReader.getStringData("textBox",1,3);

        Thread.sleep(2000);
        scrollIntoView(homePage.elements.get(0));

        homePage.clickOnElements();
        sideBarPage.clickOnTextBox();
        Thread.sleep(2000);
        elementsPage.insertFullName(FullName);
        elementsPage.insertEmail(Email);
        Thread.sleep(2000);
        elementsPage.insertCurrenntAddress(CurrentAddress);
        elementsPage.insertPermanentAddress(PermanentAddress);
        Thread.sleep(2000);
        scrollIntoView(elementsPage.getSubbmitButton());
        elementsPage.clickSubmitButton();
        Assert.assertTrue(elementsPage.getCorrectCredentials().isDisplayed());
        Thread.sleep(3000);

    }

    @Test (priority = 10)//testiranje click dugmeta
    public void Buttons() throws InterruptedException {

        Thread.sleep(2000);
        scrollIntoView(homePage.elements.get(0));
        homePage.clickOnElements();
        Thread.sleep(2000);
        scrollIntoView(sideBarPage.getButtons());
        sideBarPage.clickOnButtons();
        Thread.sleep(2000);
        buttonsPage.clickOnClickMeButton();
        Assert.assertTrue(buttonsPage.getNotification().isDisplayed());

    }

    @Test  (priority = 20)
    public void Links() throws InterruptedException {

        Thread.sleep(2000);
        scrollIntoView(homePage.elements.get(0));
        homePage.clickOnElements();
        Thread.sleep(2000);
        scrollIntoView((sideBarPage.getLinks()));
        sideBarPage.clickOnLinks();
        linksPage.clickOnCreatedLink();
        Assert.assertTrue(linksPage.getCreatedNotification().isDisplayed());

    }


    @Test
    public void RadioButton() throws InterruptedException {
        Thread.sleep(2000);
        scrollIntoView(homePage.elements.get(0));
        homePage.clickOnElements();
        Thread.sleep(2000);
        scrollIntoView((sideBarPage.getRadioButton()));
        Thread.sleep(2000);
        sideBarPage.clickOnRadioButton();
        radioButtonPage.ClickOnYesButton();
        Assert.assertTrue(radioButtonPage.getYesConfirmationMessage().isDisplayed());


    }

}

