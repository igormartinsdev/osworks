# Osworks - Instruções de uso da app dockerizada em construção

Projeto para portfólio de API em Spring Boot. Será disponibilizado como poder ver a documentação da API atravé do Swagger. 

### Acesso a imagem Docker para poder testar a API sem necessitar do Eclipse

O código a seguir baixa a imagem do MySQL, configura a porta, colocar uma variável de ambiente para setar a senha do usuário root, cria uma rede para comunicação com a imagem da API, nomeia o container e informa qual versão será baixada.

> docker container run -d -p 3306:3306 -e "MYSQL_ROOT_PASSWORD=123456" --network osworks-network --name osworks-mysql mysql:8.0
