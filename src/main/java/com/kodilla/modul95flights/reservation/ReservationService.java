package com.kodilla.modul95flights.reservation;

import com.kodilla.modul95flights.requests.FlightRequest;

public interface ReservationService {
    boolean createReservation(FlightRequest flightRequest);
}
