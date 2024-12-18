package org.example.interviewmanagement.repository;

import org.example.interviewmanagement.dto.OfferDto;
import org.example.interviewmanagement.entities.Offer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Integer> {
    @Query("""
            select new org.example.interviewmanagement.dto.OfferDto(
                o.offerId,
                o.status,
                o.notes,
                o.department,
                c.candidateId,
                o.position,
                u.userId,
                i.interviewId,
                o.contractType,
                o.level,
                o.contractPeriodStart,
                o.contractPeriodEnd,
                o.dueDate,
                o.baseSalary,
                c.fullName,
                c.email,
                u.fullName
            ) from Offer o join o.candidate c join o.interview i join  o.createdBy u
            """)
    Page<OfferDto> getAllOffers(Pageable pageable);

    @Query("""
            select new org.example.interviewmanagement.dto.OfferDto(
                o.offerId,
                o.status,
                o.notes,
                o.department,
                c.candidateId,
                o.position,
                u.userId,
                i.interviewId,
                o.contractType,
                o.level,
                o.contractPeriodStart,
                o.contractPeriodEnd,
                o.dueDate,
                o.baseSalary,
                c.fullName,
                c.email,
                u.fullName
            ) from Offer o join o.candidate c join o.interview i join  o.createdBy u
            where o.offerId = :offerId
            """)
    OfferDto findByOfferId(@Param("offerId") Integer offerId);
}
