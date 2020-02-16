package project.mangaeden;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import project.mangaeden.api.MangaApi;
import project.mangaeden.model.Chapter;
import project.mangaeden.model.ChapterDeserializer;
import project.mangaeden.model.Image;
import project.mangaeden.model.ImageDeserializer;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MangaEdenApp extends Application {

    private static MangaApi mangaApi;

    public static MangaApi getMangaApi() {
        return mangaApi;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        configureRetrofit();
    }

    //Настраиваем retrofit
    private void configureRetrofit() {
        //Конвертер для Image
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Image.class, new ImageDeserializer())
                .registerTypeAdapter(Chapter.class, new ChapterDeserializer())
                .create();

        //Логирование
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(logging).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.mangaeden.com/") //Базовая часть адреса
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson)) //Конвертер, необходимый для преобразования JSON'а в объекты
                .build();

        //Создаем объект, при помощи которого будем выполнять запросы
        mangaApi = retrofit.create(MangaApi.class);
    }
}
