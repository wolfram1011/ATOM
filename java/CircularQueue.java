

public class Circularqueue{
  public static void main(String[] args) {

    ColaCircular cola = new ColaCircular(5);

    cola.enQueue(1);
    cola.enQueue(2);
    cola.enQueue(3);
    cola.enQueue(4);
    cola.enQueue(5);
    cola.enQueue(6);
    cola.enQueue(7);
    cola.display();
    cola.deQueue();
    cola.display();
    // System.out.println(cola.inicio);
    // System.out.println(cola.fin);
    cola.deQueue();
    cola.deQueue();
    cola.deQueue();
    cola.display();
    cola.deQueue();
    cola.display();
    cola.display();
    cola.deQueue();
    cola.deQueue();
    cola.enQueue(1);
    cola.enQueue(2);
    cola.enQueue(3);
    cola.enQueue(4);
    cola.enQueue(5);
    cola.deQueue();
    cola.deQueue();
    cola.display();
    cola.enQueue(1);
    cola.display();
    cola.deQueue();
    cola.deQueue();
    cola.display();
    cola.deQueue();
    cola.display();
    cola.deQueue();
    cola.display();
    // // System.out.println(cola.inicio);
    // // System.out.println(cola.fin);
    // cola.deQueue();
    // cola.deQueue();
    // // System.out.println(cola.inicio);
    // // System.out.println(cola.fin);
    // // cola.deQueue();
    // // System.out.println(cola.inicio);
    // // System.out.println(cola.fin);
    // cola.enQueue(7);
    // // System.out.println(cola.inicio);
    // // System.out.println(cola.fin);
    // cola.display();

  }
}

class ColaCircular{
  public int inicio, fin, tamaño, value;
  int q[];

  ColaCircular(int tamaño){
    this.tamaño = tamaño;
    this.fin = this.inicio = -1;
    this.q = new int[tamaño];
  }

  boolean isEmpty(){
    if(fin == -1 && inicio == -1){
      return true;
    }else{
      return false;
    }

  }

  boolean isFull(){
    if (inicio == 0 && fin == tamaño -1  || fin == inicio -1) {
      return true;
    }else{
      return false;
    }
  }

  void enQueue(int item){
    if (isFull()) {
      System.out.println("Esta lleno la cola circular");
    }else if(inicio == -1 && fin == -1){
      fin++;
      inicio++;
      q[fin] = item;
      System.out.println("Esta el elemento: "+item);
    }else{
      fin = (fin+1)%tamaño;
      q[fin] = item;
      System.out.println("Esta el elemento: "+item);
    }
  }

  int deQueue(){
    if(isEmpty()){
      System.out.println("La cola circular esta vacia");
    }else if(inicio == fin && inicio != -1 && fin != -1){
      value = q[inicio];
      inicio = -1;
      fin = -1;
      for (int i = 0;i < tamaño  ;i++ ) {
        q[i] = 0;
      }
    }else{
      value = q[inicio];
      inicio = (inicio +1)%tamaño;
    }
    return value;

  }
  void display(){
    if(isEmpty()){
      System.out.println("Esta vacia la cola circular");
    }else{
      System.out.println("Los elementos de la cola circular son: ");
      for (int i = inicio;i != fin ; i=(i+1)%tamaño ) {
          System.out.print(q[i]+" ");

      }
      System.out.print(q[fin]+"\n");

    }
  }

}
