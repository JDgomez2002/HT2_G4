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
                        
                        for(int i = 0; i<v.size() ;i++){
                            calculo += Double.parseDouble(v.peek());
                        }

                        for(int i = 0; i<v.size() ;i++){
                            v.remove();
                        }

                        String item = Double.toString(calculo);
                        v.add(item);

                        break;

                    case "-":
                        String s2 = v.remove();
                        double calculo2 = Double.parseDouble(s2);
                            
                        for(int i = 0; i<v.size() ;i++){
                            calculo2 -= Double.parseDouble(v.peek());
                        }

                        for(int i = 0; i<v.size() ;i++){
                            v.remove();
                        }

                        String item2 = Double.toString(calculo2);
                        v.add(item2);

                        break;
                        
                    case "*":
                        // System.out.println("LENGHT ANTES"+v.size());
                        String s3 = v.remove();
                        // System.out.println("LENGHT DESPUES"+v.size());
                        double calculo3 = Double.parseDouble(s3);

                        // System.out.println(v.myStack);

                        // int r = 0;

                        // if(v.size()>=3){
                        //     r = v.size()-2;
                        // }
                        // else{
                        //     r = v.size();
                        // }

                                
                        for(int i = 0; i<v.size() ;i++){
                            // System.out.println("ANTES "+calculo3);
                            // System.out.println("PEEK "+v.peek());
                            double calculon = (calculo3 * (Double.parseDouble(v.peek())));
                            // System.out.println("DESPUES "+calculon);
                        }
                        

                        for(int i = 0; i<v.size() ;i++){
                            v.remove();
                        }

                        String item3 = Double.toString(calculo3);
                        v.add(item3);

                        break;

                    case "/":
                        String s4 = v.remove();
                        double calculo4 = Double.parseDouble(s4);
                                    
                        for(int i = 0; i<v.size() ;i++){
                            calculo4 = (Double.parseDouble(v.peek())/calculo4);
                        }

                        for(int i = 0; i<v.size() ;i++){
                            v.remove();
                        }

                        String item4 = Double.toString(calculo4);
                        v.add(item4);
                        break;

                    default:
                        v.add(cadena[k]);
                        // System.out.println("R---"+cadena[k]);
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



}
