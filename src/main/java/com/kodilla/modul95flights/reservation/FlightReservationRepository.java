package com.kodilla.modul95flights.reservation;

import com.kodilla.modul95flights.requests.FlightRequest;

public class FlightReservationRepository implements ReservationRepository {
    public boolean createReservation(FlightRequest flightRequest){
        System.out.println("Creating reservation repository for: " + flightRequest.getUser() + " for flight from: " + flightRequest.getDeparture() + " to: " + flightRequest.getArrival());
        return true;
    }
}
