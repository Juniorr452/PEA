package application.controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.GerenciadorCenas;
import application.Janelas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import sistema_loja.classes.produtos.Cd;
import sistema_loja.classes.produtos.Dvd;
import sistema_loja.classes.produtos.Livro;
import sistema_loja.classes.vendas.Venda;
import sistema_loja.exceptions.CodigoJaExistenteException;
import sistema_loja.interfaces.Produto;

public class ControladorFuncionario extends Controlador implements Initializable
{
	// Menu funcionário
    @FXML private VBox menuFuncionario;
	@FXML private VBox menuListaCompras;
	@FXML private VBox menuCadastrar;
	
	// Listar compras
	@FXML private TableView<Venda> tabelaVendas;
	@FXML private TableColumn<Venda, String> colunaNumeroPedido;
	@FXML private TableColumn<Venda, String>  colunaNome;
	@FXML private TableColumn<Venda, String>  colunaCpf;
	@FXML private TableColumn<Venda, String>  colunaCidade;
	@FXML private TableColumn<Venda, String>  colunaTelefone;
	@FXML private TableColumn<Venda, Double>  colunaValorTotal;
	
	// Cadastrar produto
	@FXML private ComboBox<String> tipoProduto;
	@FXML private ImageView imagem;
	@FXML private TextField codigo;
	@FXML private TextField nome;
	@FXML private TextField autor;
	// Campo Ano/Categoria/Duração
	@FXML private TextField campoACD;
	@FXML private TextField preco;
	@FXML private TextField quantidade;
	@FXML private TextField descricao;
	@FXML private Button cadastrar;
	
	private Image imagemProdutoPadrao;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		carregarTabelaVendas();
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
	 * Utilizada internamente para
	 * tornar um elemento invisível e outro visível,
	 * dando a impressão de trocar de tela.
	 * @param telaAtual - VBox na qual voc� est�.
	 * @param telaDestino - VBox na qual voc� deseja ir.
	 */
	private void mudarTela(VBox telaAtual, VBox telaDestino)
	{
		telaAtual.setVisible(false);
		telaDestino.setVisible(true);
	}
	
	@FXML 
	private void listarCompras()
	{
		mudarTela(menuFuncionario, menuListaCompras);
	}
	
	@FXML
	private void retornar()
	{
		mudarTela(menuListaCompras, menuFuncionario);
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
			campoACD.setPromptText("Duracao");
			break;
			
		case "CD":
			campoACD.setPromptText("Ano");
			break;
		}
	}
	
	/**
	 * Chamado ao clicar no botão de cadastrar.
	 * Vai verificar os campos para ver se s�o
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
		
		int    codigo;
		String nome;
		String autor;
		String campoACD;
		double preco;
		int    quantidade;
		Image  imagem;
		String descricao;

		try
		{
			verificarCampos();
      
			codigo = Integer.parseInt(this.codigo.getText());
			nome = this.nome.getText();
			autor = this.autor.getText();
			campoACD = this.campoACD.getText();
			preco = Double.parseDouble(this.preco.getText());
			quantidade = Integer.parseInt(this.quantidade.getText());
			imagem = this.imagem.getImage();
			descricao = this.descricao.getText();
			
			if (descricao.equals(""))
				descricao = null;
			
			// Verificar se o c�digo j� existe.
			for(Produto produto : produtos)
				if (codigo == produto.getCodigo())
					throw new CodigoJaExistenteException();
			
			switch(tipoProduto.getValue())
			{
			case "Livro":
				p = new Livro(codigo, nome, autor, campoACD, preco, imagem, quantidade, descricao);
				break;
				
			case "DVD":
				p = new Dvd(codigo, nome, autor, campoACD, preco, imagem, quantidade, descricao);
				break;
				
			case "CD":
				p = new Cd(codigo, nome, autor, campoACD, preco, imagem, quantidade, descricao);
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
		catch (NoSuchFieldException e)
		{
			Janelas.mensagem("Erro", e.getMessage(), AlertType.ERROR);
		}
		catch (NumberFormatException e)
		{
			Janelas.mensagem("Erro", "N�mero digitado inv�lido. Verifique os campos e tente novamente.", AlertType.ERROR);
		}
		catch (CodigoJaExistenteException e)
		{
			Janelas.mensagem("Aviso", e.getMessage(), AlertType.WARNING);
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
		descricao.clear();
	}
	
	/**
	 * Verifica se os valores dos campos obrigatórios
	 * não foram digitados.
	 */
	private void verificarCampos() throws NoSuchFieldException
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
			throw new NoSuchFieldException("Preencha todos os campos antes de continuar");
		}	
	}
	
	private void carregarTabelaVendas()
	{
		// ObservableList é o tipo de lista que
		// usamos para setar no TableView. 
		ObservableList<Venda> observableListVendas;
		
		// Vamos fazer uma observableList a partir da lista de vendas.
		observableListVendas = FXCollections.observableArrayList(vendas);
		tabelaVendas.setItems(observableListVendas);
		
		// Agora que temos a observableList de vendas, podemos 
		// dizer para cada coluna da tabela conter o valor de
		// determinado atributo de Venda.
		
		colunaNumeroPedido.setCellValueFactory(new PropertyValueFactory<>("numeroPedido"));
		colunaNome.setCellValueFactory(new PropertyValueFactory<>("nomeCliente"));
		colunaCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		colunaCidade.setCellValueFactory(new PropertyValueFactory<>("estadoCidade"));
		colunaTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
		colunaValorTotal.setCellValueFactory(new PropertyValueFactory<>("valorTotal"));
	}
}
