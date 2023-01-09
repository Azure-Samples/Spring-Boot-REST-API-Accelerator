package com.example.api.quotes;

public class Quote {
    private Integer id;
    private String quote;
    private String author;
    private boolean k8s = false;

    public boolean isK8s() {
        return k8s;
    }

    public void setK8s(boolean k8s) {
        this.k8s = k8s;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
