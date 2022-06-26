package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }

    }


    @Test
    public void loginASuccess() {

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("noa@gmail.com", "Nnoa12345$");
        app.getHelperUser().submitLogin();
        // 6.Assert ( is login success?)   logout present?PRESENT

    }

    @Test
    public void loginNegativeTestsWrongEmail() {

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("noagmail.com", "Nnoa12345$");
        app.getHelperUser().submitLogin();
        // 6.Assert ( is login unsuccessful?)   logout present? NOT

    }


}
