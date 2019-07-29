
package bintree;

/**
 *
 * @author Exequiel
 */
public class tNode {
   
    public int n, repeat;//Dato tipo entero
    public BinTree ls, rs;//punteros del arbol

    //Constructor
    public tNode(int info) {
        this.n = info;//Se inicializa info con la informacion del
        this.ls = null;//parametro del constructor
        this.rs = null;
        
    }
    //Constructor sin parametros
    public tNode() {
        this.n = 0;//se inicializa la informacion del arbol con 0
        this.ls = null;//puntero izquierdo apunta null
        this.rs = null;//puntero derecho apunta null
       
        
    } 

    
    
    
    
}
