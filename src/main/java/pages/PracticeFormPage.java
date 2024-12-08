package pages;

import dto.Student;
import enums.Gender;
import enums.Hobbies;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class PracticeFormPage extends BasePage {
    public PracticeFormPage(WebDriver driver) {

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
    @FindBy(xpath = "//input[@id='dateOfBirthInput']")
    WebElement fieldDateOfBirth;
    @FindBy(xpath = "//input[@id='subjectsInput']")
    WebElement fieldSubjects;
    @FindBy(xpath = "//textarea[@id='currentAddress']")
    WebElement fieldAddress;
    @FindBy(xpath = "//input[@id='react-select-3-input']")
    WebElement inputState;
    @FindBy(id="react-select-4-input")
    WebElement inputCity;
    @FindBy(xpath = "//button[@id='submit']")
    WebElement btnSubmit;
    @FindBy(xpath = "//div[text()='Thanks for submitting the form']")
    WebElement modalMessage;


    public void typePracticeForm(Student student) {
        hideBanner();
        hideFooter();
        fieldName.sendKeys(student.getName());
        fieldLastName.sendKeys(student.getLastName());
        fieldEmail.sendKeys(student.getEmail());
        typeGender(student.getGender());
        fieldMobile.sendKeys(student.getMobile());
        typeDateOfBirth(student.getDateOfBirth());
        typeSubjects(student.getSubjects());
        typeHobbies(student.getHobbies());
        fieldAddress.sendKeys(student.getAddress());
        typeStateCity(student.getState(),student.getCity());
        btnSubmit.click();
    }

    public boolean validateModalMessage(){
        return validateTextElement(modalMessage,"Thanks for submitting the form");
    }

    private void typeStateCity(String state, String city) {
        inputState.sendKeys(state);
        inputState.sendKeys(Keys.ENTER);

        inputCity.sendKeys(city);
        inputCity.sendKeys(Keys.ENTER);

    }

    private void typeHobbies(List<Hobbies> hobbies) {
        for (Hobbies h: hobbies){
            switch (h){
                case MUSIC:
                    driver.findElement(By.xpath(h.getLocator())).click();
                    break;
                case SPORTS:
                    driver.findElement(By.xpath(h.getLocator())).click();
                    break;
                case READING:
                    driver.findElement(By.xpath(h.getLocator())).click();
                    break;
            }
        }
    }

    private void typeSubjects(String subjects) {
        fieldSubjects.click();
        String []  arr= subjects.split(",");
        for(String s: arr){
            fieldSubjects.sendKeys(s);
            fieldSubjects.sendKeys(Keys.ENTER);
        }

    }

    private void typeDateOfBirth(String dateOfBirth) {
        fieldDateOfBirth.click();
        String operationSystem = System.getProperty("os.name");
        System.out.println(operationSystem);
        if (operationSystem.startsWith("Win"))
            fieldDateOfBirth.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        else if (operationSystem.startsWith("Mac"))
            fieldDateOfBirth.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        fieldDateOfBirth.sendKeys(dateOfBirth);
        fieldDateOfBirth.sendKeys(Keys.ENTER);

    }

    private void typeGender(Gender gender) {
        WebElement btnGender = driver.findElement(By.xpath(gender.getLocator()));
        btnGender.click();
    }
}
