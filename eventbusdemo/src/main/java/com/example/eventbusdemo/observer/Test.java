package com.example.eventbusdemo.observer;

public class Test {
    public static void main(String[] s){
        //被观察者
        Observable observable = new Observable();
        //观察者
        com.example.eventbusdemo.observer.Observer observer1 = new com.example.eventbusdemo.observer.Observer();
        com.example.eventbusdemo.observer.Observer observer2 = new com.example.eventbusdemo.observer.Observer();
        com.example.eventbusdemo.observer.Observer observer3 = new com.example.eventbusdemo.observer.Observer();
        com.example.eventbusdemo.observer.Observer observer4 = new com.example.eventbusdemo.observer.Observer();
        //订阅
        observable.registerObserver(observer1);
        observable.registerObserver(observer2);
        observable.registerObserver(observer3);
        observable.registerObserver(observer4);

        observable.removeObserver(observer1);
        //业务数据更新的时候
        observable.notifyMsg();

    }
}
