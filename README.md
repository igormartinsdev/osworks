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

O -Pdocker é um profile já está configurado no pom.xml para poder ler o arquivo dockerfile e gerar a image depois do build da aplicação. Seguindo fluxo você irá agora digitar o seguinte comando para parar o container do MySQL 
