package proyecto.multimedia.objetos;

/**
 *
 * @author pscam
 */
public class Disco extends Multimedia{
    private String genero;

    public Disco(String titulo, String autor, double duracion, String genero) {
        super(titulo, autor, duracion);
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "DISCO:\ngenero=" + genero + "\n" + super.toString();
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
