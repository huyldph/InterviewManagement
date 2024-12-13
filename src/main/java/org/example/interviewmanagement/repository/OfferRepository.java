package org.example.interviewmanagement.repository;

import org.example.interviewmanagement.dto.OfferDto;
import org.example.interviewmanagement.entities.Offer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Integer> {
    @Query("""
            select new org.example.interviewmanagement.dto.OfferDto(
                o.offerId,
                o.status,
                o.notes,
                c.fullName,
                c.email,
                o.createdBy.fullName,
                o.department
            ) from Offer o join o.candidate c
            """)
    Page<OfferDto> getAllOffers(Pageable pageable);
}
