package sistema_loja.exceptions;

public class CodigoJaExistenteException extends Exception
{
	public CodigoJaExistenteException()
	{
		super("C�digo j�! cadastrado. Insira um novo valor e tente novamente.");
	}
}
