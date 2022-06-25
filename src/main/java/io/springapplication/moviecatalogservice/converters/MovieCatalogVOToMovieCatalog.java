package io.springapplication.moviecatalogservice.converters;


import io.springapplication.moviecatalogservice.models.MovieCatalog;
import io.springapplication.moviecatalogservice.vo.MovieCatalogVO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MovieCatalogVOToMovieCatalog implements Converter<MovieCatalogVO, MovieCatalog> {

    @Override
    public MovieCatalog convert(MovieCatalogVO source) {
        return MovieCatalog.of(source.getMovieCode(), source.getName(), source.getYear(), source.getDuration(), null, null, null);
    }
}
