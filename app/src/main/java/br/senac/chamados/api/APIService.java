package br.senac.chamados.api;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIService {
    @POST("chamados")
    Call<ResponseBody> salvarMensagem(@Body RequestBody body);
}
