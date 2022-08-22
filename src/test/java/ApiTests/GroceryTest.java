package ApiTests;

import Api.GroceryStore;
import Api.Model.Grocery;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

@Slf4j
public class GroceryTest {

    Grocery grocery;

    Response response;
    GroceryStore groceryStore;

    public GroceryTest(){
        grocery = new Grocery();
        groceryStore = new GroceryStore();
    }

    @Test(priority = 1)
    @Description("get all grocery")
    @Severity(SeverityLevel.CRITICAL)
    public void getAllGroceryTest(){

        response = groceryStore.getAllGrocery();
        log.info("TEST : get all grocery");

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 2)
    @Description("get grocery by name")
    @Severity(SeverityLevel.CRITICAL)
    public void getGroceryByNameTest(){

        response = groceryStore.getGroceryByName(grocery.getName());
        log.info("TEST : get grocery by name");

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 3)
    @Description("post add grocery")
    @Severity(SeverityLevel.CRITICAL)
    public void addGroceryTest(){
        response = groceryStore.addGrocery(grocery.getName(), grocery.getPrice(), grocery.getStock());
        log.info("TEST : post add grocery");

        Assert.assertEquals(response.getStatusCode(), 201);
    }

    @Test(priority = 4)
    @Description("get grocery by id")
    @Severity(SeverityLevel.CRITICAL)
    public void getGroceryByIdTest(){
        response = groceryStore.getGroceryById(grocery.getId());
        log.info("TEST : get grocery by id");

        Assert.assertEquals(response.getStatusCode(), 404);
    }

    @Test(priority = 5)
    @Description("delete grocery by name")
    @Severity(SeverityLevel.CRITICAL)
    public void delGroceryTest(){
        response = groceryStore.delGroceryByName(grocery.getName());
        log.info("TEST : delete grocery by name");

        Assert.assertEquals(response.getStatusCode(), 202);
    }

}
