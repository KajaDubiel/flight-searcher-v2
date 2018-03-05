package com.kodilla.modul95flights;

import com.kodilla.modul95flights.connections.FlightConnectionsChecker;
import com.kodilla.modul95flights.information.MailService;
import com.kodilla.modul95flights.processing.FlightProcessor;
import com.kodilla.modul95flights.requests.FlightRequest;
import com.kodilla.modul95flights.requests.FlightRequestRetriever;
import com.kodilla.modul95flights.reservation.FlightReservationRepository;
import com.kodilla.modul95flights.reservation.FlightReservationService;

public class MainApp {
    public static void main(String[] args) {
        FlightRequestRetriever flightRequestRetriever = new FlightRequestRetriever();
        FlightRequest flightRequest = flightRequestRetriever.retrieve();

        FlightProcessor flightProcessor = new FlightProcessor(new MailService(), new FlightReservationService(), new FlightReservationRepository(), new FlightConnectionsChecker());
        flightProcessor.process(flightRequest);
    }
}
