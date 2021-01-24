package com.example.studiy.classes;

public class Person {
    private String name;
    private String job_type;
    private String rating;
    private String image_uri;
    private boolean favourite;
    private boolean[] subjects;

    public boolean[] getSubjects() {
        return subjects;
    }

    public void setSubjects(boolean[] subjects) {
        this.subjects = subjects;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

    public String getImage_uri() {
        return image_uri;
    }

    public void setImageUri(String image_uri) {
        this.image_uri = image_uri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobType() {
        return job_type;
    }

    public void setJobType(String job_type) {
        this.job_type = job_type;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Person() {
    }
}
