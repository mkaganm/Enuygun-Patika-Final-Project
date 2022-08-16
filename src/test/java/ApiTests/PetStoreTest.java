package ApiTests;

import Api.PetStore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PetStoreTest {

    Response response;
    PetStore petStore;

    ObjectMapper mapper;

    public PetStoreTest(){
        petStore = new PetStore();
        mapper = new ObjectMapper();
    }

    @Test(priority = 1)
    public void addPetTest() throws JsonProcessingException {
        response = petStore.addRandomPet();
        // * check adding pet status code
        Assert.assertEquals(200,response.getStatusCode());
    }

    @Test(priority = 2)
    public void findByStatusAvailableTest(){
        response = petStore.findByStatus("available");

        Assert.assertEquals(200,response.getStatusCode());
    }

    @Test(priority = 3)
    public void findByStatusPendingTest(){
        response = petStore.findByStatus("pending");

        Assert.assertEquals(200,response.getStatusCode());
    }

    @Test(priority = 4)
    public void
    findByStatusSoldTest(){
        response = petStore.findByStatus("sold");

        Assert.assertEquals(200,response.getStatusCode());
    }

    @Test(priority = 5)
    public void findPetByIdTest() {
        response = petStore.findByPetById(petStore.pet.getId());

        Assert.assertEquals(200,response.getStatusCode());
    }

    @Test(priority = 6)
    public void petDeleteTest(){
        response = petStore.delByPetById(petStore.pet.getId());

        Assert.assertEquals(200,response.getStatusCode());
    }

    @Test(priority = 7)
    public void unsuccesfullFindPetByIdTest() {
        response = petStore.findByPetById(petStore.pet.getId());

        Assert.assertEquals(404,response.getStatusCode());
    }

    @Test(priority = 8)
    public void unsuccesfullPetDeleteTest(){
        response = petStore.delByPetById(petStore.pet.getId());

        Assert.assertEquals(404,response.getStatusCode());
    }

}
