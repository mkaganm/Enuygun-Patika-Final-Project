package Enuygun;

import MKagan.DriverChrome;
import lombok.Data;
import org.openqa.selenium.By;

@Data
public class EnuygunTicketPage extends Enuygun{

    String provider;


    private By logo = By.xpath("//*[@class=\"navbar-logo\"]");

    private By selectButton = By.xpath("//button[@class=\"action-select-btn active btn btn-outline-success btn-sm\"]");
    //private By selectButton = By.xpath("//button[@id=\"tooltipTarget_0\"]");
    //private By selectButton = By.cssSelector("[class='action-select-btn active btn btn-outline-success btn-sm']");

    public EnuygunTicketPage(DriverChrome driverChrome, String pr){
        this.provider = pr;
    }

    public boolean isDisplayedLogo(DriverChrome driverChrome){
        return driverChrome.getElement(logo).isDisplayed();
    }

    public void selectOriginFlight(DriverChrome driverChrome) {
        By originFlight = By.xpath("//div[@data-booking-provider='" + provider + "']");

        driverChrome.driver.findElements(originFlight).get(0).click();
    }

    public void selectDestinationFlight(DriverChrome driverChrome){
        By returnFlight = By.cssSelector("[class='roundTrip return active'] [data-booking-provider='"+provider+"']");
        driverChrome.driver.findElements(returnFlight).get(0).click();
    }

    public void selectFlight(DriverChrome driverChrome){
        driverChrome.getElements(selectButton).get(0).click();
    }


}
