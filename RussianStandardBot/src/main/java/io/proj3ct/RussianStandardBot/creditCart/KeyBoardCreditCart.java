package io.proj3ct.RussianStandardBot.creditCart;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
public interface KeyBoardCreditCart {
    void keyBoardInstallmentPlan(SendMessage message);
    void keyBoardService(SendMessage message);
    void keyBoardInterest(SendMessage message);
    void keyBoardCashback(SendMessage message);
    void keyBoardPrivilege(SendMessage message);
    void keyBoardDocuments(SendMessage message);
}
