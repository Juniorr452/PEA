package application;

import java.io.File;
import java.net.URISyntaxException;
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
		FXMLLoader telaCarrinhoLoader;
		FXMLLoader telaBuscaLoader;
		FXMLLoader telaVendaLoader;
		
		// Vamos mandar a lista de produtos para a classe Controlador
		// antes mesmo de carregar os arquivos .fxml.
		Controlador.inicializar(carregarProdutos());
		
		try 
		{
			// Esses loaders v�o servir para carregar as cenas dentro
			// da GerenciadorCenas mais tarde.
			toolbar               = new FXMLLoader(getClass().getResource("cenas/Toolbar.fxml"));
			telaPrincipalLoader   = new FXMLLoader(getClass().getResource("cenas/Principal.fxml"));
			telaFuncionarioLoader = new FXMLLoader(getClass().getResource("cenas/Funcionario.fxml"));
			telaProdutoLoader     = new FXMLLoader(getClass().getResource("cenas/Produto.fxml"));
			telaCarrinhoLoader    = new FXMLLoader(getClass().getResource("cenas/Carrinho.fxml"));
			telaBuscaLoader       = new FXMLLoader(getClass().getResource("cenas/Busca.fxml"));
			telaVendaLoader       = new FXMLLoader(getClass().getResource("cenas/Venda.fxml"));
			// Mandar pra classe gerenciadora fazer o resto.
			GerenciadorCenas.inicializar(janela, 
					toolbar, telaPrincipalLoader, telaFuncionarioLoader, 
					telaProdutoLoader, telaCarrinhoLoader, telaBuscaLoader, telaVendaLoader);
		} 
		catch(Exception e) 
		{
			//Janelas.mensagem("Erro", "Um erro inesperado aconteceu. Notifique algum funcionário "
			//		+ "para verificar o problema.", AlertType.ERROR);
			
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
	 * @throws URISyntaxException 
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
		
		// Irá pegar o diretório local da classe com o System.getProperty
		// e irá substituir os caracteres \ com / para funcionar o carregamento
		// dos arquivos com a função converterDiretorio.
		diretorioLocal = converterDiretorio(System.getProperty("user.dir") + "/imagens");
		
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
	
	/**
	 * Pega os caracteres "\" de uma string e as
	 * substitui por "/". Tentei usar o replaceAll
	 * para isso, mas não consegui e criei essa função.
	 * @param diretorio
	 * @return A string com o diretório contendo /
	 */
	private String converterDiretorio(String diretorio)
	{
		String novoDiretorio = "";
	
		for (char c : diretorio.toCharArray())
			if (c == '\\')
				novoDiretorio += '/';
			else
				novoDiretorio += c;
		
		return novoDiretorio;
	}
}
