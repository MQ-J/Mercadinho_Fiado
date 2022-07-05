
## instalando Tomcat no codespaces
https://code.visualstudio.com/docs/java/java-tomcat-jetty#_community-server-connectors

## SERVELET tutorial (faça a rota da página referenciar uma classe do java)
https://www.brandondonnelson.com/2020/06/creating-java-web-app-servlet-in-visual.html

## Desenvolvendo o JSP
- mvn compile (atualiza as classes)
- mvn package (atualiza o arquivo .war)
- espere o output
- atualize a página (f5)

## Controlando rotas
- adicionar o servlet no arquivo web.xml (relaciona classe java com rota do site)
- na classe java, fazer o tratamento usando os modelos, e retornar uma página jsp (sua view)
- na view, mostrar as coisas.

## Banco de dados Elephantsql
https://api.elephantsql.com/console/812fe47f-c7b0-4d3b-be92-562e577c8e04/details

- para fazer operações no banco: https://api.elephantsql.com/console/812fe47f-c7b0-4d3b-be92-562e577c8e04/browser?
- tabela com relacionamento: 
  - NÂO FAÇA ISSO: (cpf, nome, telefone, compras)
values ('35302358069', 'Talita Amarajó', '11987048372', '{}');
  - USE CHAVE ESTRANGEIRA!