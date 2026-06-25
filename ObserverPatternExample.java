import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String stockSymbol, double price);
}

interface Stock {
    void registerObserver(Observer observer);
    void deregisterObserver(Observer observer);
    void notifyObservers();
}

class StockMarket implements Stock {
    private final List<Observer> observers = new ArrayList<>();
    private String stockSymbol;
    private double price;

    public void setStockPrice(String stockSymbol, double price) {
        this.stockSymbol = stockSymbol;
        this.price = price;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockSymbol, price);
        }
    }
}

class MobileApp implements Observer {
    @Override
    public void update(String stockSymbol, double price) {
        System.out.println("MobileApp: " + stockSymbol + " price updated to " + price);
    }
}

class WebApp implements Observer {
    @Override
    public void update(String stockSymbol, double price) {
        System.out.println("WebApp: " + stockSymbol + " price updated to " + price);
    }
}

public class ObserverTest {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();
        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        stockMarket.setStockPrice("AAPL", 174.50);
        stockMarket.setStockPrice("GOOGL", 2840.00);
    }
}
