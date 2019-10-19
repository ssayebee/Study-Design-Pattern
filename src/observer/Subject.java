package observer;

public interface Subject {
    public void notifyObserver();
    public void register(Observer o);
    public void unregister(Observer o);
}
