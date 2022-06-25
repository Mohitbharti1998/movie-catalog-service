package io.springapplication.moviecatalogservice.service;

import io.springapplication.moviecatalogservice.models.MovieCatalog;
import io.springapplication.moviecatalogservice.vo.MovieCatalogVO;

public interface MovieCatalogService {

    MovieCatalogVO insertMovieDetails(MovieCatalogVO movieCatalogVO) throws Exception;
}
