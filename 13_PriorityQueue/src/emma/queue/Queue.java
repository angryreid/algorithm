package emma.queue;


public interface Queue<E> {

  public int size();
  public boolean isEmpty();
  public void clear();
  public void enQueue(E element);
  public E deQueue();
  public E front();
}
