#language: pt
@funcionais
Funcionalidade: Login de usuário
  Como usuário
  Gostaria de logar no sistema SwagLabs
  Para que eu consiga realizar uma compra

Contexto:
  Dado que estou no site
  E somente poderei utilizar os logins preestabelecidos

Esquema do Cenario: Deve validar as regras de login
  Quando preencho o primeiro campo com um "<login>"
  E preencho o segundo campo com uma "<senha>"
  E clico no botão de Login
  Então a tela de produtos aparece

  Exemplos:
    | login                   | senha        |
    | standard_user           | secret_sauce |
    | problem_user            | secret_sauce |
    | performance_glitch_user | secret_sauce |
