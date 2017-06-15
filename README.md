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

# Preparando as estruturas de dados
Na classe CharacterFinder é onde o algoritmo da busca pela sequência desejada é executado.
Ao receber a Stream como parâmetro, a primeira tarefa é ler toda a stream e conforme isso vai acontecendo armazenando numa estrutura de dados que facilite a busca pela vogal num segundo momento.
Para isso utilizei uma LinkedHashMap, onde as chaves são somente as vogais encontradas e os valores são LinkedLists com todos os outros caracteres antecessores.
Assim, todas as vogais encontradas são inseridas nessa estrutura juntamente com a lista de todos os caracteres antecessores. Caso essa vogal já esteja nesse LinkedHashMap, a sua lista de antecessores é zerada; fiz dessa forma pois se a vogal se repete ela não pode ser mais considerada como uma resposta válida; marcar com uma lista vazia é uma forma de manter esse histórico.

# Executando a busca da sequência (vogal->consoante->vogal)



Esta aplicação foi construída utilizando Spring Boot Framework, Spring Data e Spring MVC. Utilizei também banco de dados H2.
A aplicação está separada por camadas: 

- *model*: as entidades de banco de dados e projeções de output estão aqui;
- *repository*: a camada de acesso ao banco de dados;
- *service*: as regras de negócio que são feitas com esses dados;
- *controller*: a exposição dos serviços e construção de outputs.

Temos então 3 entidades: Campanha, Cliente e Time (utilizada como referência).

Automaticamente são carregados os times de referência através do arquivo data.sql.

