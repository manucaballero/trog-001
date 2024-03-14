package org.tfoc;

/**
 * The rental class represents a customer renting a movie.
 */
public class Rental {

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double calculateRentalCost(){

        return movie.calculateRentalCost(daysRented);
    }

    public int obtainRentalFrequentRenderPoints() {

        int frequentRenterPoints = 1;
        frequentRenterPoints += movie.obtainRentalFrequentRenderPoints(daysRented);

        return frequentRenterPoints;
    }
}
