package com.example.max.testui.networking.dto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by max on 11/10/17.
 */

public interface Api {
    @POST("https://translate.yandex.net/api/v1.5/tr.json/translate?lang=en-ru&key=trnsl.1.1.20171109T130436Z.f05b7b2d2486882d.3f78f5d9e2ded499ba4374b6dc1249948e402ddb&text")
    Call<translateDTO> getTranslate(
            @Query("text") List<String> text,
            @Query("lang") String lang);
}
