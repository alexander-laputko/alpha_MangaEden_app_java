package project.mangaeden.api;

import project.mangaeden.model.MangaFullDescription;
import project.mangaeden.model.ImageListResponse;
import project.mangaeden.model.MangaListResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface MangaApi {

    @GET("api/list/{lang}/")
    Call<MangaListResponse> getMangaList(@Path("lang") int lang);

    @GET("api/list/{lang}/")
    Call<MangaListResponse> getMangaList(@Path("lang") int lang, @Query("p") int page, @Query("l") int length);

    @GET("api/manga/{mangaId}/")
    Call<MangaFullDescription> getMangaFull(@Path("mangaId") String mangaId);


    @GET("api/chapter/{chapterId}/")
    Call<ImageListResponse> getChapterImageList(@Path("chapterId") String chapterId);
}

