package org.sopt.ticketbay.domain.history.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.Instant;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopt.ticketbay.domain.event.domain.Event;
import org.sopt.ticketbay.domain.user.domain.User;
import org.sopt.ticketbay.global.model.BaseEntity;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class History extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Event event;

    private Instant lastViewedAt;

    private History(User user, Event event, Instant lastViewedAt) {
        this.user = user;
        this.event = event;
        this.lastViewedAt = lastViewedAt;
    }

    public static History create(User user, Event event, Instant lastViewedAt) {
        return new History(user, event, lastViewedAt);
    }

}
