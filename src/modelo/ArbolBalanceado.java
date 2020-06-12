/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author 57314
 */
public class ArbolBalanceado {

    int tamaño;
    NodoArbolBalanceado raiz;

    public ArbolBalanceado() {
        raiz = null;
        tamaño = 0;
    }
    public boolean agregar(int dato){
        boolean inserto=insertar(dato);
        return inserto;
    }
    private boolean insertar(int dato) {
        //verifica que la raiz tenga datos
        if (raiz == null) {
            //si no tiene, le asigna un dato
            raiz = new NodoArbolBalanceado(dato);
            // se aumenta la cantidad de datos
            tamaño = 1;
            //acaba el metodo
            return true;
        } else {
            //iterador o indice
            NodoArbolBalanceado actual = raiz;
            while (true) {
                if (dato < actual.valor) {//se decide si es hijoizquiedo o derecho
                    if (actual.hijoizquierdo == null) {// verifica que no tenga hijo izquierdo
                        actual.hijoizquierdo = new NodoArbolBalanceado(dato);//le da un hijo izquierdo
                        tamaño++;// aumenta tamaño del arbol
                        return true;//termina el metodo
                    } else {
                        actual = actual.hijoizquierdo;
                    }

                } else if (dato > actual.valor) {
                    if (actual.hijoderecho == null) {
                        actual.hijoderecho = new NodoArbolBalanceado(dato);//le da un hijo derecho
                        tamaño++;// aumenta tamaño del arbol
                        return true;//termina el metodo
                    } else {
                        actual = actual.hijoderecho;
                    }
                } else {
                    return false;
                }
            }
        }
    }
    // identificar el camino que se debe recorrer para llegar a tal dato
    public ArrayList<NodoArbolBalanceado>camino (int dato){
         ArrayList<NodoArbolBalanceado> lista= new ArrayList<>();
         NodoArbolBalanceado actual = raiz;
         while(actual!=null){
             lista.add(actual);
             if (dato< actual.valor) {
                 actual= actual.hijoizquierdo;
             }else if(dato<actual.valor){
                 actual = actual.hijoderecho;
             }else{
                 //romper ciclo
                 break;
             }
         }
         return lista;
    }
}
