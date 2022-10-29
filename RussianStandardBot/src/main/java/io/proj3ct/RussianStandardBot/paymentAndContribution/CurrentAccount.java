package io.proj3ct.RussianStandardBot.paymentAndContribution;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Component
public class CurrentAccount {
    public final String CURRENT_ACCOUNT_SERVICE = "Преимущества Накопительного счета:\n" +
            "\n" +
            "— Снятие и пополнение без потери процентов\n" +
            "— Ежемесячная выплата процентов\n" +
            "— Начисление процентов на ежедневный остаток";
    public final static String CURRENT_ACCOUNT_PERCENT = "Проценты по Накопительному счету.";
    public final String CURRENT_ACCOUNT_PERCENT_ = "- От 0,01 до 999,99 (включительно) - 0,01%\n" +
            "— От 1 000,00 до 1 000 000,00 (включительно)- 6%\n" +
            "— На часть суммы в размере, равном 1 000 000,00 - 6%\n" +
            "— На часть суммы, превышающую 1 000 000,00 - 3,75%";
    public final static String OPEN_CURRENT_ACCOUNT = "Как открыть Накопительный счёт.";
    public final String OPEN_CURRENT_ACCOUNT_ = "Открытие счета в мобильном банке RSB Mobile\n" +
            "1. Войдите в мобильный банк RSB Mobile.\n" +
            "2. Нажмите «Открыть новый продукт».\n" +
            "3. Выберите «Открыть счет».\n" +
            "4. Переведите средства с дебетовой карты.\n" +
            "\n" +
            "Скачать приложение банка: https://www.rsb.ru/remote/mobile/";

    public void keyBoardOpen(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(OPEN_CURRENT_ACCOUNT);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }

    public void keyBoardPercent(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(CURRENT_ACCOUNT_PERCENT);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }
}
