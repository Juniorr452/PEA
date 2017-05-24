package application;

import java.io.File;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class Janelas 
{
	 /**
     * Mostra uma mensagem simples na tela.
     * @param t�tulo - T�tulo da Janela.
     * @param header - Texto da parte de cima da janela.
     * @param conte�do - Texto da parte de baixo da janela.
     * @param alertType - Tipo de alerta (Aviso, Informa��o, Warning...).
     */
    public static void mensagem(String titulo, String conteudo, AlertType alertType)
	{	
		Alert alert = new Alert(alertType);
		alert.setTitle(titulo);
		alert.setHeaderText(null);
		alert.setContentText(conteudo);
		alert.showAndWait();
	}
    
    /**
     * Vai abrir uma janela para o usu�rio escolher
     * a imagem do produto a ser cadastrado.
     * 
     * @return A imagem escolhida pelo funcionario.
     */
    public static Image escolherImagem()
    {
    	Image i;
    	
    	// Essa classe FileChooser vai nos permitir
    	// abrir uma janela para o usu�rio abrir um arquivo.
    	FileChooser fc = new FileChooser();
    	
    	fc.setTitle("Escolha uma imagem");
    	
    	// Aqui, vamos definir os tipos de arquivo que o
    	// funcionario pode abrir
    	fc.getExtensionFilters().setAll
    	(
    		new ExtensionFilter("Imagem JPG", "*.jpg"),
    		new ExtensionFilter("Imagem PNG", "*.png")
    	);
    	
    	// Vamos criar uma nova inst�ncia de Stage
    	// para mostrar a janela de escolher imagem.
    	Stage novaJanela = new Stage();

    	// A fun��o showOpenDialog vai receber a nossa janela
    	// e retornar o arquivo selecionado pelo funcion�rio.
    	File arquivoSelecionado = fc.showOpenDialog(novaJanela);
    	
    	// Vamos carregar a imagem com o caminho do arquivo.
    	i = new Image(arquivoSelecionado.toPath().toUri().toString());
    	
    	return i;
    }
}
