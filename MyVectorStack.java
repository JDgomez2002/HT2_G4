//Universidad del Valle de Guatemala
//Algoritmos y Estructura de Datos
//Catedrático Douglas Barrios
//Primer Semestre 2022
//José Daniel Gómez Cabrera 21429
//Jorge Fernando Adrino Menéndez 21616
//Juan Pablo Cordón Cotero 21458
//Sección 41
//Actividad: HT2

import java.util.Vector;

/**
 * Defines all the methods that our Vector-Stack should have.
 */

public class MyVectorStack implements Stack<String> {
    
    Vector<String> myStack = new Vector<String>(5,5);
    private int espacios;
    private int recorrido;

    /**
     * Constructor.
     */
    public MyVectorStack(){
        this.espacios = 0;
        this.recorrido = 0;
    }

    /**
     * add an item to the stack. Will be popped next.
     * @param String
     */
    public void add(String item){
        this.myStack.add(item);
        if(this.recorrido!=this.espacios){
            this.recorrido = this.espacios;
        }
        this.espacios += 1;
        this.recorrido += 1;
    }

    /**
     * If the Stack is not empty, the most recent item will be removed and returned.
     * @return String
     */
    public String remove(){
        String s = null;
        int last = this.espacios-1;

        if((!this.myStack.isEmpty()&&(this.espacios>0))){
            s = this.myStack.get(last);
            myStack.remove(last);
            this.espacios -= 1;
            this.recorrido -= 1;
        }

        return s;
    }

    /**
     * Get the current Item on the Stack (without popping it).
     * @return String
     */
    public String peek(){
        String s = null;
        int last = this.recorrido-1;

        if(this.recorrido!=this.espacios){
            this.recorrido = this.espacios;
        }

        if(((!this.myStack.isEmpty())&&(this.recorrido>0))){
            s = this.myStack.get(last);
            this.recorrido -= 1;
        }

        return s;
    }

    /**
     * Check if the Stack is empty.
     * @return Boolean indicating if the Stack is empty
     */
    public boolean empty(){
        boolean vacio = false;
        
        if(this.espacios<=0){
            vacio = true;
        }

        return vacio;
    }

    /**
     * Get the size of the Stack.
     * @return Integer indicating the size of the Stack
     */
    public int size(){
        return this.espacios;
    }


}
