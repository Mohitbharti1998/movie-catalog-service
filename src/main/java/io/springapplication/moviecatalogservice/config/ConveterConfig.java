package io.springapplication.moviecatalogservice.config;

import io.springapplication.moviecatalogservice.converters.MovieCatalogToMovieCatalogVO;
import io.springapplication.moviecatalogservice.converters.MovieCatalogVOToMovieCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class ConveterConfig {

    @Autowired
    private MovieCatalogVOToMovieCatalog movieCatalogVOToMovieCatalog;

    @Autowired
    private MovieCatalogToMovieCatalogVO movieCatalogToMovieCatalogVO;

    @Bean("movieCatalogConversionService")
    public ConversionService conversionService(){
        ConversionServiceFactoryBean conversionServiceFactoryBean = new ConversionServiceFactoryBean();
        conversionServiceFactoryBean.setConverters(getConveters());
        conversionServiceFactoryBean.afterPropertiesSet();
        return conversionServiceFactoryBean.getObject();
    }



    private Set<Converter<?,?>> getConveters(){
        Set<Converter<?,?>> converters = new HashSet<>();
        converters.add(movieCatalogVOToMovieCatalog);
        converters.add(movieCatalogToMovieCatalogVO);
        return converters;
    }
}
