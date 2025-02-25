package org.tfoc;

public class ChildrenMovie extends Movie {

    public ChildrenMovie(String title){

        super(title);
    }

    @Override
    public double calculateRentalCost(int daysRented) {

        double cost = 1.5;
        if (daysRented > 3) cost += (daysRented - 3) * 1.5;
        return cost;
    }
}
