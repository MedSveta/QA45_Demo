package tests;

import dto.Student;
import enums.Gender;
import manager.AppManager;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;

public class PracticeFormTests extends AppManager {

    @Test
    public void studentRegFormPositiveTest(){
        Student student = new Student("Vasya", "Vasilev", "vasyavasilev@mail.com", Gender.OTHER,
                "0123456789", "07 Mar 2001", "Maths",
                "Music", "", "street 1", "NCR", "Delhi");
      new HomePage(getDriver()).clickBtnForms();
      new FormsPage(getDriver()).clickBtnPracticeForm();
      new PracticeFormPage(getDriver()).typePracticeForm(student);
    }
}
