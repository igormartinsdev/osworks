# Osworks API - Instruções de uso da app dockerizada em construção

Projeto para portfólio de API em Spring Boot que conterá: 

* Será disponibilizado como poder ver a documentação da API atravé do Swagger. (Em breve)
* Utilização de DDD (Domain-Driven Design).
* Exceptions definidas por domínio do negócio e referentes a API.
* Utilização de camadas (Services e Repository).
* Uso de DTO's para modelo de representatividade tanto para saída e entrada de informações.
* Flyway para poder aprender sua utilização.
* Testes. (Em breve)
* App gerenciada com docker compose para poder aguardar o start do banco para depois subir a API.
* Comandos utilizados para levantar a aplicação.

### Instruções de como levantar a API

Observação:
Os seguintes comandos foram feitos totalmente em ambiente linux, não tenho previsão de colocar comandos para windows ainda.

O código a seguir baixa a image do MySQL, configura a porta, colocar uma variável de ambiente para setar a senha do usuário root, cria uma rede para comunicação com a imagem da API, nomeia o container e informa qual versão será baixada.

> docker container run -d -p 3306:3306 -e "MYSQL_ROOT_PASSWORD=123456" --network osworks-network --name osworks-mysql mysql:8.0

O projeto já está com um dockerfile para criação da image da API e será gerado através do seguinte comando Maven:

> ./mvnw package -Pdocker

O -Pdocker é um parâmetro de configuração que é passado pelo comando maven referenciando a um profile configurado no pom.xml para poder ler o arquivo dockerfile e gerar a image depois do build da aplicação. Seguindo fluxo você irá agora digitar o seguinte comando para parar o container do MySQL 

> docker container stop osworks-mysql

A app faz uso do docker compose para gerenciar as images necessárias para subir a aplicação e como tendo premissa que o MySQL tem que estar UP primeiramente que a APP, fez se uso do wait-for-it.sh conforme documentação do docker compose. Segue abaixo código da configuração do docker compose.

```yml
version: "3.9"

networks:
  osworks-network:
    driver: bridge
    
services:
  osworks-mysql: 
    image: mysql:8.0
    environment:
      MYSQL_ROOT_PASSWORD: "123456"
    ports:
      - "3306:3306"
    networks:
      - osworks-network
  
  osworks-api:
    image: osworks-api
    command: ["/wait-for-it.sh", "osworks-mysql:3306", "-t", "30", "--", "java", "-jar", "osworks-api.jar"]
    environment:
      DB_HOST: osworks-mysql
    ports:
      - "8080:8080"
    networks:
      - osworks-network
    depends_on:
      - osworks-mysql  
```
Depois da breve demonstração do código de configuração seguimos o fluxo com o seguinte comando para levantar toda a aplicação com suas respectivas dependências:

> docker-compose up

Caso deseje parar a APP digite o seguinte comando:

> docker-compose down
