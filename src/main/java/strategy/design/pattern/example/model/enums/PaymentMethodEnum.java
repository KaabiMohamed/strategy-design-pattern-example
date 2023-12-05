package strategy.design.pattern.example.model.enums;

import lombok.Getter;

/**
 * Enumeration representing different payment methods.
 */
@Getter
public enum PaymentMethodEnum {
    /**
     * Represents the PayPal payment method.
     */
    PAYPAL("PAYPAL"),

    /**
     * Represents the Cash on Delivery payment method.
     */
    CASH_ON_DELIVERY("CASH_ON_DELIVERY"),

    /**
     * Represents the Credit Card payment method.
     */
    CREDIT_CARD("CREDIT_CARD");

    /**
     * The label associated with the payment method.
     */
    public final String label;

    /**
     * Constructor to initialize the payment method with a label.
     *
     * @param label The label associated with the payment method.
     */
    PaymentMethodEnum(String label) {
        this.label = label;
    }
}
