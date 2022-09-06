package EnuygunTest;

import Enuygun.*;
import Enuygun.Models.Parameter;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class EnuygunFlightTest extends BaseTest{

    Enuygun enuygun;
    EnuygunHomePage homePage;
    EnuygunFlightPage flightPage;
    EnuygunTicketPage ticketPage;
    EnuygunPaymentPage paymentPage;
    Parameter parameter;

    public EnuygunFlightTest(){
        parameter = new Parameter();
    }

    @BeforeClass
    public void setup() {

        enuygun = new Enuygun();
        homePage = new EnuygunHomePage();
        flightPage = new EnuygunFlightPage();
        ticketPage = new EnuygunTicketPage(driverChrome, parameter.getProvider());
        paymentPage = new EnuygunPaymentPage();
    }

    @Test(priority = 1)
    @Step("open page")
    @Story("enuygun flight search")
    @Description("open enuygun home page")
    @Link("https://www.enuygun.com/")
    @Severity(SeverityLevel.CRITICAL)
    public void openEnuygun(){
        driverChrome.open(enuygun.getBaseUrl());
        log.info("TEST : open enuygun home page");
    }

    @Test(priority = 2)
    @Step("open flight page")
    @Story("enuygun flight search")
    @Description("open enuygun flight page")
    @Link("https://www.enuygun.com/ucak-bileti/")
    @Severity(SeverityLevel.CRITICAL)
    public void openFlightPage(){

        driverChrome.getElement(homePage.getFlight()).click();
        String title = driverChrome.getElement(flightPage.getTitle()).getText();
        log.info("TEST : open flight page");

        Assert.assertEquals(title,"Uçak Bileti, Ucuz Uçak Biletleri");
    }

    @Test(priority = 3)
    @Step("select origin place")
    @Story("enuygun flight search")
    @Description("set origin place")
    @Link("https://www.enuygun.com/ucak-bileti/")
    @Severity(SeverityLevel.CRITICAL)
    public void selectOriginPlace(){
        String origin = flightPage.sendOrigin(driverChrome, parameter.getOrigin());
        log.info("TEST : select origin place");

        Assert.assertEquals(origin, parameter.getOrigin());
    }

    @Test(priority = 4)
    @Step("select destination place")
    @Story("enuygun flight search")
    @Description("select destination place")
    @Link("https://www.enuygun.com/ucak-bileti/")
    @Severity(SeverityLevel.CRITICAL)
    public void selectDestinationPlace(){
        String destination = flightPage.sendDestination(driverChrome, parameter.getDestination());
        log.info("TEST : select destination place");

        Assert.assertEquals(destination, parameter.getDestination());
    }

    @Test(priority = 5)
    @Step("select is direct")
    @Story("enuygun flight search")
    @Description("select is direct")
    @Link("https://www.enuygun.com/ucak-bileti/")
    @Severity(SeverityLevel.CRITICAL)
    public void selectIsDirect(){
        String direct = flightPage.checkBoxDirect(driverChrome, parameter.isDirect());

        String direct2 = "false";
        if (parameter.isDirect()){
            direct2 = "true";
        }

        log.info("TEST : is direct checkbox");

        Assert.assertEquals(direct, direct2);
    }

    @Test(priority = 6)
    @Step("select flight days")
    @Story("enuygun flight search")
    @Description("select flight days")
    @Link("https://www.enuygun.com/ucak-bileti/")
    @Severity(SeverityLevel.CRITICAL)
    public void selectDays(){
        flightPage.selectDays(driverChrome, parameter);
        log.info("TEST : select days");
    }

    @Test(priority = 7)
    @Step("find flights")
    @Story("enuygun flight search")
    @Description("find flights")
    @Link("https://www.enuygun.com/ucak-bileti/")
    @Severity(SeverityLevel.CRITICAL)
    public void findFlights(){

        flightPage.findFlights(driverChrome);
        Boolean checkLogo = ticketPage.isDisplayedLogo(driverChrome);
        log.info("TEST : click find button");

        Assert.assertEquals(checkLogo, true);
    }

    @Test(priority = 8)
    @Step("select origin flight")
    @Story("enuygun flight search")
    @Description("select origin flight")
    @Link("https://www.enuygun.com/ucak-bileti/")
    @Severity(SeverityLevel.CRITICAL)
    public void selectOriginFlight() {
        ticketPage.selectOriginFlight(driverChrome);
        log.info("TEST : select origin flight");
    }

    @Test(priority = 9)
    @Step("select return flight")
    @Story("enuygun flight search")
    @Description("select return flight")
    @Link("https://www.enuygun.com/ucak-bileti/")
    @Severity(SeverityLevel.CRITICAL)
    public void selectReturnFlight(){
        ticketPage.selectDestinationFlight(driverChrome);
        log.info("TEST : select return flight");
    }

    @Test(priority = 10)
    @Step("select flights")
    @Story("enuygun flight search")
    @Description("select flights")
    @Link("https://www.enuygun.com/ucak-bileti/")
    @Severity(SeverityLevel.CRITICAL)
    public void selectFlights(){
        ticketPage.selectFlight(driverChrome);
        log.info("TEST : click find button");
    }

    @Test(priority = 11)
    @Step("check final page")
    @Story("enuygun flight search")
    @Description("check final page")
    @Link("https://www.enuygun.com/ucak-bileti/")
    @Severity(SeverityLevel.CRITICAL)
    public void getTitle(){
        String title = paymentPage.returnEmail(driverChrome);
        log.info("TEST : check final page");

        Assert.assertEquals(title, "E-posta adresiniz");
    }

}
