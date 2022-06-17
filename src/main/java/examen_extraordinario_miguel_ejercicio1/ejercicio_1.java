/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen_extraordinario_miguel_ejercicio1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DAW
 */
public class ejercicio_1 {

    /**
     * @param args the command line arguments
     */
    static ArrayList<String> tipos_de_farolas = new ArrayList<>();
    static ArrayList<Integer> distritos = new ArrayList<>();
    static int num_lineas = 0;

    public static void leerContenidoFarolas(File archivo_luz) throws FileNotFoundException {
        String tipo_farola;
        int distrito;

        try (Scanner lector = new Scanner(archivo_luz).useDelimiter("'|,|;|' '")) {
            lector.nextLine();
            while (lector.hasNextLine()) {
                String aux;
                lector.next();

                tipo_farola = lector.next();

                lector.next();
                aux = lector.next();
                if (aux == null) {
                    lector.nextLine();
                }
                lector.next();
                lector.next();

                distrito = lector.nextInt();

                lector.nextLine();

                num_lineas++;
                System.out.println("lineas: " + num_lineas + aux);

                tipos_de_farolas.add(tipo_farola);

                distritos.add(distrito);
            }
            lector.close();
        } catch (IndexOutOfBoundsException e) {
        }
        CalcularNumeroDeFarolas();

    }

    static ArrayList<Integer> codigos = new ArrayList<>();
    static ArrayList<String> nombres = new ArrayList<>();
    static int num_lineas2 = 0;

    public static void leerContenidoDistritos(File archivo_distritos) throws FileNotFoundException {

        int codigo;
        String nombre;

        try (Scanner lector = new Scanner(archivo_distritos).useDelimiter(",|;")) {
            //lector.nextLine();
            while (lector.hasNextLine()) {

                lector.nextInt();
                lector.nextInt();
                lector.nextInt();
                lector.nextInt();
                lector.nextInt();
                lector.nextInt();

                codigo = lector.nextInt();
                nombre = lector.next();

                lector.nextLine();

                num_lineas2++;
                System.out.println("su nombre es: " +num_lineas2+ nombre + "su codigo es: " + codigo);

                codigos.add(codigo);
                nombres.add(nombre);

            }
            lector.close();
        } catch (IndexOutOfBoundsException e) {
        }
    }

    public static void CalcularNumeroDeFarolas() {
        ArrayList<String> tipo_led = new ArrayList<>();
        ArrayList<String> tipo_descarga = new ArrayList<>();

        for (String aux : tipos_de_farolas) {
            if ("LED".equals(aux)) {
                tipo_led.add(aux);
            }

            if ("DESCARGA".equals(aux)) {
                tipo_descarga.add(aux);
            }
        }
        if (tipo_led.size() > tipo_descarga.size()) {
            System.out.println("hay mas de tipo LED y son: " + tipo_led.size());
        }
        if (tipo_led.size() < tipo_descarga.size()) {
            System.out.println("hay mas de tipo DESCARGA y son: " + tipo_descarga.size());
        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        //String archivo = "datos_farolas";
        String archivo2 = "Distritos";
       // File archivo_luz = new File(archivo + ".csv");
        File archivo_distritos = new File(archivo2 + ".csv");

        //leerContenidoFarolas(archivo_luz);
        //CalcularNumeroDeFarolas();
        leerContenidoDistritos(archivo_distritos);
    }

}
