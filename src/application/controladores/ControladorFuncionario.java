package application.controladores;

import java.io.IOException;
import java.util.Scanner;

import application.GerenciadorCenas;
import application.Janelas;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import sistema_loja.classes.vendas.Cadastro;

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
		
		Cadastro cadastro;
		String titulo;
		String autor;
		String duracao;
		Image imagem;
		String preco;
		String quantidade;
		
		cadastro = new Cadastro(produtos);
		sc = new Scanner(System.in);
		
		System.out.println("Titulo: ");
		titulo = sc.nextLine();
		System.out.println("Autor: ");
		autor = sc.nextLine();
		System.out.println("Duracao: ");
		duracao = sc.nextLine();
		System.out.println("Preço: ");
		preco = sc.nextLine();
		System.out.println("Quantidade: ");
		quantidade = sc.nextLine();
		imagem = Janelas.escolherImagem();
		
		cadastro.cadastrarDVD(titulo, autor, duracao, preco, imagem, quantidade);
	
		Janelas.mensagem("Sucesso", "Produto cadastrado com sucesso", AlertType.CONFIRMATION);
		
		sc.close();
	}
}
