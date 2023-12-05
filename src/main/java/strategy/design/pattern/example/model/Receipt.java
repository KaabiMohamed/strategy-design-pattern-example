package strategy.design.pattern.example.model;

import lombok.Builder;
import lombok.Data;
import strategy.design.pattern.example.model.enums.PaymentMethodEnum;

import java.math.BigDecimal;

/**
 * The Receipt class represents a receipt for a payment transaction.
 */
@Data
@Builder
public class Receipt {

    /**
     * The total amount of the payment transaction.
     */
    BigDecimal amount;

    /**
     * The payment method used for the transaction, represented as a PaymentMethodEnum.
     */
    PaymentMethodEnum paymentMethod;
}
