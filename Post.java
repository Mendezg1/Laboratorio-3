import java.time.LocalDateTime;
import java.util.ArrayList;
public class Post {

    protected String autor;
    protected LocalDateTime fecha;
    protected int likes = 0;
    protected String tipo;
    protected ArrayList<String> comentarios = new ArrayList<String>();
    protected ArrayList<String> hash = new ArrayList<String>();
    protected String texto;
    protected int kb;//kilobytes
    protected String URL;
    protected String tipoimg;
    protected int mp;//mega pixeles
    protected double sr;// sample rate
    protected int bd;// bit depth
    protected int fr;//frame rate

    protected String getAutor(){
        return autor;
    }

    protected LocalDateTime getFecha(){
        return fecha;
    }
    protected ArrayList<String> getHash(){
        return hash;
    }

    protected int getLikes(){
        return likes;
    }

    protected String getTexto(){
        return texto;
    }

    protected String getTipo(){
        return tipo;
    }

    protected ArrayList<String> getComentarios(){
        return comentarios;
    }
    //Se agregó el parámetro n para ubicar si se refiere a un audio, video o imagen.
    protected String[] getDetalles(int n){
        String[] a = new String[4];
        a[0] = kb+"";
        a[1] = URL;
        if(n == 1){
            a[2] = mp+"";
            a[3] = tipoimg;
        }
        else if (n == 2){
            a[2] = sr+"";
            a[3] = bd+"";
        }
        else if(n==3){
            a[2] = fr+"";
        }
        return a;
    }

    protected void Like(){
        likes++;
    }

    protected void comentarios(String s){
        comentarios.add(s);
    }

}
