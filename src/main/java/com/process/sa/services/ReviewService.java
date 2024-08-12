package com.process.sa.services;

import com.process.sa.entites.Client;
import com.process.sa.entites.Review;
import com.process.sa.enums.TypeSentiment;
import com.process.sa.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private ClientService clientService;
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository, ClientService clientService) {
        this.reviewRepository = reviewRepository;
        this.clientService = clientService;
    }

    // on crée un review
    public void creer(Review review) {
        Client client = this.clientService.lireOuCreer(review.getClient());
        review.setClient(client);

        // Analyse
        if (review.getDescription().contains("pas")){
            review.setType(TypeSentiment.NEGATIF);
        } else {
            review.setType(TypeSentiment.POSITIF);
        }

        this.reviewRepository.save(review);
    }

    public List<Review> rechercher() {
        return this.reviewRepository.findAll();
    }

    public void supprimer(int id) {
        this.reviewRepository.deleteById(id);
    }
}
