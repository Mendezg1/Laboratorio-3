import java.util.ArrayList;
import java.time.LocalDateTime;
public class Emoticon extends Texto {
    public Emoticon(){
        super();
    }
    public Emoticon(String a,  ArrayList<String> hashtag, String s){
        texto = s;
        autor = a;
        hash = hashtag;
        fecha = LocalDateTime.now();
        tipo = "Emoticon";
    }
}
