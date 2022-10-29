package io.proj3ct.RussianStandardBot.service;

import io.proj3ct.RussianStandardBot.config.BotConfig;

import io.proj3ct.RussianStandardBot.creditCart.*;
import io.proj3ct.RussianStandardBot.debitCart.*;
import io.proj3ct.RussianStandardBot.paymentAndContribution.*;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

import static io.proj3ct.RussianStandardBot.paymentAndContribution.Account.*;
import static io.proj3ct.RussianStandardBot.paymentAndContribution.ContributionMonth.OPEN_CONTRIBUTION_MONTH;
import static io.proj3ct.RussianStandardBot.paymentAndContribution.ContributionPension.OPEN_CONTRIBUTION_PENSION;
import static io.proj3ct.RussianStandardBot.creditCart.CreditCartBlack.*;
import static io.proj3ct.RussianStandardBot.creditCart.CreditCartImperiaPlatinum.*;
import static io.proj3ct.RussianStandardBot.creditCart.CreditCartMip.*;
import static io.proj3ct.RussianStandardBot.creditCart.CreditCartMipSupreme.*;
import static io.proj3ct.RussianStandardBot.creditCart.CreditCartPlatinum.*;
import static io.proj3ct.RussianStandardBot.creditCart.CreditCartUnionPay.*;
import static io.proj3ct.RussianStandardBot.paymentAndContribution.CurrentAccount.CURRENT_ACCOUNT_PERCENT;
import static io.proj3ct.RussianStandardBot.paymentAndContribution.CurrentAccount.OPEN_CURRENT_ACCOUNT;
import static io.proj3ct.RussianStandardBot.debitCart.DebitCartDigital.*;
import static io.proj3ct.RussianStandardBot.debitCart.DebitCartGold.*;
import static io.proj3ct.RussianStandardBot.debitCart.DebitCartMip.*;
import static io.proj3ct.RussianStandardBot.debitCart.DebitCartPensionMip.*;
import static io.proj3ct.RussianStandardBot.debitCart.DebitCartStandart.*;
import static io.proj3ct.RussianStandardBot.debitCart.DebitCartUnionPay.*;
import static io.proj3ct.RussianStandardBot.paymentAndContribution.ContributionMaximum.OPEN_CONTRIBUTION_MAXIMUM;

@Component
public class TelegramBot extends TelegramLongPollingBot {
    CreditCartMip creditCartMip = new CreditCartMip();
    CreditCartUnionPay creditCartUnionPay = new CreditCartUnionPay();
    CreditCartPlatinum creditCartPlatinum = new CreditCartPlatinum();
    CreditCartBlack creditCartBlack = new CreditCartBlack();
    CreditCartMipSupreme creditCartMipSupreme = new CreditCartMipSupreme();
    CreditCartImperiaPlatinum creditCartImperiaPlatinum = new CreditCartImperiaPlatinum();
    DebitCartMip debitCartMip = new DebitCartMip();
    DebitCartUnionPay debitCartUnionPay = new DebitCartUnionPay();
    DebitCartPensionMip debitCartPensionMip = new DebitCartPensionMip();
    DebitCartStandart debitCartStandart = new DebitCartStandart();
    DebitCartGold debitCartGold = new DebitCartGold();
    DebitCartDigital debitCartDigital = new DebitCartDigital();
    ContributionMaximum incomeMaximum = new ContributionMaximum();
    ContributionPension contributionPension = new ContributionPension();
    ContributionMonth contributionMonth = new ContributionMonth();
    CurrentAccount currentAccount = new CurrentAccount();
    Account account = new Account();
    PaymentService paymentService = new PaymentService();

