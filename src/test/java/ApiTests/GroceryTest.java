package ApiTests;

import Api.GroceryStore;
import Api.Model.Grocery;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroceryTest {

    Grocery grocery;

    Response response;
    GroceryStore groceryStore;

    public GroceryTest(){
        grocery = new Grocery();
        groceryStore = new GroceryStore();
    }

    @Test(priority = 1)
    public void getAllGroceryTest(){

        response = groceryStore.getAllGrocery();

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 2)
    public void getGroceryByNameTest(){

        response = groceryStore.getGroceryByName(grocery.getName());

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 3)
    public void addGroceryTest(){
        response = groceryStore.addGrocery(grocery.getName(), grocery.getPrice(), grocery.getStock());

        Assert.assertEquals(response.getStatusCode(), 201);
    }

    @Test(priority = 4)
    public void getGroceryByIdTest(){
        response = groceryStore.getGroceryById(grocery.getId());

        Assert.assertEquals(response.getStatusCode(), 404);
    }

    @Test(priority = 5)
    public void delGroceryTest(){
        response = groceryStore.delGroceryByName(grocery.getName());

        Assert.assertEquals(response.getStatusCode(), 202);
    }

}
