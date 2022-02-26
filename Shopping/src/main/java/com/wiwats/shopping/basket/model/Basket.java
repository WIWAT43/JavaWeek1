package com.wiwats.shopping.basket.model;

import com.wiwats.shopping.payment.model.PaymentTransaction;
import com.wiwats.shopping.payment.model.UserPayment;
import com.wiwats.shopping.product.model.Product;
import com.wiwats.shopping.user.model.User;
import lombok.Data;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;

@Data
@Entity
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long basketId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int productUnit = 0;

    private Long userAddressID = 0L;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    private UserPayment userPayment;

    @ManyToOne
    @JoinColumn(name = "transaction_id")
    private PaymentTransaction paymentTransaction;

    private int paymentStatus=0;


    public void addBasketItem(Long basketId, User user, Product product,int productUnit) {
        this.basketId = basketId;
        this.user = user;
        this.product = product;
        this.productUnit = productUnit;
    }
    public String toReturnString() {
        return "Basket{" +
                "basketId=" + basketId +
                ", user=" + user.getUserId() +
                ", product=" + product.getProductId() +
                ", product_name=" + product.getName() +
                ", productUnit=" + productUnit +
                '}';
    }

    public void addPaymentTransaction (PaymentTransaction paymentTransaction){
        this.paymentTransaction = paymentTransaction;
        this.paymentStatus = 1;
    }

    public void setUserAddressID(Long userAddressID) {
        this.userAddressID = userAddressID;
    }
}
