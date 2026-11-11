package shop.app;

import java.util.List;

import shop.StudentInfo;
import shop.model.DigitalProduct;
import shop.model.PhysicalProduct;
import shop.model.Product;
import shop.notification.*;
import shop.payment.BankTransferPayment;
import shop.payment.CreditCardPayment;
import shop.payment.EWalletPayment;
import shop.payment.PaymentMethod;
import shop.service.CheckoutService;
import shop.shipping.ExpressShipping;
import shop.shipping.ShippingService;

public class TugasApp {
    public static void main(String[] args) {
        WhatsAppChannel wa = new WhatsAppChannel();
        SmsChannel sms = new SmsChannel(StudentInfo.SMS_MAX_LENGTH);
        EmailChannel email = new EmailChannel();
        NotificationService.register(wa);
        NotificationService.register(sms);
        NotificationService.register(email);



        Product coffee = new PhysicalProduct("KOPI-001", "Kopi Arabika Gayo 250g", 85_000, 300);
        Product rendang = new PhysicalProduct("RDG-002", "Rendang Kemasan 250g", 120_000, 400);
        Product ebook = new DigitalProduct("EBK-003", "E-book Resep Kue Nusantara", 50_000,
                "https://toko-umkm.example/unduh/ebk-003");

        List<Product> belanja = List.of(coffee, rendang, ebook);

        CheckoutService checkout = new CheckoutService();
        ShippingService express = new ExpressShipping();

        EWalletPayment wallet = new EWalletPayment("DompetKu", 300_000);
        PaymentMethod transfer = new BankTransferPayment("Bank Nagari");
        CreditCardPayment card = new CreditCardPayment("Siti Rahma", 1_000_000);
    
        System.out.println("== T1: Total dengan biaya admin (Ekspres) ==");
        System.out.println("Transfer Bank : Rp" + checkout.grandTotal(belanja, express, transfer) + " (Biaya Admin "+ transfer.adminFee(checkout.total(belanja, express)) +")");
        System.out.println("E-Wallet Dompetku : Rp" + checkout.grandTotal(belanja, express, wallet) + " (Biaya Admin "+ wallet.adminFee(checkout.total(belanja, express)) +")");
        System.out.println("Kartu Kredit : Rp" + checkout.grandTotal(belanja, express, card) + " (Biaya Admin "+ card.adminFee(checkout.total(belanja, express)) +")");

        System.out.println("\nKebijakan kartu kredit: " + card.policy());
        System.out.println("Kebijakan e-wallet: " + wallet.policy());
        System.out.println("\n== T2: Notifikasi status pesanan==");

        CustomerContact kontak1 = new CustomerContact("ahmad", "ahmad@gmail.com", "081234567890");
        CustomerContact kontak2 = new CustomerContact("siti nurbaya", "ahmad@gmail.com", "1234567890");

        System.out.println(NotificationService.broadcast(kontak1, "Pesanan Anda telah dikirim!"));
        System.out.println(NotificationService.broadcast(kontak2, "Pesanan Anda telah dikirim!"));



    }
}
