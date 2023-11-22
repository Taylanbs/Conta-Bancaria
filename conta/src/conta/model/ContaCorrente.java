package conta.model;

public class ContaCorrente {

	public static void main(String[] args) {
		private String numero;
	    private double saldo;

	    // Construtor, getters e setters aqui

	    public void depositar(double valor) {
	        saldo += valor;
	        System.out.println("Depósito de R$ " + valor + " realizado na Conta Corrente. Novo saldo: R$ " + saldo);
	    }

	    public void sacar(double valor) {
	        if (valor <= saldo) {
	            saldo -= valor;
	            System.out.println("Saque de R$ " + valor + " realizado na Conta Corrente. Novo saldo: R$ " + saldo);
	        } else {
	            System.out.println("Saldo insuficiente para saque na Conta Corrente.");
	        }


	}

}
