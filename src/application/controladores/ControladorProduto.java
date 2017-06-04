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

public class ControladorProduto extends Controlador implements Initializable
{
	@FXML private Button adicionarCarrinho;
	@FXML private Button comprar;
	@FXML private Label tituloItem;
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
			int qtdLabel = Integer.parseInt(qtd.getText());
			int qtdDesejada = verificarQuantidadeDesejada();
			ItemCarrinho item = null;
			
			//Verificamos se a quantidade desejada esta disponivel para compra
			if(qtdDesejada <= qtdLabel) 
			{
				//Iremos adicionar a lista do carrinho e diminuir a sua quantidade
				for (ItemCarrinho itemCarrinho : produtosCarrinho) 
					if(produtoSelecionado.getCodigo() == itemCarrinho.getCodigo()) 
					{
						item = itemCarrinho;
						break;
					}
						
				// Se ele encontrou um produto na nossa lista de itens do carrinho
				if(item != null) 
					item.setQtd(qtdDesejada);				
				else 
				{
					item = new ItemCarrinho(produtoSelecionado,qtdDesejada);
					Controlador.produtosCarrinho.add(item);
				}
				
				decrementarQtdLabel(qtdDesejada);
				produtoSelecionado.setQuantidade(qtdLabel - qtdDesejada);
				Janelas.mensagem("Exito", "Produto adicionado ao carrinho com sucesso", 
						AlertType.INFORMATION);
			}	
			else
				Janelas.mensagem("Erro", "A quantidade desejada não está disponível para compra.", AlertType.ERROR);
		}
		catch (NumberFormatException e)
		{
			Janelas.mensagem("Erro", "Digite um valor valido.", AlertType.ERROR);
		}
		catch (Exception f)
		{
			f.printStackTrace();
		}
	}
	
	@FXML
	private void comprar() throws IOException
	{
		try
		{
			int qtdLabel = Integer.parseInt(qtd.getText());
			int qtdDesejada = verificarQuantidadeDesejada();
			ItemCarrinho item = null;
			
			//Verificamos se a quantidade desejada esta disponivel para compra
			if(qtdDesejada <= qtdLabel) 
			{	
				//Iremos adicionar a lista do carrinho e diminuir a sua quantidade
				for (ItemCarrinho itemCarrinho : produtosCarrinho) 
					if(produtoSelecionado.getCodigo() == itemCarrinho.getCodigo()) 
					{
						item = itemCarrinho;
						break;
					}
				
				if(item != null) 
					item.setQtd(qtdDesejada);				
				else 
				{
					item = new ItemCarrinho(produtoSelecionado,qtdDesejada);
					Controlador.produtosCarrinho.add(item);
				}
				
				produtoSelecionado.setQuantidade(qtdLabel - qtdDesejada);
				GerenciadorCenas.irPara(CARRINHO);
			} 
			else 
				Janelas.mensagem("Erro", "A quantidade desejada nao esta disponivel.", AlertType.ERROR);
		}
		catch(NumberFormatException e)
		{
			Janelas.mensagem("Erro", "Digite um valor valido.", AlertType.ERROR);
		}	
	}
	
	/**
	 * Criei essa fun��o para verificar o valor da quantidade
	 * desejada nas fun��es comprar e cadastrar o carrinho.
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
		if((produtoSelecionado.getQuantidade() - qtd_desejada) > 0) 
			qtd.setText(Integer.toString(produtoSelecionado.getQuantidade() - qtd_desejada));
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
