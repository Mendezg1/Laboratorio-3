import java.util.ArrayList;
import java.time.LocalDateTime;
public class Texto extends Post {
    //@params string autor, arraylist de los hashtags, string del texto
    public Texto(String a,  ArrayList<String> hashtag, String s){
        texto = s;
        autor = a;
        hash = hashtag;
        tipo = "Texto";
        fecha = LocalDateTime.now();
    }
    public Texto(){

    }
}
