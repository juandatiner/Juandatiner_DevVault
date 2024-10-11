package com.platzi;

public class Cats {

    String id;
    String url;
    String apikey = "live_ANO6vYFza0KzBL9tRWdp4CxmBfW3UXTTAXq7DUu2OoMQZjs8fL9eJQTfRpJ7ORKY";
    String image;

    public String getId() {
        return id;
    }

    public void setId(int id) {
        this.id = String.valueOf(id);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
