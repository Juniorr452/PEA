package application;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import application.controladores.Controlador;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import sistema_loja.classes.produtos.Cd;
import sistema_loja.classes.produtos.Dvd;
import sistema_loja.classes.produtos.Livro;
import sistema_loja.interfaces.Produto;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class Main extends Application 
{
	@Override
	public void start(Stage janela) 
	{
		Pane       toolbar;
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
			toolbar = FXMLLoader.load(getClass().getResource("cenas/Toolbar.fxml"));
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
		
		// A partir daqui, teremos 3 foreachs para
		// pegar cada arquivo de cada tipo, criar uma instï¿½ncia
		// dele e adicionar na lista de produtos.
		for(File arquivo : pastaLivros.listFiles())
		{
			// Vai separar o nome do arquivo pelos
			// tracinhos e colocar todos eles em um vetor.
			informacoes = arquivo.getName().split("-");
			capa = new Image(arquivo.toPath().toUri().toString());

			// Adicionar o objeto ï¿½ nossa lista.
			// 0 - Titulo / 1 - Autor / 2 - Categoria / 3 - Preco / Capa - Imagem
			produtos.add(new Livro(informacoes[0], informacoes[1], informacoes[2], 
					               Double.parseDouble(informacoes[3]), capa));
		}
		
		for(File arquivo : pastaDVDs.listFiles())
		{
			informacoes = arquivo.getName().split("-");
			capa = new Image(arquivo.toPath().toUri().toString());

			produtos.add(new Dvd(informacoes[0], informacoes[1], informacoes[2], 
					               Double.parseDouble(informacoes[3]), capa));
		}
		
		for(File arquivo : pastaCDs.listFiles())
		{
			informacoes = arquivo.getName().split("-");
			capa = new Image(arquivo.toPath().toUri().toString());

			produtos.add(new Cd(informacoes[0], informacoes[1], informacoes[2], 
					               Double.parseDouble(informacoes[3]), capa));
		}
		
		return produtos;
	}
}
