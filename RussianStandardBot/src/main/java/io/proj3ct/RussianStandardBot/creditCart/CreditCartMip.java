package io.proj3ct.RussianStandardBot.creditCart;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class CreditCartMip implements KeyBoardCreditCart {
    public final String CASH_SERVICE_MIP = "Получите до 299 000 рублей для выгодных покупок и снятия наличных.";
    public final static String INTEREST_MIP = "До 150 дней без % c картой «МИР+».";
    public final static String CASHBACK_MIP = "Cashback c картой «МИР+».";
    public final static String SERVICE_MIP = "Бесплатное обслуживание c картой «МИР+».";
    public final String SERVICE = "0₽ обслуживание\n" +
            "\n" +
            "Не взимается при сумме покупок от 15 000 рублей в месяц за счет кредитных и собственных средств," +
            " при меньшей — 99 рублей в месяц.";

    public final String INTEREST_SERVICE_MIP = "До 150 дней без %\n" +
            "\n" +
            "Для погашения задолженности по кредитным картам других банков. " +
            "Рефинансирование оформляется без комиссии по персональному предложению в мобильном банке " +
            "RSB Mobile или интернет-банке RSB Online.";
    public final String CASHBACK_SERVICE_MIP = "5% cashback\n" +
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

    public final static String PLAN_MIP = "Беспроцентная рассрочка c картой «МИР+».";
    public final String PLAN_MIP_ = "0% - беспроцентная рассрочка\n" +
            "\n" +
            "— до 12 месяцев без комиссии у партнеров\n" +
            "— до 24 месяцев на покупки и снятие наличных с комиссией за оформление";
    public final static String DOCUMENTS_MIP = "Как получить кредитную карту «МИР+».";
    public final String DOCUMENTS_MIP_ =
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
                    "Подать заявку самостоятельно можно через сайт банка: https://anketa.rsb.ru/card/9696/firstWebForm";

    @Override
    public void keyBoardInstallmentPlan(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(PLAN_MIP);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }

    @Override
    public void keyBoardService(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(SERVICE_MIP);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }

    @Override
    public void keyBoardInterest(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(INTEREST_MIP);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }

    @Override
    public void keyBoardCashback(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(CASHBACK_MIP);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }

    @Override
    public void keyBoardPrivilege(SendMessage message) {

    }

    @Override
    public void keyBoardDocuments(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(DOCUMENTS_MIP);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }
}