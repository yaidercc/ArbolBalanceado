/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author 57314
 */
public class NodoArbolBalanceado {

    int valor;
    int altura;
    NodoArbolBalanceado hijoizquierdo;
    NodoArbolBalanceado hijoderecho;

    public NodoArbolBalanceado(int dato) {
        this.valor = dato;
        hijoderecho = null;
        hijoizquierdo = null;
        altura = 1;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public NodoArbolBalanceado getHijoizquierdo() {
        return hijoizquierdo;
    }

    public void setHijoizquierdo(NodoArbolBalanceado hijoizquierdo) {
        this.hijoizquierdo = hijoizquierdo;
    }

    public NodoArbolBalanceado getHijoderecho() {
        return hijoderecho;
    }

    public void setHijoderecho(NodoArbolBalanceado hijoderecho) {
        this.hijoderecho = hijoderecho;
    }

    public boolean EsHoja() {
        return hijoizquierdo == null && hijoderecho == null;
    }

    public void actualizaraltura() {
        if (EsHoja()) {
            altura = 1;
        } else if (hijoderecho == null) {
            altura = 1 + hijoizquierdo.altura;
        } else if (hijoizquierdo == null) {
            altura = 1 + hijoderecho.altura;
        }else{
            altura= 1 + Math.max(hijoderecho.altura,hijoizquierdo.altura);
        }

    }
    //factor de balance
    
    public int factorbalance(){
        if (EsHoja()) {
            return 0;
        }else if(hijoderecho==null){
            return -hijoizquierdo.altura;
        }else if(hijoizquierdo==null){
            return -hijoderecho.altura; 
        }else{
            return hijoderecho.altura- hijoizquierdo.altura;
        
    }
            
    }
}
