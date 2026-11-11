package shop.notification;

public class WhatsAppChannel extends AbstractChannel {


    @Override
    public String channelName() {
        // TODO Auto-generated method stub
        return "WA";
    }

    @Override
    protected boolean isValid(CustomerContact contact) {
        // TODO Auto-generated method stub
        return contact.getPhone() != null &&
         !contact.getPhone().isEmpty() && (contact.getPhone().startsWith("+62") || contact.getPhone().startsWith("08"))&&
         contact.getPhone().length() >= 10; 
    }

    @Override
    protected String prepare(String message) {
        // TODO Auto-generated method stub
        return "[TOKO UMKM] "+message;
    }

}
