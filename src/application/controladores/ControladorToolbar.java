package application.controladores;

import java.io.IOException;
import java.util.Stack;

import application.GerenciadorCenas;
import application.Janelas;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Classe controladora da barra de cima
 * 
 * @author �nio Jos�
 */
public class ControladorToolbar extends Controlador
{
	private Stack<Parent> cenas;
	private Stack<Integer> codigoCena;
	
	@FXML private Button voltar;
	@FXML private Button atualizar;
	@FXML private Button carrinho;
	@FXML private TextField campoBuscar;
	
	public ControladorToolbar()
	{
		// Vamos usar uma pilha para implementar
		// o sistema de voltar.
		cenas = new Stack<Parent>();
		codigoCena = new Stack<Integer>();
	}
	
	@FXML
	void carrinho() throws IOException
	{	
		//Se o carrinho estiver vazio, ele nao deixa entrar no carrinho.
		if(Controlador.carrinho.getProdutos().isEmpty()) {
			Janelas.mensagem("Atenção", "O carrinho está vazio.", AlertType.INFORMATION);
		} else {
			GerenciadorCenas.irPara(CARRINHO);
		}
	}
	
	@FXML
	void voltar()
	{
		GerenciadorCenas.irPara(cenas.pop());
		codigoCena.pop();
		
		if (cenas.size() < 2)
			voltar.setDisable(true);
	}
	
	/**
	 * Vamos simplesmente recarregar a cena atual.
	 * @throws IOException
	 */
	@FXML
	void atualizar() throws IOException
	{
		GerenciadorCenas.atualizar(codigoCena.peek());
	}
	
	/**
	 * Quando formos para alguma outra cena usando
	 * um dos m�todos irPara do GerenciadorCenas,
	 * vamos usar essa fun��o para adicionar a cena
	 * carregada na pilha e pegar seu c�digo.
	 * @param p
	 * @param codigoCenaAtual - Veja a classe Controlador.
	 */
	public void adicionarCena(Parent p, int codigoCenaAtual)
	{
		cenas.push(p);
		codigoCena.push(codigoCenaAtual);
		
		if (cenas.size() > 1)
			voltar.setDisable(false);
	}
	
	@FXML
	private void buscar() throws IOException
	{
		textoBusca = campoBuscar.getText();
		
		if (!textoBusca.equals(""))
			GerenciadorCenas.irPara(BUSCA);
	}
}
