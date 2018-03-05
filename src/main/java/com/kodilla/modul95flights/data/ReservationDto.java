package com.kodilla.modul95flights.data;

public class ReservationDto {
    private User user;
    private boolean isReserved;

    public ReservationDto(User user, boolean isReserved) {
        this.user = user;
        this.isReserved = isReserved;
    }

    public User getUser() {
        return user;
    }

    public boolean isReserved() {
        return isReserved;
    }


}
