package io.springapplication.moviecatalogservice.controller;

import io.springapplication.moviecatalogservice.models.MovieCatalog;
import io.springapplication.moviecatalogservice.models.MovieInfo;
import io.springapplication.moviecatalogservice.models.Response;
import io.springapplication.moviecatalogservice.repository.MovieCatalogRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


    @RestController
    @RequestMapping("/movieCatalog")
    public class MovieCatalogController {

        @Autowired
        private RestTemplate restTemplate;

        @Autowired
        private WebClient.Builder webClientBuilder;

        @Autowired
        private MovieCatalogRepositroy movieCatalogRepositroy;

        @Autowired
        private Response response;





    }


           /*
            Movie movie = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8082/movies/"+rating.getMovieId())
                    .retrieve()
                    .bodyToMono(Movie.class)
                    .block();
           */


