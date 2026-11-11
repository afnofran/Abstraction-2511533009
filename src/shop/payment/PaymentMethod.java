package shop.payment;
/** Contract for every payment method. */
public interface PaymentMethod {
    String getName();
    /** @return true if the payment succeeds */
    boolean pay(long amount);

    // default long adminFee(long nilai){
    //     return nilai;
    // }
    default long adminFee(long nilai) {
        return 0;
    }
}