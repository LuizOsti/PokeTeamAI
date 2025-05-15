package Peixo.IAdeTreinoPOKE.controller;

import java.util.List;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class LLMService {
    private final ChatModel chatModel;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public LLMService(@Qualifier("openAiChatModel") ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String escolherPokemon(List<String> pokemonsDisponiveis, List<String> pokemonsEscolhidos) {
        String prompt = """
            - escolha um dos pokemons com base nos pokemonsDisponiveis de forma a balancear as habilidades dos pokemons ja escolhidos.
            - retorne apenas o nome do pokemon sem comentarios ou formatacao adicional

            pokemons disponiveis: %s
            pokemons escolhidos: %s
            """.formatted(pokemonsDisponiveis, pokemonsEscolhidos);

        return generateResponse(prompt, 0.3);
    }

    private String generateResponse(String prompt, double temperature) {
        return ChatClient.create(chatModel)
                .prompt(new Prompt(prompt, ChatOptions.builder()
                        .temperature(temperature)
                        .build()))
                .advisors(new SimpleLoggerAdvisor())
                .call()
                .content();
    }
}