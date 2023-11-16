package observer;

public interface IPublisher {
    void addSubscriber(observer.ISubscriber sub);
    void removeSubscriber(observer.ISubscriber sub);
    void notifySubscribers(Object notification);
}
