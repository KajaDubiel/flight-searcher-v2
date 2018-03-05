package com.kodilla.modul95flights.connections;

import com.kodilla.modul95flights.requests.FlightRequest;

public interface ConnectionChecker {
    boolean checkConnectionFromDeparture(FlightRequest flightRequest);
    boolean checkConnectionToArrival(FlightRequest flightRequest);
    boolean checkConnectionWithOneChange(FlightRequest flightRequest);
}
