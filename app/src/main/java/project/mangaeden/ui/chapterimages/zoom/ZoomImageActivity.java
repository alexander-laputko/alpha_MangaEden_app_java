package project.mangaeden.ui.chapterimages.zoom;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;

import project.mangaeden.R;
import project.mangaeden.model.Image;
import project.mangaeden.ui.chapterimages.ImagesListActivity;

public class ZoomImageActivity extends AppCompatActivity {

    public static final String IMAGES_TAG = "images";
    public static final String IMAGE_POSITION = "position";
    public static final String POSITION_TAG = "position";
    ZoomViewPager pager;



    public static Intent newIntent(Context context, ArrayList<Image> imagesPage, int position){
        Intent intent = new Intent(context, ZoomImageActivity.class);
        intent.putParcelableArrayListExtra(IMAGES_TAG, imagesPage);
        intent.putExtra(IMAGE_POSITION, position);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_zoom_image);

        ArrayList<Image> pageList = getIntent().getExtras().getParcelableArrayList(IMAGES_TAG);
        int position = getIntent().getExtras().getInt(IMAGE_POSITION);

        pager = (ZoomViewPager) findViewById(R.id.pager);
        ZoomPagerAdapter adapter = new ZoomPagerAdapter(pageList);
        pager.setAdapter(adapter);
        pager.setCurrentItem(position);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra(POSITION_TAG, pager.getCurrentItem());
        setResult(RESULT_OK,intent);
        super.onBackPressed();
    }
}
