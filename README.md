# training-mockito

Projeto de estudo com exemplos práticos de testes unitários usando JUnit 5 e Mockito.

O objetivo deste repositório é reunir cenários pequenos e isolados para praticar os principais recursos do Mockito, especialmente mocks, spies, stubbing, verificação de chamadas e captura de argumentos.

## Tecnologias

- Java
- Maven
- JUnit Jupiter
- Mockito

## O que foi praticado

### Mock

Mocks simulam dependências externas ou objetos cujo comportamento não deve ser executado de verdade durante o teste.

Exemplos no projeto:

- `ListaTeste`: cria uma lista mockada com `@Mock`.
- `CadastrarPessoaTeste`: mocka a `ApiDosCorreios` para evitar uma integração real.
- `PlataformaDeEnvioTeste`: mocka a plataforma de envio de email.

### Stubbing

Stubbing é a configuração do comportamento esperado de um mock.

Recursos usados:

- `when(...).thenReturn(...)`: define o retorno de uma chamada mockada.
- `when(...).thenThrow(...)`: simula uma exceção lançada por uma dependência.
- `doNothing().when(...)`: usado em métodos `void`, especialmente em spies.
- `doThrow(...).when(...)`: simula exceção em métodos `void`.

Exemplos no projeto:

- `ListaTeste`: usa `thenReturn` para retornar um valor específico da lista.
- `CadastrarPessoaTeste`: usa `thenReturn` para retornar dados de endereço e `thenThrow` para simular falha nos Correios.
- `ContaTeste`: usa `doNothing` em método `void`.
- `PlataformaDeEnvioTeste`: usa `doThrow` em método `void`.

### Verify

`verify` valida se um método foi chamado durante a execução do teste.

Recursos usados:

- `verify(...)`: verifica uma chamada.
- `verifyNoInteractions(...)`: garante que nenhum método foi chamado.
- `times(...)`: valida quantas vezes um método foi chamado.
- `InOrder`: valida a ordem das chamadas.

Exemplos no projeto:

- `ContaTeste`: verifica chamada de `debita`, quantidade de chamadas e ordem de execução.
- `EnviarMensagemTeste`: verifica se `adicionarMensagem` foi chamado.
- `ServicoEnvioEmailTeste`: verifica se a plataforma recebeu um email para envio.

### Spy

Spy é usado quando queremos trabalhar com um objeto real, mas ainda assim verificar chamadas ou sobrescrever comportamentos específicos.

Exemplos no projeto:

- `ContaTeste`: usa `@Spy` para acompanhar chamadas em uma conta real.
- `EnviarMensagemTeste`: usa `@Spy` para testar o comportamento real de adicionar mensagens.

### ArgumentCaptor

`ArgumentCaptor` permite capturar o argumento enviado para um mock e validar seus dados.

Exemplo no projeto:

- `ServicoEnvioEmailTeste`: captura o objeto `Email` enviado para a `PlataformaDeEnvio` e valida se o formato foi definido como `HTML`.

### InjectMocks

`@InjectMocks` injeta mocks dentro da classe que está sendo testada.

Exemplos no projeto:

- `CadastrarPessoaTeste`: injeta `ApiDosCorreios` em `CadastrarPessoa`.
- `ServicoEnvioEmailTeste`: injeta `PlataformaDeEnvio` em `ServicoEnvioEmail`.

### ArgumentMatchers

Argument matchers deixam o teste mais flexível quando o valor exato do argumento não é o foco.

Recursos usados:

- `anyString()`
- `anyInt()`
- `Mockito.any()`

Exemplos no projeto:

- `CadastrarPessoaTeste`: usa `anyString()` para simular falha com qualquer CEP.
- `ContaTeste`: usa `anyInt()` em método `void`.
- `PlataformaDeEnvioTeste`: usa `Mockito.any()` para qualquer email enviado.

### Mock de métodos estáticos

O projeto também inclui exemplo de mock de método estático com `MockedStatic`.

Exemplo no projeto:

- `GeradorDeNumerosTeste`: usa `Mockito.mockStatic` para controlar o retorno de métodos estáticos de `GeradorDeNumeros`.

## Mapa dos exemplos

| Arquivo de teste | Conceitos principais |
| --- | --- |
| `ListaTeste` | `@Mock`, `when`, `thenReturn` |
| `CadastrarPessoaTeste` | `@Mock`, `@InjectMocks`, `thenReturn`, `thenThrow`, `anyString`, `assertThrows` |
| `ContaTeste` | `@Spy`, `verify`, `times`, `InOrder`, `doNothing`, `anyInt` |
| `EnviarMensagemTeste` | `@Spy`, `verify`, teste com objeto real |
| `ServicoEnvioEmailTeste` | `@Mock`, `@InjectMocks`, `@Captor`, `ArgumentCaptor`, `verify` |
| `PlataformaDeEnvioTeste` | `doThrow`, método `void`, `assertThrows`, `Mockito.any` |
| `GeradorDeNumerosTeste` | `MockedStatic`, `mockStatic`, métodos estáticos |

## Como rodar os testes

Com Maven instalado, execute:

```bash
mvn test
```

No IntelliJ IDEA, também é possível rodar os testes diretamente pela pasta `src/test/java`.
