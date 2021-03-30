package com.apkdoandroid.giftcard.model;

public class Spot {
    private Long id;
    private String nome;
    private String city;
    private String url;

    public Spot() {
    }

    public Spot(Long id, String nome, String city, String url) {
        this.id = id;
        this.nome = nome;
        this.city = city;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
