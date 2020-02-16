package project.mangaeden.ui.mangalist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import project.mangaeden.R;
import project.mangaeden.model.Manga;


public class MangaAdapter extends RecyclerView.Adapter<MangaAdapter.MangaViewHolder> {

    ArrayList<Manga> mangaList;
    private OnItemClickListener listener;

    public MangaAdapter(ArrayList<Manga> mangaList, OnItemClickListener listener) {
        this.mangaList = mangaList;
        this.listener = listener;
    }

    @Override
    public MangaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_manga, parent, false);
        return new MangaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MangaViewHolder holder, int position) {
        holder.bind(mangaList.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return mangaList.size();
    }


    //Ищем вьюшки элементов
    class MangaViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivMangaImage;
        private TextView tvMangaTitle, tvMangaHits, tvMangaDate;

        //Метод в котором присваиваем id элементов вьюшки им java коду
        public MangaViewHolder(View itemView) {
            super(itemView);
            ivMangaImage = (ImageView) itemView.findViewById(R.id.ivMangaImage);
            tvMangaTitle = (TextView) itemView.findViewById(R.id.tvMangaTitle);
            tvMangaHits = (TextView) itemView.findViewById(R.id.tvMangaHits);
            tvMangaDate = (TextView) itemView.findViewById(R.id.tvMangaDate);
        }

        //Метод показывающий в каком формате будут наши элементы вьюшки
        private void bind(final Manga mangaItem, final OnItemClickListener listener) {

            final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy", Locale.US);

            Glide.with(ivMangaImage.getContext())
                    .load("http://cdn.mangaeden.com/mangasimg/" + (mangaItem.getImage()))
                    .placeholder(R.drawable.no_image)
                    .error(R.drawable.no_image)
                    .into(ivMangaImage);

            //Picasso.with(ivMangaImage.getContext())
             //       .load("http://cdn.mangaeden.com/mangasimg/" + (mangaItem.getImage()))
               //     .placeholder(R.drawable.no_image)
                //    .error(R.drawable.no_image)
                //    .into(ivMangaImage);

            tvMangaTitle.setText(mangaItem.getTitle());
            tvMangaHits.setText("" + mangaItem.getHits());
            tvMangaDate.setText(DATE_FORMAT.format(new Date(1000 * mangaItem.getLastChapterDate())));
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(mangaItem);
                }
            });
        }

    }

    interface OnItemClickListener {
        void onItemClick(Manga manga);
    }
}