    final static String START = "/start";
    final static String CREDIT_CART = "Кредитные карты";
    final static String CREDIT_CART_MIP = "Карта «Мир+»";
    final static String CREDIT_CART_PLATINUM = "Карта «Platinum»";
    final static String CREDIT_CART_UNION = "Карта «UnionPay»";
    final static String CREDIT_CART_BLACK = "Карта «Black»";
    final static String CREDIT_CART_MIP_SUPREME = "Карта «Мир Supreme»";
    final static String CREDIT_CART_IMPERIA_PLATINUM = "Карта «Imperia Platinum»";
    final static String DEBIT_CART_MIP = "Карта «Мир»";
    final static String DEBIT_CART_UNION_PAY = "Карта «Union Pay»";
    final static String DEBIT_MIP = "Пенсионная карта «Мир»";
    final static String DEBIT_CART_STANDART = "Банк в кармане «Стандарт»";
    final static String DEBIT_CART_GOLD = "Банк в кармане «Gold»";
    final static String DEBIT_CART_DIGITAL = "Банк в кармане «Digital»";
    final static String PAYMENT_FOR_SERVICES = "Оплата услуг";
    final static String PAYMENT_CREDIT = "Оплата кредита";
    final static String PAYMENT_FINE = "Оплата штрафа";
    final static String PAYMENT_ACCOUNTS = "Оплата счёта";
    final static String TRANSLATION_CASH = "Денежные переводы";
    final static String DEBIT_CART = "Дебетовые карты";
    final static String INCOME = "Вклады и счета";
    final static String CONTRIBUTION = "Вклады";
    final static String CURRENT_ACCOUNT = "Накопительный счёт";
    final static String ACCOUNT = "Текущий счёт";
    final static String CONTRIBUTION_MAXIMUM = "Вклад «Максимальный»";
    final static String CONTRIBUTION_PENSION = "Вклад «Пенсионный»";
    final static String CONTRIBUTION_MONTHLY = "Вклад «Ежемесячный доход»";
    final static String BACK = "Вернуться назад";
    final static String WARNING = "Вся информация в данном Телеграм боте " +
            "вымышленное, любое сходство с реальной информацией случайны. Автор не " +
            "несёт ответственность за причинённый вред своей информацией. Всё написанное " +
            "используется исключительно в учебных целях.";
    final static String WARNING_ = "/help";
    final static String AUTHOR = "/author";
    final static String AUTHOR_ = "По всем вопросам писать на почту - leonidovich.w@gmail.com";
    final BotConfig botConfig;

    public TelegramBot(BotConfig botConfig) throws TelegramApiException {
        this.botConfig = botConfig;
        List<BotCommand> listOfCommands = new ArrayList<>();
        listOfCommands.add(new BotCommand(START, BACK));
        listOfCommands.add(new BotCommand(WARNING_, "Важно"));
        listOfCommands.add(new BotCommand(AUTHOR, "Автор"));
        this.execute(new SetMyCommands(listOfCommands, new BotCommandScopeDefault(), null));
    }

