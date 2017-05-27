package application.controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.GerenciadorCenas;
import application.Janelas;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import sistema_loja.classes.produtos.Cd;
import sistema_loja.classes.produtos.Dvd;
import sistema_loja.classes.produtos.Livro;
import sistema_loja.interfaces.Produto;

public class ControladorFuncionario extends Controlador implements Initializable
{
    @FXML private VBox menuFuncionario;
	@FXML private VBox menuListaCompras;
	@FXML private VBox menuCadastrar;
	
	@FXML private ComboBox<String> tipoProduto;
	@FXML private ImageView imagem;
	@FXML private TextField codigo;
	@FXML private TextField nome;
	@FXML private TextField autor;
	// Campo Ano/Categoria/Duracao
	@FXML private TextField campoACD;
	@FXML private TextField preco;
	@FXML private TextField quantidade;
	
	@FXML private Button cadastrar;
	
	private Image imagemProdutoPadrao;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		imagemProdutoPadrao = imagem.getImage();
	}
	
	/**
	 * Chamado ao clicar no botão cadastrar,
	 * no primeiro menu da tela.
	 */
	@FXML
	private void irCadastrar()
	{
		mudarTela(menuFuncionario, menuCadastrar);
	}
	
	/**
	 * Função utilizada internamente para
	 * tornar um elemento invisível e outro visível,
	 * dando a impressão de trocar de tela.
	 * @param telaAtual - VBox na qual você está.
	 * @param telaDestino - VBox na qual você deseja ir.
	 */
	private void mudarTela(VBox telaAtual, VBox telaDestino)
	{
		telaAtual.setVisible(false);
		telaDestino.setVisible(true);
	}
	
	@FXML 
	private void listarCompras()
	{
		System.out.println("Listar compras");
	}
	
	@FXML
	private void sair() throws IOException
	{
		GerenciadorCenas.irPara(PRINCIPAL);
	}
	
	/**
	 * Chamado ao clicar no botão
	 * escolher imagem.
	 */
	@FXML
	private void escolherImagem()
	{
		imagem.setImage(Janelas.escolherImagem());
	}
	
	/**
	 * Chamado quando o funcionário
	 * selecionar outro valor na caixa
	 * de tipo.
	 */
	@FXML 
	private void mudarTipo()
	{
		switch(tipoProduto.getValue())
		{
		case "Livro":
			campoACD.setPromptText("Categoria");
			break;
			
		case "DVD":
			campoACD.setPromptText("Duração");
			break;
			
		case "CD":
			campoACD.setPromptText("Ano");
			break;
		}
	}
	
	/**
	 * Chamado ao clicar no botão de cadastrar.
	 * Vai verificar os campos para ver se são
	 * nulos, pegar as informações, ver o tipo
	 * de produto e cadastrar de acordo com ele.
	 * 
	 * Reseta os campos aos valores originais no
	 * fim da operação.
	 */
	@FXML
	private void cadastrar()
	{
		Produto p;
		
		String codigo;
		String nome;
		String autor;
		String campoACD;
		double preco;
		int    quantidade;
		Image  imagem;

		if (verificarCampos())
		{
			codigo = this.codigo.getText();
			nome = this.nome.getText();
			autor = this.autor.getText();
			campoACD = this.campoACD.getText();
			preco = Double.parseDouble(this.preco.getText());
			quantidade = Integer.parseInt(this.quantidade.getText());
			imagem = this.imagem.getImage();
			
			switch(tipoProduto.getValue())
			{
			case "Livro":
				p = new Livro(nome, autor, campoACD, preco, imagem, quantidade);
				break;
				
			case "DVD":
				p = new Dvd(nome, autor, campoACD, preco, imagem, quantidade);
				break;
				
			case "CD":
				p = new Cd(nome, autor, campoACD, preco, imagem, quantidade);
				break;
				
			default:
				p = null;
				break;
			}
			
			produtos.add(p);
			Janelas.mensagem("Sucesso", "Produto cadastrado com sucesso", AlertType.CONFIRMATION);
			mudarTela(menuCadastrar, menuFuncionario);
			resetarCampos();
		}
		else
		{
			Janelas.mensagem("Erro", "Preencha todos os campos antes de continuar", AlertType.ERROR);
		}
	}

	@FXML
	private void cancelar()
	{
		mudarTela(menuCadastrar, menuFuncionario);
	}
	
	/**
	 * Limpa os valores que estiverem nos campos.
	 */
	private void resetarCampos()
	{
		imagem.setImage(imagemProdutoPadrao);
		codigo.clear();
		nome.clear();
		autor.clear();
		campoACD.clear();
		preco.clear();
		quantidade.clear();
	}
	
	/**
	 * Verifica se os valores dos campos obrigatórios
	 * não foram digitados.
	 * @return true, se todos foram preenchidos.
	 * <P>
	 * false, se existe algum sem informação.
	 */
	private boolean verificarCampos()
	{
		if (codigo.getText().equals("")     ||
			nome.getText().equals("")       ||
			autor.getText().equals("")      ||
			campoACD.getText().equals("")   ||
			preco.getText().equals("")      ||
			quantidade.getText().equals("") ||
			imagem.getImage()      == null  ||
		    tipoProduto.getValue() == null)
		{
			return false;
		}		
		else
			return true;	
	}
}
