package proyecto.multimedia.objetos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pscam
 */
public class Pelicula extends Multimedia {

     private String actorPpal;

    public Pelicula(String titulo, String autor, double duracion, String actorPpal) {
        super(titulo, autor, duracion);
        this.actorPpal = actorPpal;
    }

    @Override
    public String toString() {
        return "PELICULA:\nactorPpal=" + actorPpal + "\n" + super.toString();
    }

    public String getActorPpal() {
        return actorPpal;
    }

    public void setActorPpal(String actorPpal) {
        this.actorPpal = actorPpal;
    }
}
