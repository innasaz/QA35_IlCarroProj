package models;


import lombok.*;

import java.util.Random;

@Setter
@Getter
@ToString
@Builder
//@AllArgsConstructor
//@NoArgsConstructor
public class Car {
    private String location;
    private String make;
    private String model;
    private String year;
    private String engine;
    private String fuel;
    private String gear;
    private String wD;
    private String doors;
    private String seats;
    private String clasS;
    private String fuelConsumption ;
    private String carRegistrationNumber ;
    private String price;
    private String distanceIncluded ;
    private String features;
    private String about;

    public String getCarRegistrationNumber() {
        Random random = new Random();
        int i = random.nextInt(1000)+100;
        return "11-"+i+"-"+i;
    }
}
