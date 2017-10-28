package co.test.fearapp;

import android.graphics.drawable.Drawable;

public class ImageClass {
    String topic;
    Drawable image;

    public ImageClass(Drawable newPicture, String newTopic){
        topic = newTopic;
        image = newPicture;
    }

    //Get the topic of a particular image
    public String getTopic(){
        return topic;
    }
    //Set the topic of a particular image
    public void setTopic(String newTopic){
        topic = newTopic;
    }

    //Get the image itself
    public Drawable getImage(){
        return image;
    }
    //Set what image the picture is
    public void setImage(Drawable newPicture){
        image = newPicture;
    }
}
