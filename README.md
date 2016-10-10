# plataformavideos
Plataforma de vídeos desktop em JavaFX.<br>
**Projeto desenvolvido por alunos do curso do Bachalado em Tecnologia da Informação da UFRN para a disciplina de Desenvolvimento para ambientes em desktop**

####PROFESSOR
Handerson Bezerra Medeiros

####ALUNOS
Francleide Simão e
Maria Clara Pereira


####O PROJETO
<p>O projeto é uma plataforma de videos, séries e filmes. O sistema deve  listá-los e catalogados com as seguintes informações: Nome, descrição, ano, temporada, episódio, duração, categoria, diretor, ator principal, faixa etária,   
</p><p>O usuário deve possuir uma conta para ter acesso a plataforma. Após logar, o usuário tem acesso aos filmes e séries recém cadastradas na plataforma e/ou antigos. Como atrativo da plataforma, ela deve disponibilizar formas para o usuário favoritar seus filmes e series, para assisti-los, revê-lo e também buscá-los.
</p><p>Na busca, o usuário, pode pesquisar por: nome, Ator principal, em determinada categoria ou não. O sistema deve está ciente que não deve aparecer conteúdo que não seja adequado para a faixa etária do usuário. 
</p><p> Quando escolher um conteúdo, o usuário terá acesso a informações mais detalhadas sobre o conteúdo, como: imagem, temporadas, descrição e etc. Ao selecionar o conteúdo para assistir, o usuário pode a qualquer momento pausar, tocar ou parar o vídeo. O usuário deve ver uma timeline do video e controlar seu volume. 
</p><p>O Administrador, deve ter acesso ao cadastro de conteúdo, onde ele irá subir novos vídeos para a plataforma que ficarão disponíveis para os usuários, apenas os administradores terão acesso a essa função. 
</p>
######IMPLEMENTAÇÃO
O sistema será desenvolvido na linguagem Java utilizando a biblioteca JavaFX.

#####REQUISITOS E FUNCIONALIDADES
Usuários | Descrição
---------|----------
Cliente  |Pode visualizar os filmes, vídeos e séries cadastradas
Administrador |Pode adicionar, editar e excluir os filmes, vídeos e séries.

 Funcionalidade | Descrição  
----------------|------------
Efetuar login   | O usuário deve efetuar login para poder ter acesso ao sistema
Criar conta de usuário| O usuário tem que criar uma conta para efetuar um login
Listar favorito | O usuário poderá visualizar os vídeos ou séries que foram marcadas como favoritas
Favoritar vídeos ou séries | O usuário pode adicionar um vídeo ou série a uma lista de favoritos
Buscar vídeos ou série | O usuário  pode buscar um vídeo ou série
Listar vídeos | O usuário poderá visualizar todos os vídeos adicionados pelo administrador
Cadastrar vídeo ou filme| O administrador poderá cadastrar, editar ou excluir um vídeo ou filme
Cadastrar série, temporada e epsódio | O administrador poderá cadastrar, editar ou excluir uma série, temporada e epsiódio
Exibir detalhe do item | Quando o usuário clicar em um item irá aparecer as informações sobre ele como descrição, ano, ator e etc
Assistir filmes e epsódio | Quando o usuário visualizar os detalhes do filme ou série poderá assistir ao clicar em assistir e controlar a exibição do vídeo com os controles de play, pause, parar, recuar ou acelerar um video.

#####ENTREGAS
>Sprint 1 - 12/10
>Sprint 2 - 26/10

 Sprints | Funcionalidade | Responsável
---------|----------------|------------
  1      | Efetuar login  |Francleide
  1      | Criar conta de usuário | Francleide
  1      | Buscar vídeos ou série |
  1      | Listar vídeos |
  1      | Cadastrar vídeo |
  2      | Cadastrar série, temporada e epsódio |Francleide
  2      | Exibir detalhe do item |
  2      | Assistir filmes e epsódio |
  2      | Listar favorito | Francleide
  2      | Favoritar vídeos ou séries | Francleide
       
<br>
####DIAGRAMAS
######CASOS DE USO
<img src="https://github.com/francleide/plataformavideos/blob/master/Caso_de_Uso_reformulado2.jpg" alt="Caso de Uso" />

######BANCO DE DADOS
<img src="https://github.com/francleide/plataformavideos/blob/master/diagrama_BD.png" alt="Banco de dados" />
####CONCLUSÃO
