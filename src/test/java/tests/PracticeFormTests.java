package tests;

import manager.AppManager;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;

public class PracticeFormTests extends AppManager {

    @Test
    public void studentRegFormPositiveTest(){
      new HomePage(getDriver()).clickBtnForms();
      new FormsPage(getDriver()).clickBtnPracticeForm();
    }
}
