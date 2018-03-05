package com.kodilla.modul95flights.reservation;

import com.kodilla.modul95flights.requests.FlightRequest;

public interface ReservationRepository {
    boolean createReservation(FlightRequest flightRequest);
}
