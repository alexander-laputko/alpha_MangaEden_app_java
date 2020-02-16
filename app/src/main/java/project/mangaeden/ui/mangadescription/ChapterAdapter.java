package project.mangaeden.ui.mangadescription;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import project.mangaeden.R;
import project.mangaeden.model.Chapter;
import project.mangaeden.model.Manga;

public class ChapterAdapter extends RecyclerView.Adapter<ChapterAdapter.ChapterViewHolder> {

    ArrayList<Chapter> chapterList;
    private OnItemClickListener listener;

    public ChapterAdapter(ArrayList<Chapter> chapterList, OnItemClickListener listener) {
        this.chapterList = chapterList;
        this.listener = listener;
    }

    @Override
    public ChapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_chapter, parent, false);
        return new ChapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ChapterViewHolder holder, int position) {
        holder.bind(chapterList.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return chapterList.size();
    }


    class ChapterViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNumber;
        private TextView tvTitle;
        private TextView tvDate;

        public ChapterViewHolder(View itemView) {
            super(itemView);
            tvNumber = (TextView) itemView.findViewById(R.id.tvNumberChapter);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitleChapter);
            tvDate = (TextView) itemView.findViewById(R.id.tvDateChapter);
        }

        private void bind(final Chapter chapterItem, final OnItemClickListener listener) {

            final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy", Locale.US);

            tvNumber.setText("№" + chapterItem.getNumber());
            tvTitle.setText(chapterItem.getTitle());
            tvDate.setText(DATE_FORMAT.format(new Date(1000 * chapterItem.getDate())));
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(chapterItem);
                }
            });
        }
    }

    interface OnItemClickListener {
        void onItemClick(Chapter chapter);
    }
}
