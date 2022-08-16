package Api.Model;

import com.github.javafaker.Faker;
import lombok.Data;

import java.util.ArrayList;

@Data
public class Tag {
    private int id;
    private String name;



    public ArrayList<Tag> setupTag(){

        Faker faker = new Faker();

        ArrayList<Tag> arrayList = new ArrayList<Tag>();
        Tag tag = new Tag();
        tag.setId(faker.idNumber().hashCode());
        tag.setName(faker.name().firstName());

        arrayList.add(tag);
        return arrayList;
    }
}
