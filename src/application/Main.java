package application;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import application.controladores.Controlador;
import application.controladores.ItemCarrinho;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import sistema_loja.classes.vendas.Cadastro;
import sistema_loja.interfaces.Produto;
import javafx.scene.image.Image;

public class Main extends Application 
{
	@Override
	public void start(Stage janela) 
	{
		FXMLLoader toolbar;
		FXMLLoader telaPrincipalLoader;
		FXMLLoader telaFuncionarioLoader;
		FXMLLoader telaProdutoLoader;
		FXMLLoader telaCarrinhoLoader;
		FXMLLoader telaBuscaLoader;
		
		List<ItemCarrinho> carrinho = new ArrayList<ItemCarrinho>();
		
		// Vamos mandar a lista de produtos para a classe Controlador
		// antes mesmo de carregar os arquivos .fxml.
		Controlador.setListaProdutos(carregarProdutos());
		
		//Para inicializar a lista do carrinho, mesmo ela estando vazia.
		Controlador.setListaCarrinho(carrinho);
		
		try 
		{
			// Vamos carregar a toolbar e criar as inst�ncias dos loaders.
			
			// Esses loaders v�o servir para carregar as cenas dentro
			// da GerenciadorCenas mais tarde.
			toolbar               = new FXMLLoader(getClass().getResource("cenas/Toolbar.fxml"));
			telaPrincipalLoader   = new FXMLLoader(getClass().getResource("cenas/Principal.fxml"));
			telaFuncionarioLoader = new FXMLLoader(getClass().getResource("cenas/Funcionario.fxml"));
			telaProdutoLoader     = new FXMLLoader(getClass().getResource("cenas/Produto.fxml"));
			telaCarrinhoLoader    = new FXMLLoader(getClass().getResource("cenas/Carrinho.fxml"));
			telaBuscaLoader       = new FXMLLoader(getClass().getResource("cenas/Busca.fxml"));
			
			// Mandar pra classe gerenciadora fazer o resto.
			GerenciadorCenas.inicializar(janela, 
					toolbar, telaPrincipalLoader, telaFuncionarioLoader, 
					telaProdutoLoader, telaCarrinhoLoader, telaBuscaLoader);
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
	
	/**
	 * M�todo que ir� carregar as imagens dos
	 * produtos e as informações no nome do mesmo (Preço, autor...)
	 * 
	 * @return Um mapa com os produtos carregados
	 */
	public List<Produto> carregarProdutos()
	{
		List<Produto> produtos;
		Cadastro cadastro;
		String diretorioLocal;
		File pastaLivros;
		File pastaDVDs;
		File pastaCDs;

		String[] informacoes;
		Image capa;
		
		// Ir� pegar o diret�rio local da classe
		diretorioLocal = getClass().getResource("imagens").getPath();	
		
		// Instanciar a lista, criar objetos contendo
		// o diret�rio das pastas de cada tipo de produto.
		produtos    = new ArrayList<Produto>();
		pastaLivros = new File(diretorioLocal + "/livros/");
		pastaDVDs   = new File(diretorioLocal + "/dvds/");
		pastaCDs    = new File(diretorioLocal + "/cds/");
		
		// Criar uma inst�ncia da classe cadastro
		// para cadastrar os produtos.
		cadastro = new Cadastro(produtos);
		
		// A partir daqui, teremos 3 foreachs para
		// pegar cada arquivo de cada tipo, criar uma inst�ncia
		// dele e adicionar na lista de produtos.
		for(File arquivo : pastaLivros.listFiles())
		{		
			// Vai separar o nome do arquivo pelos
			// tracinhos e colocar todos eles em um vetor.
			informacoes = arquivo.getName().split("-");
			capa = new Image(arquivo.toPath().toUri().toString());
			
			cadastro.cadastrarLivro(
					informacoes[0],  // Código
					informacoes[1],  // Título
					informacoes[2],  // Autor
					informacoes[3],  // Categoria
					informacoes[4],  // Preço
					capa,            // Imagem da capa
					informacoes[5]); // Quantidade
		}
		
		for(File arquivo : pastaDVDs.listFiles())
		{
			informacoes = arquivo.getName().split("-");
			capa = new Image(arquivo.toPath().toUri().toString());
			
			cadastro.cadastrarDVD(
					informacoes[0],  // Código
					informacoes[1],  // Título
					informacoes[2],  // Autor
					informacoes[3],  // Duração
					informacoes[4],  // Preço
					capa,            // Imagem da capa
					informacoes[5]); // Quantidade
		}
		
		for(File arquivo : pastaCDs.listFiles())
		{
			informacoes = arquivo.getName().split("-");
			capa = new Image(arquivo.toPath().toUri().toString());

			cadastro.cadastrarCD(
					informacoes[0],  // Código
					informacoes[1],  // Título
					informacoes[2],  // Autor
					informacoes[3],  // Ano
					informacoes[4],  // Preço
					capa,            // Imagem da capa
					informacoes[5]); // Quantidade
		}
		
		return produtos;
	}
}
