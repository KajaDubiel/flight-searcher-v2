package com.kodilla.modul95flights.information;

import com.kodilla.modul95flights.data.User;

public class MailService implements InfoService {
    public void sendMessage(User user){
        System.out.println("Sending message to : " + user);
    }
}
