package shop.notification;


public class EmailChannel extends AbstractChannel {

    public EmailChannel() {
        super();
    }
    @Override
    public String channelName() {
        // TODO Auto-generated method stub
        return "Email";
    }
    @Override 
    public boolean isValid(CustomerContact contact) {
        // TODO Auto-generated method stub
        return contact.getEmail() != null && contact.getEmail().split("@").length >= 2 && !contact.getEmail().contains(" ");
    }
    
    @Override
    protected String prepare(String message) {
        // TODO Auto-generated method stub
        return message;
    }

}
