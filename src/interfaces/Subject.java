package interfaces;

import java.util.ArrayList;

public interface Subject {

    public void addSubscriber(Subscriber subscriber);
    public void removeSubscriber(Subscriber subscriber);
    public void notifySubscribers();

}
