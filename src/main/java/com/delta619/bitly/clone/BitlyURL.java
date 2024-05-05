package com.delta619.bitly.clone;
import java.util.Random;

public class BitlyURL {
    private String short_url;
//    private String id;
    private String full_url;
//    private String user_id;

    public BitlyURL(){

    }

    public BitlyURL(String full_url){

        final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

            Random random = new Random();
            StringBuilder sb = new StringBuilder(CHARACTERS.length());
            for (int i = 0; i < 5; i++) {
                // Generate a random index within the range of the characters string
                int randomIndex = random.nextInt(CHARACTERS.length());
                // Append the character at the random index to the StringBuilder
                sb.append(CHARACTERS.charAt(randomIndex));
            }
            this.short_url = sb.toString();
    }


    public String getShort_url() {
        return short_url;
    }
}
