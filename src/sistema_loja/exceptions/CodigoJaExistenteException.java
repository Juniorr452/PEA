package sistema_loja.exceptions;

public class CodigoJaExistenteException extends Exception
{
	public CodigoJaExistenteException()
	{
		super("Código já! cadastrado. Insira um novo valor e tente novamente.");
	}
}
