package MKagan;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class DriverFirefox extends Drivers {



    // * default constructor for driver
    public DriverFirefox() {
        //setupDriver();    // for select my driver in bin folder
        WebDriverManager.firefoxdriver().setup(); // for all OS
        this.driver = new FirefoxDriver();

    }

    // * constructor with options
    public DriverFirefox(String[] args){
        //setupDriver();    // for select my driver in bin folder
        WebDriverManager.firefoxdriver().setup(); // for all OS
        this.driver = new FirefoxDriver(optionsFirefox(args));

    }

    // * set options
    public FirefoxOptions optionsFirefox(String[] args){
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments(args);
        return options;
    }

    // * setup driver and driver path
    @Override
    public void setupDriver(){
        System.setProperty("webdriver.gecko.driver", FindPath.driverPath(DriverType.FIREFOX));
    }


}
