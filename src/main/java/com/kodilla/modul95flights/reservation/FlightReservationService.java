package com.kodilla.modul95flights.reservation;

import com.kodilla.modul95flights.requests.FlightRequest;

public class FlightReservationService implements ReservationService {
    public boolean createReservation(FlightRequest flightRequest){
        System.out.println("Creating reservation for: " + flightRequest.getUser() + " for flight from: " + flightRequest.getDeparture() + " to: " + flightRequest.getArrival());
        return true;
    }
}
