package application.controladores;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import sistema_loja.classes.produtos.Cd;
import sistema_loja.classes.produtos.Dvd;
import sistema_loja.classes.produtos.Livro;
import sistema_loja.interfaces.Produto;

public class ControladorBusca extends Controlador implements Initializable
{
    @FXML private Text     textoResultados;
    @FXML private FlowPane secaoResultados;
    
    // Essa lista vai guardar os produtos
    // que procuramos na busca.
    private List<Produto> resultados;

	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		// Instanciar a lista para guardar os produtos.
		resultados = new ArrayList<Produto>();

		// Ver o que o usuário digitou.'
		switch(textoBusca)
		{
		// Todos os produtos.
		case "Todos":
			resultados = produtos;
			break;
			
		// Apenas os livros.
		case "Livros":
			for(Produto p : produtos)
				if (p instanceof Livro)
					resultados.add(p);
			break;
			
		// Apenas DVDs
		case "DVD":
			for(Produto p : produtos)
				if (p instanceof Dvd)
					resultados.add(p);
			break;
	
		// Apenas CDs
		case "CD":
			for(Produto p : produtos)
				if (p instanceof Cd)
					resultados.add(p);
			break;
			
		default:
			for(Produto p : produtos)
				if (p.getTitulo().toLowerCase().contains(textoBusca.toLowerCase()) ||
					p.getAutor().toLowerCase().contains(textoBusca.toLowerCase()))
						resultados.add(p);
			break;
		}	
		
		mostrarResultados();
	}
	
	/**
	 * Coloca os resultados na tela, se existirem.
	 */
	private void mostrarResultados()
	{
		if (resultados.isEmpty())
		{
			textoResultados.setText("Ops! Não encontramos nada D=");
		}
		else
		{
			textoResultados.setText("Resultados para " + '"' + textoBusca + '"');
			
			/**
			 * Vamos pegar os produtos que foram buscados
			 * e adicionar na cena.
			 */
			for(Produto p : resultados)
				secaoResultados.getChildren().add(new Item(p));
		}
	}
}
