package io.springapplication.moviecatalogservice.utils;


import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class AppUtils {

    public String generateUniqueId(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
