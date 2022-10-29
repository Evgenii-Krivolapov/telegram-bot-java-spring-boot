package io.proj3ct.RussianStandardBot.paymentAndContribution;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
public interface KeyBoardContribution {
    void keyBoardOpenContribution(SendMessage message);
}
