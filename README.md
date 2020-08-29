<h1 align="center">Automação Salsa Technology</h1>
<h1 align="center">
    <a href="https://www.oracle.com/br/java/technologies/javase/javase-jdk8-downloads.html">🔗 Java</a>
    <a href="https://www.selenium.dev/">🔗 Selenium</a>
    <a href="http://cucumber.io/">🔗 Cucumber</a>
    <a href="https://community.jaspersoft.com/">🔗 JasperReports</a>
    <a href="https://junit.org/junit5/">🔗 jUnit</a>
    <a href="https://github.com/DiUS/java-faker">🔗 Faker</a>

</h1>
<p align="center">🚀 Projeto de automação de testes utilizando as técnicas da metodologia BDD.</p>


## Começando

Para executar o projeto, será necessário instalar os seguintes programas:

- [JDK 8: Necessário para executar o projeto Java](https://www.oracle.com/br/java/technologies/javase/javase-jdk8-downloads.html)
- [Maven 3.6.3: Necessário para realizar o build do projeto Java](https://downloads.apache.org/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.zip)

*Não Esqueça de configurar as variáveis de ambiente para execução.
- [Tutorial para configuração das variáveis](https://medium.com/beelabacademy/configurando-vari%C3%A1veis-de-ambiente-java-home-e-maven-home-no-windows-e-unix-d9461f783c26#:~:text=Bom%2C%20mas%20o%20que%20s%C3%A3o,arquivos%20necess%C3%A1rios%2C%20inclusive%20os%20bin%C3%A1rios.)
- [IntelliJ: Para desenvolvimento do projeto](https://www.jetbrains.com/pt-br/idea/) 
                                                                  
*Instale também os plugins Gherkin e Cucumber for Java.

- [Git: Para versionamento e clone do projeto](https://github.com/barbosamp/JavaBDD)


## Execução Via Terminal

É possível executar o projeto via linha de comando. Após configurar as variáveis de ambiente abra o terminal.

```bash
# clonando projeto do git
$ git clone https://github.com/barbosamp/javabdd.git

# acesse a pasta do projeto
$ cd JavaBDD

# execute o comando do maven para execução dos testes.
$ mvn clean install && test
```

## Execução via IDE

```bash
├───chromewindows    - Contém o chromeWebDriver                                 
├───evidence         - Evidências de execução no formato DOC                                 
│   ├───failed                                        
│   └───passed                                        
├───report           - Configuração do JasperReports                                 
├───src                                               
│   ├───main                                          
│   │   ├───java                                      
│   │   │   └───br                                    
│   │   │       └───com                               
│   │   │           └───application                   
│   │   │               └───name                      
│   │   │                   ├───anotation             
│   │   │                   ├───commons             
│   │   │                   ├───configuration         
│   │   │                   ├───enums                 
│   │   │                   ├───interfaces            
│   │   │                   ├───reports               
│   │   │                   │   ├───evidence          
│   │   │                   │   │   └───funcionalidade
│   │   │                   │   ├───images            
│   │   │                   │   └───model             
│   │   │                   └───web                   
│   │   │                       ├───funcionalidade    - Interações com a tela.
│   │   │                       └───pages             - Mapeamento de elementos
│   │   └───resources     - Properties do projeto. 
│   └───test                                          
│       ├───java                                      
│       │   └───br                                    
│       │       └───com                               
│       │           ├───appName                       
│       │           │   └───steps                     
│       │           │       └───web                   - Steps de testes cucumber
│       │           └───runTest                       - Classe de execução dos testes.
│       └───resources                                 
│           └───features                              - Cenários de Teste no formato Gherkin
```

O arquivo que deve ser executado encontra-se:
```bash
# src/test/java/br/com/runTest/RunTest.java

# Executa os dois cenários criados reutilizando a massa em tempo de execução.
tags = {"@cadastro, @login"})

# Executa somente o cenário de cadastro de um novo usuário. As informações estarão gravadas no arquivo:
# src/main/resources/application.properties
tags = {"@cadastro"})

# Executa somente o cenário de login reutilizando os dados inseridos no cadastro anterior.
tags = {"@login"})

```

#### [IntelliJ] Para executar o projeto basta clicar com o botão direito do mouse -> Run 'RunTest'

## Evidências
As evidêcnias dos testes estão localizadas após a execução em: 
```bash
JavaBdd/evidence
```
## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)
