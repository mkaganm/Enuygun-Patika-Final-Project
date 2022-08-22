package Enuygun;

import MKagan.DriverChrome;
import lombok.Data;
import org.openqa.selenium.By;

@Data
public class EnuygunPaymentPage extends Enuygun{

    private By emailTitle = By.xpath("//label[@for=\"contact_email\"]");

    public String returnEmail(DriverChrome driverChrome){
        return driverChrome.getElement(emailTitle).getText();
    }
}
