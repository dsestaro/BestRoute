# BestRoute
Web Service that given a route map find the shortest path.

# Problem: #
##### .: entregando mercadorias :. ####

O novo sistema de entregas visando sempre o menor custo. Para popular sua base de dados o sistema precisa expor um Webservices que aceite o formato de malha logística (exemplo abaixo), nesta mesma requisição o requisitante deverá informar um nome para este mapa. É importante que os mapas sejam persistidos para evitar que a cada novo deploy todas as informações desapareçam. O formato de malha logística é bastante simples, cada linha mostra uma rota: ponto de origem, ponto de destino e distância entre os pontos em quilômetros.

- A B 10
- B D 15
- A C 20
- C D 30
- B E 50
- D E 30

Com os mapas carregados o requisitante irá procurar o menor valor de entrega e seu caminho, para isso ele passará o mapa, nome do ponto de origem, nome do ponto de destino, autonomia do caminhão (km/l) e o valor do litro do combustível, agora sua tarefa é criar este Webservices. Um exemplo de entrada seria, mapa SP, origem A, destino D, autonomia 10, valor do litro 2,50; a resposta seria a rota A B D com custo de 6,25.

##### Restrições: #####
- Só pode existir uma única rota de A para B, para o mapa X. Caso essa rota seja informada mais de uma vez o valor da distância será atualizado.
- Os mapas são persistidos em banco de dados e transacionados, portanto não é possível a execução de duas aplicações simultaneamente.
- Todos os caminhos são unidirecionais, ou seja, A B 10 é diferente de B A 10.

#### Tecnologias Utilizadas e Motivações ####
- [Hibernate]	- Ferramenta de JPA conhecida e de fácil manuseio de entidades, além de possuir uma fácil integração com os outros frameworks utilizados.
- [Spring]	- Framework MVC mais conhecido no mercado.
- [Spring Boot]	- Framework para desenvolvimento ágil de projetos, foi escolhido por configurar automaticamente o Spring, além de conseguir rodar uma versão standalone da aplicação gerada.
- [Spring IO]	- Utilizado para criar o projeto inicial, adicionando ao pom.xml as principais dependências selecionadas por mim, assim como criando toda a estrutura do projeto.
- [HSQLDB]	- Banco de dados em arquivo para evitar a necessidade de configurações adicionais ao projeto, além de possuir uma boa performance de I/O
- [JUnit]		- Ferramenta de testes amplamente utilizada.
- [Log4J]	- Ferramenta de log utilizada por todos os frameworks
- [REST Assured] - Framework para realização de testes utilizando chamadas REST
- [Mockito]	- Framework utilizado para mockar chamadas de métodos que não podem ser executados em tempo de execução.
- [Dozer]	- Framework para cópia de dados entre objetos de classes diferentes.
- [Gson]	- Framework para a serialização de dados.
 
#### Algoritmo de Menor Caminho ####
- [Dijkstra] 	- Algoritmo para encontrar melhor caminho, sem utilizar nenhuma métrica ou heurística para determinar o mesmo
 
#### Serviços REST ####
##### GET /rest/getMap #####
Serviço que retorna o mapa solicitado populado, com todas as suas, rotas dados o identificador (nome). 
###### name: ######
Nome do mapa a ser obtido.

###### Exemplo de chamada: ######
```sh
/rest/getMap?name=SP
```

##### POST /rest/setMap #####
Serviço que grava o mapa enviado no banco de dados, caso já exista o mapa salvo no banco de dados os valores serão atualizados.
###### map:
Mapa e rotas a serem salvas. O objeto tem a seguinte forma:
```java
public class CitiesMap {
	private String name;
	private List<Path> paths;
}

public class Path {
	private String start;
	private String end;
	private double distance;
}
```
###### Exemplo de chamada: 

```sh
/rest/setMap?map={"name":"SP","paths":[{"start":"A","end":"B","distance":10.0},{"start":"B","end":"D","distance":15.0},{"start":"A","end":"C","distance":20.0},{"start":"C","end":"D","distance":30.0},{"start":"B","end":"E","distance":50.0},{"start":"D","end":"E","distance":30.0}]}
```

##### GET /rest/bestRoute #####
Serviço que retorna o menor caminho encontrado no mapa e o custo desse caminho para o caminhão especificado. 
###### name: ######
Nome do mapa a ser calculado.
###### start: ######
Nome da cidade de origem.
###### end: ######
Nome da cidade de destino.
###### autonomy: ######
Quantidade de KM/L que o caminhão possui.
###### price: ######
Custo de 1L de gasolina

###### Exemplo de chamada: ######

```sh
/rest/bestRoute?name=SP&start=A&end=D&autonomy=10&price=2.5
```

#### Como executar o projeto ####

##### Para a execução e compilação do projeto é necessário o framework Maven instalado. #####

para realizar a execução do projeto deve-se executar os seguintes comandos na ordem aprensetada:

Para compilar o projeto e rodar os testes
```sh
mvn clean install
```

Start da aplicação
```sh
mvn spring-boot:run
```

Após rodar o comando apresentado acima o sistema já se encontra disponível para receber requisições.

[Hibernate]: <http://hibernate.org/>
[Spring]: <http://projects.spring.io/spring-framework/>
[Spring Boot]: <http://projects.spring.io/spring-boot/>
[Spring IO]: <http://platform.spring.io/platform/>  
[HSQLDB]: <http://hsqldb.org/>
[JUnit]: <http://junit.org/>
[Log4J]: <http://logging.apache.org/log4j/2.x/>
[REST Assured]: <http://code.google.com/p/rest-assured/>
[Mockito]: <http://mockito.org/>
[Dozer]: <http://dozer.sourceforge.net/>
[Gson]: <https://github.com/google/gson>
[Dijkstra]: <http://www.vogella.com/tutorials/JavaAlgorithmsDijkstra/article.html>
