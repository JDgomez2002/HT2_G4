//Universidad del Valle de Guatemala
//Algoritmos y Estructura de Datos
//Catedrático Douglas Barrios
//Primer Semestre 2022
//José Daniel Gómez Cabrera 21429
//Jorge Fernando Adrino Menéndez 21616
//Juan Pablo Cordón Cotero 21458
//Sección 41
//Actividad: HT2

import java.io.File;
import java.util.*;
import java.time.LocalTime;


/**
 * Main del grupo 4
 */

public class MainG4{
    public static void main(String[] args) {

        //CALCULADORA GRUPO4 (NUESTRA CALCULADORA)
        Calculator c = new CalculadoraGrupo4();


        Vista v = new Vista();
        FileReader file = new FileReader();

        ArrayList<String> expresiones = file.leer_archivo();
        ArrayList<Double> resultados = new ArrayList<Double>();

        double resultado_actual = 0;

        v.bienvenida();

        for(int k = 0; k<expresiones.size() ;k++){
            resultado_actual = c.calculate(expresiones.get(k));
            resultados.add(resultado_actual);
        }

        for(int i = 0; i<resultados.size() ;i++){
            v.imprimir_resultados(resultados.get(i));
        }

        v.despedida();
    }
}

//---------------------------------------------------------------------------------------------------------------------
//
//FILERADER
//
//---------------------------------------------------------------------------------------------------------------------

class FileReader{
    
    public ArrayList<String> leer_archivo(){
        ArrayList<String> expresiones = new ArrayList<String>();

        try{
            
            String i = "datos.txt";
            File myFile = new File(i);
            Scanner scan = new Scanner(myFile);

            String j = "";

            while(scan.hasNextLine()){
                j = scan.nextLine();
                expresiones.add(j);
            }

        }
        catch(Exception e){
            String s = "FileReader: leer_archivo(): "+e.getMessage();
            throw new RuntimeException(s);
        }

        return expresiones;
    }
}


//---------------------------------------------------------------------------------------------------------------------
//
//VISTA
//
//---------------------------------------------------------------------------------------------------------------------


class Vista{

    private Scanner scan = new Scanner(System.in);
    private int numero_de_resultados = 0;

    /**
     * Bienvenida al usuario.
     * 
     * @author Grupo 4
     * @version bienvenida 1.1
     */
    public void bienvenida(){
        System.out.println();
        System.out.println();
        System.out.println("------------ Calculadora Postfix ------------");
        System.out.println();
        System.out.println("------------ BIENVENIDO ------------");
        System.out.println("- Hora de Entrada: "+LocalTime.now().getHour()+":"+LocalTime.now().getMinute());
        System.out.println("---------------------------------------------");
        System.out.println("- Esta es la Calculadora Postfix del Grupo 4!");
        System.out.println("---------------------------------------------");
        System.out.println();
    }

    /**
     * Metodo para mostrar un resultado al usuario
     * 
     * @author Grupo 4
     * @version bienvenida 1.1
     */
    public void imprimir_resultados(double result){
        this.numero_de_resultados += 1;
        System.out.println("\t---- Resultado No."+this.numero_de_resultados+" ----");
        System.out.println("\t R// "+result);
        System.out.println();
    }

    /**
     * Metodo de despedida para el usuario.
     */
    public void despedida(){
        System.out.println();
        System.out.println("---------------------------------------------");
        System.out.println(" Gracias por usar la Calculadora Postfix!");
        System.out.println("- Hora de Salida: "+LocalTime.now().getHour()+":"+LocalTime.now().getMinute());
        System.out.println("---------------------------------------------");
        System.out.println("- Vuelve pronto!");
        System.out.println("---------------------------------------------");
        System.out.println();
    }

}