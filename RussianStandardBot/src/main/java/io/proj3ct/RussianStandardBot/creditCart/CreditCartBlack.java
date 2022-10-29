package io.proj3ct.RussianStandardBot.creditCart;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;


@Component
public class CreditCartBlack implements KeyBoardCreditCart {
    public final String CASH_SERVICE_BLACK = "Получите до 600 000 рублей для выгодных покупок и снятия наличных.";
    public final static String CASHBACK_BLACK = "Cashback c картой «Back».";
    public final String CASHBACK_SERVICE_BLACK = "10% cashback\n" +
            "в 3-х популярных категориях\n" +
            "Для тех, кто оформит карту до 31 декабряя 2022 года:\n" +
            "— Бытовая техника и электроника\n" +
            "— Магазины спорттоваров\n" +
            "— Отели\n" +
            "\n" +
            "До 25% cashback у партнеров банка\n" +
            "Предложения с максимальной выгодой в более чем 200 магазинах-партнерах.\n" +
            "Подробнее в мобильном банке RSB Mobile\n" +
            "\n" +
            "До 6% cashback\n" +
            "За бронирование отелей, покупку ж/д и авиабилетов на Туристическом портале travel.rsb.ru.\n" +
            "\n" +
            "1% cashback\n" +
            "за остальные покупки.";
    public final static String INTEREST_BLACK = "До 150 дней без % c картой «Black».";
    public final String INTEREST_BLACK_ = "До 150 дней без %\n" +
            "\n" +
            "Для погашения задолженности по кредитным картам других банков. " +
            "Рефинансирование оформляется без комиссии по персональному предложению в мобильном банке " +
            "RSB Mobile или интернет-банке RSB Online.";
    public final static String INSTALLMENT_PLAN_BLACK = "Беспроцентная рассрочка c картой «Black».";
    public final String INSTALLMENT_PLAN_BLACK_ = "0% - беспроцентная рассрочка\n" +
            "\n" +
            "— до 12 месяцев без комиссии у партнеров,\n" +
            "— до 24 месяцев на покупки и снятие наличных с комиссией за оформление.";
    public final static String SERVICE_BLACK = "Бесплатное обслуживание c картой «Black».";
    public final String SERVICE_BLACK_ = "0₽ — обслуживание карты\n" +
            "\n" +
            "Плата не взимается при сумме покупок от 50 000 рублей" +
            "в месяц за счет кредитных и собственных средств, при меньшей — 499 рублей в месяц.";
    public final static String PRIVILEGE_BLACK = "Эксклюзивные привилегии c картой «Black».";
    public final String PRIVILEGE_BLACK_ =
            "Наслаждайтесь премиальным сервисом дома и в путешествиях.\n" +
                    "\n" +
                    "Личный помощник:\n" +
                    "Достаточно одного звонка и профессиональные консьержи выполнят любое поручение:\n" +
                    "\n" +
                    "— Подберут подходящие билеты\n" +
                    "— Арендуют виллу, апартаменты или номер в отеле\n" +
                    "— Забронируют столик в популярном ресторане\n" +
                    "— Позаботятся о прокате автомобиля и яхты\n" +
                    "— Спланируют эксклюзивные экскурсии и досуг\n" +
                    "\n" +
                    "Бесплатное страхование:\n" +
                    "Страховая защита действует автоматически при оплате поездки или проживания картой Black. " +
                    "Для получения полиса направьте запрос на bip‑insurance@rsb.ru.\n" +
                    "\n" +
                    "— Помощь на сумму до 200 000 $\n" +
                    "— Для владельца карты и членов его семьи\n" +
                    "— В России и за рубежом";
    public final static String DOCUMENTS_BLACK = "Как получить кредитную карту «Black».";
    public final String DOCUMENTS_BLACK_ =
            "ПРОСТЫЕ ТРЕБОВАНИЯ\n" +
                    "— Возраст от 21 до 70 лет и постоянная регистрация в регионе присутствия банка.\n" +
                    "\n" +
                    "МИНИМУМ ДОКУМЕНТОВ\n" +
                    "— Паспорт РФ и СНИЛС или другой документ на выбор.\n" +
                    "\n" +
                    "БЕСПЛАТНАЯ ДОСТАВКА\n" +
                    "— Курьером по России (возможность доставки карты в ваш населенный пункт уточняйте " +
                    "дополнительно по телефону горячей линии/в чате).\n" +
                    "\n" +
                    "Подать заявку самостоятельно можно через сайт банка: https://anketa.rsb.ru/card/9687/firstWebForm";

    public void keyBoardDocuments(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(DOCUMENTS_BLACK);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }

    public void keyBoardPrivilege(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(PRIVILEGE_BLACK);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }

    @Override
    public void keyBoardInstallmentPlan(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(INSTALLMENT_PLAN_BLACK);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }

    @Override
    public void keyBoardService(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(SERVICE_BLACK);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }

    @Override
    public void keyBoardInterest(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(INTEREST_BLACK);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }

    @Override
    public void keyBoardCashback(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(CASHBACK_BLACK);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }
}
