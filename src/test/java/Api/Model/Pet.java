package Api.Model;

import com.github.javafaker.Faker;
import lombok.Data;

import java.util.ArrayList;

/*ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */

@Data
public class Pet{
    private int id;
    private Category category;
    private String name;
    private ArrayList<String> photoUrls = new ArrayList<String>();
    private ArrayList<Tag> tags;
    private String status;



    public Pet(){

        Faker faker = new Faker();


        Category category1 = new Category();
        Tag tag = new Tag();

        this.category = category1.setupCategory();
        this.tags = tag.setupTag();
        this.name = faker.name().firstName();
        this.id = faker.idNumber().hashCode();
        this.status = "sold";
        this.photoUrls.add("www.enuygun.com");
    }
}






