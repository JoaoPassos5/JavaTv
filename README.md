## Relatório do Projeto

## Título
FEITV

## Descrição
Sistema desenvolvido em Java com Login e Cadastro, gerenciamento de vídeos, listas e favoritos.

## Funcionalidades
- Cadastro de usuários
- Login
- Curtir e Descurtir vídeos
- Criação de listas
- Edição de listas
- Sistema de favoritos
- Listagem de vídeos

## Tecnologias utilizadas
- Java
- Swing
- MySQL
- JDBC

## Estrutura do Projeto

### classe main
A classe Main é responsável por iniciar o sistema e abrir a tela inicial da aplicação.

### model
Responsável pelas entidades do sistema.

### dao
Responsável pelo acesso ao banco de dados.

### view
Responsável pelas telas do sistema.

### controller
Responsável pelo controle das ações do sistema.

## Banco de Dados
O sistema utiliza banco de dados MySQL para armazenar:
- usuários
- vídeos
- listas
- curtidas e descurtidas
- favoritos

## Fluxo de Navegação do Sistema

O sistema inicia na tela de login, onde o usuário pode entrar com uma conta existente ou acessar a tela de cadastro.

Após realizar o login, o usuário é direcionado para a tela principal do sistema, onde possui acesso às funcionalidades disponíveis.

### Fluxo das telas

Login → Cadastro 

Cadastro → Login

Login → Menu Principal  
Menu Principal → Menu de Vídeos  
Menu Principal → Menu de Favoritos  
Menu Principal → Listas 

Menu de Vídeos → Menu Principal

Menu de Favoritos → Menu Principal

Listas → Menu Principal

## Interfaces do Sistema

### Tela de Login
A tela de login é responsável pela autenticação do usuário no sistema, permitindo acesso às funcionalidades disponíveis através do usuário e senha cadastrados.

### Tela de Cadastro
A tela de cadastro permite registrar novos usuários no banco de dados, possibilitando futuros acessos ao sistema.

### Menu Principal
O menu principal centraliza as funcionalidades do sistema, permitindo acesso rápido às telas de vídeos, favoritos e listas.

### Menu de Vídeos
A interface de vídeos permite visualizar os conteúdos cadastrados no sistema, filtrando entre séries e filmes, além de possibilitar interação com curtidas e favoritos.

### Menu de Favoritos
A tela de favoritos permite ao usuário favoritar e desfavoritar vídeos de sua escolha.

### Menu de Listas
A funcionalidade de listas permite organizar vídeos favoritos em "playlists" criadas pelo usuário.

## Dificuldades Encontradas

Durante o desenvolvimento do projeto, algumas dificuldades foram encontradas principalmente na integração entre Java e MySQL, manipulação de interfaces gráficas com Swing e organização da estrutura MVC.

Também foram realizados ajustes relacionados à navegação entre telas, consultas SQL e gerenciamento das listas e favoritos.

## Conclusão

O projeto permitiu aplicar conhecimentos de programação orientada a objetos, banco de dados e desenvolvimento de interfaces gráficas em Java.

Além disso, o desenvolvimento contribuiu para o aprendizado sobre organização de sistemas utilizando a arquitetura MVC, integração com banco de dados MySQL e construção de aplicações desktop funcionais.

## Aprendizados
Durante o desenvolvimento foram trabalhados:
- Programação orientada a objetos
- Integração com banco de dados
- Estrutura MVC
- Desenvolvimento de interfaces gráficas

## Imagens

<img width="668" height="999" alt="image" src="https://github.com/user-attachments/assets/9d981c69-f831-4ee4-920c-5108555569cd" />
<img width="596" height="594" alt="image" src="https://github.com/user-attachments/assets/c038597a-bcd7-4246-b53c-495e09d315d8" />
<img width="540" height="776" alt="image" src="https://github.com/user-attachments/assets/24fb2ecc-77e2-441b-8d12-63b23fa1ddf5" />
<img width="596" height="284" alt="image" src="https://github.com/user-attachments/assets/e72902e1-6e9f-4915-8e4d-7117c2fbede4" />


## Autor
- João Victor Ferreira Passos
