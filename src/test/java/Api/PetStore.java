package Api;

import Api.Model.Pet;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PetStore {

    Response response;
    ObjectMapper mapper;
    public Pet pet;


    public PetStore(){
        mapper = new ObjectMapper();
        pet  = new Pet();
    }

    // * this method adding pet to api service
    public Response addRandomPet() throws JsonProcessingException {

        String jsonStr = mapper.writeValueAsString(pet);    // * converting to json

        baseURI = "https://petstore.swagger.io/v2";
        response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(jsonStr)
                .when()
                .post("/pet");

        return response;
    }

    public Response findByStatus(String status){

        baseURI = "https://petstore.swagger.io/v2";
        response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .params("status",status)
                .when()
                .get("/pet/findByStatus");

        return response;
    }

    // * this method find pet by id
    public Response findByPetById(int petId){

        String pi = String.valueOf(petId);

        baseURI = "https://petstore.swagger.io/v2";
        response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .get("/pet/" + pi);

        return response;
    }

    // * this method delete pet by id
    public Response delByPetById(int petId){

        String pi = String.valueOf(petId);

        baseURI = "https://petstore.swagger.io/v2";
        response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .header("api_key","aliqua velit fugiat tempor adipisicing")
                .delete("/pet/" + pi);

        return response;
    }




}
