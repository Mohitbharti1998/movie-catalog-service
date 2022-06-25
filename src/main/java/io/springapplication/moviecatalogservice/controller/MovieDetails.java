package io.springapplication.moviecatalogservice.controller;

import io.springapplication.moviecatalogservice.models.MovieCatalog;
import io.springapplication.moviecatalogservice.service.MovieCatalogService;
import io.springapplication.moviecatalogservice.vo.MovieCatalogVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movieDetails")
public class MovieDetails {

    private final MovieCatalogService movieCatalogService;

    @Autowired
    public MovieDetails(final MovieCatalogService movieCatalogService) {
        this.movieCatalogService = movieCatalogService;
    }

//    @Autowired
//    private MovieCatalogRepositroy movieCatalogRepositroy;
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @Autowired
//    private Response response;
//
//    @Autowired
//    private MovieInfo movieInfo;
//
//    private MovieCatalog movieCatalog;
//
//    public MovieDetails() {
//    }

    @RequestMapping("/insertMovieDetails")
    public MovieCatalogVO insertUserRating(@RequestBody MovieCatalogVO movieCatalog) {

        System.out.println(movieCatalog);

        try{
            return movieCatalogService.insertMovieDetails(movieCatalog);
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

//    public String insertOtherDetails() throws JSONException {
//        String url = "http://localhost:8082/movieInfo/insert";
//        String movie = restTemplate.postForObject(url,movieInfo,String.class);
//        JSONObject jsonObject = new JSONObject(movie);
//        return  jsonObject.getJSONObject("data").getString("id");
//    }
}