    @Override
    public String getBotUsername() {
        return botConfig.getBotName();
    }

    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();
            switch (message) {
                case START:
                    startCommandReceived(chatId, update.getMessage().getChat().getFirstName());
                    break;
                case CREDIT_CART:
                    sendMessage(chatId, "Вы выбрали Кредитные карты");
                    break;
                case DEBIT_CART:
                    sendMessage(chatId, "Вы выбрали Дебетовые карты");
                    break;
                case INCOME:
                    sendMessage(chatId, "Вы выбрали Вклады и счета");
                    break;
                case WARNING_:
                    sendMessage(chatId, WARNING);
                    break;
                case CONTRIBUTION:
                    sendMessage(chatId, "Вы выбрали Вклады");
                    break;
                case PAYMENT_FOR_SERVICES:
                    sendMessage(chatId, "Вы выбрали Оплата услуг");
                    break;
                case AUTHOR:
                    sendMessage(chatId, AUTHOR_);
                    break;
                case CREDIT_CART_MIP:
                    sendMessageCreditCartMIP(chatId, creditCartMip.CASH_SERVICE_MIP);
                    break;
                case SERVICE_MIP:
                    sendMessageCreditCartMIP(chatId, creditCartMip.SERVICE);
                    break;
                case INTEREST_MIP:
                    sendMessageCreditCartMIP(chatId, creditCartMip.INTEREST_SERVICE_MIP);
                    break;
                case CASHBACK_MIP:
                    sendMessageCreditCartMIP(chatId, creditCartMip.CASHBACK_SERVICE_MIP);
                    break;
                case PLAN_MIP:
                    sendMessageCreditCartMIP(chatId, creditCartMip.PLAN_MIP_);
                    break;
                case DOCUMENTS_MIP:
                    sendMessageCreditCartMIP(chatId, creditCartMip.DOCUMENTS_MIP_);
                    break;
                case CREDIT_CART_UNION:
                    sendMessageUnionPay(chatId, creditCartUnionPay.CASH_SERVICE_UNION_PAY);
                    break;
                case PLAN_UNION_PAY:
                    sendMessageUnionPay(chatId, creditCartUnionPay.INSTALLMENT_PLAN_UNION_PAY);
                    break;
                case SERVICE_UNION:
                    sendMessageUnionPay(chatId, creditCartUnionPay.SERVICE_UNION_PAY);
                    break;
                case INTEREST_UNION_PAY:
                    sendMessageUnionPay(chatId, creditCartUnionPay.INTEREST_SERVICE_UNION_PAY);
                    break;
                case CASHBACK_UNION_PAY:
                    sendMessageUnionPay(chatId, creditCartUnionPay.CASHBACK_SERVICE_UNION_PAY);
                    break;
                case PRIVILEGE_UNION_PAY:
                    sendMessageUnionPay(chatId, creditCartUnionPay.PRIVILEGE_UNION_PAY_);
                    break;
                case DOCUMENTS_UNION_PAY:
                    sendMessage(chatId, creditCartUnionPay.DOCUMENTS_UNION_PAY_);
                    break;
                case CREDIT_CART_PLATINUM:
                    sendMessageCreditCartPlatinum(chatId, creditCartPlatinum.CASH_SERVICE_PLATINUM);
                    break;
                case PLAN_PLATINUM:
                    sendMessageCreditCartPlatinum(chatId, creditCartPlatinum.INSTALLMENT_PLAN_PLATINUM);
                    break;
                case SERVICE_PLATINUM:
                    sendMessageCreditCartPlatinum(chatId, creditCartPlatinum.SERVICE_PLATINUM_);
                    break;
                case INTEREST_PLATINUM:
                    sendMessageCreditCartPlatinum(chatId, creditCartPlatinum.INTEREST_SERVICE_PLATINUM);
                    break;
                case CASH_BACK_PLATINUM:
                    sendMessageCreditCartPlatinum(chatId, creditCartPlatinum.CASHBACK_PLATINUM);
                    break;
                case PRIVILEGE_PLATINUM:
                    sendMessageCreditCartPlatinum(chatId, creditCartPlatinum.PRIVILEGE_PLATINUM_);
                    break;
                case DOCUMENTS_PLATINUM:
                    sendMessageCreditCartPlatinum(chatId, creditCartPlatinum.DOCUMENTS_PLATINUM_);
                    break;
                case CREDIT_CART_BLACK:
                    sendMessageCreditCartBlack(chatId, creditCartBlack.CASH_SERVICE_BLACK);
                    break;
                case CASHBACK_BLACK:
                    sendMessageCreditCartBlack(chatId, creditCartBlack.CASHBACK_SERVICE_BLACK);
                    break;
                case INTEREST_BLACK:
                    sendMessageCreditCartBlack(chatId, creditCartBlack.INTEREST_BLACK_);
                    break;
                case INSTALLMENT_PLAN_BLACK:
                    sendMessageCreditCartBlack(chatId, creditCartBlack.INSTALLMENT_PLAN_BLACK_);
                    break;
                case SERVICE_BLACK:
                    sendMessageCreditCartBlack(chatId, creditCartBlack.SERVICE_BLACK_);
                    break;
                case PRIVILEGE_BLACK:
                    sendMessageCreditCartBlack(chatId, creditCartBlack.PRIVILEGE_BLACK_);
                    break;
                case DOCUMENTS_BLACK:
                    sendMessageCreditCartBlack(chatId, creditCartBlack.DOCUMENTS_BLACK_);
                    break;
                case CREDIT_CART_MIP_SUPREME:
                    sendMessageCreditCartMipSupreme(chatId, creditCartMipSupreme.CASH_SERVICE_MIP_SUPREME);
                    break;
                case CASHBACK_MIP_SUPREME:
                    sendMessageCreditCartMipSupreme(chatId, creditCartMipSupreme.CASHBACK_MIP_SUPREME_);
                    break;
                case INTEREST_MIP_SUPREME:
                    sendMessageCreditCartMipSupreme(chatId, creditCartMipSupreme.INTEREST_MIP_SUPREME_);
                    break;
                case SERVICE_MIP_SUPREME:
                    sendMessageCreditCartMipSupreme(chatId, creditCartMipSupreme.SERVICE_MIP_SUPREME_);
                    break;
                case INSTALLMENT_PLAN_MIP_SUPREME:
                    sendMessageCreditCartMipSupreme(chatId, creditCartMipSupreme.INSTALLMENT_PLAN_MIP_SUPREME_);
                    break;
                case PRIVILEGE_MIP_SUPREME:
                    sendMessageCreditCartMipSupreme(chatId, creditCartMipSupreme.PRIVILEGE_MIP_SUPREME_);
                    break;
                case DOCUMENTS_MIP_SUPREME:
                    sendMessageCreditCartMipSupreme(chatId, creditCartMipSupreme.DOCUMENTS_MIP_SUPREME_);
                    break;
                case CREDIT_CART_IMPERIA_PLATINUM:
                    sendMessageCreditCartImperiaPlatinum(chatId, creditCartImperiaPlatinum.CASH_SERVICE_IMPERIA);
                    break;
                case CASHBACK_IMPERIA:
                    sendMessageCreditCartImperiaPlatinum(chatId, creditCartImperiaPlatinum.CASHBACK_IMPERIA_);
                    break;
                case PLAN_IMPERIA:
                    sendMessageCreditCartImperiaPlatinum(chatId, creditCartImperiaPlatinum.PLAN_IMPERIA_);
                    break;
                case SERVICE_IMPERIA:
                    sendMessageCreditCartImperiaPlatinum(chatId, creditCartImperiaPlatinum.SERVICE_IMPERIA_);
                    break;
                case PRIVILEGE_IMPERIA:
                    sendMessageCreditCartImperiaPlatinum(chatId, creditCartImperiaPlatinum.PRIVILEGE_IMPERIA_);
                    break;
                case DOCUMENTS_IMPERIA:
                    sendMessageCreditCartImperiaPlatinum(chatId, creditCartImperiaPlatinum.DOCUMENTS_IMPERIA_);
                    break;
                case DEBIT_CART_MIP:
                    sendMessageDebitMip(chatId, debitCartMip.INFO_MIP);
                    break;
                case INCOME_MIP:
                    sendMessageDebitMip(chatId, debitCartMip.INCOME_MIP_);
                    break;
                case CASHBACK_MUP:
                    sendMessageDebitMip(chatId, debitCartMip.CASHBACK_MUP_);
                    break;
                case COMFORTABLE_MIP:
                    sendMessageDebitMip(chatId, debitCartMip.COMFORTABLE_MIP_);
                    break;
                case DOCUMENT_MUP:
                    sendMessageDebitMip(chatId, debitCartMip.DOCUMENT_MUP_);
                    break;
                case DEBIT_CART_UNION_PAY:
                    sendMessageDebitUnionPay(chatId, debitCartUnionPay.INFO_UNION);
                    break;
                case INCOME_UNION_PAY:
                    sendMessageDebitUnionPay(chatId, debitCartUnionPay.INCOME_UNION_PAY_);
                    break;
                case CASHBACK_PAY:
                    sendMessageDebitUnionPay(chatId, debitCartUnionPay.CASHBACK_UNION_);
                    break;
                case COMFORTABLE_UNION_PAY:
                    sendMessageDebitUnionPay(chatId, debitCartUnionPay.COMFORTABLE_UNION_PAY_);
                    break;
                case DOCUMENT_UNION:
                    sendMessageDebitUnionPay(chatId, debitCartUnionPay.DOCUMENT_UNION_);
                    break;
                case DEBIT_MIP:
                    sendMessageDebitPensionMip(chatId, debitCartPensionMip.INFO_PENSION_MIP);
                    break;
                case INCOME_PENSION_MIP:
                    sendMessageDebitPensionMip(chatId, debitCartPensionMip.INCOME_PENSION_MIP_);
                    break;
                case CASHBACK_PENSION_MIP:
                    sendMessageDebitPensionMip(chatId, debitCartPensionMip.CASHBACK_PENSION_MIP_);
                    break;
                case COMFORTABLE_PENSION_MIP:
                    sendMessageDebitPensionMip(chatId, debitCartPensionMip.COMFORTABLE_PENSION_MIP_);
                    break;
                case DOCUMENTS_PENSION_MIP:
                    sendMessageDebitPensionMip(chatId, debitCartPensionMip.DOCUMENTS_PENSION_MIP_);
                    break;
                case DEBIT_CART_STANDART:
                    sendMessageDebitStandart(chatId, debitCartStandart.INFO_STANDART);
                    break;
                case INCOME_STANDART:
                    sendMessageDebitStandart(chatId, debitCartStandart.INCOME_STANDART_);
                    break;
                case CASHBACK_STANDART:
                    sendMessageDebitStandart(chatId, debitCartStandart.CASHBACK_STANDART_);
                    break;
                case COMFORTABLE_STANDART:
                    sendMessageDebitStandart(chatId, debitCartStandart.COMFORTABLE_STANDART_);
                    break;
                case DOCUMENTS_STANDART:
                    sendMessageDebitStandart(chatId, debitCartStandart.DOCUMENTS_STANDART_);
                    break;
                case DEBIT_CART_GOLD:
                    sendMessageDebitGold(chatId, debitCartGold.INFO_GOLD);
                    break;
                case INCOME_GOLD:
                    sendMessageDebitGold(chatId, debitCartGold.INCOME_GOLD_);
                    break;
                case CASHBACK_GOLD:
                    sendMessageDebitGold(chatId, debitCartGold.CASHBACK_GOLD_);
                    break;
                case COMFORTABLE_GOLD:
                    sendMessageDebitGold(chatId, debitCartGold.COMFORTABLE_GOLD_);
                    break;
                case DOCUMENTS_GOLD:
                    sendMessageDebitGold(chatId, debitCartGold.DOCUMENTS_GOLD_);
                    break;
                case DEBIT_CART_DIGITAL:
                    sendMessageDebitDigital(chatId, debitCartDigital.INFO_DIGITAL);
                    break;
                case INCOME_DIGITAL:
                    sendMessageDebitDigital(chatId, debitCartDigital.INCOME_DIGITAL_);
                    break;
                case COMFORTABLE_DIGITAL:
                    sendMessageDebitDigital(chatId, debitCartDigital.COMFORTABLE_DIGITAL_);
                    break;
                case DOCUMENTS_DIGITAL:
                    sendMessageDebitDigital(chatId, debitCartDigital.DOCUMENTS_DIGITAL_);
                    break;
                case CONTRIBUTION_MAXIMUM:
                    sendMessageContribution(chatId, incomeMaximum.PERCENT_MAXIMUM_CONTRIBUTION);
                    break;
                case OPEN_CONTRIBUTION_MAXIMUM:
                    sendMessageContribution(chatId, incomeMaximum.OPEN_CONTRIBUTION_MAXIMUM_);
                    break;
                case CONTRIBUTION_PENSION:
                    sendMessageContribution(chatId, contributionPension.PERCENT_CONTRIBUTION_PENSION);
                    break;
                case OPEN_CONTRIBUTION_PENSION:
                    sendMessageContribution(chatId, contributionPension.OPEN_CONTRIBUTION_PENSION_);
                    break;
                case CONTRIBUTION_MONTHLY:
                    sendMessageContribution(chatId, contributionMonth.PERCENT_CONTRIBUTION_MONTH);
                    break;
                case OPEN_CONTRIBUTION_MONTH:
                    sendMessageContribution(chatId, contributionMonth.OPEN_CONTRIBUTION_MONTH_);
                    break;
                case CURRENT_ACCOUNT:
                    sendMessageCurrentAccount(chatId, currentAccount.CURRENT_ACCOUNT_SERVICE);
                    break;
                case CURRENT_ACCOUNT_PERCENT:
                    sendMessageCurrentAccount(chatId, currentAccount.CURRENT_ACCOUNT_PERCENT_);
                    break;
                case OPEN_CURRENT_ACCOUNT:
                    sendMessageCurrentAccount(chatId, currentAccount.OPEN_CURRENT_ACCOUNT_);
                    break;
                case ACCOUNT:
                    sendMessageAccount(chatId, account.ACCOUNT_SERVICE);
                    break;
                case ACCOUNT_ADVANTAGES:
                    sendMessageAccount(chatId, account.ACCOUNT_ADVANTAGES_);
                    break;
                case NEED_ACCOUNT:
                    sendMessageAccount(chatId, account.NEED_ACCOUNT_);
                    break;
                case DOCUMENTS_ACCOUNT:
                    sendMessageAccount(chatId, account.DOCUMENTS_ACCOUNT_);
                    break;
                case OPEN_ACCOUNT:
                    sendMessageAccount(chatId, account.OPEN_ACCOUNT_);
                    break;
                case PAYMENT_CREDIT:
                    sendMessage(chatId, paymentService.PAYMENT_CREDIT_);
                    break;
                case PAYMENT_FINE:
                    sendMessage(chatId, paymentService.PAYMENT_FINE_);
                    break;
                case PAYMENT_ACCOUNTS:
                    sendMessage(chatId, paymentService.PAYMENT_ACCOUNTS_);
                    break;
                case TRANSLATION_CASH:
                    sendMessage(chatId, paymentService.TRANSLATION_CASH_);
                    break;
                default:
                    sendMessage(chatId, "Здравствуйте. Я вас не понимаю. Переформулируйте, пожалуйста.");
            }
        }
    }

    private void startCommandReceived(long chatId, String name) {
        String answer = "Здравствуйте " + name + ", Вас привествует вертуальный помощник Банка Русский Стандарт. Чем можем помочь?";
        sendMessage(chatId, answer);
    }

    private void sendMessage(long chatId, String textToSend) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);
        keyBoard(message);
        if (textToSend.equals("Вы выбрали Кредитные карты")) {
            keyBoardCreditCart(message);
        } else if (textToSend.equals("Вы выбрали Дебетовые карты")) {
            keyBoardDebitCart(message);
        } else if (textToSend.equals("Вы выбрали Вклады и счета")) {
            keyBoardIncome(message);
        } else if (textToSend.equals("Вы выбрали Вклады")) {
            keyBoardConribution(message);
        } else if (textToSend.equals("Вы выбрали Оплата услуг")) {
            keyBoardPaymentService(message);
        }

        messageExecute(message);
    }

    public void messageExecute(SendMessage message) {
        try {
            execute(message);
        } catch (TelegramApiException ex) {
            ex.getStackTrace();
        }
    }

    private void sendMessageAccount(long chatId, String textToSend) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);
        keyBoard(message);
        if (textToSend.equals(account.ACCOUNT_SERVICE)) {
            account.keyBoardAdvantages(message);
        } else if (textToSend.equals(account.ACCOUNT_ADVANTAGES_)) {
            account.keyBoardNeed(message);
        } else if (textToSend.equals(account.NEED_ACCOUNT_)) {
            account.keyBoardDocuments(message);
        } else if (textToSend.equals(account.DOCUMENTS_ACCOUNT_)) {
            account.keyBoardOpen(message);
        }
        messageExecute(message);
    }

    private void sendMessageCurrentAccount(long chatId, String textToSend) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);
        keyBoard(message);
        if (textToSend.equals(currentAccount.CURRENT_ACCOUNT_SERVICE)) {
            currentAccount.keyBoardPercent(message);
        } else if (textToSend.equals(currentAccount.CURRENT_ACCOUNT_PERCENT_)) {
            currentAccount.keyBoardOpen(message);
        }
        messageExecute(message);
    }

    private void sendMessageContribution(long chatId, String textToSend) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);
        keyBoard(message);
        if (textToSend.equals(incomeMaximum.PERCENT_MAXIMUM_CONTRIBUTION)) {
            incomeMaximum.keyBoardOpenContribution(message);
        } else if (textToSend.equals(contributionPension.PERCENT_CONTRIBUTION_PENSION)) {
            contributionPension.keyBoardOpenContribution(message);
        } else if (textToSend.equals(contributionMonth.PERCENT_CONTRIBUTION_MONTH)) {
            contributionMonth.keyBoardOpenContribution(message);
        }
        messageExecute(message);
    }

    private void sendMessageDebitDigital(long chatId, String textToSend) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);
        keyBoard(message);

        if (textToSend.equals(debitCartDigital.INFO_DIGITAL)) {
            debitCartDigital.keyBoardIncome(message);
        } else if (textToSend.equals(debitCartDigital.INCOME_DIGITAL_)) {
            debitCartDigital.keyBoardComfortable(message);
        } else if (textToSend.equals(debitCartDigital.COMFORTABLE_DIGITAL_)) {
            debitCartDigital.keyBoardDocuments(message);
        }
        messageExecute(message);
    }

    private void sendMessageDebitGold(long chatId, String textToSend) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);
        keyBoard(message);
        if (textToSend.equals(debitCartGold.INFO_GOLD)) {
            debitCartGold.keyBoardIncome(message);
        } else if (textToSend.equals(debitCartGold.INCOME_GOLD_)) {
            debitCartGold.keyBoardCashBack(message);
        } else if (textToSend.equals(debitCartGold.CASHBACK_GOLD_)) {
            debitCartGold.keyBoardComfortable(message);
        } else if (textToSend.equals(debitCartGold.COMFORTABLE_GOLD_)) {
            debitCartGold.keyBoardDocuments(message);
        }
        messageExecute(message);
    }

    private void sendMessageDebitStandart(long chatId, String textToSend) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);
        keyBoard(message);
        if (textToSend.equals(debitCartStandart.INFO_STANDART)) {
            debitCartStandart.keyBoardIncome(message);
        } else if (textToSend.equals(debitCartStandart.INCOME_STANDART_)) {
            debitCartStandart.keyBoardCashBack(message);
        } else if (textToSend.equals(debitCartStandart.CASHBACK_STANDART_)) {
            debitCartStandart.keyBoardComfortable(message);
        } else if (textToSend.equals(debitCartStandart.COMFORTABLE_STANDART_)) {
            debitCartStandart.keyBoardDocuments(message);
        }
        messageExecute(message);
    }

    private void sendMessageDebitPensionMip(long chatId, String textToSend) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);
        keyBoard(message);
        if (textToSend.equals(debitCartPensionMip.INFO_PENSION_MIP)) {
            debitCartPensionMip.keyBoardIncome(message);
        } else if (textToSend.equals(debitCartPensionMip.INCOME_PENSION_MIP_)) {
            debitCartPensionMip.keyBoardCashBack(message);
        } else if (textToSend.equals(debitCartPensionMip.CASHBACK_PENSION_MIP_)) {
            debitCartPensionMip.keyBoardComfortable(message);
        } else if (textToSend.equals(debitCartPensionMip.COMFORTABLE_PENSION_MIP_)) {
            debitCartPensionMip.keyBoardDocuments(message);
        }
        messageExecute(message);
    }

    private void sendMessageDebitUnionPay(long chatId, String textToSend) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);
        keyBoard(message);
        if (textToSend.equals(debitCartUnionPay.INFO_UNION)) {
            debitCartUnionPay.keyBoardIncome(message);
        } else if (textToSend.equals(debitCartUnionPay.INCOME_UNION_PAY_)) {
            debitCartUnionPay.keyBoardCashBack(message);
        } else if (textToSend.equals(debitCartUnionPay.CASHBACK_UNION_)) {
            debitCartUnionPay.keyBoardComfortable(message);
        } else if (textToSend.equals(debitCartUnionPay.COMFORTABLE_UNION_PAY_)) {
            debitCartUnionPay.keyBoardDocuments(message);
        }
        messageExecute(message);
    }

    private void sendMessageDebitMip(long chatId, String textToSend) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);
        keyBoard(message);
        if (textToSend.equals(debitCartMip.INFO_MIP)) {
            debitCartMip.keyBoardIncome(message);
        } else if (textToSend.equals(debitCartMip.INCOME_MIP_)) {
            debitCartMip.keyBoardCashBack(message);
        } else if (textToSend.equals(debitCartMip.CASHBACK_MUP_)) {
            debitCartMip.keyBoardComfortable(message);
        } else if (textToSend.equals(debitCartMip.COMFORTABLE_MIP_)) {
            debitCartMip.keyBoardDocuments(message);
        }
        messageExecute(message);
    }

    private void sendMessageCreditCartImperiaPlatinum(long chatId, String textToSend) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);
        keyBoard(message);
        if (textToSend.equals(creditCartImperiaPlatinum.CASH_SERVICE_IMPERIA)) {
            creditCartImperiaPlatinum.keyBoardCashback(message);
        } else if (textToSend.equals(creditCartImperiaPlatinum.CASHBACK_IMPERIA_)) {
            creditCartImperiaPlatinum.keyBoardInstallmentPlan(message);
        } else if (textToSend.equals(creditCartImperiaPlatinum.PLAN_IMPERIA_)) {
            creditCartImperiaPlatinum.keyBoardService(message);
        } else if (textToSend.equals(creditCartImperiaPlatinum.SERVICE_IMPERIA_)) {
            creditCartImperiaPlatinum.keyBoardPrivilege(message);
        } else if (textToSend.equals(creditCartImperiaPlatinum.PRIVILEGE_IMPERIA_)) {
            creditCartImperiaPlatinum.keyBoardDocuments(message);
        }
        messageExecute(message);
    }

    private void sendMessageCreditCartMipSupreme(long chatId, String textToSend) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);
        keyBoard(message);
        if (textToSend.equals(creditCartMipSupreme.CASH_SERVICE_MIP_SUPREME)) {
            creditCartMipSupreme.keyBoardCashback(message);
        } else if (textToSend.equals(creditCartMipSupreme.CASHBACK_MIP_SUPREME_)) {
            creditCartMipSupreme.keyBoardInterest(message);
        } else if (textToSend.equals(creditCartMipSupreme.INTEREST_MIP_SUPREME_)) {
            creditCartMipSupreme.keyBoardService(message);
        } else if (textToSend.equals(creditCartMipSupreme.SERVICE_MIP_SUPREME_)) {
            creditCartMipSupreme.keyBoardInstallmentPlan(message);
        } else if (textToSend.equals(creditCartMipSupreme.INSTALLMENT_PLAN_MIP_SUPREME_)) {
            creditCartMipSupreme.keyBoardPrivilege(message);
        } else if (textToSend.equals(creditCartMipSupreme.PRIVILEGE_MIP_SUPREME_)) {
            creditCartMipSupreme.keyBoardDocuments(message);
        }
        messageExecute(message);
    }

    private void sendMessageCreditCartBlack(long chatId, String textToSend) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);
        keyBoard(message);
        if (textToSend.equals(creditCartBlack.CASH_SERVICE_BLACK)) {
            creditCartBlack.keyBoardCashback(message);
        } else if (textToSend.equals(creditCartBlack.CASHBACK_SERVICE_BLACK)) {
            creditCartBlack.keyBoardInterest(message);
        } else if (textToSend.equals(creditCartBlack.INTEREST_BLACK_)) {
            creditCartBlack.keyBoardInstallmentPlan(message);
        } else if (textToSend.equals(creditCartBlack.INSTALLMENT_PLAN_BLACK_)) {
            creditCartBlack.keyBoardService(message);
        } else if (textToSend.equals(creditCartBlack.SERVICE_BLACK_)) {
            creditCartBlack.keyBoardPrivilege(message);
        } else if (textToSend.equals(creditCartBlack.PRIVILEGE_BLACK_)) {
            creditCartBlack.keyBoardDocuments(message);
        }
        messageExecute(message);
    }

    private void sendMessageCreditCartPlatinum(long chatId, String textToSend) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);
        keyBoard(message);
        if (textToSend.equals(creditCartPlatinum.CASH_SERVICE_PLATINUM)) {
            creditCartPlatinum.keyBoardInstallmentPlan(message);
        } else if (textToSend.equals(creditCartPlatinum.INSTALLMENT_PLAN_PLATINUM)) {
            creditCartPlatinum.keyBoardService(message);
        } else if (textToSend.equals(creditCartPlatinum.SERVICE_PLATINUM_)) {
            creditCartPlatinum.keyBoardInterest(message);
        } else if (textToSend.equals(creditCartPlatinum.INTEREST_SERVICE_PLATINUM)) {
            creditCartPlatinum.keyBoardCashback(message);
        } else if (textToSend.equals(creditCartPlatinum.CASHBACK_PLATINUM)) {
            creditCartPlatinum.keyBoardPrivilege(message);
        } else if (textToSend.equals(creditCartPlatinum.PRIVILEGE_PLATINUM_)) {
            creditCartPlatinum.keyBoardDocuments(message);
        }
        messageExecute(message);
    }

    private void sendMessageCreditCartMIP(long chatId, String textToSend) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);
        keyBoard(message);
        if (textToSend.equals(creditCartMip.CASH_SERVICE_MIP)) {
            creditCartMip.keyBoardService(message);
        } else if (textToSend.equals(creditCartMip.SERVICE)) {
            creditCartMip.keyBoardInterest(message);
        } else if (textToSend.equals(creditCartMip.INTEREST_SERVICE_MIP)) {
            creditCartMip.keyBoardCashback(message);
        } else if (textToSend.equals(creditCartMip.CASHBACK_SERVICE_MIP)) {
            creditCartMip.keyBoardInstallmentPlan(message);
        } else if (textToSend.equals(creditCartMip.PLAN_MIP_)) {
            creditCartMip.keyBoardDocuments(message);
        }
        messageExecute(message);
    }

    public void sendMessageUnionPay(long chatId, String textToSend) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);
        keyBoard(message);
        if (textToSend.equals(creditCartUnionPay.CASH_SERVICE_UNION_PAY)) {
            creditCartUnionPay.keyBoardInstallmentPlan(message);
        } else if (textToSend.equals(creditCartUnionPay.INSTALLMENT_PLAN_UNION_PAY)) {
            creditCartUnionPay.keyBoardService(message);
        } else if (textToSend.equals(creditCartUnionPay.SERVICE_UNION_PAY)) {
            creditCartUnionPay.keyBoardInterest(message);
        } else if (textToSend.equals(creditCartUnionPay.INTEREST_SERVICE_UNION_PAY)) {
            creditCartUnionPay.keyBoardCashback(message);
        } else if (textToSend.equals(creditCartUnionPay.CASHBACK_SERVICE_UNION_PAY)) {
            creditCartUnionPay.keyBoardPrivilege(message);
        } else if (textToSend.equals(creditCartUnionPay.PRIVILEGE_UNION_PAY_)) {
            creditCartUnionPay.keyBoardDocuments(message);
        }
        messageExecute(message);
    }

    public static void keyBoard(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();

        //верхний ряд
        row.add(CREDIT_CART);
        row.add(PAYMENT_FOR_SERVICES);
        keyboardRows.add(row);

        //нижний ряд
        row = new KeyboardRow();
        row.add(DEBIT_CART);
        row.add(INCOME);
        keyboardRows.add(row);

        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }

    public void keyBoardCreditCart(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(CREDIT_CART_MIP);
        row.add(CREDIT_CART_PLATINUM);
        row.add(CREDIT_CART_UNION);
        keyboardRows.add(row);

        row = new KeyboardRow();
        row.add(CREDIT_CART_MIP_SUPREME);
        row.add(CREDIT_CART_BLACK);
        row.add(CREDIT_CART_IMPERIA_PLATINUM);
        keyboardRows.add(row);

        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }

    public void keyBoardDebitCart(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(DEBIT_CART_MIP);
        row.add(DEBIT_MIP);
        row.add(DEBIT_CART_UNION_PAY);
        keyboardRows.add(row);

        row = new KeyboardRow();
        row.add(DEBIT_CART_GOLD);
        row.add(DEBIT_CART_DIGITAL);
        row.add(DEBIT_CART_STANDART);
        keyboardRows.add(row);

        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }

    public void keyBoardIncome(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(ACCOUNT);
        row.add(CURRENT_ACCOUNT);

        keyboardRows.add(row);

        row = new KeyboardRow();
        row.add(CONTRIBUTION);
        keyboardRows.add(row);

        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }

    public void keyBoardConribution(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(CONTRIBUTION_MAXIMUM);
        row.add(CONTRIBUTION_PENSION);

        keyboardRows.add(row);

        row = new KeyboardRow();
        row.add(CONTRIBUTION_MONTHLY);
        keyboardRows.add(row);

        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }

    public void keyBoardPaymentService(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(PAYMENT_FINE);
        row.add(PAYMENT_CREDIT);

        keyboardRows.add(row);

        row = new KeyboardRow();
        row.add(PAYMENT_ACCOUNTS);
        row.add(TRANSLATION_CASH);
        keyboardRows.add(row);

        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }
}
