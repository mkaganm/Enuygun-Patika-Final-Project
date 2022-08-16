package Api.Model;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import lombok.Data;

import java.util.Locale;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
@Data
public class Category {
    private int id;
    private String name;



    public Category setupCategory(){

        Category category = new Category();
        Faker faker = new Faker();

        category.setId(faker.idNumber().hashCode());
        category.setName(faker.name().firstName());

        return category;
    }
}
