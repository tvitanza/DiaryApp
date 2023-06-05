package DiaryAppPackage;

import java.time.LocalDate;

public class Diary {
    private int id;
    private String title;
    private LocalDate begin;
    private boolean isPublic;

    public Diary(int id, String title, LocalDate begin, boolean isPublic) {
        this.id = id;
        this.title = title;
        this.begin = begin;
        this.isPublic = isPublic;
    }

    public Diary(String title, LocalDate begin, boolean isPublic) {
        this.title = title;
        this.begin = begin;
        this.isPublic = isPublic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getBegin() {
        return begin;
    }

    public void setBegin(LocalDate begin) {
        this.begin = begin;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }
}

