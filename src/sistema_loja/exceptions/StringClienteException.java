package sistema_loja.exceptions;

public class StringClienteException extends Exception{

		public StringClienteException(){
			super("Digite de acordo com o campo. Apenas n�meros em Telefone , CPF e Endere�o.");
		}

}
