package io.proj3ct.RussianStandardBot.creditCart;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreditCartMipSupreme implements KeyBoardCreditCart {
    public final String CASH_SERVICE_MIP_SUPREME = "Получите до 600 000 рублей для выгодных покупок и снятия наличных.";
    public final static String CASHBACK_MIP_SUPREME = "Cashback c картой «Мир Supreme».";
    public final String CASHBACK_MIP_SUPREME_ = "Держатели карт Мир Supreme вернут 5% от стоимости покупок в категории «Рестораны» " +
            "и 1,5% за остальные покупки.\n" +
            "\n" +
            "Получайте cashback:\n" +
            "\n" +
            "1. 5% от платежной системы «Мир» в популярной категории «Рестораны»:\n" +
            "\n" +
            "— Начисляется в рублях на счет карты единым платежом до 20 числа месяца, следующего за месяцем покупок\n" +
            "— Категория повышенного сashback может измениться.\n" +
            "— Если доля покупок в указанной категории превышает 30% от общей суммы покупок в месяц, cashback начисляется " +
            "только на сумму, не превышающую 30%\n" +
            "— Максимальная сумма выплат в календарный месяц — 5 000 рублей.\n" +
            "\n" +
            "2. До 1,5% сashback бонусов за покупки, в рамках условий программы лояльности RS Cashback.\n" +
            "\n" +
            "— Cashback бонусы будут зачислены на бонусный счет по окончании бонусного периода.\n" +
            "— Максимальное начисление — 10 000 Cashback бонусов за бонусный период\n" +
            "— Минимальная сумма покупок по карте Мир Supreme для зачисления Cashback бонусов — 10 000 ₽ в течение бонусного периода.\n" +
            "\n" +
            "3. До 25% cashback\n" +
            "\n" +
            "Особые предложения с максимальной выгодой для владельцев премиальных карт «Мир Supreme».";
    public final static String INTEREST_MIP_SUPREME = "До 150 дней без % c картой «Мир Supreme».";
    public final String INTEREST_MIP_SUPREME_ = "До 150 дней без %\n" +
            "\n" +
            "Для погашения задолженности по кредитным картам других банков. " +
            "Рефинансирование оформляется без комиссии по персональному предложению в мобильном банке " +
            "RSB Mobile или интернет-банке RSB Online.";
    public final static String SERVICE_MIP_SUPREME = "Бесплатное обслуживание c картой «Мир Supreme».";
    public final String SERVICE_MIP_SUPREME_ = "0₽ обслуживание\n" +
            "\n" +
            "Плата за обслуживание не взимается при сумме покупок от 50 000 рублей в месяц за счет кредитных и " +
            "собственных средств, при меньшей — 499 рублей в месяц.";
    public final static String INSTALLMENT_PLAN_MIP_SUPREME = "Беспроцентная рассрочка c картой «Мир Supreme».";
    public final String INSTALLMENT_PLAN_MIP_SUPREME_ = "0% — беспроцентная рассрочка\n" +
            "\n" +
            "— до 12 месяцев без комиссии у партнеров\n" +
            "— до 24 месяцев на покупки и снятие наличных с комиссией за оформление";
    public final static String PRIVILEGE_MIP_SUPREME = "Привилегии c картой «Мир Supreme».";
    public final String PRIVILEGE_MIP_SUPREME_ = "Больше комфорта — больше выгоды\n" +
            "Привилегии в путешествиях по всему миру c картой «Мир Supreme».\n" +
            "\n" +
            "Личный помощник:\n" +
            "Достаточно одного звонка и профессиональные консьержи выполнят любое поручение и организуют путешествие:\n" +
            "\n" +
            "— Подберут подходящие билеты\n" +
            "— Арендуют виллу, апартаменты или номер в отеле\n" +
            "— Забронируют столик в популярном ресторане\n" +
            "— Позаботятся о прокате автомобиля и яхты\n" +
            "— Спланируют эксклюзивные экскурсии и досуг\n" +
            "\n" +
            "Бесплатное страхование:\n" +
            "Страховая защита действует автоматически при оплате поездки или проживания картой «Мир Supreme». " +
            "Для получения полиса направьте запрос на bip‑insurance@rsb.ru.\n" +
            "\n" +
            "— Помощь на сумму до 200 000 $\n" +
            "— Для владельца карты и членов его семьи\n" +
            "— В России и за рубежом\n" +
            "\n" +
            "Доступ в бизнес-залы:\n" +
            "Ожидание рейса станет комфортней в бизнес-залах по всему миру с программой DragonPass.";
    public final static String DOCUMENTS_MIP_SUPREME = "Как получить кредитную карту «Мир Supreme»";
    public final String DOCUMENTS_MIP_SUPREME_ =
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
                    "Подать заявку самостоятельно можно через сайт банка: https://anketa.rsb.ru/card/9689/firstWebForm";

    public void keyBoardDocuments(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(DOCUMENTS_MIP_SUPREME);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }

    public void keyBoardPrivilege(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(PRIVILEGE_MIP_SUPREME);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }

    @Override
    public void keyBoardInstallmentPlan(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(INSTALLMENT_PLAN_MIP_SUPREME);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }

    @Override
    public void keyBoardService(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(SERVICE_MIP_SUPREME);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }

    @Override
    public void keyBoardInterest(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(INTEREST_MIP_SUPREME);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }

    @Override
    public void keyBoardCashback(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(CASHBACK_MIP_SUPREME);
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }
}
