package project.mangaeden.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class MangaListResponse {
    private int end;
    @SerializedName("manga")
    private ArrayList<Manga> mangas;
    private int page;
    private int start;
    private int total;

    public MangaListResponse(int end, ArrayList<Manga> mangas, int page, int start, int total) {
        this.end = end;
        this.mangas = mangas;
        this.page = page;
        this.start = start;
        this.total = total;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public ArrayList<Manga> getMangas() {
        return mangas;
    }

    public void setMangas(ArrayList<Manga> mangas) {
        this.mangas = mangas;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "MangaListResponse{" +
                "end=" + end +
                ", mangas=" + mangas +
                ", page=" + page +
                ", start=" + start +
                ", total=" + total +
                '}';
    }
}
