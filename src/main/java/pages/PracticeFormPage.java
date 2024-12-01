package pages;

import dto.Student;
import enums.Gender;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PracticeFormPage extends BasePage{
    public PracticeFormPage(WebDriver driver){

        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//input[@id='firstName']")
    WebElement fieldName;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement fieldLastName;
    @FindBy(xpath = "//input[@id='userEmail']")
    WebElement fieldEmail;
    @FindBy(xpath = "//input[@id='userNumber']")
    WebElement fieldMobile;
    @FindBy(xpath = "//div[@id='subjectsContainer']")
    WebElement fieldSubjects;
    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    WebElement chkHobbiesSports;
    @FindBy(xpath = "//label[@for='hobbies-checkbox-2']")
    WebElement chkHobbiesReading;
    @FindBy(xpath = "//label[@for='hobbies-checkbox-3']")
    WebElement chkHobbiesMusic;
    @FindBy(xpath = "//textarea[@id='currentAddress']")
    WebElement fieldAddress;
    @FindBy(xpath = "//div[text()='Select State']")
    WebElement btnState;
    @FindBy(xpath = "//div[text()='Select City']")
    WebElement btnCity;







    public void typePracticeForm(Student student) {
        fieldName.sendKeys(student.getName());
        fieldLastName.sendKeys(student.getLastName());
        fieldEmail.sendKeys(student.getEmail());
        typeGender(student.getGender());
        fieldMobile.sendKeys(student.getMobile());
        fieldAddress.sendKeys(student.getAddress());

    }

    private void typeGender(Gender gender) {
        WebElement btnGender = driver.findElement(By.xpath(gender.getLocator()));
        btnGender.click();
    }
}
