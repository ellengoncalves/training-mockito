package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.mockito.Mockito;

import java.util.List;

// necessário incluir essa extensão para utilizar o Mockito
@ExtendWith(MockitoExtension.class)
public class ListaTeste {

    // criação de objeto mockado
    @Mock
    private List<String> letras;

    @Test
    void adicionarItemNaLista() {
        // verificação do conteúdo na primeira posição da lista
        Mockito.when(letras.get(0)).thenReturn("B");

        // chamada da lista mockada
        Assertions.assertEquals("B", letras.get(0));
    }

}
