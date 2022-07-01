# LetsCode
desafio bootcamp 

# Primeiro Passo: Iniciando Sistema de API's
1- Inicie a API de Authorização que está startando na na porta 8082;
2- Inicie a API de critica de Filmes (esta api); 

No Postman - Importe a collection encaminhada junto das duas api's, nela se encontram os seguintes endpoints: 
POST 8080/usuario
POST 8082/api/login
GET 8080/filmes?titulo=legion
POST 8080/filmes/avaliacoes
POST 8080/filmes/comentarios
GET 8080/filmes/comentarios/
POST 8080/filmes/comentarios/**
POST 8080/filmes/citacoes/comentario/**
POST 8080/filmes/like/comentario/**
POST 8080/filmes/repetido/comentario/**
DEL 8080/filmes/comentarios/**

Na web, para acesso ao banco de dados, entrar no LINK: 
'http://localhost:8080/h2-console'
confirmar se o campo 'JDBC URL:' está com a descrição 'jdbc:h2:mem:testdb'
no campo 'password' escrever a senha que é 'password'
clicar em 'Conect'

# Segundo Passo: Cadastrando Usuário
Com as api's rodando e o import feito faça o seguinte procedimento: 
1- No endpoint "Registrar Usuário"
Siga o seguinte caminho: 
Body -> selecione "raw" -> Registre o seu usuário de acordo com o modelo:
{
"idUsuario":1,
"username":"victor",
"password":"123456"
}
2- No endpoint "Login"
Siga o seguinte caminho:
Body -> selecione "x-www-from-urlencoded" -> Passe os parâmetros de username e password registrados anteriormente
No campo de resposta você receberá um token de acordo com o modelo:
"access_token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2aWN0b3IiLCJyb2xlcyI6WyJST0xFX0xFSVRPUiJdLCJpc3MiOiJodHRwOi8vbG9jYWxob3N0OjgwODIvYXBpL2xvZ2luIiwiZXhwIjoxNjU2Njk5MTA2fQ.zab9aHUhpscPihBsPpeq88OsGhGBOHoF-wn_b18X3Y4",
"refresh_token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2aWN0b3IiLCJpc3MiOiJodHRwOi8vbG9jYWxob3N0OjgwODIvYXBpL2xvZ2luIiwiZXhwIjoxNjU2NzAwMzA2fQ.x8wipgiayUPyjhbqRFsY6EOXVED7jwwmpR3AXCiM5uc"

você utilizará o "refresh_token" que é valido por 10 minutos, qualquer atividade fora disso você receberá um erro 403 forbidden.

**Passo Extra** : Atribuindo um perfil a um usuário
algumas ações só podem ser realizados por tipos específicos de usuário, sendo assim é preciso que aquele usuário alcance o nível desejado para determinada ação

Existem duas formas de fazermos isso
1 - cadastrar usuário atribuindo o perfil desejado, para simplificar o processo e testar com mais velocidade, ficando da seguinte forma o cadastro de usuário:
{
"idUsuario":1,
"username":"victor",
"password":"123456",
"perfils": [
{"idPerfil":4}
]
}

2- Upgrade por meio de pontos:
Olhando no banco de dados existe uma tabela chamada : "TB_PONTO"
No espaço em branco passe o seguinte código: 
update tb_ponto set pontos = (numero de pontos desejados) where id_usuario = (id do úsuario que deseja atribuir os pontos)

# Terceiro passo: Utilizando os serviços da API
Existem agora algumas ações que podem ser realizadas dentro da api, representadas por: 
Buscar Filme Pelo Nome - Todo tipo de perfil
Avaliar Filme - Todo tipo de perfil
Comentar Filme - Apenas perfil "BASICO", "AVANCADO" e "MODERADOR"
Buscar Comentarios de um filme - Todo tipo de perfil
Comentar Comentario - Apenas perfil "BASICO", "AVANCADO" e "MODERADOR"
Citar Comentario - Apenas perfil "AVANCADO" e "MODERADOR"
Gostar Comentario - Apenas perfil "AVANCADO" e "MODERADOR"
Marcar como Repetido - Apenas perfil "MODERADOR"
Deletar Comentario - Apenas perfil "MODERADOR"

**Buscar Filme pelo nome** - 
Para essa ação é necessário seguir o seguinte caminho: 
Headers -> Authorization -> Atualizar para seu token ativo como o modelo:
Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2FvIiwicm9sZXMiOlsiUk9MRV9MRUlUT1IiXSwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgyL2FwaS9sb2dpbiIsImV4cCI6MTY1NjY0MzI5M30.env5Gv2XZXoCnUFcZ0vs9-oShCk-UGmcg-3UtmF1MDg
Params -> Adicionar um valor para o parâmetro "titulo"
obs: Se for um titulo com mais de uma palavra é necessário que os espaços sejam subistituidos por "_", por exemplo: 
Batman_Dark_Knigth
 clicar em "Send" 
copie e guarde o campo "imdbID"
Por exemplo:
"Title":"Batman",
"imdbID":"tt0096895" - Guardar este valor

**Avaliar Filme** - 
Seguir o seguinte caminho:
Headers -> Authorization -> Atualizar para seu token ativo como o modelo:
Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2FvIiwicm9sZXMiOlsiUk9MRV9MRUlUT1IiXSwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgyL2FwaS9sb2dpbiIsImV4cCI6MTY1NjY0MzI5M30.env5Gv2XZXoCnUFcZ0vs9-oShCk-UGmcg-3UtmF1MDg
Body -> raw -> colocar o imdbId em "IdFilme" e a sua nota em "avaliacao" de acordo com o modelo:
{
"idFilme":"tt1038686",
"avaliacao":3
}
Ao avaliar um filme o usuario ganha um ponto, isso pode ser verificado no banco de dados, passando o comando:
SELECT * FROM TB_PONTO e clicando em "run"
E na tb_avaliacao constará a avaliação, com a nota e o úsuario que realizou.

**Comentar Filme** - (Para está ação é necessário estar com o perfil no mínimo "BASICO" olhar o **passo extra** depois de cadastro de usuário)
Seguir o seguinte caminho:
Headers -> Authorization -> Atualizar para seu token ativo como o modelo:
Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2FvIiwicm9sZXMiOlsiUk9MRV9MRUlUT1IiXSwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgyL2FwaS9sb2dpbiIsImV4cCI6MTY1NjY0MzI5M30.env5Gv2XZXoCnUFcZ0vs9-oShCk-UGmcg-3UtmF1MDg
Body -> raw -> colocar o imdbId em "IdFilme" e o seu comentario em "comentario" de acordo com o modelo:
{
"idFilme":"tt0848228",
"comentario":"Impressionado!!!!"
}
Ao comentar um filme o usuario ganha um ponto, isso pode ser verificado no banco de dados, passando o comando:
SELECT * FROM TB_PONTO e clicando em "run"
Na tb_comentario constará o comentário e o usuário que realizou.

**Listar Comentarios** 
seguir o seguinte caminho: 
Na URL você deve passar o id do filme que gostaria de vizualizar com comentário, como o modelo:
'http://localhost:8080/filmes/comentarios/tt0848228'
Headers -> Authorization -> Atualizar para seu token ativo como o modelo:
Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2FvIiwicm9sZXMiOlsiUk9MRV9MRUlUT1IiXSwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgyL2FwaS9sb2dpbiIsImV4cCI6MTY1NjY0MzI5M30.env5Gv2XZXoCnUFcZ0vs9-oShCk-UGmcg-3UtmF1MDg
Com isso você pode visualizar o id_comentario de cada comentário, salve este valor

**Comentar comentarios** (Para está ação é necessário estar com o perfil no mínimo "BASICO" olhar o **passo extra** depois de cadastro de usuário)
seguir o seguinte caminho: 
Na URL você deve passar o id do comentário que gostaria de responder, de acordo com o modelo:
'http://localhost:8080/filmes/comentarios/2(sendo 2 o id do comentário)'
Headers -> Authorization -> Atualizar para seu token ativo como o modelo:
Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2FvIiwicm9sZXMiOlsiUk9MRV9MRUlUT1IiXSwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgyL2FwaS9sb2dpbiIsImV4cCI6MTY1NjY0MzI5M30.env5Gv2XZXoCnUFcZ0vs9-oShCk-UGmcg-3UtmF1MDg
Body -> raw -> adicionar a sua resposta em "comentário" como no modelo:
{
"comentario":"Não sabe avaliar um filme"
}
Ao responder um comentário o usuario ganha um ponto, isso pode ser verificado no banco de dados, passando o comando:
SELECT * FROM TB_PONTO e clicando em "run"
Na tb_resposta_comentario constará a resposta e o usuário que realizou.


**Citar Comentario** (Para está ação é necessário estar com o perfil no mínimo "AVANCADO" olhar o **passo extra** depois de cadastro de usuário)
seguir o seguinte caminho:
Na URL você deve passar o id do comentário que gostaria de citar, de acordo com o modelo:
'http://localhost:8080/filmes/comentarios/2(sendo 2 o id do comentário)'
Headers -> Authorization -> Atualizar para seu token ativo como o modelo:
Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2FvIiwicm9sZXMiOlsiUk9MRV9MRUlUT1IiXSwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgyL2FwaS9sb2dpbiIsImV4cCI6MTY1NjY0MzI5M30.env5Gv2XZXoCnUFcZ0vs9-oShCk-UGmcg-3UtmF1MDg

Ao citar um comentário o usuario ganha um ponto, isso pode ser verificado no banco de dados, passando o comando:
SELECT * FROM TB_PONTO e clicando em "run"
Na tb_citacao_comentario constará o comentario que foi citado e o usuário que realizou.

**Gostar do Comentario** (Para está ação é necessário estar com o perfil no mínimo "AVANCADO" olhar o **passo extra** depois de cadastro de usuário)
seguir o seguinte caminho:
Na URL você deve passar o id do comentário que gostaria de gostar, de acordo com o modelo:
'http://localhost:8080/filmes/comentarios/2(sendo 2 o id do comentário)'
Headers -> Authorization -> Atualizar para seu token ativo como o modelo:
Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2FvIiwicm9sZXMiOlsiUk9MRV9MRUlUT1IiXSwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgyL2FwaS9sb2dpbiIsImV4cCI6MTY1NjY0MzI5M30.env5Gv2XZXoCnUFcZ0vs9-oShCk-UGmcg-3UtmF1MDg
Params -> Atribuia um valor de "true" ou "false" para o parâmetro "like"

Na tabela tb_like constará qual usuário efetuou a ação e em qual comentário.

**Marcar Como Repetido** (Para está ação é necessário estar com o perfil "MODERADOR" olhar o **passo extra** depois de cadastro de usuário)
seguir o seguinte caminho:
Na URL você deve passar o id do comentário que gostaria de marcar como repetido, de acordo com o modelo:
'http://localhost:8080/filmes/comentarios/2(sendo 2 o id do comentário)'
Headers -> Authorization -> Atualizar para seu token ativo como o modelo:
Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2FvIiwicm9sZXMiOlsiUk9MRV9MRUlUT1IiXSwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgyL2FwaS9sb2dpbiIsImV4cCI6MTY1NjY0MzI5M30.env5Gv2XZXoCnUFcZ0vs9-oShCk-UGmcg-3UtmF1MDg
Params -> Atribuia um valor de "true" ou "false" para o parâmetro "repetido"

Na tabela tb_repetido constará qual usuário efetuou a ação e em qual comentário.

**Deletar Comentario**
Na URL você deve passar o id do comentário que gostaria de citar, de acordo com o modelo:
'http://localhost:8080/filmes/comentarios/2(sendo 2 o id do comentário)'
Headers -> Authorization -> Atualizar para seu token ativo como o modelo:
Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2FvIiwicm9sZXMiOlsiUk9MRV9MRUlUT1IiXSwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgyL2FwaS9sb2dpbiIsImV4cCI6MTY1NjY0MzI5M30.env5Gv2XZXoCnUFcZ0vs9-oShCk-UGmcg-3UtmF1MDg