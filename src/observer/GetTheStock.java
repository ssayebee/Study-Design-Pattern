package observer;
import java.text.DecimalFormat;
import java.util.Random;

public class GetTheStock implements Runnable{

    private Subject stockGrabber;
    private int startTime;
    private String stock;
    private double price;

    public GetTheStock(Subject stockGrabber, int startTime, String stock, double price) {
        this.stockGrabber = stockGrabber;
        this.startTime = startTime;
        this.stock = stock;
        this.price = price;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 20 ; i++) {
            try {
                Thread.sleep(1000 * startTime);
            }
            catch (InterruptedException e) {}

            double randNum = (Math.random()*0.06 ) - .03;

            DecimalFormat df = new DecimalFormat("#.##");

            price = Double.valueOf(df.format((price + randNum)));

            if ("IBM".equals(stock)) ((StockGrabber)stockGrabber).setIBMPrice(price);
            if ("AAPL".equals(stock)) ((StockGrabber)stockGrabber).setAaplPrice(price);
            if ("GOOG".equals(stock)) ((StockGrabber)stockGrabber).setGoogPrice(price);

            System.out.println(stock + ": " + df.format(price) + " " + df.format(randNum));
            System.out.println();

        }

    }
}
