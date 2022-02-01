import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

//Universidad del Valle de Guatemala
//Algoritmos y Estructura de Datos
//Catedrático Douglas Barrios
//Primer Semestre 2022
//José Daniel Gómez Cabrera 21429
//Jorge Fernando Adrino Menéndez 21616
//Juan Pablo Cordón Cotero 21458
//Sección 41
//Actividad: HT2

/**
 * Defines all the methods that a Calculator should have
 */
public class CalculadoraGrupo4 implements Calculator{

    /**
     * Calculates an entire operation.
     * @param operation String containing the operation to be calculated.
     * @return double with the result of the operation
     */
    public double calculate(String operation){

        //Operation
        // "1 2 + 3 4 *"

        MyVectorStack v = new MyVectorStack();
        String[] cadena = null;
        double respuesta = 0;
        
        try{

            cadena = operation.split(" ");

            for(int k = 0; k<cadena.length ;k++){
                
                switch (cadena[k]) {

                    case "+":
                        String s1 = v.remove();
                        double calculo = Double.parseDouble(s1);
                        
                        calculo += Double.parseDouble(v.remove());
                        

                        String item = Double.toString(calculo);
                        v.add(item);

                        break;

                    case "-":
                        String s2 = v.remove();
                        double calculo2 = Double.parseDouble(s2);
                                                    
                        
                        calculo2 -= Double.parseDouble(v.remove());

                        String item2 = Double.toString(calculo2);
                        v.add(item2);

                        break;
                        
                    case "*":
                        String s3 = v.remove();
                        double calculo3 = Double.parseDouble(s3);

                        calculo3 = (calculo3 * (Double.parseDouble(v.remove())));

                        String item3 = Double.toString(calculo3);
                        v.add(item3);

                        break;

                    case "/":
                        String s4 = v.remove();
                        double calculo4 = Double.parseDouble(s4);
                                    
                        calculo4 = (Double.parseDouble(v.remove())/calculo4);

                        String item4 = Double.toString(calculo4);
                        v.add(item4);

                        break;

                    default:
                        
                        if(!cadena[k].equals(" ")){
                            v.add(cadena[k]);
                        }

                        break;
                }
            }
            if(!v.empty()){
                respuesta = Double.parseDouble(v.remove());
            }
        }
        catch(Exception e){
            String s = "CalculadoraGrupo4: calculate(): "+e.getMessage();
            throw new RuntimeException(s);
        }
        return respuesta;
    }

    
    @Test
    //Prueba para demostrar que la calculadora funciona correctamente
    public void testCalculate(){
        assertEquals(36, calculate("1 2 + 3 4 * *"));
        assertEquals(10, calculate("4 2 / 6 2 + + "));
        assertEquals(0, calculate("8 2 2 -"));
        assertEquals(3, calculate("7 8 + 6 + 9 3 /"));
    }
}


