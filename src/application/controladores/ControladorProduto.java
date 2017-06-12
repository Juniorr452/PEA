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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import sistema_loja.exceptions.QuantidadeIndisponivelException;

public class ControladorProduto extends Controlador implements Initializable
{
	@FXML private Button adicionarCarrinho;
	@FXML private Button comprar;
	@FXML private Label tituloItem;
	@FXML private Label codigoItem;
	@FXML private ImageView capaItem;
	@FXML private Label autorItem;
	@FXML private Label precoItem;
	@FXML private Label msgCarrinho;
	@FXML private Label qtd;
	@FXML private TextArea qtdArea;
	@FXML private Text descricaoItem;
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		tituloItem.setText(produtoSelecionado.getTitulo());
		codigoItem.setText("(Cód: " + Integer.toString(produtoSelecionado.getCodigo()) + ")");
		capaItem.setImage(produtoSelecionado.getImage());
		autorItem.setText(produtoSelecionado.getAutor());
		precoItem.setText(Double.toString(produtoSelecionado.getPreco()));
		descricaoItem.setText(produtoSelecionado.getDescricao());
		
		if(produtoSelecionado.getQuantidade() != 0) 	
			qtd.setText(Integer.toString(produtoSelecionado.getQuantidade()));
		else 
			setIndisponivel();
	}
	
	@FXML
	private void adicionarCarrinho()
	{	
		try
		{	
			int qtdDesejada = verificarQuantidadeDesejada();
			
			carrinho.adicionarItem(produtoSelecionado, qtdDesejada);
			
			decrementarQtdLabel(qtdDesejada);
			
			Janelas.mensagem("Exito", "Produto adicionado ao carrinho com sucesso", 
					AlertType.INFORMATION);
		}
		catch (NumberFormatException e)
		{
			Janelas.mensagem("Erro", "Digite um valor valido.", AlertType.ERROR);
		}
		catch (QuantidadeIndisponivelException e)
		{
			Janelas.mensagem("Erro", e.getMessage(), AlertType.ERROR);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@FXML
	private void comprar() throws IOException
	{
		try
		{
			int qtdDesejada = verificarQuantidadeDesejada();
			
			carrinho.adicionarItem(produtoSelecionado, qtdDesejada);
			
			GerenciadorCenas.irPara(CARRINHO);
		}
		catch(NumberFormatException e)
		{
			Janelas.mensagem("Erro", "Digite um valor válido.", AlertType.ERROR);
		}
		catch (QuantidadeIndisponivelException e)
		{
			Janelas.mensagem("Erro", e.getMessage(), AlertType.ERROR);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Criei essa função para verificar o valor da quantidade
	 * desejada nas funções comprar e cadastrar o carrinho.
	 * <p>
	 * Evita que um valor inv�lido seja pegado pelo sistema e
	 * colocado no carrinho (Tais como 0, -1, ""...)
	 * <p>
	 * Coloque dentro de um try catch para impedir que a opera��o
	 * seja realizada.
	 * 
	 * @return - O n�mero digitado, caso seja v�lido.
	 * 
	 * @throws NumberFormatException - Caso o n�mero lido seja inv�lido
	 * ou menor que 0
	 */
	private int verificarQuantidadeDesejada() throws NumberFormatException
	{
		int qtdDesejada = Integer.parseInt(qtdArea.getText());
		
		if (qtdDesejada <= 0)
			throw new NumberFormatException();
		
		return qtdDesejada;
	}
	
	private void decrementarQtdLabel(int qtd_desejada) 
	{
		if((produtoSelecionado.getQuantidade()) > 0) 
			qtd.setText(Integer.toString(produtoSelecionado.getQuantidade()));
		else 
			setIndisponivel();
	}
	
	private void setIndisponivel() 
	{
		qtd.setText("Indisponível");
		qtdArea.setDisable(true);
		adicionarCarrinho.setDisable(true);
		comprar.setDisable(true);
	}
}
