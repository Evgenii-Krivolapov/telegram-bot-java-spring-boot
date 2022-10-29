package io.proj3ct.RussianStandardBot.paymentAndContribution;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContributionMonth implements KeyBoardContribution {
    public final String PERCENT_CONTRIBUTION_MONTH = "Вклад с регулярным доходом или капитализацией:\n" +
            "— Сумма вклада от: 30 000 ₽\n" +
            "— Ставка вклада: 6,75%\n" +
            "— Срок вклада: 182, 365 дней\n" +
            "— Валюта вклада: Рубли РФ";
    public final static String OPEN_CONTRIBUTION_MONTH = "Как открыть вклад «Ежемесячный доход».";
    public final String OPEN_CONTRIBUTION_MONTH_ = "Заполните анкету:\n" +
            "— Курьер привезет договор о выпуске бесплатной digital-карты, " +
            "после чего вам будет предоставлен доступ в онлайн-банк.\n" +
            "\n" +
            "Пополните карту:\n" +
            "— Пополните вашу digital-карту переводом с карты любого банка.\n" +
            "\n" +
            "Оформите вклад:\n" +
            "— Выберите вклад и переведите средства с вашей digital-карты\n" +
            "\n" +
            "Подать заявку можно через сайт банка: https://anketa.rsb.ru/card/9869/firstWebForm";

    @Override
    public void keyBoardOpenContribution(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(OPEN_CONTRIBUTION_MONTH);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }
}
