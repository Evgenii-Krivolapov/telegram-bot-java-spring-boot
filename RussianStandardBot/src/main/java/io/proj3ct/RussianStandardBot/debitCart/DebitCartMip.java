package io.proj3ct.RussianStandardBot.debitCart;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Component
public class DebitCartMip implements keyBoardForDebitCart {
    public final String INFO_MIP = "Карта национальной платежной системы «Мир».";
    public final static String INCOME_MIP = "Доход с картой «Мир».";
    public final String INCOME_MIP_ = "Доход по накопительному счету\n" +
            "— Переведите на накопительный счет от 1000 до 1  млн ₽ и получайте доход 6% годовых.\n" +
            "\n" +
            "Несгораемые проценты\n" +
            "— При снятии денег с накопительного счета начисленные проценты сохраняются.\n" +
            "\n" +
            "Реальный доход\n" +
            "— Доход по накопительному счету рассчитывается ежедневно, а выплачивается — ежемесячно.";
    public final static String CASHBACK_MUP = "Cashback c картой «МИР».";
    public final String CASHBACK_MUP_ = "До 20% у партнеров программы «Мир»\n" +
            "— За покупки в супермаркетах и небольших магазинах, в кафе у дома, на АЗС " +
            "и в различных сервисных предприятиях — cashback зачисляется прямо на карту. \n" +
            "\n" +
            "1% по программе RS Cashback\n" +
            "— Получайте обратно 1%, потраченный на покупки в 3-х категориях," +
            "которые меняются раз в три месяца: прокат авто, отели, Технопарк.";
    public final static String COMFORTABLE_MIP = "С картой «МИР» удобно.";
    public final String COMFORTABLE_MIP_ = "Выгодные покупки\n" +
            "— Совершайте покупки с максимальной выгодой более чем в 200 магазинах известных брендов.\n" +
            "\n" +
            "Выгодные путешествия\n" +
            "— Покупайте авиа и ж/д билеты, бронируйте отели на специальных условиях на Туристическом портале travеl.rsb.ru.\n" +
            "\n" +
            "Акции платежных систем\n" +
            "— Специальные предложения программы лояльности «Мир» порадуют при оплате услуг и покупок.";
    public final static String DOCUMENT_MUP = "Как получить дебетовую карту «Мир».";
    public final String DOCUMENT_MUP_ =
            "Карта «Мир» оформляется с 18 лет.\n" +
                    "\n" +
                    "МИНИМУМ ДОКУМЕНТОВ\n" +
                    "— Паспорт РФ\n" +
                    "\n" +
                    "БЕСПЛАТНАЯ ДОСТАВКА\n" +
                    "— Курьером по России (возможность доставки карты в ваш населенный пункт уточняйте " +
                    "дополнительно по телефону горячей линии/в чате).\n" +
                    "\n" +
                    "Подать заявку самостоятельно можно через сайт банка: https://anketa.rsb.ru/card/9199/firstWebForm";

    @Override
    public void keyBoardIncome(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(INCOME_MIP);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }

    @Override
    public void keyBoardCashBack(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(CASHBACK_MUP);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }

    @Override
    public void keyBoardComfortable(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(COMFORTABLE_MIP);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }

    @Override
    public void keyBoardDocuments(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(DOCUMENT_MUP);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }
}
