package com.platzi;

import com.google.gson.Gson;
import okhttp3.Request;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class CatsService {

    public static void seeCats() throws IOException {

        //get api dates
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.thecatapi.com/v1/images/search").get().build();
        Response response = client.newCall(request).execute();


        // remove [] of the consult
        assert response.body() != null;
        String JSON = response.body().string();
        JSON = JSON.substring(1);
        JSON = JSON.substring(0, JSON.length() -1);

        // object Gson class
        Gson gson = new Gson();
        Cats cats = gson.fromJson(JSON , Cats.class);

        // resize if is necessary
        Image image = null;
        try{
            URL url = new URL(cats.getUrl());
            image = ImageIO.read(url);

            ImageIcon catBackground = new ImageIcon(image);

            if (catBackground.getIconWidth() > 800){

                //resize
                Image background = catBackground.getImage();
                Image modify = background.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
                catBackground = new ImageIcon(modify);
            }

            String menu = "Options: \n"
                    +" 1. See another image \n"
                    +" 2. Favorite \n"
                    +" 3. Return \n";

            String[] bottoms ={ "See another image", "Favorite", "Return"};
            String id_cat = cats.getId();
            String option = (String) JOptionPane.showInputDialog(null,
                    menu, id_cat, JOptionPane.INFORMATION_MESSAGE, catBackground, bottoms, bottoms[0]);

            int selection = -1;

            for (int i = 0; i < bottoms.length; i++) {

                if (option.equals(bottoms[i])){

                    selection = i;
                }
            }

            switch (selection){
                case 0:
                    seeCats();
                    break;
                case 1:
                    favoriteCats(cats);
                    break;
                default:
                    break;
            }

        }catch (IOException e){
            System.out.println(e);
        }
    }

    public static void favoriteCats(Cats cats){

        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\r\n    \"image_id\":\""+ cats.getId()+"\"\r\n}");
            Request request = new Request.Builder()
                    .url("https://api.thecatapi.com/v1/favourites")
                    .method("POST", body)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("x-api-key", cats.getApikey())
                    .build();
            Response response = client.newCall(request).execute();

        }catch (IOException e){
            System.out.println(e);
        }

    }

    public static void seeFavourites(String apikey) throws IOException {

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.thecatapi.com/v1/favourites")
                .addHeader("Content-Type", "application/json")
                .addHeader("x-api-key", apikey)
                .build();
        Response response = client.newCall(request).execute();

        // remove [] of the consult
        assert response.body() != null;
        String JSON = response.body().string();

        // object Gson class
        Gson gson = new Gson();

        CatFavourite[] catsArray = gson.fromJson(JSON, CatFavourite[].class);

        if (catsArray.length > 0){
            int min = 1;
            int max = catsArray.length;
            int random = (int) (Math.random() * ((max-min)+1)) + min;
            int index = random - 1;

            CatFavourite catFavourite= catsArray[index];

            // resize if is necessary
            Image image = null;
            try{
                URL url = new URL(catFavourite.image.getUrl());
                image = ImageIO.read(url);

                ImageIcon catBackground = new ImageIcon(image);

                if (catBackground.getIconWidth() > 800){

                    //resize
                    Image background = catBackground.getImage();
                    Image modify = background.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
                    catBackground = new ImageIcon(modify);
                }

                String menu = "Options: \n"
                        +" 1. See another image \n"
                        +" 2. Remove Favorite \n"
                        +" 3. Return \n";

                String[] bottoms ={ "See another image", "Remove Favorite", "Return"};
                String id_cat = catFavourite.getId();
                String option = (String) JOptionPane.showInputDialog(null,
                        menu, id_cat, JOptionPane.INFORMATION_MESSAGE, catBackground, bottoms, bottoms[0]);

                int selection = -1;

                for (int i = 0; i < bottoms.length; i++) {

                    if (option.equals(bottoms[i])){

                        selection = i;
                    }
                }

                switch (selection){
                    case 0:
                        seeFavourites(apikey);
                        break;
                    case 1:
                        removeFavourites(catFavourite);
                        break;
                    default:
                        break;
                }

            }catch (IOException e){
                System.out.println(e);
            }
        }

    }

    private static void removeFavourites(CatFavourite catFavourite) {

        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://api.thecatapi.com/v1/favourites/"+catFavourite.getId()+"")
                    .delete(null)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("x-api-key", catFavourite.getApikey())
                    .build();
            Response response = client.newCall(request).execute();

        }catch (IOException e){
            System.out.println(e);
        }

    }
}
