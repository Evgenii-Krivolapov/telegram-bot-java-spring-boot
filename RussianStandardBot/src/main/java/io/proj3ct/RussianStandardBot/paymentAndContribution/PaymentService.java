package io.proj3ct.RussianStandardBot.paymentAndContribution;

import org.springframework.stereotype.Component;

@Component
public class PaymentService {

    public final String PAYMENT_CREDIT_ = "Погашение кредита по № договора\n" +
            "\n" +
            "На сайте банка: https://www.rsb.ru/platezhi-perevody/services/credit/pay/";

    public final String PAYMENT_FINE_ = "Оплата штрафов ГИБДД\n" +
            "\n" +
            "На сайте банка: https://www.rsb.ru/platezhi-perevody/services/fines/";
    public final String PAYMENT_ACCOUNTS_ = "Оплата товаров по электронным счетам\n" +
            "\n" +
            "Как оплатить счет:\n" +
            "— Магазины выставляют счета за покупки, а вы оплачиваете их в своем интернет или мобильном банке\n" +
            "\n" +
            "1. Выберите магазин, который может выставлять счета\n" +
            "2. Укажите способ оплаты Web Money®, Robokassa, ИнвойсБокс™, OnPay или Platron\n" +
            "3. Зайдите в интернет- или мобильный банк, чтобы подтвердить оплату";

    public final String TRANSLATION_CASH_ = "Денежный перевод\n" +
            "\n" +
            "На сайте банка: https://www.rsb.ru/platezhi-perevody/s-karty-na-kartu/";
}
