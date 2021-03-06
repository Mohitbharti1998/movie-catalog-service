package io.springapplication.moviecatalogservice.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "movieCatalog")
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieCatalog {


    @Id
    private String movieCode;

    private String name;

    private int year;

    private String duration;

    private String correlationId;

    private Date createdDate;

    private Date updatedDate;



}
