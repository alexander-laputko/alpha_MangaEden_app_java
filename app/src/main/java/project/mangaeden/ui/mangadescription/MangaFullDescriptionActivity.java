package project.mangaeden.ui.mangadescription;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import project.mangaeden.MangaEdenApp;
import project.mangaeden.R;
import project.mangaeden.model.Chapter;
import project.mangaeden.model.Manga;
import project.mangaeden.model.MangaFullDescription;
import project.mangaeden.ui.chapterimages.ImagesListActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MangaFullDescriptionActivity extends AppCompatActivity {

    public static final String MANGA_ID = "MangaID";
    public static final String MANGA_TITTLE = "MangaTittle";

    private ChapterAdapter adapter;
    private RecyclerView recyclerView;
    private ImageView ivCoverManga;
    private TextView tvReleased;
    private TextView tvAuthor;
    private TextView tvHits;
    private TextView tvCategories;
    private TextView tvDescription;
    private ProgressBar progressBar;
    private LinearLayout contentPanel;

    private String mangaID;


    public static Intent newIntent(Context context, String mangaID, String mangaTittle) {
        Intent intent = new Intent(context, MangaFullDescriptionActivity.class);
        intent.putExtra(MANGA_ID, mangaID);
        intent.putExtra(MANGA_TITTLE, mangaTittle);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manga_full_description);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String tittle = getIntent().getExtras().getString(MANGA_TITTLE);
        getSupportActionBar().setTitle(tittle);

        ivCoverManga = (ImageView) findViewById(R.id.ivCoverManga);
        tvReleased = (TextView) findViewById(R.id.tvReleased);
        tvAuthor = (TextView) findViewById(R.id.tvAuthor);
        tvHits = (TextView) findViewById(R.id.tvHits);
        tvCategories = (TextView) findViewById(R.id.tvCategories);
        tvDescription = (TextView) findViewById(R.id.tvDescription);
        progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        contentPanel = (LinearLayout) findViewById(R.id.contentPanel);


        adapter = new ChapterAdapter(new ArrayList<Chapter>(), new ChapterAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(Chapter chapter) {
                startActivity(ImagesListActivity.newIntent(MangaFullDescriptionActivity.this, chapter.getID(), chapter.getTitle()));
            }
        });


        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewChapterList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


        ViewCompat.setNestedScrollingEnabled(recyclerView, false);

        mangaID = getIntent().getExtras().getString(MANGA_ID);

        MangaEdenApp.getMangaApi().getMangaFull(mangaID).enqueue(new Callback<MangaFullDescription>() {
            @Override
            public void onResponse(Call<MangaFullDescription> call, Response<MangaFullDescription> response) {
                MangaFullDescription description = response.body();

                Glide.with(ivCoverManga.getContext())
                        .load("http://cdn.mangaeden.com/mangasimg/" + (description.getImage()))
                        .placeholder(R.drawable.no_image)
                        .error(R.drawable.no_image)
                        .into(ivCoverManga);

                //Picasso.with(ivCoverManga.getContext())
                        //.load("http://cdn.mangaeden.com/mangasimg/" + (description.getImage()))
                        //.placeholder(R.drawable.no_image)
                        //.error(R.drawable.no_image)
                        //.into(ivCoverManga);

                tvReleased.setText("" + description.getReleased());
                tvAuthor.setText(description.getAuthor());
                tvHits.setText("" + description.getHits());
                tvCategories.setText(description.getCategoriesAsString());
                tvDescription.setText(Html.fromHtml(description.getDescription()));


                adapter.chapterList.clear();
                adapter.chapterList.addAll(description.getChapters());
                adapter.notifyDataSetChanged();
                contentPanel.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<MangaFullDescription> call, Throwable t) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
