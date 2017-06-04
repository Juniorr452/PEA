package application.controladores;

import java.io.IOException;

import application.GerenciadorCenas;
import application.Janelas;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import sistema_loja.interfaces.Produto;

public class ItemCarrinho extends HBox {
	
	@FXML private Label tituloLabel;
	@FXML private TextField qtdText;
	@FXML private Label precoLabel;
	@FXML private Button remover;
	
	private Produto produto;
	
	private int qtdDesejada;
	private double preco;
	private int codigo;
	
	public ItemCarrinho(Produto p, int qtdDesejada)
	{
		// Preparar o FxmlLoader para carregar
		// o arquivo posteriormente.
		FXMLLoader fxmlLoader = new FXMLLoader(
	                getClass().getResource("../cenas/ItemCarrinho.fxml"));

		// Setar a raiz e controlador do .fxml a ser carregado
		// como essa inst�ncia.
	    fxmlLoader.setRoot(this);
	    fxmlLoader.setController(this);

	    try 
	    {
	    	// Carregar o arquivo.
	    	fxmlLoader.load();
	    } 
	    catch (IOException exception) 
	    {
	    	throw new RuntimeException(exception);
	    }
	    
	    produto = p;
	    
	    this.qtdDesejada = qtdDesejada; 
	    preco = p.getPreco();
	    codigo = produto.getCodigo();
	    
		tituloLabel.setText(p.getTitulo());
		qtdText.setText(Integer.toString(this.qtdDesejada));
		precoLabel.setText(Double.toString(p.getPreco()));
	}
	
	@FXML
	void remover() throws IOException 
	{
		//Ao clicarmos em remover, ele pegara este objeto, e ira retirar da lista do carrinho
		Controlador.produtosCarrinho.remove(this);
		
		for (Produto p : Controlador.produtos) {
			if(codigo == p.getCodigo()) {
				p.setQuantidade(p.getQuantidade() + qtdDesejada);
			}
		}
		
		Janelas.mensagem("Êxito", "Produto removido com sucesso do carrinho.", AlertType.INFORMATION);
		
		if(Controlador.produtosCarrinho.isEmpty())
			GerenciadorCenas.irPara(1);
		else
			GerenciadorCenas.irPara(4);
	}
	
	public double getPreco() {
		return preco;
	}
	
	public int getQtd() {
		return qtdDesejada;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setQtd(int valor) {
		qtdDesejada += valor;
		qtdText.setText(Integer.toString(qtdDesejada));
	}
}
