package proyecto.multimedia.ejecutable;

import proyecto.multimedia.menu.OpcionesMenu;
/**
 * clase con metodo Main para ejecutar programa
 * @author pscam
 */
public class AñadeObjetosALaListaMultimedia {

    public static void main(String[] args) {
        OpcionesMenu miMenu = new OpcionesMenu();
        int salir = 0, aux;

        while (salir != 1) {

            miMenu.menu();
            System.out.println("PRESIONE 0 SI DESEA CONTINUAR, CUALQUIER NUMERO PARA SALIR");
            aux = miMenu.pedirDatoEntero();
            if (aux != 0) {
                salir = aux;
            }
        }
    }
}
