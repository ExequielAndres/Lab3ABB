
package bintree;
import java.util.Scanner;
/**
 *
 * @author Exequiel
 */
class Main
{
  static Scanner keyboard = new Scanner(System.in); // input de teclado
    
   public static void main(String x[])
  { 
    int[ ] repeat = new  int[99999]; // arreglo para almacenar la cantidad de veces que se repite un dato
    BinTree bTree ;
    int number;
    bTree = new BinTree();
    int option;
    bTree.insert(30);repeat[30]++;  // se inicializa con 10 nodos y se anota su repeticion
    bTree.insert(29);repeat[29]++;
    bTree.insert(31);repeat[31]++;
    bTree.insert(28);repeat[28]++;
    bTree.insert(32);repeat[32]++;
    bTree.insert(27);repeat[27]++;
    bTree.insert(33);repeat[33]++;
    bTree.insert(26);repeat[26]++;
    bTree.insert(34);repeat[34]++;
    bTree.insert(25);repeat[25]++;
    
   
    
           
            do
            {
                System.out.print("\n ");  // menu que funciona mediante do-while
                System.out.print("\n "); 
                System.out.print("\n * * * * MENU * * * * * * * * * * * *   *"); 
                System.out.print("\n *  1.Insertar                          *");  
                System.out.print("\n *  2.Buscar dato                       *");
                System.out.print("\n *  3.Mostrar  recorridos del arbol     *");                      
                System.out.print("\n *  4.Eliminar dato                     *");
                System.out.print("\n *  5.Altura del arbol                  *");
                System.out.print("\n *  6.Cantidad de nodos                 *");                
                System.out.print("\n *  9.Salir                             *");
                System.out.print("\n * * * * * * * * * * * * * * * * * * * * ");
                System.out.print("\n "); 
                System.out.print("\n "); 
                  
                System.out.print("\n Ingrese opcion :");
                option = keyboard.nextInt();
                
            
                 // opciones disponibles para el usuario                    
                 switch(option) 
                 {
                  case 1:   System.out.print("\n Ingrese nuevo Elemento : "); //insertar
                             
                            number=keyboard.nextInt();
                            if(bTree.search(number)==null){
                                bTree.insert(number);
                                repeat[number]=repeat[number]+1; 
                                System.out.print("\n Dato :"+number+", ingresado al arbol, repeticiones :"+repeat[number]);  
                            }                           
                            else{
                                System.out.print("\n Elemento repetido ");
                                repeat[number]=repeat[number]+1;
                                System.out.print("\n repeticiones (considerando el ingreso actual) : "+repeat[number]);
                            }
                                
                                

                        break;
                   
                  case 2:  System.out.print("\n Ingrese dato a buscar : "); //buscar
                            number=keyboard.nextInt();
                            if(bTree.search(number)==null)
                                System.out.print("\n Dato : "+number+", no encontrado ");
                            
                            else
                                System.out.print("\n Dato : "+number+", encontrado, repeticiones "+repeat[number]);

                        break;
                 
                  case 3: 
                            System.out.print("\n PreOrden : ");  // imprime los recorridos
                            bTree.preOrder();
                            System.out.print("\n InOrden : "); 
                            bTree.inOrder();
                            System.out.print("\n PostOrden : "); 
                            bTree.posOrder();
                        break;
                 
                  case 4:   System.out.print("\n Ingrese dato a eliminar : "); // eliminar un dato
                            number=keyboard.nextInt();
                            
                            if(bTree.search(number)==null){
                                System.out.print("\n Dato: "+number+", no encontrado : ");
                                } 
                            else{
                                bTree.delete(number);
                                repeat[number]=0;
                                System.out.print("\n Dato: "+number+", eliminado correctamente  ");   
                            }                         
                               
                            
                                
                                
                                             
                        break;
                    
                   case 5:   System.out.print("\n La altura del arbol es : "+bTree.height()); // imprime la altura del arbol
                         break;
                         
                    case 6:   System.out.print("\n La cantidad de nodos es : "+bTree.quantity()); // imprime la cantidad de nodos del arbol
                         break;
                   
                   
                   
                         
                        
                         
                  default:    System.out.print("\n PROGRAMA FINALIZADO "); // mensaje de programa finalizaedo
                           
            }
      }
                        while(option<=6);           
    }
}