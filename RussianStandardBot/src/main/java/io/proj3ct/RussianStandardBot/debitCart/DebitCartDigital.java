package io.proj3ct.RussianStandardBot.debitCart;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Component
public class DebitCartDigital implements keyBoardForDebitCart {
  public   final String INFO_DIGITAL = "Моментальная цифровая карта";
    public  final static String INCOME_DIGITAL = "Доход с картой «Банк в кармане Digital».";
    public  final String INCOME_DIGITAL_ = "Доход по накопительному счету\n" +
            "— Переведите на накопительный счет от 1000 до 10  млн ₽ и получайте доход 6% годовых.\n" +
            "\n" +
            "1 Cashback бонус — 1 ₽\n" +
            "— Переводите Cashback бонусы в рубли и используйте их для оплаты повседневных покупок, " +
            "ЖКУ, ТВ, интернета, мобильной связи и многого другого в интернет- и мобильном банке.\n" +
            "\n" +
            "Реальный доход\n" +
            "— Оформляйте вклады и управляйте ими онлайн, не тратя время на посещение офиса. " +
            "Вся информация по вкладу отразится в мобильном банке.";
    public  final static String COMFORTABLE_DIGITAL = "С картой «Банк в кармане Digital» удобно.";
    public  final String COMFORTABLE_DIGITAL_ = "Сохраняйте свой бюджет\n" +
            "— Без платы за годовое обслуживание.\n" +
            "\n" +
            "Наличные без комиссии\n" +
            "— До 300 000 ₽ в день (300 000 ₽ в месяц) в банкоматах банка.\n" +
            "\n" +
            "Пополняйте бесплатно\n" +
            "— Переводом с карт других банков в интернет- и мобильном банке, в банкоматах банка, " +
            "на сайте RS express. Наличными в банкоматах и офисах банка.\n" +
            "\n" +
            "Самый эффективный интернет-банк и мобильное приложение\n" +
            "— Оплата услуг без комиссии\n" +
            "— Выгодные переводы\n" +
            "— Управление финансами онлайн\n" +
            "\n" +
            "Выгодные покупки\n" +
            "— Совершайте покупки с максимальной выгодой более чем в 200 магазинах известных брендов.\n" +
            "\n" +
            "Выгодные путешествия\n" +
            "— Покупайте авиа и ж/д билеты, бронируйте отели на специальных условиях на Туристическом портале travеl.rsb.ru.\n" +
            "\n" +
            "Акции платежных систем\n" +
            "— Специальные предложения программы лояльности «Мир» порадуют при оплате услуг и покупок.";
    public final static String DOCUMENTS_DIGITAL = "Как получить дебетовую карту «Банк в кармане Digital».";
    public final String DOCUMENTS_DIGITAL_ =
            "Карта «Банк в кармане Digital» — это инновационный и максимально удобный платежный инструмент, который представляет\n" +
                    "собой виртуальную карту без физического носителя.\n" +
                    "\n" +
                    "Вы можете оформить её в нашем мобильном приложении.";

    @Override
    public void keyBoardIncome(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(INCOME_DIGITAL);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);

    }

    @Override
    public void keyBoardCashBack(SendMessage message) {
    }

    @Override
    public void keyBoardComfortable(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(COMFORTABLE_DIGITAL);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }

    @Override
    public void keyBoardDocuments(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(DOCUMENTS_DIGITAL);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }
}
