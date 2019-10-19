package observer;

public class StockObserver implements Observer {

    private double ibmPrice;
    private double aaplPrice;
    private double googPrice;

    private static int observerIDTracker = 0;

    private int observerID;
    private Subject stockGrabber;

    public StockObserver(Subject stockGrabber) {
        this.stockGrabber = stockGrabber;
        this.observerID = ++observerIDTracker;
        System.out.println("New Observer " + this.observerID);
        stockGrabber.register(this);
    }

    @Override
    public void update(double IBMPrice, double aaplPrice, double googPrice) {
        this.ibmPrice = IBMPrice;
        this.aaplPrice = aaplPrice;
        this.googPrice = googPrice;

        printThePrice();
    }

    private void printThePrice() {
        System.out.println(observerID +
                "\nIMB: " + ibmPrice +
                "\nAAPL: " + aaplPrice +
                "\nGOOG: " + googPrice +
                "\n");
    }
}
