## BANCO DE DADOS HEROKU NO JAVA OLHA
- https://devcenter.heroku.com/articles/connecting-heroku-postgres#connecting-in-java
- https://devcenter.heroku.com/articles/connecting-to-relational-databases-on-heroku-with-java#using-the-jdbc_database_url


## instalando Maven no codespaces
https://code.visualstudio.com/docs/java/java-tomcat-jetty#_community-server-connectors

## SERVELET tutorial
https://www.brandondonnelson.com/2020/06/creating-java-web-app-servlet-in-visual.html

## Maven!
- mvn install
- mvn package
- mvn compile

## Desenvolvendo o JSP
- mvn compile (atualiza as classes)
- mvn package (atualiza o arquivo .war)
- atualiza a página (f5)

## Controlando rotas
- adicionar o servlet no arquivo web.xml (relaciona classe java com rota do site)
- na classe java, fazer o tratamento usando os modelos, e retornar uma página jsp (sua view)
- na view, mostrar as coisas.

## INSERT no Heroku
insert into Produto(id, nome, valor)
values(1, 'arroz', 2);

select * from Produto;