package yildiz.pakistanbullusevcet.trakya.com.trakyauniproje.Service;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import yildiz.pakistanbullusevcet.trakya.com.trakyauniproje.Models.Mesaj;
import yildiz.pakistanbullusevcet.trakya.com.trakyauniproje.Models.OgrenciProfil;

/**
 * Created by NFL on 3.4.2017.
 */

public interface RetrofitInterface {

    //Bunu(Call<Boolean>) boolean döndürmemeizin sebebi dönen değer sadece true ya da false geliyor olması
    @POST("login.php")
    Call<Boolean> isGiris(@Query("ogrenci_no") Long ogrenci_no,
                          @Query("sifre") String sifre);

    @GET("ogrenciProfil.php")
    Call<OgrenciProfil> getOgrenciProfil(@Query("ogrenci_id") Long ogrenci_no);

    @FormUrlEncoded
    @POST("getMesajlar.php")
    Call<List<Mesaj>> getMesajlar(@Field("alici_id") int alici_id,
                                  @Field("alici_hoca_mi") boolean alici_hoca_mi,
                                  @Field("gonderen_id") int gonderen_id,
                                  @Field("gonderen_hoca_mi") boolean gonderen_hoca_mi);

    @FormUrlEncoded
    @POST("mesajGonder.php")
    Call<Boolean> mesajGonder (@Field("alici_id") int alici_id,
                                 @Field("alici_hoca_mi") boolean alici_hoca_mi,
                                 @Field("gonderen_id") int gonderen_id,
                                 @Field("gonderen_hoca_mi") boolean gonderen_hoca_mi,
                                 @Field("mesaj_icerik") String mesaj_icerik);
}