#language: pt
#encoding: UTF-8
#author: Marcos Barbosa


  Funcionalidade: Cadastro de usuário

    @web @cadastro
    Cenario: Validar mensagem de sucesso ao cadastrar um usuário

      Dado que acesso a pagina inicial do sistema
      E estou realizando o teste
        | Numero do CT |                          Nome do CT            | Nome do executor   | Sprint   |
        | 123-XXX      |         Realizar cadastro de um novo usuário   |  Marcos Barbosa    | Sprint X |
      E acesso a tela de registro
      E preencho os dados validos de cadastro
      Entao visualizo a mensagem "Your Account Has Been Created!"
      E realizo logout no sistema
