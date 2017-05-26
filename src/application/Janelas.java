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
     * @param título - Título da Janela.
     * @param header - Texto da parte de cima da janela.
     * @param conteúdo - Texto da parte de baixo da janela.
     * @param alertType - Tipo de alerta (Aviso, Informação, Warning...).
     */
    public static void mensagem(String título, String conteúdo, AlertType alertType)
	{	
		Alert alert = new Alert(alertType);
		alert.setTitle(título);
		alert.setHeaderText(null);
		alert.setContentText(conteúdo);
		alert.showAndWait();
	}
    
    /**
     * Vai abrir uma janela para o usuário escolher
     * a imagem do produto a ser cadastrado.
     * 
     * @return A imagem escolhida pelo funcionario.
     */
    public static Image escolherImagem()
    {
    	Image i;
    	
    	// Essa classe FileChooser vai nos permitir
    	// abrir uma janela para o usuário abrir um arquivo.
    	FileChooser fc = new FileChooser();
    	
    	fc.setTitle("Escolha uma imagem");
    	
    	// Aqui, vamos definir os tipos de arquivo que o
    	// funcionario pode abrir
    	fc.getExtensionFilters().setAll
    	(
    		new ExtensionFilter("Imagem JPG", "*.jpg"),
    		new ExtensionFilter("Imagem PNG", "*.png")
    	);
    	
    	// Vamos criar uma nova instância de Stage
    	// para mostrar a janela de escolher imagem.
    	Stage novaJanela = new Stage();

    	// A função showOpenDialog vai receber a nossa janela
    	// e retornar o arquivo selecionado pelo funcionário.
    	File arquivoSelecionado = fc.showOpenDialog(novaJanela);
    	
    	// Vamos carregar a imagem com o caminho do arquivo.
    	if (arquivoSelecionado.exists())
    		i = new Image(arquivoSelecionado.toPath().toUri().toString());
    	else 
    		i = null;
    	
    	return i;
    }
}
