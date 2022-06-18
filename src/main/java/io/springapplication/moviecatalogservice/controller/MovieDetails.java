package io.springapplication.moviecatalogservice.controller;

import io.springapplication.moviecatalogservice.models.MovieCatalog;
import io.springapplication.moviecatalogservice.models.MovieInfo;
import io.springapplication.moviecatalogservice.models.Response;
import io.springapplication.moviecatalogservice.repository.MovieCatalogRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movieDetails")
public class MovieDetails {

    @Autowired
    private MovieCatalogRepositroy movieCatalogRepositroy;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Response response;

    @Autowired
    private MovieInfo movieInfo;

    private MovieCatalog movieCatalog;

    @RequestMapping("/insertMovieDetails")
    public Response insertUserRating(@RequestBody MovieCatalog insert) {
        movieInfo = insert.getOtherDetails();
        insert.destroyOtherDetails();
        try {
            Long correlationId = insertOtherDetails();
            movieCatalog = movieCatalogRepositroy.insert(insert);
            response.setStatus("success");
            response.setError(null);
            return response;
        } catch (org.springframework.dao.DuplicateKeyException error) {
            response.setStatus("failure");
            response.setError("Duplicate Code");
            response.setData(insert);
            return response;
        }catch (Exception ex){
            response.setStatus("failure");
            response.setError(null);
            return response;
        }

    }

    public Long insertOtherDetails(){
        String url = "localhost:8082/movieInfo/insert";
        ResponseEntity<MovieInfo> movieInfoResponseEntity = restTemplate.postForEntity(url,movieInfo,MovieInfo.class);
        return movieInfoResponseEntity.getBody().getMovieId();

    }
}
