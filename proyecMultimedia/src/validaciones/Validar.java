/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validaciones;

/**
 * Clase general quer contiene metodos para validar
 * @author pscam
 */
public class Validar {
    
    /**
     * comprueba que los datos que se ingresaro sean digitos
     * @param valor cadena que ingreso el usuario.
     * @return true si la cadena contiene solo digitos, de lo contrario false.
     */
    public boolean esNumero(String valor){
        return valor.matches("\\d*"); //comprueba que sean digitos
        //equivalente a ("\\d*") ->> ("[0-9]*")
    }
}
