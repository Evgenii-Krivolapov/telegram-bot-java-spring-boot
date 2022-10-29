package io.proj3ct.RussianStandardBot.creditCart;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreditCartImperiaPlatinum implements KeyBoardCreditCart {

    public final String CASH_SERVICE_IMPERIA = "Статусная карта с большим кредитным лимитом.";
    public final static String CASHBACK_IMPERIA = "Уникальная бонусная программа «Imperia Rewards».";
    public final String CASHBACK_IMPERIA_ = "БОЛЬШЕ ПОКУПОК — БОЛЬШЕ БАЛЛОВ\n" +
            "\n" +
            "Накапливайте баллы\n" +
            "\n" +
            "— БЕЗ ОГРАНИЧЕНИЙ\n" +
            "1% cashback за покупки от 100 рублей в любой категории.\n" +
            "\n" +
            "— ПОВЫШЕННАЯ СТАВКА\n" +
            "2% cashback за сумму трат, превышающих 200 000 рублей в месяц.\n" +
            "\n" +
            "Получайте вознаграждение\n" +
            "\n" +
            "— ПРОЗРАЧНЫЙ КУРС\n" +
            "1 балл = 1 рубль при оплате любых вознаграждений.\n" +
            "Обратитесь в консьерж-службу и обменяйте накопленные баллы на вознаграждения:\n" +
            "\n" +
            "— Авиа и железнодорожные билеты\n" +
            "— Путешествие по России и заграницу\n" +
            "— Бронирование отелей и апартаментов\n" +
            "— Заказ и доставку подарков";
    public final static String PLAN_IMPERIA = "Неограниченные финансовые возможности с картой «Imperia Platinum».";
    public final String PLAN_IMPERIA_ = "До 3 000 000 ₽ для выгодных покупок\n" +
            "— Кредитная карта дает возможность воспользоваться высоким кредитный кредитным лимитом до 3 000 000 ₽.\n" +
            "\n" +
            "Льготный период до 55 дней\n" +
            "— Проценты по кредиту не начисляются при своевременном погашении всей задолженности.\n" +
            "\n" +
            "Высокий доход\n" +
            "— Возможность моментально открыть накопительный счет Imperia и получать доход до 6% годовых, " +
            "разместив от 30 000 ₽. Пополнение в любой момент и снятие без потери процентов.";

    public final static String SERVICE_IMPERIA = "Сервис на высшем уровне c картой «Imperia Platinum».";
    public final String SERVICE_IMPERIA_ = "Премиальное обслуживание\n" +
            "— Особое отношение и безупречный сервис: " +
            "8 выделенных зон обслуживания в крупных городах и приоритетное обслуживание в офисах банка по всей России.\n" +
            "\n" +
            "Консьерж-служба\n" +
            "— Решит самые разнообразные вопросы от организации незабываемого путешествия до решения бизнес задач 24/7\n" +
            "\n" +
            "Страхование в путешествии\n" +
            "— Вам и вашей семье доступна надежная страховая защита во время путешествий на сумму до 500 000 €. " +
            "Оплатите перелет, отель или аренду автомобиля до начала путешествия картой Imperia Platinum, " +
            "и вы автоматически активируете страхование на все время поездки.\n" +
            "\n" +
            "Выделенная линия\n" +
            "— Специалисты банка незамедлительно решат любые вопросы по карте Imperia Platinum 24/7/365 — достаточно одного звонка.";
    public final static String PRIVILEGE_IMPERIA = "Привлекательные бонусы и скидки c картой «Imperia Platinum».";
    public final String PRIVILEGE_IMPERIA_ = "Скидки у партнеров банка\n" +
            "— Совершайте покупки с выгодой до 30% более чем в 200 магазинах известных брендов.\n" +
            "\n" +
            "Скидка на страховой полис\n" +
            "— Туристический портал travel.rsb.ru. предлагает авиабилеты по выгодным ценам и страховой полис со скидкой 5%.";
    public final static String DOCUMENTS_IMPERIA = "Как получить кредитную карту «Imperia Platinum».";
    public final String DOCUMENTS_IMPERIA_ = "— Карту могут получить граждане России в возрасте от 25 до 65 лет.\n" +
            "\n" +
            "— Для получения необходим паспорт и один из дополнительных документов.\n" +
            "\n" +
            "— Бесплатная доставка по всей России.\n" +
            "\n" +
            "Подать заявку самостоятельно можно через сайт банка: https://anketa.rsb.ru/short/6944/secondTypeShortForm";

    @Override
    public void keyBoardInstallmentPlan(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(PLAN_IMPERIA);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }

    @Override
    public void keyBoardService(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(SERVICE_IMPERIA);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }

    @Override
    public void keyBoardInterest(SendMessage message) {
    }

    @Override
    public void keyBoardCashback(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(CASHBACK_IMPERIA);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }

    @Override
    public void keyBoardPrivilege(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(PRIVILEGE_IMPERIA);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }

    @Override
    public void keyBoardDocuments(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(DOCUMENTS_IMPERIA);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }
}
