package io.proj3ct.RussianStandardBot.paymentAndContribution;

import org.springframework.stereotype.Component;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;


import java.util.ArrayList;
import java.util.List;


@Component
public class Account {
    public final String ACCOUNT_SERVICE = "Вы выбрали Текущий счёт";
    public final static String ACCOUNT_ADVANTAGES = "Преимущества Текущего счета";
    public final String ACCOUNT_ADVANTAGES_ = "Безопасное хранение:\n" +
            "— Текущий счет не привязан к карте доступ к нему имеете только вы. Денежные средства" +
            "застрахованы и находятся под надежной защитой.\n" +
            "\n" +
            "Быстрые переводы:\n" +
            "— Между счетами в Банке Русский Стандарт, на счета других банков в России и за границей.\n" +
            "\n" +
            "Удобные способы пополнения:\n" +
            "— Безналичным переводом или наличными через банкоматы и кассы банка.";
    public final static String NEED_ACCOUNT = "Для чего нужен валютный перевод.";

    public final String NEED_ACCOUNT_ = "— Отправить средства на свой счет в российском или иностранном банке.\n" +
            "\n" +
            "— Отправить деньги родственникам и друзьям, проживающим за границей.\n" +
            "\n" +
            "— Оплатить покупки в зарубежных магазинах, проживание в отелях, трансфер, учебу, отдых или участие в " +
            "конференциях за границей.\n" +
            "\n" +
            "— Отправить денежные средства брокеру.\n" +
            "\n" +
            "— Чтобы перевести денежные средства на валютный счет, обратитесь в ближайший офис Банка Русский Стандарт.";

    public final static String DOCUMENTS_ACCOUNT = "Необходимые документы.";
    public final String DOCUMENTS_ACCOUNT_ = "— Паспорт или другой документ, удостоверяющий личность.\n" +
            "\n" +
            "— Полное имя получателя или полное наименование организации-получателя.\n" +
            "\n" +
            "— Номер счёта или IBAN (для стран Евросоюза).\n" +
            "\n" +
            "— SWIFT-код/ BIC банка получателя или полное наименования и адрес банка, в котором ваш адресат получит деньги.";
    public final static String OPEN_ACCOUNT = "Как открыть Текущий счёт";
    public final String OPEN_ACCOUNT_ = "1. Обратитесь в ближайший офис банка с паспортом или другим документом, " +
            "удостоверяющим личность (для иностранного гражданина)\n" +
            "2. Подпишите догово об открытии счета\n" +
            "3. Внесите сумму в валюте своего счета\n" +
            "\n" +
            "Офисы Банка Русский Стандарт: https://www.rsb.ru/about/branch/moscow/";

    public void keyBoardOpen(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(OPEN_ACCOUNT);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }

    public void keyBoardDocuments(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(DOCUMENTS_ACCOUNT);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }

    public void keyBoardNeed(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(NEED_ACCOUNT);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }

    public void keyBoardAdvantages(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(ACCOUNT_ADVANTAGES);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }
}
