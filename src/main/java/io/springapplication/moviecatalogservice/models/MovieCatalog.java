package io.springapplication.moviecatalogservice.models;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "movieCatalog")
@Data
public class MovieCatalog {


    @Id
    private String movieCode;

    private String name;

    private int year;

    private String duration;

    private String correlationId;

    private MovieInfo otherDetails;

    public void destroyOtherDetails(){
        this.otherDetails = null;
    }


}
