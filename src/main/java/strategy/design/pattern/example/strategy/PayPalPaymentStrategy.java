package strategy.design.pattern.example.strategy;

import org.springframework.stereotype.Service;
import strategy.design.pattern.example.model.Receipt;
import strategy.design.pattern.example.model.enums.PaymentMethodEnum;

import java.math.BigDecimal;

/**
 * A concrete implementation of the PaymentStrategy interface for processing PayPal payments.
 * This class is annotated with @Service to indicate that it is a Spring service component.
 */
@Service
public class PayPalPaymentStrategy implements PaymentStrategy {

    /**
     * Processes a payment using PayPal for the specified 'amount'.
     *
     * @param amount The amount to be paid, represented as a BigDecimal.
     * @return A Receipt object representing the payment transaction with the PaymentMethodEnum set to PAYPAL.
     */
    @Override
    public Receipt pay(BigDecimal amount) {
        return Receipt.builder()
                .amount(amount)
                .paymentMethod(PaymentMethodEnum.PAYPAL)
                .build();
    }

    @Override
    public PaymentMethodEnum getType() {
        return PaymentMethodEnum.PAYPAL;
    }
}
