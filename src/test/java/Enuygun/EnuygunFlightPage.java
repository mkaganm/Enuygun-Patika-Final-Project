package Enuygun;

import Enuygun.Models.Parameter;
import MKagan.DriverChrome;
import lombok.Data;
import org.openqa.selenium.By;


@Data
public class EnuygunFlightPage extends Enuygun{

    private By title = By.xpath("//h1[@class=\"flight-landing-h1\"]");
    private By originInput = By.id("OriginInput");  // origin input

    private By destinationInput = By.id("DestinationInput");    // destination input

    private By transitFilter = By.id("transitFilter");   // isDirect checkbox

    private By findButton = By.xpath("//span[contains(text(),'Ucuz bilet bul')]");  // find button

    private By departureDate = By.id("DepartureDate");  //  departure date button

    private By returnDate = By.id("ReturnDate");    // return date button

    private By dayElements = By.xpath("//div/table/tbody/tr/td[@aria-disabled='false']"); // for find day

    private By optionOriginPlace = By.id("react-autowhatever-OriginInput-section-0-item-0");

    private By optionReturnPlace = By.id("react-autowhatever-DestinationInput-section-0-item-0");

    public String sendOrigin(DriverChrome driver, String origin){
        driver.getElement(originInput).click();
        driver.getElement(originInput).sendKeys(origin);
        driver.getElement(optionOriginPlace).click();

        String[] inputText = driver.getElement(originInput).getAttribute("value").split(",");
        return inputText[0];
    }

    public String sendDestination(DriverChrome driver, String destination){
        driver.getElement(destinationInput).click();
        driver.getElement(destinationInput).sendKeys(destination);
        driver.getElement(optionReturnPlace).click();

        String[] inputText = driver.getElement(destinationInput).getAttribute("value").split(",");
        return inputText[0];
    }

    public String checkBoxDirect(DriverChrome driver, Boolean direct){
        if (direct){
            driver.getElement(transitFilter).click();
        }
        return driver.getElement(transitFilter).getAttribute("value");
    }

    public void selectDays(DriverChrome driver, Parameter parameter){

        driver.getElement(departureDate).click();
        driver.getElements(dayElements).get(parameter.getDepartureDay()).click();

        driver.getElement(returnDate).click();
        driver.getElements(dayElements).get(parameter.getReturnDay()).click();
    }

    public void findFlights(DriverChrome driver){
        driver.getElement(findButton).click();
    }




}
