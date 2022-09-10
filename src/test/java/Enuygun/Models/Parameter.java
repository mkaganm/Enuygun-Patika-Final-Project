package Enuygun.Models;

import lombok.Data;


@Data
public class Parameter {
    private String origin;
    private String destination;
    private int departureDay;
    private int returnDay;
    private String provider;
    private boolean isDirect;

    public Parameter(){
        this.origin = "İstanbul";
        this.destination = "Amsterdam";
        this.departureDay = 5;
        this.returnDay = 5;
        this.provider = "galileo-sabre";
        this.isDirect = true;
    }

}
