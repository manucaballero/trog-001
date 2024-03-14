package org.tfoc;

public abstract class Movie {

    private String title;

    public Movie(String title) {

        this.title = title;
    }

    abstract double calculateRentalCost(int daysRented);

    int obtainRentalFrequentRenderPoints(int daysRented){

        return 0;
    }

    public String getTitle() {
        return title;
    }
}
