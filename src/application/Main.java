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
		List<ScrollPane> fxml;
		Pane root;
		
		// Vamos mandar a lista de produtos para a classe Controlador
		// antes mesmo de carregar os arquivos .fxml.
		Controlador.setListaProdutos(carregarProdutos());
		
		try 
		{
			// Carregar a toolbar.
			root = FXMLLoader.load(getClass().getResource("cenas/Toolbar.fxml"));
			
			// Carregar e fazer uma lista com todas as outras telas.
			fxml = new ArrayList();
			fxml.add(FXMLLoader.load(getClass().getResource("cenas/Principal.fxml")));
			fxml.add(FXMLLoader.load(getClass().getResource("cenas/Funcionario.fxml")));
			fxml.add(FXMLLoader.load(getClass().getResource("cenas/Produto.fxml")));
			
			// Mandar pra classe gerenciadora fazer o resto.
			GerenciadorCenas.inicializar(janela, root, fxml);
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
	 * produtos e as informa��es no nome do mesmo (Pre�o, autor...)
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
		
		// Ir� pegar o diret�rio local da classe
		diretorioLocal = getClass().getResource("imagens").getPath();	
		
		// Instanciar a lista, criar objetos contendo
		// o diret�rio das pastas de cada tipo de produto.
		produtos    = new ArrayList();
		pastaLivros = new File(diretorioLocal + "/livros/");
		pastaDVDs   = new File(diretorioLocal + "/dvds/");
		pastaCDs    = new File(diretorioLocal + "/cds/");
		
		// A partir daqui, teremos 3 foreachs para
		// pegar cada arquivo de cada tipo, criar uma inst�ncia
		// dele e adicionar na lista de produtos.
		for(File arquivo : pastaLivros.listFiles())
		{
			// Vai separar o nome do arquivo pelos
			// tracinhos e colocar todos eles em um vetor.
			informacoes = arquivo.getName().split("-");
			capa = new Image(arquivo.toPath().toUri().toString());

			// Adicionar o objeto � nossa lista.
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
