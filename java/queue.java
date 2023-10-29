
public class queue {

  public static void main(String[] args) {
    Cola cola = new Cola(5);
    cola.enQueue(1);
    cola.enQueue(2);
    cola.enQueue(3);
    cola.enQueue(4);
    cola.enQueue(5);
    cola.enQueue(10);
    cola.enQueue(11);
    cola.display();
    int x = cola.deQueue();
    cola.deQueue();
    cola.display();
    cola.deQueue();
    cola.display();
    cola.deQueue();
    cola.display();
    cola.deQueue();
    cola.deQueue();
    cola.deQueue();
    System.out.println("Valor del dequeue "+x);
    cola.display();
    cola.enQueue(6);
    cola.enQueue(7);
    cola.display();
    System.out.println(cola.fin);


  }

}

class Cola{
  public int inicio, fin, tamaño, value;
  int c[];

  Cola(int tamaño){
    this.tamaño = tamaño;
    this.fin = -1;
    this.c = new int[tamaño];
  }
  boolean isEmpty(){
    if (fin == -1) {
      return true;

    }else{
      return false;
    }
  }
  boolean isFull(){
    if (fin == tamaño-1) {
      return true;
    }
    return false;
  }
  void enQueue(int item){
    if (isFull()) {
      System.out.println("Esta lleno");

    }else{
      fin++;
      c[fin] = item;
      System.out.println("Esta el elemento: "+ item);
    }
  }

  public int deQueue(){
    if(isEmpty()){
      System.out.println("La cola esta vacia");
    }else{
      value = c[0];
      for (int i = 0;i < fin; i++ ) {
        c[i] = c[i+1] ;

      }
      c[fin] = 0;
      fin--;
    }

    return value;
}

public void display(){
  if (isEmpty()) {
    System.out.println("Esta vacia la cola");
  }else{
    System.out.print("La cola es: ");
    for (int i = 0;i <= fin; i++ ) {
      System.out.print(c[i]+" ");

    }
    System.out.print("\n");
  }

}


}
