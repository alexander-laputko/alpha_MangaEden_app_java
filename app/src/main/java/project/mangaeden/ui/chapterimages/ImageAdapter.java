package project.mangaeden.ui.chapterimages;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

import project.mangaeden.R;
import project.mangaeden.model.Image;


public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {
    ArrayList<Image> imageList;
    private OnItemClickListener listener;

    public ImageAdapter(ArrayList<Image> imageList, OnItemClickListener listener) {
        this.imageList = imageList;
        this.listener = listener;
    }

    public ImageAdapter(OnItemClickListener listener) {
        this.imageList = new ArrayList<Image>();
        this.listener = listener;
    }

    @Override
    public ImageAdapter.ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_image, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        holder.bind(imageList.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    class ImageViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivPage;

        public ImageViewHolder(View itemView) {
            super(itemView);
            ivPage = (ImageView) itemView.findViewById(R.id.ivPage);
        }

        private void bind(final Image imageItem, final OnItemClickListener listener) {
            Glide.with(itemView.getContext())
                    .load("http://cdn.mangaeden.com/mangasimg/" + imageItem.getUrl())
                    .error(R.drawable.no_image)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(ivPage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(imageItem, getAdapterPosition());
                }
            });
        }
    }

    interface OnItemClickListener {
        void onItemClick(Image image, int position);
    }
}
