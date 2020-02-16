package project.mangaeden.model;

import java.util.ArrayList;

public class ImageListResponse {
    private ArrayList<Image> images;

    public ImageListResponse(ArrayList<Image> images) {
        this.images = images;
    }

    public ArrayList<Image> getImages() {
        return images;
    }

    public void setImages(ArrayList<Image> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "ImageListResponse{" +
                "images=" + images +
                '}';
    }
}
