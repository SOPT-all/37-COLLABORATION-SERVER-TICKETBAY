package org.sopt.ticketbay.domain.event.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.Instant;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopt.ticketbay.domain.event.domain.enums.MainCategory;
import org.sopt.ticketbay.global.model.BaseEntity;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Event extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(length = 50)
    private String detailName;

    private Instant eventDate;

    @Enumerated(EnumType.STRING)
    private MainCategory mainCategory;

    @Column(length = 50)
    private String subCategory;

    @Column(length = 50)
    private String place;

    private long viewCount = 0;

    private Event(
        String name,
        String detailName,
        Instant eventDate,
        MainCategory mainCategory,
        String subCategory,
        String place,
        long viewCount)
    {
        this.name = name;
        this.detailName = detailName;
        this.eventDate = eventDate;
        this.mainCategory = mainCategory;
        this.subCategory = subCategory;
        this.place = place;
        this.viewCount = viewCount;
    }

    public static Event create(
        String name,
        String detailName,
        Instant eventDate,
        MainCategory mainCategory,
        String subCategory,
        String place,
        long viewCount)
    {
        return new Event(name, detailName, eventDate, mainCategory, subCategory, place, viewCount);
    }
}
