package sistema_loja.exceptions;

public class QuantidadeMaximaException extends Exception
{
	public QuantidadeMaximaException()
	{
		super("Quantidade máxima excedida. Remova os produtos com quantidade"
				+ " maior que 10 e tente novamente.");
	}
}
