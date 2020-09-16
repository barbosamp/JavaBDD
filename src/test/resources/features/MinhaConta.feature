#language: pt
#enconding: UTF-8
#author: Marcos Barbosa
#date: 15/09/2020
#version: 1.0

  Funcionalidade: Minha Conta

    @login @web
    Cenario: Realizar a alteração das informações de conta do usuário cadastrado
      Dado que acesso a pagina inicial do sistema
      E estou realizando o teste
        | Numero do CT |                          Nome do CT                                           | Nome do executor   | Sprint   |
        | 123-XXX      |         Realizar a alteração das informações de conta do usuário cadastrado   |  Marcos Barbosa    | Sprint X |
      E realizo login no sistema com usuario cadastrado
      E acesso a tela de informações do usuario
      Quando altero o nome do usuario
      E clico no botao "Continue"
      Entao visualizo a mensagem "Success: Your account has been successfully updated." na tela de conta