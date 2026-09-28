package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

/**
 * Teste da classe {@link EnviarMensagem} exemplificando Spy
 */
@ExtendWith(MockitoExtension.class)
public class EnviarMensagemTeste {

    // o Spy referencia um objeto real da classe, ajuda a testar de forma mais próxima o comportamento da classe
    @Spy
    EnviarMensagem enviarMensagem = new EnviarMensagem();

    @Test
    void adicionarMensagem() {
        Mensagem mensagem = new Mensagem("Hello World");

        enviarMensagem.adicionarMensagem(mensagem);

        verify(enviarMensagem).adicionarMensagem(mensagem);

        Assertions.assertEquals(1, enviarMensagem.getMensagens().size());
    }

}
