# Explorando Marte

## Descrição do problema

Um conjunto de sondas foi enviado pela NASA à Marte e irá pousar num planalto. Esse planalto, que curiosamente é retangular, deve ser explorado pelas sondas para que suas câmeras embutidas consigam ter uma visão completa da área e enviar as imagens de volta para a Terra.\
A posição e direção de uma sonda são representadas por uma combinação de coordenadas x-y e uma letra representando a direção cardinal para qual a sonda aponta, seguindo a rosa dos ventos em inglês.

![Rosa dos ventos](simple-wind-rose.png)

O planalto é dividido numa malha para simplificar a navegação. Um exemplo de posição seria (0, 0, N), que indica que a sonda está no canto inferior esquerdo e apontando para o Norte.
Para controlar as sondas, a NASA envia uma simples sequência de letras. As letras possíveis são "L", "R" e "M". Destas, "L" e "R" fazem a sonda virar 90 graus para a esquerda ou direita, respectivamente, sem mover a sonda. "M" faz com que a sonda mova-se para a frente um ponto da malha, mantendo a mesma direção.
Nesta malha o ponto ao norte de (x,y) é sempre (x, y+1).

## Entrada e Saída

### Entrada

A entrada deverá ser feita em arquivo e no formato descrito abaixo:

5 5\
1 2 N\
LMLMLMLMM

A primeira linha da entrada de dados é a coordenada do ponto superior-direito da malha do planalto. Lembrando que a inferior esquerda sempre será (0,0).\
O resto da entrada será informação das sondas que foram implantadas. Cada sonda é representada por duas linhas.\
A primeira indica sua posição inicial e a segunda uma série de instruções indicando para a sonda como ela deverá explorar o planalto.\
A posição é representada por dois inteiros e uma letra separados por espaços, correspondendo à coordenada X-Y e à direção da sonda. Cada sonda será controlada 

### Saída

A saída deverá contar uma linha para cada sonda, na mesma ordem de entrada, indicando sua coordenada final e direção.

1 3 N

## Solução

A solução foi chamada de Explorador e foi escrita partindo de algumas premissas e levando algumas limitações em consideração. 

### Premissas 

* Mesmo que, as instruções da sonda sejam em inglês o código será escrito em PT-BR.
* TDD será prática obrigatória.
* Existem limites da área a ser explorada. 
* A entrada será em arquivo, pois fica mais simples a preparação de entradas mais completas e complexas
* A saída será no terminal por simplicidade.
* Execução dos testes unitários deverá ser rápida. 

### Considerações

* A linguagem selecionada foi a java. Devido ser mais familiarizado a ela.
* Um gerenciador de dependências foi utilizado(demorei a aceitar a ideia). Para essa tarefa o maven foi utilizado.
* Ser simples na elaboração da solução.

### Etapas

As etapas da escrita da solução podem ser descritas em:

- [x] Criar estrutura do projeto.
- [x] Escrever comportamento direcional (R e L).
- [x] Escrever comportamento posicional (pontos cardeais).
- [x] Ler arquivo de entrada
- [x] Escrever a saída no console

### Executando

Para executar o Explorador foi criado um arquivo Explorador.java e nele encontra-se o método main, 
ele será o responsável pela execução do sistema.