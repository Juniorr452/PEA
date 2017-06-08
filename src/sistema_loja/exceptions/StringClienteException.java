package sistema_loja.exceptions;

public class StringClienteException extends Exception{

		public StringClienteException(){
			super("Digite de acordo com o campo. Apenas números em Telefone , CPF e Endereço.");
		}

}
