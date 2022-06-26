package tests;

import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{



    @Test
    public void registrationSuccess(){
       app.getHelperUser().openLoginRegistrationForm();
       app.getHelperUser().fillLoginRegistrationForm("noa003@gmail.com","Nnoa12345$");
       app.getHelperUser().submitRegistration();

    }


}
