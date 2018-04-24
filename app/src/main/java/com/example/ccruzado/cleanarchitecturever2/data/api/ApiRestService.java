package com.example.ccruzado.cleanarchitecturever2.data.api;

import com.example.ccruzado.cleanarchitecturever2.data.model.MultipleResourceData;
import com.example.ccruzado.cleanarchitecturever2.data.model.Post;
import com.example.ccruzado.cleanarchitecturever2.domain.model.MultipleResourceDomain;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by ccruzado on 14/03/2018.
 */

public interface ApiRestService {

/*    @GET("rest/v2/region/Americas/{id}")
    Observable<Usuario> UsuarioInfo(@Path("id") int id);

    @GET("rest/v2/region/Americas")
    Observable<List<Usuario>> ListaUsuario();*/

    @GET("/api/unknown")
    Observable<MultipleResourceData> listMultiple();

    @POST("/posts")
    Observable<Post> postPost(Post post);

}
