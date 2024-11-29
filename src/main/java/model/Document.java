package model;

public class Document {
    private int id;
    private String name;
    private int year;
    private String category;

    public Document(){}

    public Document(int id, String name, int year, String category) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
