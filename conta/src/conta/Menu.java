package conta;

public class Menu {
	
	import conta.model.ContaCorrente;
	import conta.model.ContaPoupanca;
	
		public static void main(String[] args) {
		// Teste da Conta Corrente
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.depositar(1000.0);
        contaCorrente.sacar(500.0);

        // Teste da Conta Poupança
        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.depositar(500.0);
        contaPoupanca.sacar(200.0);
    
	}

}
