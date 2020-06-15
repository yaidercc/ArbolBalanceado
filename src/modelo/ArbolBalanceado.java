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

    public boolean agregar(int dato) {
        boolean inserto = insertar(dato);
        if (inserto) {
            balancear();
        }
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

    // identificar el camino que se debe recorrer para llegar a dicho dato, y guardar los nodos que hay en su camino 
    //con un arraylist que obtiene los nodos de la clase NodoArbolBalanceado
    public ArrayList<NodoArbolBalanceado> camino(int dato) {
        ArrayList<NodoArbolBalanceado> lista = new ArrayList<>();
        NodoArbolBalanceado actual = raiz;
        while (actual != null) {
            lista.add(actual);
            if (dato < actual.valor) {
                actual = actual.hijoizquierdo;
            } else if (dato < actual.valor) {
                actual = actual.hijoderecho;
            } else {
                //romper ciclo
                break;
            }
        }
        if (actual == null) {
            lista.clear();
        }
        return lista;
    }

    private void balancear() {
        ArrayList<NodoArbolBalanceado> lista = new ArrayList<>();
        int indiceUltimo = lista.size() - 1;
        for (int i = indiceUltimo; i >= 0; i--) {
            NodoArbolBalanceado A = lista.get(i);
            // a cada nodo le indica su altura
            A.actualizaraltura();
            // busca el padre de cada nodo y se le asigna a la variable padreA
            NodoArbolBalanceado PadreA;

            if (A == raiz) {
                PadreA = null;
            } else {
                PadreA = lista.get(i - 1);
            }
            // verifica se el arbol o el subarbol esta desbalanceado 
            if (A.factorbalance() == -2) {
                if (A.hijoizquierdo.factorbalance() <= 0) {
                    balanceLL(A, PadreA);
                } else {
                    balanceLR(A, PadreA);
                }
            } else if (A.factorbalance() == 2) {
                if (A.hijoderecho.factorbalance()>=0) {
                    balanceRR(A,PadreA);
                }
            }
        }
    }

    private void balanceLL(NodoArbolBalanceado A, NodoArbolBalanceado padreA) {
        NodoArbolBalanceado B = A.hijoizquierdo;
        if (A == raiz) {
            B = raiz;
        } else if (padreA.hijoizquierdo == A) {
            padreA.hijoizquierdo = B;
        } else {
            padreA.hijoderecho = B;
        }

        A.hijoizquierdo = B.hijoderecho;
        B.hijoizquierdo = A;
    }

    private void balanceLR(NodoArbolBalanceado A, NodoArbolBalanceado padreA) {
        NodoArbolBalanceado B = A.hijoizquierdo;
        NodoArbolBalanceado C = B.hijoderecho;

        if (A == raiz) {
            B = raiz;
        } else if (padreA.hijoizquierdo == A) {
            padreA.hijoizquierdo = C;
        } else {
            padreA.hijoderecho = C;
        }
        A.hijoizquierdo = C.hijoderecho;
        A.hijoderecho = C.hijoizquierdo;
        C.hijoizquierdo = B;
        C.hijoderecho = A;

        A.actualizaraltura();
        B.actualizaraltura();
        C.actualizaraltura();

    }

    private void balanceRR(NodoArbolBalanceado A, NodoArbolBalanceado padreA) {

    }
}
