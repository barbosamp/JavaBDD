#language: pt
#encoding: UTF-8
#author: Marcos Barbosa


  Funcionalidade: Login

    @web @login
    Cenario: Realizar login no sistema com usuário válido

      Dado que acesso a pagina inicial do sistema
      E estou realizando o teste
        | Numero do CT |                          Nome do CT            | Nome do executor   | Sprint   |
        | 1234-XXX     |  Realizar login no sistema com usuário válido  |  Marcos Barbosa    | Sprint X |
      E acesso a tela de login
      Quando insiro credenciais do tipo "valido"
      Entao visualizo a tela de My Account
