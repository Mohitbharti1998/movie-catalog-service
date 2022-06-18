package io.springapplication.moviecatalogservice.repository;

import io.springapplication.moviecatalogservice.models.MovieCatalog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieCatalogRepositroy extends MongoRepository<MovieCatalog,String> {

}
