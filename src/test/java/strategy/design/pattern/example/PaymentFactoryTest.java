package strategy.design.pattern.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import strategy.design.pattern.example.factory.PaymentFactory;
import strategy.design.pattern.example.model.Receipt;
import strategy.design.pattern.example.model.enums.PaymentMethodEnum;

import java.math.BigDecimal;

/**
 * The PaymentFactoryTest class contains test cases for the PaymentFactory class.
 */
@SpringBootTest
public class PaymentFactoryTest {

    @Autowired
    PaymentFactory paymentFactory;

    /**
     * Test if PayPal payment proceeds successfully.
     */
    @Test
    void givenPaypalPaymentMethod_whenProceedPayment_thenSuccess() {
        PaymentMethodEnum paymentMethod = PaymentMethodEnum.PAYPAL;
        BigDecimal amount = new BigDecimal(100);
        Receipt response = paymentFactory.proceedPayment(paymentMethod, amount);
        Assertions.assertEquals(paymentMethod, response.getPaymentMethod());
        Assertions.assertEquals(amount, response.getAmount());
    }

    /**
     * Test if Credit Card payment proceeds successfully.
     */
    @Test
    void givenCreditCardPaymentMethod_whenProceedPayment_thenSuccess() {
        PaymentMethodEnum paymentMethod = PaymentMethodEnum.CREDIT_CARD;
        BigDecimal amount = new BigDecimal(200);
        Receipt response = paymentFactory.proceedPayment(paymentMethod, amount);
        Assertions.assertEquals(paymentMethod, response.getPaymentMethod());
        Assertions.assertEquals(amount, response.getAmount());
    }

    /**
     * Test if UnsupportedOperationException is thrown for an unimplemented Cash on Delivery payment method.
     */
    @Test
    void givenCashOnDeliveryPaymentMethod_whenProceedPayment_thenThrowUnsupportedOperationException() {
        PaymentMethodEnum paymentMethod = PaymentMethodEnum.CASH_ON_DELIVERY;
        BigDecimal amount = new BigDecimal(300);
        Assertions.assertThrowsExactly(UnsupportedOperationException.class, () -> {
            paymentFactory.proceedPayment(paymentMethod, amount);
        });
    }

    /**
     * Test if UnsupportedOperationException is thrown for an unknown payment method.
     */
    @Test
    void givenUnknownPaymentMethod_whenProceedPayment_thenThrowUnsupportedOperationException() {
        PaymentMethodEnum unknownPaymentMethod = PaymentMethodEnum.CASH_ON_DELIVERY;
        BigDecimal amount = new BigDecimal(300);
        Assertions.assertThrowsExactly(UnsupportedOperationException.class, () -> {
            paymentFactory.proceedPayment(unknownPaymentMethod, amount);
        });
    }
}
