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

    //@returns autor del post
    protected String getAutor(){
        return autor;
    }

    //@returns fecha de publicación del post
    protected LocalDateTime getFecha(){
        return fecha;
    }

    //@returns hashtags del post
    protected ArrayList<String> getHash(){
        return hash;
    }

    //@returns likes del post
    protected int getLikes(){
        return likes;
    }

    //@returns texto del post
    protected String getTexto(){
        return texto;
    }

    //@returns tipo del post
    protected String getTipo(){
        return tipo;
    }

    //@returns los comentarios del post
    protected ArrayList<String> getComentarios(){
        return comentarios;
    }


    //Se agregó el parámetro n para ubicar si se refiere a un audio, video o imagen.
    //@params int n para identificar el tipo de multimedia
    //@returns los detalles según el tipo de multimedia
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

    //@params el comentario a ingresar en el post.
    protected void comentarios(String s){
        comentarios.add(s);
    }

}
