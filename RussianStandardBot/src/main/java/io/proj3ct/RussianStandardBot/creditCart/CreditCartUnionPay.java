package io.proj3ct.RussianStandardBot.creditCart;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreditCartUnionPay implements KeyBoardCreditCart {

    public final String CASH_SERVICE_UNION_PAY = "Получите до 600 000 рублей для выгодных покупок, снятия наличных и путешествий по всему миру";
    public final static String PLAN_UNION_PAY = "Беспроцентная рассрочка c картой «UnionPay».";
    public final String INSTALLMENT_PLAN_UNION_PAY = "0% — беспроцентная рассрочка\n" +
            "\n" +
            "— до 12 месяцев без комиссии у партнеров\n" +
            "— до 24 месяцев на покупки и снятие наличных с комиссией за оформление";
    public  final static String SERVICE_UNION = "Бесплатное обслуживание c картой «UnionPay».";
    public  final String SERVICE_UNION_PAY = "0₽ Обслуживание карты\n" +
            "\n" +
            "Плата не взимается при сумме покупок от 50 000 рублей за расчетный период за счет кредитных и собственных средств, " +
            "при меньшей — 499 рублей в месяц.";
    public final static String INTEREST_UNION_PAY = "До 150 дней без % c картой «UnionPay».";
    public  final String INTEREST_SERVICE_UNION_PAY = "До 150 дней без %\n" +
            "\n" +
            "Для погашения задолженности по кредитным картам других банков. " +
            "Рефинансирование оформляется без комиссии по персональному предложению в мобильном банке " +
            "RSB Mobile или интернет-банке RSB Online.";
    public final static String CASHBACK_UNION_PAY = "Cashback c картой «UnionPay».";
    public  final String CASHBACK_SERVICE_UNION_PAY = "5% cashback\n" +
            "в избранных категориях\n" +
            "\n" +
            "Повышенный cashback в 3-х выбранных категориях из 7-ми.\n" +
            "Для тех, кто оформит карту с 01.10.2022 по 31.12.2022.\n" +
            "\n" +
            "— Одежда и обувь\n" +
            "— Кафе, рестораны, фастфуд\n" +
            "— Бытовая техника и электроника\n" +
            "— Аптеки\n" +
            "— Магазины косметики\n" +
            "— Магазины спорттоваров\n" +
            "— Такси\n" +
            "\n" +
            "До 25 % cashback и скидки\n" +
            "У партнеров банка и платежной системы (при регистрации карты в программе лояльности «Привет, мир!»)\n" +
            "\n" +
            "1 % сashback\n" +
            "За остальные покупки.";
    public final static String PRIVILEGE_UNION_PAY = "Удобно дома и в путешествиях c картой «UnionPay».";
    public  final String PRIVILEGE_UNION_PAY_ =
            "Пользуйтесь картой UnionPay в России и в 180 странах и регионах, включая Китай, ЮВА, " +
                    "Турцию, СНГ, ОАЭ и Ближний Восток.\n" +
                    "\n" +
                    "Бесплатное страхование\n" +
                    "Страховая защита действует автоматически при оплате поездки или проживания картой UnionPay. Для получения полиса направьте запрос на bip‑insurance@rsb.ru.\n" +
                    "\n" +
                    "— Помощь на сумму до 200 000 $\n" +
                    "— Для владельца карты и членов его семьи\n" +
                    "— В России и за рубежом";
    public final static String DOCUMENTS_UNION_PAY = "Как получить кредитную карту «UnionPay».";
    public  final String DOCUMENTS_UNION_PAY_ =
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
                    "Подать заявку самостоятельно можно через сайт банка: https://anketa.rsb.ru/card/9819/firstWebForm";

    @Override
    public void keyBoardInstallmentPlan(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(PLAN_UNION_PAY);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }

    @Override
    public void keyBoardService(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(SERVICE_UNION);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }

    @Override
    public void keyBoardInterest(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(INTEREST_UNION_PAY);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }

    @Override
    public void keyBoardCashback(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(CASHBACK_UNION_PAY);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }

    @Override
    public void keyBoardPrivilege(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(PRIVILEGE_UNION_PAY);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }

    @Override
    public void keyBoardDocuments(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(DOCUMENTS_UNION_PAY);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }
}