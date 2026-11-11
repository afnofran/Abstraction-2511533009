package shop.notification;

public class SmsChannel extends AbstractChannel {
    int maxLength;
    public SmsChannel(int maxLength) {
        super();
        this.maxLength = maxLength;
    }

    @Override
    public String channelName() {
        // TODO Auto-generated method stub
        return "SMS";
    }

    @Override
    protected boolean isValid(CustomerContact contact) {
        return contact.getPhone() != null && contact.getPhone().startsWith("08");
    }

    @Override
    protected String prepare(String message) {
        return message.length() < maxLength ? message : message.substring(0, maxLength-3) + "...";
    }

    public String getLastDelivered() {
        return pesanTerakhir;
    }

}
