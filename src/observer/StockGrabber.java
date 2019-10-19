package observer;

import java.util.ArrayList;

public class StockGrabber implements Subject{

    private ArrayList<Observer> observers;
    private double IBMPrice;
    private double aaplPrice;
    private double googPrice;

    public StockGrabber() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(IBMPrice, aaplPrice, googPrice);
        }
    }

    @Override
    public void register(Observer newObserver) {
        observers.add(newObserver);

    }

    @Override
    public void unregister(Observer deletedObserver) {
        int observerIndex = observers.indexOf(deletedObserver);
        System.out.println("Observer " + (observerIndex+1) + " deleted");
        observers.remove(observerIndex);

    }

    public void setIBMPrice(double newIBMPrice) {
        this.IBMPrice = newIBMPrice;
        notifyObserver();
    }

    public void setAaplPrice(double newAaplPrice) {
        this.aaplPrice = newAaplPrice;
        notifyObserver();
    }

    public void setGoogPrice(double newGoogPrice) {
        this.googPrice = newGoogPrice;
        notifyObserver();
    }
}
