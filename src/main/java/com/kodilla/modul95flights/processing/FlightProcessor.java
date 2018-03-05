package com.kodilla.modul95flights.processing;

import com.kodilla.modul95flights.connections.ConnectionChecker;
import com.kodilla.modul95flights.data.ReservationDto;
import com.kodilla.modul95flights.requests.FlightRequest;
import com.kodilla.modul95flights.reservation.ReservationRepository;
import com.kodilla.modul95flights.reservation.ReservationService;
import com.kodilla.modul95flights.information.InfoService;

public class FlightProcessor {
    private InfoService infoService;
    private ReservationService reservationService;
    private ReservationRepository reservationRepository;
    private ConnectionChecker connectionChecker;

    public FlightProcessor(InfoService infoService, ReservationService reservationService, ReservationRepository reservationRepository, ConnectionChecker connectionChecker) {
        this.infoService = infoService;
        this.reservationService = reservationService;
        this.reservationRepository = reservationRepository;
        this.connectionChecker = connectionChecker;
    }

    public ReservationDto process(FlightRequest flightRequest){
        boolean isReserved = connectionChecker.checkConnectionFromDeparture(flightRequest);
        if(isReserved){
            infoService.sendMessage(flightRequest.getUser());
            reservationRepository.createReservation(flightRequest);
            return new ReservationDto(flightRequest.getUser(), true);
        } else {
            return new ReservationDto(flightRequest.getUser(), false);
        }
    }
}
