package sistema_loja.exceptions;

public class QuantidadeIndisponivelException extends Exception 
{
	public QuantidadeIndisponivelException()
	{
		super("A quantidade desejada não está disponível para compra.");
	}
}
