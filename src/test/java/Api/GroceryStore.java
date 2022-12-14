package Api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class GroceryStore {

    Response response;

    // * get all grocery product
    public Response getAllGrocery(){

        baseURI = "https://my.api.mockaroo.com";

        response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .header("X-API-Key","c9cd0b40")
                .get("/allGrocery.json");

        return response;
    }

    // * get grocery by name
    public Response getGroceryByName(String name){

        baseURI = "https://my.api.mockaroo.com";

        response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .header("X-API-Key","c9cd0b40")
                .get("/getGrocery/" + name + ".json");

        return response;
    }

    // * this method is adding product
    public Response addGrocery(String name, String price, String stock){

        String url = "/addGrocery.json?name="+ name + "&price=" + price + "&stock=" + stock;

        baseURI = "https://my.api.mockaroo.com";
        response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .header("X-API-Key","c9cd0b40")
                .post(url);

        return response;

    }

    // * this method find product by id ( fake request it returns 404)
    public Response getGroceryById(String id){

        baseURI = "https://my.api.mockaroo.com";

        response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .header("X-API-Key","c9cd0b40")
                .get("/groceryNotFound/" + id + ".json");

        return response;

    }

    // * this method del grocery
    public Response delGroceryByName(String name){

        baseURI = "https://my.api.mockaroo.com";

        response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .header("X-API-Key","c9cd0b40")
                .delete("/delGrocery/" + name + ".json");

        return response;
    }




}
