package org.sopt.ticketbay.global.response;

public interface ResponseCode {
    int getStatus();
    String getCode();
    String getMessage();
}
