import java.time.LocalDateTime;
import java.util.ArrayList;
public class Video extends Multimedia {
    //@params string del autor, arraylist de los hashtags, int del tamaño, string del url e int del frame rate
        public Video(String a, ArrayList<String>hashtags, int kbs, String url, int frames){
            autor = a;
            hash = hashtags;
            kb = kbs;
            URL = url;
            fr = frames;
            tipo = "Video";
            fecha = LocalDateTime.now();
        }

        public Video(){
            super();
        }
}

