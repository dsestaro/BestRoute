# BestRoute
Web Service that given a route map find the shortest path.

# Problem: #
##### .: entregando mercadorias :. ####

O Walmart esta desenvolvendo um novo sistema de logistica e sua ajuda é muito importante neste momento. Sua tarefa será desenvolver o novo sistema de entregas visando sempre o menor custo. Para popular sua base de dados o sistema precisa expor um Webservices que aceite o formato de malha logística (exemplo abaixo), nesta mesma requisição o requisitante deverá informar um nome para este mapa. É importante que os mapas sejam persistidos para evitar que a cada novo deploy todas as informações desapareçam. O formato de malha logística é bastante simples, cada linha mostra uma rota: ponto de origem, ponto de destino e distância entre os pontos em quilômetros.

- A B 10
- B D 15
- A C 20
- C D 30
- B E 50
- D E 30

Com os mapas carregados o requisitante irá procurar o menor valor de entrega e seu caminho, para isso ele passará o mapa, nome do ponto de origem, nome do ponto de destino, autonomia do caminhão (km/l) e o valor do litro do combustivel, agora sua tarefa é criar este Webservices. Um exemplo de entrada seria, mapa SP, origem A, destino D, autonomia 10, valor do litro 2,50; a resposta seria a rota A B D com custo de 6,25.

##### Restrições: #####
- Só pode existir uma única rota de A para B, para o mapa X. Caso essa rota seja informada mais de uma vez o valor da distância será atualizado.
- Os mapas são persistidos em banco de dados e transacionados, portanto não é possível a execução de duas aplicações simultâneamente.
- Todos os caminhos são unidirecionais, ou seja, A B 10 é diferente de B A 10.

#### Tecnologias Utilizadas ####
- [Hibernate]
- [Spring]
- [Spring Boot]
- [Spring IO]
- [HSQLDB]
- [JUnit]
- [Log4J]
- [REST Assured]
- [Mockito]
- [Dozer]
- [Gson]
 
#### Algoritmo de Menor Caminho ####
- [Dijkstra] 
 
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
/rest/setMap?name=SP
```

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