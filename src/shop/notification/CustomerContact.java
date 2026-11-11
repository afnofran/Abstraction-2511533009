package shop.notification;

public final class CustomerContact{
    String name,email,phone;
    public CustomerContact(String name, String email, String phone){
        if (name == null) throw new IllegalArgumentException("Nama tidak boleh kosong");
        this.name = name;
        if (email == null) email="";
        if (phone == null) phone="";
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    } 
}