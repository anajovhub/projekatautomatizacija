package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    //U ovom ispod delu deklarisem driver, wdwait,homePage,homePageUrl,elementsPage,sideBarPage,radioButtonPage,
    // js, linksPage,webTables,buttonsPage

    public static WebDriver driver;
    public WebDriverWait wdwait;

    public ExcelReader excelReader;
    public HomePage homePage;
    public String homePageUrl;
    public ElementsPage elementsPage;
    public SideBarPage sideBarPage;
    public CheckBoxPage checkBoxPage;
    public RadioButtonPage radioButtonPage;
    public JavascriptExecutor js;
    public LinksPage linksPage;
    public  WebTables webTables;
    public ButtonsPage buttonsPage;

    //Before se izvrsava pre svakog testa i unutar te metode ubacujem sta ocekujem da se uradi pre svakog test
    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //!!!!!!
        excelReader = new ExcelReader("C:\\Users\\jovan\\OneDrive\\Radna površina\\selenium projekat\\jole.xlsx");
        homePage = new HomePage();
        homePageUrl = excelReader.getStringData("textBox",1,4);
        elementsPage= new ElementsPage();
        sideBarPage = new SideBarPage();
        checkBoxPage = new CheckBoxPage();
        radioButtonPage = new RadioButtonPage();
        js = (JavascriptExecutor) driver;
        linksPage = new LinksPage(driver,wdwait);
        webTables = new WebTables(driver,wdwait);
        buttonsPage = new ButtonsPage();
    }

    public void vissibilityWait(WebElement element){
        wdwait.until(ExpectedConditions.visibilityOf(element));
    }

    public void scrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    @AfterClass
    public void tearDown(){
        //driver.quit();
        //driver.close();
    }
}