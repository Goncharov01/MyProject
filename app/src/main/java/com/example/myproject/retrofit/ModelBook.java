package com.example.myproject.retrofit;

public class ModelBook {

    int id;

    String title;

    String author;

    String description;

    int published;

    public ModelBook(int id, String title, String author, String description, int published) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.published = published;
    }

    public ModelBook(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public ModelBook(String title, String author, String description) {
        this.title = title;
        this.author = author;
        this.description = description;
    }

    public ModelBook(String title, String author, String description, int published) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.published = published;
    }

    public ModelBook() {
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPublished() {
        return published;
    }

    public void setPublished(int published) {
        this.published = published;
    }


    @Override
    public String toString() {
        return "ModelBook{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", published=" + published +
                '}';
    }
}
