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

        return switch (movie.getMovieType()) {
            case REGULAR -> {
                double cost = 2;
                if (daysRented > 2)
                    cost += (daysRented - 2) * 1.5;
                yield cost;
            }
            case NEW_RELEASE -> daysRented * 3;
            case CHILDREN -> {
                double cost = 1.5;
                if (daysRented > 3)
                    cost += (daysRented - 3) * 1.5;
                yield cost;
            }
        };
    }

    public int obtainRentalFrequentRenderPoints() {

        int frequentRenterPoints = 1;
        // add bonus for a two day new release rental
        if ((movie.getMovieType() == MovieType.NEW_RELEASE) && daysRented > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }
}
