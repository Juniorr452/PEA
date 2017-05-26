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
	@FXML private TextArea qtd_area;
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		tituloItem.setText(produtoSelecionado.getTitulo());
		capaItem.setImage(produtoSelecionado.getImage());
		autorItem.setText(produtoSelecionado.getAutor());
		precoItem.setText(Double.toString(produtoSelecionado.getPreco()));
		
		if(produtoSelecionado.getQuantidade() != 0) 	
			qtd.setText(Integer.toString(produtoSelecionado.getQuantidade()));
		else {
			setIndisponivel();
		}
	}
	
	@FXML
	void adicionarCarrinho()
	{	
		int qtd_label = Integer.parseInt(qtd.getText());
		int qtd_desejada = Integer.parseInt(qtd_area.getText());
		
		//Verificamos se a quantidade desejada esta disponivel para compra
		if(qtd_desejada <= qtd_label) {
			
			//Iremos adicionar a lista do carrinho e diminuir a sua quantidade
				Controlador.produtosCarrinho.add(produtoSelecionado);
				produtoSelecionado.setQuantidadeDesejada(qtd_desejada);
				Janelas.mensagem("Êxito", "Produto adicionado ao carrinho com sucesso", 
																			AlertType.INFORMATION);
				decrementarQtdLabel(qtd_desejada);
				produtoSelecionado.setQuantidade(qtd_label - qtd_desejada);
		} else {
			Janelas.mensagem("Erro", "A quantidade desejada não está disponível para compra.", AlertType.ERROR);
		}	
	}
	
	@FXML
	void comprar() throws IOException
	{
		int qtd_label = Integer.parseInt(qtd.getText());
		int qtd_desejada = Integer.parseInt(qtd_area.getText());
		
		//Verificamos se a quantidade desejada esta disponivel para compra
		if(qtd_desejada <= qtd_label) {	
			
			//Iremos adicionar o produto a lista do carrinho e diminuir a sua quantidade.
			Controlador.produtosCarrinho.add(produtoSelecionado);
			produtoSelecionado.setQuantidadeDesejada(qtd_desejada);
			produtoSelecionado.setQuantidade(qtd_label - qtd_desejada);
			GerenciadorCenas.irPara(4);
		} else {
			Janelas.mensagem("Erro", "A quantidade desejada não está disponível", AlertType.ERROR);
		}		
	}
	
	private void decrementarQtdLabel(int qtd_desejada) {
		if((produtoSelecionado.getQuantidade() - qtd_desejada) > 0) {
			qtd.setText(Integer.toString(produtoSelecionado.getQuantidade() - qtd_desejada));
		} else {
			setIndisponivel();
		}
	}
	
	private void setIndisponivel() {
		qtd.setText("Indisponível");
		qtd_area.setDisable(true);
		adicionarCarrinho.setDisable(true);
		comprar.setDisable(true);
	}
}
