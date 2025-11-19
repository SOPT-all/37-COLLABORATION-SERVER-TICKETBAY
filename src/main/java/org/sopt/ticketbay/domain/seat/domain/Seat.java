package org.sopt.ticketbay.domain.seat.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopt.ticketbay.global.model.BaseEntity;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Seat extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private int area;

    private int seatColumn;

    private String seatType;

    private String imageKey;

    private String positionName;

    private Seat (
        int area,
        int seatColumn,
        String seatType,
        String imageKey,
        String positionName
    ) {
        this.area = area;
        this.seatColumn = seatColumn;
        this.seatType = seatType;
        this.imageKey = imageKey;
        this.positionName = positionName;
    }

    public Seat create(
        int area,
        int seatColumn,
        String seatType,
        String imageKey,
        String positionName
    ) {
        return new Seat(area, seatColumn, seatType, imageKey, positionName);
    }
}
