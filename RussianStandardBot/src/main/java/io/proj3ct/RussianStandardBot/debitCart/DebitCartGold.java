package io.proj3ct.RussianStandardBot.debitCart;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Component
public class DebitCartGold implements keyBoardForDebitCart {
    public final String INFO_GOLD = "Карта с весомым доходом и выгодой от покупок";
    public final static String INCOME_GOLD = "Доход с картой «Банк в кармане Gold».";
    public  final String INCOME_GOLD_ = "Получайте прибыль от суммы на счете\n" +
            "\n" +
            "Доход по накопительному счету\n" +
            "— Переведите на накопительный счет от 1000 до 1  млн ₽ и получайте доход 6% годовых.\n" +
            "\n" +
            "Несгораемые проценты\n" +
            "— При снятии денег с накопительного счета начисленные проценты сохраняются.\n" +
            "\n" +
            "Реальный доход\n" +
            "— Доход по накопительному счету рассчитывается ежедневно, а выплачивается — ежемесячно.";
    public  final static String CASHBACK_GOLD = "Cashback c картой «Банк в кармане Gold».";
    public  final String CASHBACK_GOLD_ = "Возвращайте деньги, потраченные на покупки\n" +
            "\n" +
            "— Cashback за покупки у наших партнеров\n" +
            "— В 3-х категориях из 7-ми на выбор\n" +
            "— 1% за остальные покупки\n" +
            "\n" +
            "Минимальная сумма покупок для получения cashback — 5000 ₽ за бонусный период в сумме по всем картам, участвующим в RS Cashback.\n" +
            "\n" +
            "Получайте Cashback бонусы на Туристическом портале travel.rsb.ru\n" +
            "— За бронирование отелей\n" +
            "— За покупку ж/д билетов\n" +
            "— За оплату авиабилетов\n" +
            "\n" +
            "Используйте Cashback бонусы:\n" +
            "— Переводите на карту по курсу 1 cashback бонус — 1 ₽.\n" +
            "— Оплачивайте ЖКХ, ТВ, интернет, мобильную связь и многое другое в интернет-банке.\n" +
            "— Выбирайте товары и подарочные карты из каталога в личном кабинете.";
    public final static String COMFORTABLE_GOLD = "С картой «Банк в кармане Gold» удобно.";
    public  final String COMFORTABLE_GOLD_ = "Годовое обслуживание\n" +
            "— 0₽ со 2-го месяца при ежедневном суммарном остатке от 300 000₽ на счете карты, накопительном счете.\n" +
            "\n" +
            "Наличные без комиссии\n" +
            "— До 300 000 ₽ в день (1 000 000 ₽ в месяц) в банкоматах банка " +
            "и 1 снятие в месяц до 100 000 ₽ в других банкоматах.\n" +
            "\n" +
            "Пополнение карты\n" +
            "— Переводом с карт других банков, в банкоматах, на сайте RS express , " +
            "в интернет - и мобильном банке или наличными в банкоматах и офисах банка.\n" +
            "\n" +
            "Самый эффективный интернет-банк и мобильное приложение\n" +
            "— Оплата услуг без комиссии\n" +
            "— Выгодные переводы\n" +
            "— Управление финансами онлайн\n" +
            "\n" +
            "Приложения для бесконтактной оплаты по картам Mastercard\n" +
            "— Экономия времени\n" +
            "— Повышенная безопасность\n" +
            "— Контроль расходов\n" +
            "\n" +
            "Выгодные покупки\n" +
            "— Совершайте покупки с максимальной выгодой более чем в 200 магазинах известных брендов.\n" +
            "— Выгодные путешествия\n" +
            "— Покупайте авиа и ж/д билеты, бронируйте отели на специальных условиях на Туристическом портале travеl.rsb.ru.";

    public  final static String DOCUMENTS_GOLD = "Как получить дебетовую карту «Банк в кармане Gold».";
    public  final String DOCUMENTS_GOLD_ =
            "Карта «Банк в кармане Gold» оформляется с 18 лет.\n" +
                    "\n" +
                    "МИНИМУМ ДОКУМЕНТОВ\n" +
                    "- Паспорт РФ\n" +
                    "\n" +
                    "БЕСПЛАТНАЯ ДОСТАВКА\n" +
                    "- Курьером по России (возможность доставки карты в ваш населенный пункт уточняйте " +
                    "дополнительно по телефону горячей линии/в чате).\n" +
                    "\n" +
                    "Подать заявку самостоятельно можно через сайт банка: https://anketa.rsb.ru/card/9829/firstWebForm";

    @Override
    public void keyBoardIncome(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(INCOME_GOLD);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }

    @Override
    public void keyBoardCashBack(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(CASHBACK_GOLD);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }

    @Override
    public void keyBoardComfortable(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(COMFORTABLE_GOLD);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }

    @Override
    public void keyBoardDocuments(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(DOCUMENTS_GOLD);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }
}
