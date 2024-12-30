# CalculadoraGUI

## Descrição
`CalculadoraGUI` é um projeto Java que implementa uma calculadora simples com interface gráfica (GUI) usando o Swing. Ela suporta operações básicas como adição, subtração, multiplicação e divisão, além de funcionalidades adicionais como alternar o sinal de um número, limpar entradas e exibir mensagens de erro para operações inválidas.

## Funcionalidades
- **Operações básicas**: Adição, subtração, multiplicação e divisão.
- **Alternar sinal**: Botão "+/-" para mudar o sinal do número exibido.
- **Limpeza de entradas**:
  - `C`: Limpa o último número inserido.
  - `AC`: Limpa todas as entradas e redefine a calculadora.
- **Erro para operações inválidas**: Exibe `ERR` para entradas ou resultados com mais de 8 dígitos ou divisão por zero.
- **Suporte a números decimais**: Entrada de números com ponto decimal.

## Estrutura do Código
- **`CalculadoraGUI`**: Classe principal que configura a interface gráfica e gerencia a lógica da calculadora.
  - `JTextField display`: Exibe o número atual ou o resultado da última operação.
  - `JPanel buttonPanel`: Contém os botões da calculadora.
  - `ButtonClickListener`: Listener que trata os eventos de clique nos botões.
- **Métodos principais**:
  - `toggleSign()`: Alterna o sinal do número atual.
  - `performOperation(String command)`: Realiza a operação matemática especificada.
  - `formatResult(double value)`: Formata o resultado para garantir que ele não ultrapasse 8 dígitos.

## Como Usar
1. **Requisitos**:
   - Java Development Kit (JDK) 8 ou superior.
2. **Execução**:
   - Compile o arquivo `CalculadoraGUI.java` com o comando:
     ```
     javac CalculadoraGUI.java
     ```
   - Execute o programa com o comando:
     ```
     java CalculadoraGUI
     ```
3. **Interface**:
   - Use os botões numéricos para inserir números (máximo de 8 dígitos).
   - Use os botões de operação (`+`, `-`, `*`, `/`) para realizar cálculos.
   - Use o botão `=` para obter o resultado.
   - Use o botão `C` para limpar o número atual e `AC` para redefinir a calculadora.
   - Use o botão `+/-` para alternar o sinal do número exibido.

## Limitações
- Os resultados são limitados a 8 dígitos. Operações que excedam esse limite exibirão `ERR`.
- A divisão por zero também resulta em `ERR`.

## Autor
Desenvolvido como exemplo de projeto para implementação de uma calculadora gráfica em Java.