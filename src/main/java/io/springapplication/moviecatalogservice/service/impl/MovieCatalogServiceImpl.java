package io.springapplication.moviecatalogservice.service.impl;

import io.springapplication.moviecatalogservice.models.MovieCatalog;
import io.springapplication.moviecatalogservice.repository.MovieCatalogRepositroy;
import io.springapplication.moviecatalogservice.service.MovieCatalogService;
import io.springapplication.moviecatalogservice.utils.AppUtils;
import io.springapplication.moviecatalogservice.vo.MovieCatalogVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MovieCatalogServiceImpl implements MovieCatalogService {

    @Autowired
    @Qualifier("movieCatalogConversionService")
    private ConversionService conversionService;

    @Autowired
    private MovieCatalogRepositroy movieCatalogRepositroy;

    @Override
    public MovieCatalogVO insertMovieDetails(MovieCatalogVO movieCatalogVO) throws Exception {
        if(movieCatalogVO.getMovieCode() != null && checkCodeDuplicate(movieCatalogVO.getMovieCode()))
            throw  new RuntimeException("Code already exists");

        MovieCatalog movieCatalog = conversionService.convert(movieCatalogVO,MovieCatalog.class);

        String correlationId = AppUtils.generateUniqueId();
        movieCatalog.setCorrelationId(correlationId);

        Date date = new Date();

        movieCatalog.setCreatedDate(date);
        movieCatalog.setUpdatedDate(date);

        try{
            movieCatalog = movieCatalogRepositroy.save(movieCatalog);
        }catch (Exception e){
            throw new Exception("Unable to create profile." + e);
        }

        return conversionService.convert(movieCatalog,MovieCatalogVO.class);

    }


    private boolean checkCodeDuplicate(String movieCode){
        try {
            return movieCatalogRepositroy.existsById(movieCode);
        }catch (Exception e)
        {
            //unable to connect to db hence returning true to avoid altering and db addition of profiles.
            return true;
        }
    }


}
