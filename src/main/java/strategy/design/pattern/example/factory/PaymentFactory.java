package strategy.design.pattern.example.factory;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.stereotype.Component;
import strategy.design.pattern.example.model.Receipt;
import strategy.design.pattern.example.model.enums.PaymentMethodEnum;
import strategy.design.pattern.example.strategy.PaymentStrategy;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * The PaymentFactory class is responsible for creating and handling payment strategies
 * based on the payment method provided.
 */
@Component
public class PaymentFactory {
    private final Map<PaymentMethodEnum, PaymentStrategy> paymentStrategies = new HashMap<>();

    /**
     * Constructs a PaymentFactory with the provided payment strategies.
     *
     * @param listableBeanFactory A map of payment method names to PaymentStrategy implementations.
     */
    public PaymentFactory(ListableBeanFactory listableBeanFactory) {
        listableBeanFactory.getBeansOfType(PaymentStrategy.class)
                .values().forEach(service -> paymentStrategies.put(service.getType(),service));
    }

    private PaymentStrategy getStrategy(PaymentMethodEnum paymentMethod) {
        PaymentStrategy paymentStrategy = paymentStrategies.get(paymentMethod);
        if (Objects.isNull(paymentStrategy))
            throw new UnsupportedOperationException(String.format("Invalid Payment Method %s", paymentMethod));
        return paymentStrategy;
    }

    /**
     * Proceeds with the payment using the specified payment method and amount.
     *
     * @param paymentMethod The payment method to be used for the transaction.
     * @param amount        The amount to be paid, represented as a BigDecimal.
     * @return A Receipt object representing the payment transaction.
     * @throws UnsupportedOperationException if the specified payment method is not supported.
     */
    public Receipt proceedPayment(PaymentMethodEnum paymentMethod, BigDecimal amount) {
        return getStrategy(paymentMethod).pay(amount);
    }
}
