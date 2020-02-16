package project.mangaeden.model;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class Manga implements Comparable<Manga> {
    @SerializedName("a")
    private String alias;
    @SerializedName("c")
    private ArrayList<String> categories;
    @SerializedName("h")
    private int hits;
    @SerializedName("i")
    private String ID;
    @SerializedName("im")
    private String image;
    @SerializedName("ld")
    private long lastChapterDate;
    @SerializedName("s")
    private int status;
    @SerializedName("t")
    private String title;

    public Manga(String alias, ArrayList<String> categories, int hits, String ID, String image, long lastChapterDate, int status, String title) {
        this.alias = alias;
        this.categories = categories;
        this.hits = hits;
        this.ID = ID;
        this.image = image;
        this.lastChapterDate = lastChapterDate;
        this.status = status;
        this.title = title;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public ArrayList<String> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<String> categories) {
        this.categories = categories;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getLastChapterDate() {
        return lastChapterDate;
    }

    public void setLastChapterDate(long lastChapterDate) {
        this.lastChapterDate = lastChapterDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public String toString() {
        return "\nManga{" +
                "\nalias='" + alias + '\'' +
                ",\n categories=" + categories +
                ",\n hits=" + hits +
                ",\n ID='" + ID + '\'' +
                ",\n image='" + image + '\'' +
                ",\n lastChapterDate=" + lastChapterDate +
                ",\n status=" + status +
                ",\n title='" + title + '\'' +
                '}';
    }

    @Override
    public int compareTo(@NonNull Manga otherManga) {
        if (lastChapterDate > otherManga.getLastChapterDate())
            return -1;
        else if (otherManga.getLastChapterDate() > lastChapterDate)
            return 1;
        else return 0;

    }
}
