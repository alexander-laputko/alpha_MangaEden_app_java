package project.mangaeden.ui.chapterimages.zoom;

import android.content.Context;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.github.chrisbanes.photoview.PhotoView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import project.mangaeden.R;
import project.mangaeden.model.Image;

public class ZoomPagerAdapter extends PagerAdapter {

    ArrayList<Image> images;

    public ZoomPagerAdapter(ArrayList<Image> images) {
        this.images = images;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (ViewGroup) object;
    }

    //метод которые преобразует наш xml layout в объект класса view
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) container.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.item_pager_zoom, container, false);

        PhotoView photoView = (PhotoView) itemView.findViewById(R.id.photoView);

        /*Picasso.with(photoView.getContext())
                .load("http://cdn.mangaeden.com/mangasimg/" + images.get(position).getUrl())
                .error(R.drawable.no_image)
                .into(photoView);*/

        Glide.with(itemView.getContext())
                .load("http://cdn.mangaeden.com/mangasimg/" + images.get(position).getUrl())
                .error(R.mipmap.ic_launcher)
                //.placeholder(R.drawable.no_image)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(photoView);

        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
