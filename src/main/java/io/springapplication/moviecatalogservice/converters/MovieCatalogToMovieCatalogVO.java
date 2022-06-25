package io.springapplication.moviecatalogservice.converters;

import io.springapplication.moviecatalogservice.models.MovieCatalog;
import io.springapplication.moviecatalogservice.vo.MovieCatalogVO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class MovieCatalogToMovieCatalogVO implements Converter<MovieCatalog, MovieCatalogVO> {


    @Override
    public MovieCatalogVO convert(MovieCatalog source) {
        return MovieCatalogVO.of(source.getMovieCode(),source.getName(),source.getYear(),source.getDuration(),source.getCorrelationId(),source.getCreatedDate(),source.getUpdatedDate());
    }
}
