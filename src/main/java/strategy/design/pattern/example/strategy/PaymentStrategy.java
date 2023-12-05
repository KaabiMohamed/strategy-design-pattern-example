/**
 * The PaymentStrategy interface defines a contract for implementing different payment strategies.
 * Classes that implement this interface must provide an implementation for the 'pay' method,
 * which takes a BigDecimal 'amount' as input and returns a Receipt object representing the
 * payment transaction.
 */
package strategy.design.pattern.example.strategy;

import strategy.design.pattern.example.model.Receipt;

import java.math.BigDecimal;

public interface PaymentStrategy {

    /**
     * Performs a payment transaction with the specified 'amount'.
     *
     * @param amount The amount to be paid, represented as a BigDecimal.
     * @return A Receipt object representing the payment transaction.
     */
    Receipt pay(BigDecimal amount);
}
