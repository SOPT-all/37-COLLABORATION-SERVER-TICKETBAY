package org.sopt.ticketbay.domain.ticket.service;

import static org.sopt.ticketbay.domain.ticket.domain.exception.TicketErrorCode.TICKET_NOT_FOUND;

import lombok.RequiredArgsConstructor;
import org.sopt.ticketbay.domain.ticket.domain.Ticket;
import org.sopt.ticketbay.domain.ticket.domain.exception.TicketException;
import org.sopt.ticketbay.domain.ticket.repository.TicketRepository;
import org.sopt.ticketbay.domain.ticket.service.dto.response.TicketResult;
import org.sopt.ticketbay.global.s3.S3Service;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final S3Service s3Service;

    public TicketResult getTicketDetail(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
            .orElseThrow(() -> new TicketException(TICKET_NOT_FOUND));
        String imageUrl = s3Service.generatePresignedUrl(ticket.getSeat().getImageKey());

        return TicketResult.of(ticket, imageUrl);
    }

}
