package application;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import application.controladores.Controlador;
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
		
		// Vamos mandar a lista de produtos para a classe Controlador
		// antes mesmo de carregar os arquivos .fxml.
		Controlador.setListaProdutos(carregarProdutos());
		
		try 
		{
			// Vamos carregar a toolbar e criar as instâncias dos loaders.
			
			// Esses loaders vão servir para carregar as cenas dentro
			// da GerenciadorCenas mais tarde.
			toolbar = new FXMLLoader(getClass().getResource("cenas/Toolbar.fxml"));
			telaPrincipalLoader = new FXMLLoader(getClass().getResource("cenas/Principal.fxml"));
			telaFuncionarioLoader = new FXMLLoader(getClass().getResource("cenas/Funcionario.fxml"));
			telaProdutoLoader = new FXMLLoader(getClass().getResource("cenas/Produto.fxml"));
			
			// Mandar pra classe gerenciadora fazer o resto.
			GerenciadorCenas.inicializar(janela, toolbar, telaPrincipalLoader,
					                     telaFuncionarioLoader, telaProdutoLoader);
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
	 * Mï¿½todo que irï¿½ carregar as imagens dos
	 * produtos e as informaï¿½ï¿½es no nome do mesmo (Preï¿½o, autor...)
	 * 
	 * @return Uma lista com os produtos carregados
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
		
		// Irï¿½ pegar o diretï¿½rio local da classe
		diretorioLocal = getClass().getResource("imagens").getPath();	
		
		// Instanciar a lista, criar objetos contendo
		// o diretï¿½rio das pastas de cada tipo de produto.
		produtos    = new ArrayList<Produto>();
		pastaLivros = new File(diretorioLocal + "/livros/");
		pastaDVDs   = new File(diretorioLocal + "/dvds/");
		pastaCDs    = new File(diretorioLocal + "/cds/");
		
		// Criar uma instância da classe cadastro
		// para cadastrar os produtos.
		cadastro = new Cadastro(produtos);
		
		// A partir daqui, teremos 3 foreachs para
		// pegar cada arquivo de cada tipo, criar uma instï¿½ncia
		// dele e adicionar na lista de produtos.
		for(File arquivo : pastaLivros.listFiles())
		{		
			// Vai separar o nome do arquivo pelos
			// tracinhos e colocar todos eles em um vetor.
			informacoes = arquivo.getName().split("-");
			capa = new Image(arquivo.toPath().toUri().toString());
			
			cadastro.cadastrarLivro(
					informacoes[0],  // Título
					informacoes[1],  // Autor
					informacoes[2],  // Categoria
					informacoes[3],  // Preco 
					capa,            // Imagem da capa
					informacoes[4]); // Quantidade
		}
		
		for(File arquivo : pastaDVDs.listFiles())
		{
			informacoes = arquivo.getName().split("-");
			capa = new Image(arquivo.toPath().toUri().toString());
			
			cadastro.cadastrarDVD(informacoes[0], informacoes[1],
					informacoes[2], informacoes[3], capa, informacoes[4]);
		}
		
		for(File arquivo : pastaCDs.listFiles())
		{
			informacoes = arquivo.getName().split("-");
			capa = new Image(arquivo.toPath().toUri().toString());

			cadastro.cadastrarCD(informacoes[0], informacoes[1],
					informacoes[2], informacoes[3], capa, informacoes[4]);
		}
		
		return produtos;
	}
}
