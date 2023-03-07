# Oficinia-API

O projeto em questão é uma API REST de uma oficina mecânica, desenvolvida em Java com o framework Spring Boot e banco de dados PostgreSQL. A aplicação permite a gestão de peças de automóveis, oferecendo funcionalidades como criação, atualização, exclusão e busca de peças.

A estrutura do projeto é organizada da seguinte forma:

- A pasta src/main/java contém o código-fonte da aplicação, com as classes que definem as entidades do banco de dados, os repositórios que realizam a comunicação com o banco de dados, os controladores que implementam as rotas da API e os serviços que contêm a lógica de negócio da aplicação.

- A pasta src/main/resources contém os arquivos de configuração da aplicação, como o arquivo application.properties que configura o banco de dados PostgreSQL e outras configurações do Spring Boot.

A aplicação utiliza Java 17 e Spring Boot 3, oferecendo um ambiente moderno e robusto para a criação de APIs RESTful. Além disso, a aplicação conta com validação e tratamento de exceções personalizados, ajudando a garantir a integridade dos dados e a segurança da aplicação.

É possível buscar por código de barras, modelo do automóvel, letra inicial do nome da peça e categorias de peças. Essas funcionalidades são implementadas através dos endpoints da API e facilitam a pesquisa e a organização das peças na oficina mecânica.

- Para buscar peças por código de barras, é necessário utilizar a rota /pecas/{codigoBarras}, onde codigoBarras é o código de barras da peça desejada, informado como um parâmetro na URL.

- Para buscar peças por modelo de automóvel, é necessário utilizar a rota /pecas/{modelo}/modelo, onde modelo é o modelo de automóvel da peça desejada, informado como um parâmetro na URL.

- Para buscar peças por letra inicial do nome, é necessário utilizar a rota /pecas/{letraInicial}/nome, onde letraInicial é a letra inicial do nome da peça desejada, informada como um parâmetro na URL.

- Por fim, para buscar peças por categoria, é necessário utilizar a rota /pecas/{categoria}/categoria, onde categoria é a categoria da peça desejada, informada como um parâmetro na URL.
