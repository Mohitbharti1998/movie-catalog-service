package io.springapplication.moviecatalogservice.repository;

import io.springapplication.moviecatalogservice.models.MovieCatalog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieCatalogRepositroy extends MongoRepository<MovieCatalog,String> {

}
