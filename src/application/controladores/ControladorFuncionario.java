package application.controladores;

import java.io.IOException;
import java.util.Scanner;

import application.GerenciadorCenas;
import javafx.fxml.FXML;
import sistema_loja.classes.produtos.Dvd;

public class ControladorFuncionario extends Controlador
{
	@FXML
	private void sair() throws IOException
	{
		GerenciadorCenas.irPara(PRINCIPAL);
	}
	
	@FXML
	private void cadastrarDvd()
	{
		Scanner sc;
		String titulo;
		String autor;
		String preco;
		
		sc = new Scanner(System.in);
		
		System.out.println("Titulo: ");
		titulo = sc.nextLine();
		System.out.println("Autor: ");
		autor = sc.nextLine();
		System.out.println("Preço: ");
		preco = sc.nextLine();
		System.out.println("Produto cadastrado");
		
		produtos.add(new Dvd(titulo, autor, "12h 30m", Double.parseDouble(preco), null));
		
		sc.close();
	}
}
