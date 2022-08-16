package Api.Model;

import com.github.javafaker.Faker;
import lombok.Data;

@Data
public class Grocery {

    private String id;
    private String name;
    private String price;
    private String stock;

    public Grocery(){

        Faker faker = new Faker();

        this.id = faker.bothify("#");
        this.name = faker.pokemon().name();
        this.price = faker.bothify("##.##");
        this.stock = faker.bothify("##");
    }
}
