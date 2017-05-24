package application.controladores;

import java.io.IOException;
import java.util.Stack;

import application.GerenciadorCenas;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;

/**
 * Classe controladora da barra de cima
 * 
 * @author ï¿½nio Josï¿½
 */
public class ControladorToolbar extends Controlador
{
	private Stack<Parent> cenas;
	private int codigoCenaAtual;
	
	@FXML private Button voltar;
	@FXML private Button atualizar;
	@FXML private Button carrinho;
	
	public ControladorToolbar()
	{
		// Vamos usar uma pilha para implementar
		// o sistema de voltar.
		cenas = new Stack<Parent>();
	}
	
	@FXML
	void carrinho()
	{
		System.out.println("Teste carrinho");
	}
	
	@FXML
	void voltar()
	{
		GerenciadorCenas.irPara(cenas.pop());
		
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
		GerenciadorCenas.irPara(codigoCenaAtual);
	}
	
	/**
	 * Quando formos para alguma outra cena usando
	 * um dos métodos irPara do GerenciadorCenas,
	 * vamos usar essa função para adicionar a cena
	 * carregada na pilha e pegar seu código.
	 * @param p
	 * @param codigoCenaAtual - Veja a classe Controlador.
	 */
	public void adicionarCena(Parent p, int codigoCenaAtual)
	{
		cenas.push(p);
		this.codigoCenaAtual = codigoCenaAtual;
		
		if (cenas.size() > 1)
			voltar.setDisable(false);
	}
}
