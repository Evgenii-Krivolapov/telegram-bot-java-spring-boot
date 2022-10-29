package io.proj3ct.RussianStandardBot.paymentAndContribution;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContributionMaximum implements KeyBoardContribution {
    public final String PERCENT_MAXIMUM_CONTRIBUTION = "Рекомендуемый вклад «Максимальный»:\n" +
            "— Взнос от: 30 000 ₽\n" +
            "— Ставка: 7.25%\n" +
            "— Срок: 182 дня\n";
    public final static String OPEN_CONTRIBUTION_MAXIMUM = "Как открыть вклад «Максимальный».";
    public final String OPEN_CONTRIBUTION_MAXIMUM_ = "Открыть вклад — просто\n" +
            "Вы можете оформить вклад удобным для вас способом:\n" +
            "\n" +
            "— В любом офисе банка:\n" +
            "Получите профессиональную консультацию и откройте вклад на лучших условиях.\n" +
            "\n" +
            "— В интернет-банке:\n" +
            "Оформите карту Банк в кармане Digital, пополните ее с карты любого банка, " +
            "откройте вклад и пополните его бесплатным переводом с карты Банк в кармане Digital.\n" +
            "\n" +
            "— На сайте банка заполните анкету, курьер привезет документы на подпись, вам откроется доступ к " +
            "интернет банку RSB Online и мобильному банку RSB Mobile с выпущенной картой Банк в кармане Digital. " +
            "Переведите средства с карты любого банка на карту Банк в кармане Digital и с нее на выбранный вклад.\n" +
            "\n " +
            "Подать заявку самостоятельно можно через сайт банка: https://anketa.rsb.ru/card/9869/firstWebForm";

    @Override
    public void keyBoardOpenContribution(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(OPEN_CONTRIBUTION_MAXIMUM);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }
}
