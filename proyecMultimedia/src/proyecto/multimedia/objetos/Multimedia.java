package proyecto.multimedia.objetos;

import java.io.Serializable;
import java.util.Objects;

/**
 * Clase abstracta Multimedia
 *
 * @author pscam
 */
public abstract class Multimedia implements Serializable {

    private String titulo;
    private String autor;
    private double duracion;

    /**
     * Constructor completo de la clase
     *
     * @param titulo del objeto multimedia
     * @param autor de objeto multimedia
     * @param duracion tiempo de reproduccion que dura el objeto.
     */
    public Multimedia(String titulo, String autor, double duracion) {
        this.titulo = titulo.toLowerCase();
        this.autor = autor.toLowerCase();
        this.duracion = duracion;
    }

    /**
     * Metodo sobreescrito que muestra informacion del objeto.
     *
     * @return Imprime una cadena de texto con toda la informacion.
     */
    @Override
    public String toString() {
        return "titulo=" + titulo + "\nautor=" + autor + "\nduracion=" + duracion;
    }

    /**
     * Metodo que compara un los atributos titulo y autos con un objeto pasado
     * por parametro
     *
     * @param obj obtjeto que pasamos para comparar.
     * @return true si los objetos son iguales, de lo contrario false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Multimedia other = (Multimedia) obj;
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.autor, other.autor)) {
            return false;
        }
        return true;
    }

//    public boolean equals(Multimedia obj) {
//        if (this == obj) {
//            return (obj.autor.equals(this.autor) && obj.titulo.equals(this.titulo));
//        }
//        return false;
//    }
    /**
     *
     * @return
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     *
     * @param titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     *
     * @return
     */
    public String getAutor() {
        return autor;
    }

    /**
     *
     * @param autor
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     *
     * @return
     */
    public double getDuracion() {
        return duracion;
    }

    /**
     *
     * @param duracion
     */
    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }
}
