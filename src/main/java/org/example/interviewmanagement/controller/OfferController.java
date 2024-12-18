package org.example.interviewmanagement.controller;

import org.example.interviewmanagement.dto.request.OfferRequest;
import org.example.interviewmanagement.entities.Offer;
import org.example.interviewmanagement.service.CandidateService;
import org.example.interviewmanagement.service.InterviewService;
import org.example.interviewmanagement.service.OfferService;
import org.example.interviewmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OfferController {
    @Autowired
    private OfferService offerService;

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private InterviewService interviewService;

    @Autowired
    private UserService userService;

    @GetMapping("/offers")
    public ResponseEntity<?> getOffers(@RequestParam(name = "page", defaultValue = "0") Integer page) {
        Pageable pageable = PageRequest.of(page, 10);

        try {
            return ResponseEntity.ok(offerService.getAllOffers(pageable));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error fetching offers: " + e.getMessage());
        }
    }

    @GetMapping("/offers/{id}")
    public ResponseEntity<?> getOfferById(@PathVariable("id") Integer offerId) {
        try {
            return ResponseEntity.ok(offerService.findByOfferId(offerId));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error fetching offer: " + e.getMessage());
        }
    }

    @DeleteMapping("/offers/{id}")
    public ResponseEntity<?> deleteOffer(@PathVariable("id") Integer offerId) {
        try {
            offerService.deleteOffer(offerId);
            return ResponseEntity.ok("Offer deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error deleting offer: " + e.getMessage());
        }
    }

    @PostMapping("/offers")
    public ResponseEntity<?> saveOffer(@RequestBody OfferRequest request) {
        try {
            Offer offer = new Offer();
            offer.setStatus(request.getStatus());
            offer.setNotes(request.getNotes());
            offer.setDepartment(request.getDepartment());
            offer.setPosition(request.getPosition());
            offer.setContractType(request.getContractType());
            offer.setLevel(request.getLevel());
            offer.setContractPeriodStart(request.getContractPeriodStart());
            offer.setContractPeriodEnd(request.getContractPeriodEnd());
            offer.setDueDate(request.getDueDate());
            offer.setBaseSalary(request.getBaseSalary());
            offer.setCreatedBy(userService.findByUserId(request.getUserId()));
            offer.setCandidate(candidateService.findById(request.getCandidateId()));
            offer.setInterview(interviewService.findById(request.getInterviewId()));

            offerService.saveOffer(offer);
            return ResponseEntity.ok("Offer saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error saving offer: " + e.getMessage());
        }
    }

    @PutMapping("/offers/{id}")
    public ResponseEntity<?> updateOffer(@PathVariable("id") Integer offerId, @RequestBody OfferRequest request) {
        try {
            Offer offer = new Offer();
            offer.setOfferId(offerId);
            offer.setStatus(request.getStatus());
            offer.setNotes(request.getNotes());
            offer.setDepartment(request.getDepartment());
            offer.setPosition(request.getPosition());
            offer.setContractType(request.getContractType());
            offer.setLevel(request.getLevel());
            offer.setContractPeriodStart(request.getContractPeriodStart());
            offer.setContractPeriodEnd(request.getContractPeriodEnd());
            offer.setDueDate(request.getDueDate());
            offer.setBaseSalary(request.getBaseSalary());
            offer.setCreatedBy(userService.findByUserId(request.getUserId()));
            offer.setCandidate(candidateService.findById(request.getCandidateId()));
            offer.setInterview(interviewService.findById(request.getInterviewId()));

            offerService.updateOffer(offer);
            return ResponseEntity.ok("Offer updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error updating offer: " + e.getMessage());
        }
    }
}
