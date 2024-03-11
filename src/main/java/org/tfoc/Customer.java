package org.tfoc;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private List<Rental> rentals;

    public Customer(String name) {
        this.name = name;
        this.rentals = new ArrayList<>();
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = appendCustomerHeader();

        for (Rental rental : rentals) {

            double thisAmount = calculateRentalCost(rental);

            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if ((rental.getMovie().getMovieType() == MovieType.NEW_RELEASE) && rental.getDaysRented() > 1)
                frequentRenterPoints++;

            result += appendRentalCostInfo(rental, thisAmount);
            totalAmount += thisAmount;
        }

        result += appendFooterLines(totalAmount, frequentRenterPoints);

        return result;
    }

    private String appendRentalCostInfo(Rental rental, double thisAmount) {
        return "\t" + rental.getMovie().getTitle() + "\t" + thisAmount + "\n";
    }

    private String appendCustomerHeader() {
        return "Rental Record for " + getName() + "\n";
    }

    private double calculateRentalCost(Rental rental) {

        int daysRented = rental.getDaysRented();
        return switch (rental.getMovie().getMovieType()) {
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

    private String appendFooterLines(double totalAmount, int frequentRenterPoints) {

        return appendAmountOwed(totalAmount) + appendFrequentRenterPoints(frequentRenterPoints);
    }

    private String appendFrequentRenterPoints(int frequentRenterPoints) {

        return "You earned " + frequentRenterPoints + " frequent renter points";
    }

    private String appendAmountOwed(double totalAmount) {

        return "Amount owed is " + totalAmount + "\n";
    }

}
