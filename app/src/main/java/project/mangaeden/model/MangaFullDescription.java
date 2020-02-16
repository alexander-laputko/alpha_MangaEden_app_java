package project.mangaeden.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MangaFullDescription {
    private String alias;
    private ArrayList<String> categories;
    private ArrayList<Chapter> chapters;                                           //Здесь тоже массив с разными типами
    private int chapters_len;
    private String description;
    private String author;
    private int hits;
    private String image;
    private int last_chapter_date;
    private int released;
    private String startsWith;
    private int status;
    private String title;
    private ArrayList<String> title_kw;
    private int type;
    private boolean updateKeyworlds;

    public MangaFullDescription(String alias, ArrayList<String> categories, ArrayList<Chapter> chapters, int chapters_len, String description, String author, int hits, String image, int last_chapter_date, int released, String startsWith, int status, String title, ArrayList<String> title_kw, int type, boolean updateKeyworlds) {
        this.alias = alias;
        this.categories = categories;
        this.chapters = chapters;
        this.chapters_len = chapters_len;
        this.description = description;
        this.author = author;
        this.hits = hits;
        this.image = image;
        this.last_chapter_date = last_chapter_date;
        this.released = released;
        this.startsWith = startsWith;
        this.status = status;
        this.title = title;
        this.title_kw = title_kw;
        this.type = type;
        this.updateKeyworlds = updateKeyworlds;
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

    public ArrayList<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(ArrayList<Chapter> chapters) {
        this.chapters = chapters;
    }

    public int getChapters_len() {
        return chapters_len;
    }

    public void setChapters_len(int chapters_len) {
        this.chapters_len = chapters_len;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getLast_chapter_date() {
        return last_chapter_date;
    }

    public void setLast_chapter_date(int last_chapter_date) {
        this.last_chapter_date = last_chapter_date;
    }

    public int getReleased() {
        return released;
    }

    public void setReleased(int released) {
        this.released = released;
    }

    public String getStartsWith() {
        return startsWith;
    }

    public void setStartsWith(String startsWith) {
        this.startsWith = startsWith;
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

    public ArrayList<String> getTitle_kw() {
        return title_kw;
    }

    public void setTitle_kw(ArrayList<String> title_kw) {
        this.title_kw = title_kw;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isUpdateKeyworlds() {
        return updateKeyworlds;
    }

    public void setUpdateKeyworlds(boolean updateKeyworlds) {
        this.updateKeyworlds = updateKeyworlds;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "MangaFullDescription{" +
                "alias='" + alias + '\'' +
                ", categories=" + categories +
                ", chapters=" + chapters +
                ", chapters_len=" + chapters_len +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", hits=" + hits +
                ", image='" + image + '\'' +
                ", last_chapter_date=" + last_chapter_date +
                ", released=" + released +
                ", startsWith='" + startsWith + '\'' +
                ", status=" + status +
                ", title='" + title + '\'' +
                ", title_kw=" + title_kw +
                ", type=" + type +
                ", updateKeyworlds=" + updateKeyworlds +
                '}';
    }

    public String getCategoriesAsString() {
        String result = "";
        if (!categories.isEmpty()) {
            result = categories.get(0);
            for (int i = 1; i < categories.size(); i++) {
                result = result + ", " + categories.get(i);
            }
        }
        return result;
    }
}
