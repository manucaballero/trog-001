package org.tfoc;

public class NewReleaseMovie extends Movie {

    public NewReleaseMovie(String title){

        super(title);
    }

    @Override
    public double calculateRentalCost(int daysRented) {

        return daysRented * 3;
    }

    @Override
    int obtainRentalFrequentRenderPoints(int daysRented){

        return daysRented > 1 ? 1 : 0;
    }

}
