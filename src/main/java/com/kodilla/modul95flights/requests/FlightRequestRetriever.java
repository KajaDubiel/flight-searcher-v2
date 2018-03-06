package com.kodilla.modul95flights.requests;

import com.kodilla.modul95flights.data.User;

public class FlightRequestRetriever {
    public FlightRequest retrieve() {
        User user = new User("Katarzyna", "Kowalska", "kasiakowalska@wp.pl");

        String departure = "Katowice";
        String arrival = "Warszawa";

        return new FlightRequest(user, departure, arrival);
    }
}
