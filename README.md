# PEA
--------------------------------------------------------------------------------------------------------------------------------
Para	 driblar	 a	 crise,	 um	 cliente	 está	 querendo	 inovar	 no	 seu	
negócio de	 vendas	 de	 Livros,	 CD	 e	 DVD.	 Ele	 teve	 a	 ideia	 de	
substituir	os	vendedores	da	loja	por	estações	de	autoatendimento.	
A	ideia	é	que	o	cliente	possa	usá-lo	para	consultar	os	produtos	na	
loja	e	realizar	suas	compras.
Diante	 disso,	 o projeto	 deve	 ser	 composto	 por um	 sistema	 de	 carrinho	 de	 compras	
automatizado e	inteligente, que	permite	 o	 usuário	listar	 os	 produtos	 cadastrados	no	
sistema	e	adicionar	no	carrinho	os	produtos	com	suas	respectivas	quantidades.
Ao	escolher	os	produtos,	o	sistema	deve	permitir	o	usuário	visualizar	todos	os	itens	do	
seu	carrinho,	seus	respectivos	preços	e	o	valor	total	da	compra. Além	disso,	o	sistema	
deve	possibilitar	a	remoção	de	um	dos	itens	do	carrinho.
Por	fim,	o	sistema	deve	permitir	que	o	cliente	finalize a	sua	compra e	um	número	de	
pedido	 é	 gerado.	 Esta	 compra	 deve	 ser	 armazenada e	 permitir que outro	 usuário	
também	faça	sua	compra. Para	evitar	fraudes,	o	sistema	deve	permitir	a	compra	de,	no	
máximo,	 10	 itens	 de	 cada	 produto. Este	 tratamento	 deve	 ser	 feito	 quando	 o	 cliente	
finalizar	a	compra.
Portanto,	o	sistema	deve	possuir	as	seguintes	funcionalidades:
1. (1,0)	Cadastrar produto	(acesso	restrito	com senha: 123)
2. (1,0)	Listar produtos
3. (2,0)	Adicionar	produto	ao	carrinho	com	sua	quantidade
4. (0,5)	Visualizar o	carrinho
5. (1,5)	Excluir	produto	do	carrinho
6. (2,0)	Finalizar	a	compra
7. (2,0) Listar	compras	realizadas (acesso	restrito	com senha: 123)
8. (1,0)	Controlar	estoque (opcional) (acesso	restrito	com senha: 123)

Para	 a	 implementação	 do	 sistema,	 utilizar	 as	 seguintes	 regras (implementar	 a	
funcionalidade	sem	suas	respectivas	regras	implica	na	perda	de	50%	da	sua	pontuação):
• Utilizar	Interfaces	e	Herança	para	os	produtos
• Utilizar	 coleções nos cadastros	 de	 produto,	 produtos	 no	 carrinho	 e	 compras	
realizadas;
• Utilizar	exceções	nos	seguintes	casos:
o Ao	cadastrar	um	produto	com	o	código	já	existente;
o Ao	 finalizar	 a	 compra	 e	 houver	 um	 produto	 acima	 do	 limite	 máximo	
permitido	(10);
o Efetuar	a	compra	de	um	produto	que	não	tem	em	estoque	(opcional)
--------------------------------------------------------------------------------------------------------------------------------

Então...

Eu diria que seria bom começarmos a implementar as classes dos produtos por agora. Estou pensando de colocar 24 produtos (8 em cada categoria) ao carregar a tela principal. O usuário poderá clicar em "Ver todos" e ir para uma tela listando os produtos da categoria selecionada. Outra forma de acessar a lista de produtos seria utilizar a busca na barra superior direita.

Talvez essa parte de busca seria melhor colocarmos mais quando tivermos todas as funções básicas que o professor quer no nosso sistema. Podemos começar fazendo as classes dos produtos, criando a tela de listar todos os produtos da loja e a tela do carrinho de compras. Qualquer dúvida a respeito do código perguntem no grupo.
