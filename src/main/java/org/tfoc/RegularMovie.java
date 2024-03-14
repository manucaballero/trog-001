package org.tfoc;

public class RegularMovie extends Movie {

    public RegularMovie(String title){

        super(title);
    }

    @Override
    public double calculateRentalCost(int daysRented) {

        double cost = 2;
        if (daysRented > 2) cost += (daysRented - 2) * 1.5;

        return cost;
    }
}
