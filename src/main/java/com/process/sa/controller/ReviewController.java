package com.process.sa.controller;

import com.process.sa.entites.Review;
import com.process.sa.services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController // pour dire que toutes les requetes qui passeront dans mon controller arriveront ici
@RequestMapping(path = "review", produces = APPLICATION_JSON_VALUE)
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    // creation du review
    // @RequestBody c'est pour dire qu'on veut récupérer le corps de la requete
    // NB: un requetes à 3 parties (l'url(localhost:8080/api/review, l'en-tete(ici c'est du json) et le corps)
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void creer(@RequestBody Review review) {
        this.reviewService.creer(review);
    }

    // rechercher les reviews
    @GetMapping
    public List<Review> rechercher() {
        return this.reviewService.rechercher();
    }

    /*
    * avec l'annotation @Pathvariable spring boot saura que
    * l'id qui figure dans la requete doit etre transmis à la fonction supprimer en paramètre
     */

    // supprimer une review
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "{id}")
    public void supprimer(@PathVariable int id) {
        this.reviewService.supprimer(id);
    }
}
