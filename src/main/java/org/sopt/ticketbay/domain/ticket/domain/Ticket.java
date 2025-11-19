package org.sopt.ticketbay.domain.ticket.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopt.ticketbay.domain.event.domain.Event;
import org.sopt.ticketbay.domain.seat.domain.Seat;
import org.sopt.ticketbay.global.model.BaseEntity;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Ticket extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Event event;

    @ManyToOne(fetch = FetchType.LAZY)
    private Seat seat;

    @Column(nullable = false)
    private long productNumber;

    @Column(nullable = false)
    private boolean status;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int amount;

    private Ticket(
        Event event,
        Seat seat,
        long productNumber,
        boolean status,
        int price,
        int amount
    ) {
        this.event = event;
        this.seat = seat;
        this.productNumber = productNumber;
        this.status = status;
        this.price = price;
        this.amount = amount;
    }

    public Ticket create(
        Event event,
        Seat seat,
        long productNumber,
        boolean status,
        int price,
        int amount
    ) {
        return new Ticket(event, seat, productNumber, status, price, amount);
    }

}
