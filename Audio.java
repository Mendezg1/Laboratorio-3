import java.time.LocalDateTime;
import java.util.ArrayList;
public class Audio extends Multimedia {
    public Audio(String a, ArrayList<String>hashtags, int kbs, String url, int sampler, int bitd){
        autor = a;
        hash = hashtags;
         kb = kbs;
         URL = url;
         tipo = "Audio";
         sr = sampler;
         bd = bitd;
         fecha = LocalDateTime.now();
     }
     public Audio(){
         super();
     }
}
