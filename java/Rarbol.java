import java.util.Random;

public class Rarbol {

  public static void main(String[] args) {

    int entero = 5;
    boolean valor = false;

    ArbolBinario bt = new ArbolBinario();
    bt.sumar(1);
    bt.sumar(2);
    bt.sumar(3);
    bt.sumar(4);
    bt.sumar(5);
    bt.sumar(6);
    bt.sumar(7);
    // bt.sumar(8);
    // bt.sumar(9);
    // bt.sumar(10);
    // bt.sumar(11);
    // bt.sumar(12);
    // bt.sumar(13);
    // bt.sumar(14);
    bt.eliminarNodo(3);
    bt.restaurarIndice(bt.raiz);
    System.out.println("*****encontrando valor: "+bt.contieneNodo(3));
    bt.restaurarIndice(bt.raiz);
    System.out.println(bt.raiz.value);
    bt.eliminarNodo(5);
    System.out.println(bt.raiz.value);
    bt.restaurarIndice(bt.raiz);
    System.out.println("******encontrando valor: "+bt.contieneNodo(5));

  } // void main

} //class lista

class Node {
  int value;
  Node left;
  Node right;
  boolean indice = false;
  String order = "";


  Node(int value, String order){
    this.order = order;
    this.value = value;
    this.right = null;
    this.left = null;
  }
}

public class ArbolBinario{
  int dif,suma,total,temp = 0;
  Node raiz,prev;
  String lugar = "raiz->",ruta= "";
  boolean interruptor = false;

  private Node addRecursive(Node nodo, int value){
    Random rand = new Random();
    int n = rand.nextInt(10);
    if(nodo == null){
      return new Node(value,lugar);
    }
    if(n%2 ==0){
      lugar = "left->";
      nodo.left = addRecursive(nodo.left,value);
    }else if (n%2 != 0){
      lugar = "right->";
      nodo.right = addRecursive(nodo.right, value);
    }else {
      return nodo;
    }
    return nodo;
  }

  public boolean restaurarIndice(Node nodo){
    // temp++;
    System.out.println("diferencia en restaurar: "+dif+"total en restaurar: "+total);

    if (nodo == null) {
      nodo = raiz;
      System.out.println("primer if en restaurar"+ "nodo raiz"+raiz.value);

    }
    else if (nodo.indice == true) {
      suma++;
      dif++;
      nodo.indice = false;

    }
    if (total == dif || temp == 10 ) {
      dif = 0;
      suma = 0;
      return true;
    }

    Random rand = new Random();
    int n = rand.nextInt(10);


    return n%2 == 0
      ? restaurarIndice(nodo.left)
      : restaurarIndice(nodo.right);

  }

  public void sumar(int value){
    total++;
    raiz = addRecursive(raiz, value);
  }

  private boolean contenerNodoRecursivo(Node nodo, int value){
    System.out.println("total en contener: "+total+"suma en contener: "+suma);
    // temp++;

    if(nodo == null){
      nodo = raiz;
    }
    else if(value == nodo.value){
      suma++;
      dif = total - suma;
      ruta = ruta + nodo.order;
      // nodo = null;
      // nodo.value = 2;
      nodo.indice = true;
      suma = 0;
      return true;
    }else if(nodo.indice == false){
      System.out.println("diferencia de contener: "+dif+"+"+suma);
      suma++;
      dif = total - suma;
      nodo.indice = true;
      ruta = ruta+nodo.order;
    }
    if (suma == total ||  temp == 20) {
      System.out.println("total de contener");
      suma = 0;
      return false;

    }
    Random rand = new Random();
    int n = rand.nextInt(10);


    return n%2 == 0
      ? contenerNodoRecursivo(nodo.left, value)
      : contenerNodoRecursivo(nodo.right, value);
  }



  public boolean contieneNodo(int value) {
    suma = 0;
    return contenerNodoRecursivo(raiz, value);
  }

  public Node ultimoEncontrar(Node cubo, Node cubito){

      if (cubo == null) {

        return cubito;


      }

      cubo.left = ultimoEncontrar(cubo.left,cubito);



    return cubo;
  }

