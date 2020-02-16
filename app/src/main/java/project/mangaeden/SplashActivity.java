package project.mangaeden;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import project.mangaeden.ui.mangalist.MangaListActivity;


public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, MangaListActivity.class);
        startActivity(intent);
        finish();
    }
}
