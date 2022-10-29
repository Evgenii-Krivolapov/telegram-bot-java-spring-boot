# telegram-bot-java-spring-boot
При создании приложения, я использовал:

1. IntelliJ IDEA.
2. Maven.
3. Spring Initializr Который предоставляет интерфейс для генерации заготовки проекта с добавлением стандартных зависимостей.

Установка библиотеки 

Использование MAVEN: 

        <dependency>
			<groupId>org.telegram</groupId>
			<artifactId>telegrambots</artifactId>
			<version>6.1.0</version>
	</dependency>
        
        
        <dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
	</dependency>
        
        
        
Теперь перейдём к коду! 

После создания проекта и подключения нужных нам библиотек, мы создаём класс TelergamBot. Напоминаю, 
что класс должен расширяться и реализовать все необходимые методы TelegramLongPollingBot

    
    import org.telegram.telegrambots.api.methods.send.SendMessage;
    import org.telegram.telegrambots.api.objects.Update;
    import org.telegram.telegrambots.bots.TelegramLongPollingBot;
    import org.telegram.telegrambots.exceptions.TelegramApiException;
    import org.springframework.stereotype.Component;
    
    @Component
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

Дальше мы создаём файл application.properties в папке resources. Туда мы помещаем имя и токен нашего бота, получаенного от @BotFather. 

После, создаём класс BotConfig, через который мы будем получать наше имя и токен с файла application.properties 

Код выглядит так: 

    import lombok.Data;
    import org.springframework.beans.factory.annotation.Value;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.context.annotation.PropertySource;
    
    @Configuration
    @Data
    @PropertySource("application.properties")
    public class BotConfig {
    
    @Value("${bot.name}")
    String botName;
    
    @Value("${bot.key}")
    String token;
    }

Благодаря библиотеки lombok и аннотации @Data, для наших двух переменных мы создали set, get, и конструктор. 
Дальше мы вызываем объект класса BotConfig делаем его неизменным final. 

Класс TelegramBot теперь выглядит следующим образом: 

    import io.proj3ct.RussianStandardBot.config.BotConfig;
    
    import org.telegram.telegrambots.api.methods.send.SendMessage;
    import org.telegram.telegrambots.api.objects.Update;
    import org.telegram.telegrambots.bots.TelegramLongPollingBot;
    import org.telegram.telegrambots.exceptions.TelegramApiException;
    import org.springframework.stereotype.Component;
   
    final BotConfig botConfig;

    public TelegramBot(BotConfig botConfig) throws TelegramApiException {
        this.botConfig = botConfig;
    }
    @Component
    public class TelergamBot extends TelegramLongPollingBot {
    
    @Override
    public void onUpdateReceived(Update update) {
    }
   
    @Override
    public String getBotUsername() {
        return botConfig.getBotName();
    }

    @Override
    public String getBotToken() {      
        return botConfig.getToken();
    }
    }
    
Но как запустить бота? Ну, это хороший вопрос. Нужно создать экземпляр TelegramBotsApi и зарегистрирует нашего нового бота. Для этого создадим отдельный класс BotInitializer.

Код выглядит следующим образом: 

    package io.proj3ct.RussianStandardBot.config;

    import io.proj3ct.RussianStandardBot.service.TelegramBot;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.context.event.ContextRefreshedEvent;
    import org.springframework.context.event.EventListener;
    import org.springframework.stereotype.Component;
    import org.telegram.telegrambots.meta.TelegramBotsApi;
    import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
    import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

    @Component
    public class BotInitializer {

    @Autowired
    TelegramBot bot;

    @EventListener({ContextRefreshedEvent.class})
    public void init() throws TelegramApiException{
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        try {
            telegramBotsApi.registerBot(bot);
        } catch (TelegramApiException ex){
            ex.getMessage();
        }
    }

Теперь перейдём к логике нашего бота. Когда сообщение получено, бот вызовет этот метод onUpdateReceived(Update update)
             
       @Override
        public void onUpdateReceived(Update update) {

        //Проверяем есть ли сообщение и в сообщении есть текст
        if (update.hasMessage() && update.getMessage().hasText()) {
        String messaget = update.getMessage().getText();
        long chatId = update.getMessage().getChatId();
	
	switch (message) {
                case START: //Если пользователь отправил /start 
                    startCommandReceived(chatId, update.getMessage().getChat().getFirstName()); //Вызывается метод startCommandReceived
                    break;
		default:
                    sendMessage(chatId, "Здравствуйте. Я вас не понимаю. Переформулируйте, пожалуйста.");//При неизвестной нам команды
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
      
        messageExecute(message);
    }
    
    public void messageExecute(SendMessage message) { //Отправка нашего объекта сообщения пользователю
        try {
            execute(message);
        } catch (TelegramApiException ex) {
            ex.getStackTrace();
        }
    }    
