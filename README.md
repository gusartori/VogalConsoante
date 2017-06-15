# Buscar vogal (única) precedida de consoante precidida de vogal


Projeto que implementa um algoritmo para buscar em uma dada entrada se existem uma vogal que é precedida por uma consoante que é precedida por uma volga.
Essa volga não pode ter ocorrido em nenhum momento, desta forma ela é única.

## Input (Entrada)

A premissa do projeto é que a entrada seja convertida em uma estrutra de dados que implemente a interface stream fornecida.
```
public interface Stream {

    char getNext();
    boolean hasNext();

}
```
Dessa forma criei a classe StreamWord que implementa a interface além de armazenar o *input* passado.

A leitura é feita na própria classe *main* do projeto e espera-se que o usuário digite esse *input*.

## Algoritmo e Estruturas de Dados

### Preparando as estruturas de dados
Na classe CharacterFinder é onde o algoritmo da busca pela sequência desejada é executado.
Ao receber a Stream como parâmetro, a primeira tarefa é ler toda a stream e conforme isso vai acontecendo armazenando numa estrutura de dados que facilite a busca pela vogal num segundo momento.
Para isso utilizei uma LinkedHashMap, onde as chaves são somente as vogais encontradas e os valores são LinkedLists com todos os outros caracteres antecessores.
Assim, todas as vogais encontradas são inseridas nessa estrutura juntamente com a lista de todos os caracteres antecessores. Caso essa vogal já esteja nesse LinkedHashMap, a sua lista de antecessores é zerada; fiz dessa forma pois se a vogal se repete ela não pode ser mais considerada como uma resposta válida; marcar com uma lista vazia é uma forma de manter esse histórico.

### Executando a busca da sequência (vogal->consoante->vogal)
Num segundo momento é feito a busca na estrutura de dados acima. Como se trata de uma LinkedHashpMap, os valores chaves estão ordenados o que vai de encontro com o requisito "primeira voga". 
Para fazer a checagem se é vogal ou consoante criei uma classe utilitária que utiliza expressão regular para isso.

## Compilar

Para compilar o projeto basta baixá-lo em sua máquina com Java 8 instalado, navegar para o diretório src/main/java e em seguida executar o seguinte comando:

```
javac com/project/Application.java
```


## Testes
Criei uma classe de testes com diversos cenários para a Stream.
Para executar os testes na linha de comando:
```

```

## Rodar aplicação
Para rodar a aplicação no terminal navegar para o diretório src/main/java e em seguida executar o seguinte comando:
```
java com/project/Application
```