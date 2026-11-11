package shop.notification;


public abstract class AbstractChannel implements NotificationChannel {
    int sentOut = 0;
    String pesanTerakhir = "";
    
    @Override
    public final boolean send(CustomerContact contact, String message) {
        if (message == null || message.isEmpty()) return false;
        if (isValid(contact)) {
            pesanTerakhir = prepare(message);
            sentOut++;
            System.out.println("[" + channelName() + "] " + pesanTerakhir);
            return true;
        }
        return isValid(contact);
    }

    protected abstract boolean isValid(CustomerContact contact);
    protected abstract String prepare(String message);
    

    public final int getSentCountt(){
        return sentOut;
    }

    public String getLastDeliveredMessage() {
        return pesanTerakhir;
    }


}
