package io.proj3ct.RussianStandardBot.debitCart;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Component
public class DebitCartPensionMip implements keyBoardForDebitCart {
    public final String INFO_PENSION_MIP = "Карта для получения пенсии";

    public final static String INCOME_PENSION_MIP = "Доход с «Пенсионной картой МИР».";
    public final String INCOME_PENSION_MIP_ = "Доход по накопительному счету\n" +
            "— Переведите на накопительный счет от 1000 до 1  млн ₽ и получайте доход 6% годовых.\n" +
            "\n" +
            "Несгораемые проценты\n" +
            "— При снятии денег с накопительного счета начисленные проценты сохраняются.\n" +
            "\n" +
            "Реальный доход\n" +
            "— Доход по накопительному счету рассчитывается ежедневно, а выплачивается — ежемесячно.\n" +
            "\n" +
            "Переведите пенсию на вашу карту любым удобным способом\n" +
            "— Онлайн в личном кабинете на портале «Госуслуги» по инструкции.\n" +
            "— Онлайн на сайте Пенсионного фонда России.\n" +
            "— В Многофункциональном центре предоставления государственных услуг (МФЦ).\n" +
            "— В территориальном органе Пенсионного фонда России.";
    public final static String CASHBACK_PENSION_MIP = "Cashback c «Пенсионной картой МИР».";
    public final String CASHBACK_PENSION_MIP_ = "Возвращайте деньги, потраченные на покупки\n" +
            "\n" +
            "До 20% у партнеров программы «Мир»\n" +
            "— За покупки в супермаркетах и небольших магазинах, в кафе у дома, на АЗС и в различных " +
            "сервисных предприятиях — cashback зачисляется прямо на карту. \n" +
            "\n" +
            "1% по программе RS Cashback\n" +
            "— Получайте обратно 1%, потраченный на покупки в 3-х категориях, которые меняются раз в " +
            "три месяца: прокат авто, отели, Технопарк.";
    public final static String DOCUMENTS_PENSION_MIP = "Как получить дебетовую «Пенсионную карту МИР».";
    public final String DOCUMENTS_PENSION_MIP_ = "Пенсионную карту «Мир» могут оформить граждане России.\n" +
            "\n" +
            "Необходимые документы:\n" +
            "— Для женщин от 55 лет и мужчин от 60 лет только паспорт.\n" +
            "— Для лиц от 18 лет — паспорт и второй документ из списка:\n" +
            "\n" +
            "Удостоверение:\n" +
            "— Пенсионное\n" +
            "— Участника ликвидации аварии на ЧАЭС\n" +
            "— Ветерана труда\n" +
            "— Ветерана боевых действий\n" +
            "— Многодетной семьи\n" +
            "— Многодетного родителя\n" +
            "\n" +
            "БЕСПЛАТНАЯ ДОСТАВКА\n" +
            "— Курьером по России (возможность доставки карты в ваш населенный пункт уточняйте " +
            "дополнительно по телефону горячей линии/в чате).\n" +
            "\n" +
            "Подать заявку самостоятельно можно через сайт банка: https://anketa.rsb.ru/card/9641/firstWebForm";

    public final static String COMFORTABLE_PENSION_MIP = "С «Пенсионной картой МИР» удобно.";
    public final String COMFORTABLE_PENSION_MIP_ = "Самый эффективный интернет-банк и мобильное приложение\n" +
            "— Оплата услуг без комиссии\n" +
            "— Выгодные переводы\n" +
            "— Управление финансами онлайн\n" +
            "\n" +
            "Современный и удобный мобильный банк RSB Mobile\n" +
            "— Экономия времени\n" +
            "— Повышенная безопасность\n" +
            "— Контроль расходов\n" +
            "\n" +
            "Выгодные покупки\n" +
            "— Совершайте покупки с максимальной выгодой более чем в 200 магазинах известных брендов.\n" +
            "\n" +
            "Выгодные путешествия\n" +
            "— Покупайте авиа- и железнодорожные билеты, бронируйте отели на Туристическом портале " +
            "travеl.rsb.ru и получайте обратно до 6% стоимости.\n" +
            "\n" +
            "Акции платежных систем\n" +
            "— Специальные предложения и программы лояльности «Мир» порадуют при оплате услуг и покупок.";

    @Override
    public void keyBoardIncome(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(INCOME_PENSION_MIP);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }

    @Override
    public void keyBoardCashBack(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(CASHBACK_PENSION_MIP);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }

    @Override
    public void keyBoardComfortable(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(COMFORTABLE_PENSION_MIP);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }

    @Override
    public void keyBoardDocuments(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(DOCUMENTS_PENSION_MIP);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }
}
