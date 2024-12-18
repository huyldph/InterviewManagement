package org.example.interviewmanagement.service;

import org.example.interviewmanagement.dto.OfferDto;
import org.example.interviewmanagement.entities.Offer;
import org.example.interviewmanagement.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OfferService {
    @Autowired
    private OfferRepository offerRepository;

    public Page<OfferDto> getAllOffers(Pageable pageable) {
        return offerRepository.getAllOffers(pageable);
    }

    public void saveOffer(Offer entity) {
        offerRepository.save(entity);
    }

    public void deleteOffer(Integer offerId) {
        offerRepository.deleteById(offerId);
    }

    public void updateOffer(Offer entity) {
        offerRepository.save(entity);
    }

    public OfferDto findByOfferId(Integer offerId) {
        return offerRepository.findByOfferId(offerId);
    }
}
