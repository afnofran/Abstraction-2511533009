package shop.notification;

import java.util.ArrayList;
import java.util.List;

public class NotificationService {
    public static List<NotificationChannel> notifList = new ArrayList<>();

    public static void register(NotificationChannel channel) {
        // Implementation for registering a notification channel
        notifList.add(channel);
    }

    public static int broadcast(CustomerContact contact, String message) {
        int count = 0;
        for (NotificationChannel channel : notifList) {
            if (channel.send(contact, message)) {
                count++;
            }
        }   
        return count;
    }
    /*
void register(NotificationChannel channel);
int broadcast(CustomerContact contact, String
message)  */
}
