package Peixo.IAdeTreinoPOKE.service;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service  
public class IAService {

    private final ChatClient chatClient;  

    public IAService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }
    public String enviarMensagem(String mensagem) {
        return chatClient.prompt()
            .system("Você é um assistente útil especializado em Pokémon.") // Opcional: contexto do assistente
            .user(mensagem)
            .call()
            .content();
    }
}