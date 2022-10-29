# telegram-bot-java-spring-boot
При создании приложения, я использовал:

1. IntelliJ IDEA.
2. Maven.

Установка библиотеки 

Использование MAVEN: 

        <dependency>
			<groupId>org.telegram</groupId>
			<artifactId>telegrambots</artifactId>
			<version>${telegram.version}</version>
		</dependency>
        
        
        <dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
		</dependency>
        
        
        <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter</artifactId>
		</dependency>
        
        
        
Теперь перейдём к коду! 

Здесь будет описания действия бота. 


RussianStandartBot - scr - main - java - io  - pro3ct - service - TelegramBot

После создания проекта и подключения нужных нам библиотек, мы создаём класс TelergamBot. Напоминаю, 
что класс должен расширяться и реализовать все необходимые методы TelegramLongPollingBot

    
    import org.telegram.telegrambots.api.methods.send.SendMessage;
    import org.telegram.telegrambots.api.objects.Update;
    import org.telegram.telegrambots.bots.TelegramLongPollingBot;
    import org.telegram.telegrambots.exceptions.TelegramApiException;
    
    public class TelergamBot extends TelegramLongPollingBot {
    
    @Override
    public void onUpdateReceived(Update update) {
    }
   
    @Override
    public String getBotUsername() {
        return null;
    }

    @Override
    public String getBotToken() {      
        return null;
    }
    }

