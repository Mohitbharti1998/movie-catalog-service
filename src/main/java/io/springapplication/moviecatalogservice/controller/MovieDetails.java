package io.springapplication.moviecatalogservice.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import io.springapplication.moviecatalogservice.models.MovieCatalog;
import io.springapplication.moviecatalogservice.models.MovieInfo;
import io.springapplication.moviecatalogservice.models.Response;
import io.springapplication.moviecatalogservice.repository.MovieCatalogRepositroy;
import org.bson.types.ObjectId;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
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
            String correlationId = insertOtherDetails();
            insert.setCorrelationId(correlationId);
            movieCatalog = movieCatalogRepositroy.insert(insert);
            response.setStatus("success");
            response.setError(null);
            return response;
        } catch (org.springframework.dao.DuplicateKeyException error) {
            response.setStatus("failure");
            response.setError("Duplicate Code");
            return response;
        }catch (Exception ex){
            response.setStatus("failure" + ex);
            response.setError(null);
            return response;
        }

    }

    public String insertOtherDetails() throws JSONException {
        String url = "http://localhost:8082/movieInfo/insert";
        String movie = restTemplate.postForObject(url,movieInfo,String.class);
        JSONObject jsonObject = new JSONObject(movie);
        return  jsonObject.getJSONObject("data").getString("id");
    }
}
