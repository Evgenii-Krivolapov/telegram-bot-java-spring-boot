package io.proj3ct.RussianStandardBot.debitCart;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
public interface keyBoardForDebitCart {
    void keyBoardIncome(SendMessage message);
    void keyBoardCashBack(SendMessage message);
    void keyBoardComfortable(SendMessage message);
    void keyBoardDocuments(SendMessage message);
}
