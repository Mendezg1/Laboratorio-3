import java.time.LocalDateTime;
import java.util.ArrayList;
public class Imagen extends Multimedia {
    public Imagen(String a, ArrayList<String>hashtags, int kbs, String url, String formato, int megap){
       autor = a;
       hash = hashtags;
        kb = kbs;
        URL = url;
        tipo = "Imagen";
        tipoimg = formato;
        mp = megap;
        fecha = LocalDateTime.now();
    }
    public Imagen(){
        super();
    }
}
