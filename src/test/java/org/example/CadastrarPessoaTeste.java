package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CadastrarPessoaTeste {

    @Mock
    private ApiDosCorreios apiDosCorreios;

    // dessa forma é passado o mock para a classe
    @InjectMocks
    private CadastrarPessoa cadastrarPessoa;

    @Test
    void validarDadosDeCadastro() {
        DadosLocalizacao dadosLocalizacao = new DadosLocalizacao("SP", "Araraquara", "rua tres", "apt", "centro");
        // quando essa api for chamada, ao inves de ir na api, vai direto no objeto criado
        Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep("123123")).thenReturn(dadosLocalizacao);
        Pessoa pessoa = cadastrarPessoa.cadastrarPessoa("Ellen", "123123123", LocalDate.now(), "123123");

        // validacao do usuario de cadastro
        assertEquals("Ellen", pessoa.getNome());
        assertEquals("123123123", pessoa.getDocumento());
        assertEquals("SP", pessoa.getEndereco().getUf());
        assertEquals("apt", pessoa.getEndereco().getComplemento());
    }
}
