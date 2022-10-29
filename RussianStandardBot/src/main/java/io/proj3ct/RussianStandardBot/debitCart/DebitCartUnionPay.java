package io.proj3ct.RussianStandardBot.debitCart;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Component
public class DebitCartUnionPay implements keyBoardForDebitCart {
    public final String INFO_UNION = "Карта для покупок и путешествий по всему миру.";
    public final static String INCOME_UNION_PAY = "Доход с картой «UnionPay».";
    public final String INCOME_UNION_PAY_ = "Доход по накопительному счету\n" +
            "— Переведите на накопительный счет от 1000₽ до 1 млн ₽ и получайте доход 6% годовых.\n" +
            "\n" +
            "Несгораемые проценты\n" +
            "— При снятии денег с накопительного счета начисленные проценты сохраняются.\n" +
            "\n" +
            "Реальный доход\n" +
            "— Доход по накопительному счету рассчитывается ежедневно, а выплачивается — ежемесячно.";
    public final static String CASHBACK_PAY = "Cashback c картой «Union Pay».";
    public final String CASHBACK_UNION_ = " В 3-х выбранных категориях\n" +
            "— Категории меняются каждые 3 месяца.\n" +
            "— До 25% у партнеров банка\n" +
            "— 1% за остальные покупки\n" +
            "\n" +
            "Cashback начисляется только за покупки на территории РФ.\n" +
            "Минимальная сумма покупок для получения cashback — 5000₽ за бонусный период в сумме " +
            "по всем картам, участвующим в RS Cashback.\n" +
            "\n" +
            "Получайте Cashback бонусы на Туристическом портале travel.rsb.ru\n" +
            "— За бронирование отелей\n" +
            "— За покупку ж/д билетов\n" +
            "— За оплату авиабилетов\n" +
            "\n" +
            "Используйте Cashback бонусы:\n" +
            "— Переводите на карту по курсу 1 cashback бонус — 1₽.\n" +
            "— Оплачивайте ЖКХ, ТВ, интернет, мобильную связь и многое другое в интернет-банке.\n" +
            "— Выбирайте товары и подарочные карты из каталога в личном кабинете.";
    public final static String COMFORTABLE_UNION_PAY = "С картой «UnionPay» удобно.";
    public final String COMFORTABLE_UNION_PAY_ = "Путешествие:\n" +
            "— Пользуйтесь картой UnionPay в России и еще 180 странах и регионах, " +
            "включая Китай, ЮВА, Турцию, СНГ, ОАЭ и Ближний Восток.\n" +
            "\n" +
            "Онлайн-платежи:\n" +
            "Самый эффективный интернет-банк и мобильное приложение\n" +
            "— Оплата услуг без комиссии\n" +
            "— Выгодные переводы\n" +
            "— Управление финансами онлайн\n" +
            "\n" +
            "Акции:\n" +
            "Выгодные покупки\n" +
            "— Совершайте покупки с максимальной выгодой более чем в 200 магазинах известных брендов.\n" +
            "Акции платежных систем\n" +
            "— Специальные предложения платежной системы UnionPay.";
    public final static String DOCUMENT_UNION = "Как получить дебетовую карту «UnionPay».";
    public final String DOCUMENT_UNION_ =
            "Карта «UnionPay» оформляется с 18 лет.\n" +
                    "\n" +
                    "МИНИМУМ ДОКУМЕНТОВ\n" +
                    "— Паспорт РФ\n" +
                    "\n" +
                    "БЕСПЛАТНАЯ ДОСТАВКА\n" +
                    "— Курьером по России (возможность доставки карты в ваш населенный пункт уточняйте " +
                    "дополнительно по телефону горячей линии/в чате).\n" +
                    "\n" +
                    "Подать заявку самостоятельно можно через сайт банка: https://anketa.rsb.ru/card/9932/firstWebForm";

    @Override
    public void keyBoardIncome(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(INCOME_UNION_PAY);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }

    @Override
    public void keyBoardCashBack(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(CASHBACK_PAY);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }

    @Override
    public void keyBoardComfortable(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(COMFORTABLE_UNION_PAY);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }

    @Override
    public void keyBoardDocuments(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(DOCUMENT_UNION);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }
}