  public Node eliminarNodoRecursivo(Node nodo, int value){

      if(nodo == null){
        nodo = raiz;
        System.out.println("nodo null en eliminar");
        return null;
      }
      else if(value == nodo.value){
         System.out.println("Encontrar nodo: "+nodo.value+"left: "+nodo.left + "right: "+nodo.right);
         total--;
         ruta = ruta + nodo.order;
         dif = total - suma;
         suma = 0;
         nodo.indice = true;
         interruptor = true;
        if (nodo.left == null && nodo.right == null ) {
          System.out.println("primer if eliminar"+dif);
          return null;
        }
         else if (nodo.left == null) {
           System.out.println("segundo if");
          // if (nodo.order == "left->") {
          //   // nodo = nodo.right;
          // }
          // nodo.right.indice = true;
          return nodo.right;
        }
        else if (nodo.right == null) {
          System.out.println("tercer if");
          // if (nodo.order == "left->") {
          //   // nodo = nodo.left;
          // }
          // nodo.left.indice = true;
          return nodo.left;
        }else{
          System.out.println("cuarto if"+dif);
          raiz = ultimoEncontrar(raiz,nodo.right);
          return nodo.left;
        }
      }else if(nodo.indice == false){
        System.out.println("valores de false: "+nodo.value);
        suma++;
        dif = total - suma;
        nodo.indice = true;
        ruta = ruta+nodo.order;
      }
      if (suma == total) {
        suma = 0;
        return nodo;

      }
      Random rand = new Random();
      int n = rand.nextInt(10);

      if (n%2 == 0) {
        nodo.left = eliminarNodoRecursivo(nodo.left, value);
      }else{
        nodo.right = eliminarNodoRecursivo(nodo.right, value);
      }

      return nodo;

  }//funcion


  public void eliminarNodo(int value) {
    Node cajon = null;
    System.out.println("metodo eliminar");

    while (interruptor == false) {
      System.out.println("cajon nodo: "+cajon);
      cajon = null;
      cajon = eliminarNodoRecursivo(raiz,value);
    }
    raiz = cajon;
    interruptor = false;
  }

}// class




// private Node eliminarNodoRecursivo(Node nodo, int value){
//
//   if(nodo == null){
//     nodo = raiz;
//     System.out.println("ff");
//   }
//   else if(value == nodo.value){
//     System.out.println("Encontrar nodo");
//      suma++;
//      ruta = ruta + nodo.order;
//      dif = total - suma;
//      suma = 0;
//      nodo.indice = true;
//     if (nodo.left == null && nodo.right == null ) {
//       System.out.println("primer if eliminar");
//
//       return null;
//     }
//      else if (nodo.left == null) {
//        System.out.println("segundo if");
//       // if (nodo.order == "left->") {
//       //   // nodo = nodo.right;
//       // }
//       nodo.right.indice = true;
//       return nodo.right;
//     }
//     else if (nodo.right == null) {
//       System.out.println("tercer if");
//       // if (nodo.order == "left->") {
//       //   // nodo = nodo.left;
//       // }
//       nodo.left.indice = true;
//       return nodo.left;
//     }else{
//       System.out.println("cuarto if");
//       nodo.value = 0;
//       return nodo;
//     }
//     // else{
//     //   Node cubo;
//     //
//     //   cubo = ultimoEncontrar(nodo.left);
//     //   cubo = nodo.right;
//     //   nodo = nodo.left;
//     //   return true;
//     // }
//       // return null;
//   }else if(nodo.indice == false){
//     suma++;
//     dif = total - suma;
//     nodo.indice = true;
//     ruta = ruta+nodo.order;
//   }
//   if (suma == total || suma + dif == total) {
//     suma = 0;
//     return nodo;
//
//   }
//   Random rand = new Random();
//   int n = rand.nextInt(10);
//
//   if (n%2 == 0) {
//     nodo.left = eliminarNodoRecursivo(nodo.left, value);
//   }else{
//     nodo.right = eliminarNodoRecursivo(nodo.right, value);
//   }
//
//   return nodo;
// }

//
// Node nodo = raiz;
//
// while(nodo.value != value && total >= suma){
//
//   if (nodo.indice == false) {
//       suma++;
//       dif = total - suma;
//       nodo.indice = true;
//       ruta = ruta+nodo.order;
//     }
//     Random rand = new Random();
//     int n = rand.nextInt(10);
//
//     if (n%2 == 0) {
//       nodo = nodo.left;
//       if (nodo == null) {
//         nodo = raiz;
//       }
//     }else{
//       nodo = nodo.right;
//       if (nodo == null) {
//         nodo = raiz;
//       }
//     }
//   }// while
//
//   if (nodo.value == value) {
//     if (nodo.left == null && nodo.right == null) {
//       nodo = null;
//       nodo = new Node(2);
//     }else if (nodo.left == null) {
//       nodo = nodo.right;
//     }else if (nodo.right == null) {
//       nodo = nodo.left;
//     }else{
//       nodo = nodo;
//     }
//
//
//   }//if valor encontrado
