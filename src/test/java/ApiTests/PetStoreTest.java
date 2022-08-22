package ApiTests;

import Api.PetStore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

@Slf4j
public class PetStoreTest {

    Response response;
    PetStore petStore;
    ObjectMapper mapper;

    public PetStoreTest(){
        petStore = new PetStore();
        mapper = new ObjectMapper();
    }

    @Test(priority = 1)
    @Description("post add pet")
    @Severity(SeverityLevel.CRITICAL)
    public void addPetTest() throws JsonProcessingException {
        response = petStore.addRandomPet();
        log.info("TEST : post add pet");
        // * check adding pet status code
        Assert.assertEquals(200,response.getStatusCode());
    }

    @Test(priority = 2)
    @Description("get find by status available ")
    @Severity(SeverityLevel.CRITICAL)
    public void findByStatusAvailableTest(){
        response = petStore.findByStatus("available");
        log.info("TEST : get find by status available ");
        Assert.assertEquals(200,response.getStatusCode());
    }

    @Test(priority = 3)
    @Description("get find by status pending")
    @Severity(SeverityLevel.CRITICAL)
    public void findByStatusPendingTest(){
        response = petStore.findByStatus("pending");
        log.info("TEST : get find by status pending");
        Assert.assertEquals(200,response.getStatusCode());
    }

    @Test(priority = 4)
    @Description("get find by status sold")
    @Severity(SeverityLevel.CRITICAL)
    public void findByStatusSoldTest(){
        response = petStore.findByStatus("sold");
        log.info("TEST : get find by status sold");
        Assert.assertEquals(200,response.getStatusCode());
    }

    @Test(priority = 5)
    @Description("get find by pet by id")
    @Severity(SeverityLevel.CRITICAL)
    public void findPetByIdTest() {
        response = petStore.findByPetById(petStore.pet.getId());
        log.info("TEST : get find by id");
        Assert.assertEquals(200,response.getStatusCode());
    }

    @Test(priority = 6)
    @Description("delete pet")
    @Severity(SeverityLevel.CRITICAL)
    public void petDeleteTest(){
        response = petStore.delByPetById(petStore.pet.getId());
        log.info("TEST : delete pet by id");
        Assert.assertEquals(200,response.getStatusCode());
    }

    @Test(priority = 7)
    @Description("get unsuccessful find pet by id")
    @Severity(SeverityLevel.CRITICAL)
    public void unsuccessfulFindPetByIdTest() {
        response = petStore.findByPetById(petStore.pet.getId());
        log.info("TEST : unsuccessful find by id");
        Assert.assertEquals(404,response.getStatusCode());
    }

    @Test(priority = 8)
    @Description("delete unsuccessful pet")
    @Severity(SeverityLevel.CRITICAL)
    public void unsuccessfulPetDeleteTest(){
        response = petStore.delByPetById(petStore.pet.getId());
        log.info("TEST : unsuccessful delete by id");
        Assert.assertEquals(404,response.getStatusCode());
    }
}
