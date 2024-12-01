package experiments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class XpathSelectors {
    WebDriver driver = new ChromeDriver();

    @Test
    public void selectorRadioButtonPage(){
        driver.get("https://demoqa.com/radio-button");
        driver.manage().window().maximize();
        hideBanner();
        hideFooter();

        WebElement btnYes = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        btnYes.click();
        WebElement btnImp =driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
        btnImp.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

    @Test
    public void selectorTextBox(){
        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();
        hideBanner();
        hideFooter();

        WebElement inputFullName = driver.findElement(By.xpath("//input[@placeholder='Full Name']"));
        inputFullName.sendKeys("Monkey");
        WebElement inputEmail = driver.findElement(By.xpath("//form/div[@id='userEmail-wrapper']//input"));
        inputEmail.sendKeys("monkey@gmail.com");
        WebElement inputCurAdd = driver.findElement(By.xpath("//*[text()='Current Address']"));
        System.out.println(inputCurAdd.getTagName());
        WebElement curAdd = driver.findElement(By.xpath("//*[text()='Current Address']/../..//textarea"));
        curAdd.sendKeys("street Monkey 5");
        WebElement perAdd = driver.findElement(By.xpath("//div[@id='permanentAddress-wrapper']//textarea"));
        perAdd.sendKeys("Monkey street 6");
        WebElement btnSubmit = driver.findElement(By.xpath("//button[text()='Submit']"));
        btnSubmit.click();
        WebElement output = driver.findElement(By.xpath("//div[@id='output']"));
        System.out.println(output.getText());




        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
    private void hideBanner(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('#fixedban').style.display='none'");
    }
    private void hideFooter(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('footer').style.display='none'");
    }
}
