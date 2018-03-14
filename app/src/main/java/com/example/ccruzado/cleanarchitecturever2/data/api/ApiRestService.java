package com.example.ccruzado.cleanarchitecturever2.data.api;

import com.example.ccruzado.cleanarchitecturever2.data.model.MultipleResource;
import com.example.ccruzado.cleanarchitecturever2.data.model.Post;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by ccruzado on 14/03/2018.
 */

public interface ApiRestService {

/*    @GET("rest/v2/region/Americas/{id}")
    Observable<Usuario> UsuarioInfo(@Path("id") int id);

    @GET("rest/v2/region/Americas")
    Observable<List<Usuario>> ListaUsuario();*/

    @GET("/api/unknown")
    Observable<MultipleResource> listMultiple();

    @POST("/posts")
    Observable<Post> postPost(Post post);

}
