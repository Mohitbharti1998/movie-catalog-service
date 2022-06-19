package io.springapplication.moviecatalogservice.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "movieCatalog")
public class MovieCatalog {


    @Id
    private String movieCode;

    private String name;

    private int year;

    private String duration;

    private String correlationId;

    private MovieInfo otherDetails;

    public MovieInfo getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(MovieInfo otherDetails) {
        this.otherDetails = otherDetails;
    }

    public void destroyOtherDetails(){
        this.otherDetails = null;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public String getMovieCode() {
        return movieCode;
    }



    public void setMovieCode(String movieCode) {
        this.movieCode = movieCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
