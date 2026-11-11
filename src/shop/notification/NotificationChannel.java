package shop.notification;

interface NotificationChannel {
    String channelName(); 
    boolean send(CustomerContact contact, String message);
}
