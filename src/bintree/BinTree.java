
package bintree;

/**
 *
 * @author Exequiel
 */
public class BinTree {

    //Dato
    public tNode root;

    public BinTree() {
        this.root = null;
    }
    //Comprueba si esta vacio
    public boolean isEmpty() {
        return (root == null);
    }
    //Insertar un nodo
    public void insert(int info) {
        
        if (isEmpty()) {
            tNode Tree = new tNode();//Creacion de un nuevo nodo
            Tree.n = info;//se inserta un nuevo nodo
            Tree.rs = new BinTree();//inicializa puntero derecho
            Tree.ls = new BinTree();//inicializa puntero izquierdo
            root = Tree;
        } else {
            if (info > root.n) { //Criterio de insercciÃ³n
                (root.rs).insert(info);//se inserta a la derecha
            }
            if (info < root.n) {
                (root.ls).insert(info);//se inserta a la izquierda
            }
        }
    }
    
  
    
    //Eliminar Nodo
    public void delete(int a) {
        try {
            BinTree deleted = search(a);//Busca el dato a 
            if (!deleted.isEmpty()) {//verifica si no esta vacio
                if (deleted.isLeaf()) {//verifica si es hoja
                    deleted.root = null;//elimina la hoja
                } else {//si los punteros derecho e izquierdo no estan vacios
                    if (!deleted.root.ls.isEmpty() && !deleted.root.rs.isEmpty()) {
                        int b = deleted.root.rs.searchMin();//busca el dato menor derecho
                        BinTree temp = search(b);
                        temp.root = temp.root.rs.root;
                        deleted.root.n = b;
                    } else {
                        if (deleted.root.ls.isEmpty()) {//verifica si rama izquierda esta vacia
                            deleted.root = deleted.root.rs.root;
                        } else {
                            deleted.root = deleted.root.ls.root;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
      //Buscar Nodo segun numero
    public BinTree search(int a) {
        BinTree tree = null;
        if (!isEmpty()) {
            if (a == root.n) {
                return this; //retorna el dato encontrado
            } else {
                if (a < root.n) {//busca a la izquierda
                    tree = root.ls.search(a); //Recursividad
                } else {//busca a la derecha
                    tree = root.rs.search(a); //Reursividad
                }
            }
        }
        return tree;
    }

    //Recorrido en preOrden R-I-D
    public void preOrder() {
        if (!isEmpty()) {
            System.out.print(root.n + " ");
            root.ls.preOrder();
            root.rs.preOrder();
        }
    }
    //Recorrido  en orden I-R-D
    public void inOrder() {
        if (!isEmpty()) {
            root.ls.inOrder();
            System.out.print(root.n + " ");
            root.rs.inOrder();
        }
    }
    //Recorrido post orden I-D-R
    public void posOrder() {
        if (!isEmpty()) {
            root.ls.posOrder();
            root.rs.posOrder();
            System.out.print(root.n + " ");
        }
    }
    //retorna la cantidad de nodos
    public int quantity() {
        if (isEmpty()) {
            return 0;
        } else {
            return (1 + root.rs.quantity() + root.ls.quantity());
        }
    }
    
    //retorna la altura del arbol
    public int height() {
        if (isEmpty()) {
            return 0;
        } else {
            return (1 + Math.max(root.rs.height(), root.ls.height()));
        }
    }
  
    
    //Buscar Nodo menor
    public int searchMin() {
        BinTree current = this;
        int reeturn = -1;
        try {
            while (!current.root.ls.isEmpty()) {//mientras no este vacio
                current = current.root.ls;//recorre hasta el ultimo nodo izquierdo
            }
            reeturn = current.root.n;//valor se incializa con el valor menor
        } catch (Exception e) {
            current.root = null;
            return reeturn;
        }
        return reeturn;
    }
    //Buscar Nodo mayor
    public int searchMax() {
        BinTree current = this;
        int reeturn = -1;
        try {
            while (!current.root.rs.isEmpty()) {//mientras no este vacio
                current = current.root.rs;//recorre hasta el ultimo nodo derecho
            }
            reeturn = current.root.n;//valor se incializa con el valor mayor
        } catch (Exception e) {
            
            current.root = null;
            return reeturn;
        }

        return reeturn;
    }

    //Verficar si el Nodo es Hoja
    public boolean isLeaf() {
        boolean leaf = false;
        if ((root.ls).isEmpty() && (root.rs).isEmpty()) {
            leaf = true;
        }
        return leaf;
    }
    
}
