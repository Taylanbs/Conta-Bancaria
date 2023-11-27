package conta;

import java.io.IOException;

import java.util.InputMismatchException;


import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.ContaCorrente;

import conta.model.ContaPoupanca;

import conta.util.Cores;


public class Menu {
	
	
	public static Scanner leia = new Scanner(System.in);
	
		
	public static void main(String[] args) {
		
		ContaController contas = new ContaController();

		int opcao, numero, agencia, tipo, aniversario;
		String titular;
		float saldo, limite;
		
		
		System.out.println("\nCriar Contas\n");
		
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "André Luiz Tonon", 1000f, 100.0f);
		contas.cadastrar(cc1);
		
		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Amora Santos Tonon", 2000f, 100.0f);
		contas.cadastrar(cc2);
		
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Maria da Conceicao", 4000f, 12);
		contas.cadastrar(cp1);
		
		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Francisco Pereira", 8000f, 15);
		contas.cadastrar(cp2);
		
		contas.listarTodas();		
		
		
		while (true) {
			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND+
					"*********************************");
			System.out.println("                                             ");
			System.out.println("          BANCO DO BRAZIL COM Z              ");
			System.out.println("                                             ");
			System.out.println("*********************************************");
			System.out.println("                                             ");
			System.out.println("      1 - CRIAR CONTA                        ");
			System.out.println("      2 - LISTAR TODAS AS CONTAS             ");
			System.out.println("      3 - BUSCAR CONTA POR NUMERO            ");
			System.out.println("      4 - ATUALIZAR DADOS DA CONTA           ");
			System.out.println("      5 - APAGAR CONTA                       ");
			System.out.println("      6 - SACAR                              ");
			System.out.println("      7 - DEPOSITAR                          ");
			System.out.println("      8 - TRANSFERIR VALORES ENTRE CONTAS"    );
			System.out.println("      9 - SAIR                               ");
			System.out.println("                                             ");
			System.out.println("*********************************************");
			System.out.println("ENTRE COM A OPÇÃO DESEJADA:");
			System.out.println("                           " + Cores.TEXT_RESET);
			

			try {
				opcao = leia.nextInt();
			}catch(InputMismatchException e){
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao=0;
			}	
			
			
			
			if (opcao == 9) {
				System.out.println("Banco do Brazil com Z - O seu futuro começa AQUI!");
				sobre();
				leia.close();
				System.exit(0);
			}
			
			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE + "Criar Conta\n\n");
				
				System.out.println("Digite o numero da agencia: ");
				agencia = leia.nextInt();
				
				System.out.println("Digite o nome do TITULAR: ");
				leia.skip("\\R?");
				titular = leia.nextLine();
				
				do {
					System.out.println("Digite o tipo da Conta (1 - CC ou 2 - CP): ");
					tipo = leia.nextInt();
				}while(tipo <1 && tipo > 2);
				
				System.out.println("Digite o saldo da conta (R$): ");
				saldo = leia.nextFloat();
				
				switch (tipo) {
					case 1 -> {
						System.out.println("Digite o LIMITE do crédito (RS): ");
						limite = leia.nextFloat();
						contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
					}
					case 2 ->{
						System.out.println("Digite o DIA DO ANIVERSARIO da conta: ");
						aniversario = leia.nextInt();
						contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
						
						
					}
				}
			keyPress();
			break;
			
			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listar todas as Contas\n\n");
				contas.listarTodas();
			break;
			
			case 3:
				System.out.println(Cores.TEXT_WHITE + "Consultar dados da Conta - por número\n\n");
				
				System.out.println("Digite o número da conta");
				numero = leia.nextInt();
				
				contas.procurarPorNumero(numero);
				
			keyPress();
				
			break;
			
			case 4:
				System.out.println(Cores.TEXT_WHITE + "Atualizar dados da Conta\n\n");
				
                 System.out.println(" Digite o Número da conta: ");
                 
                 numero = leia.nextInt();
                 
                 var buscaConta = contas.buscarNaCollection(numero);
                 
                 if(buscaConta != null) {
                	 tipo = buscaConta.getTipo();
                	 
                	 System.out.println("Digite o número da agencia: ");
                	 agencia = leia.nextInt();
                	 
                	 System.out.println("Digite o nome do TITULAR: ");
                	 leia.skip("\\R?");
                	 titular = leia.nextLine();
                	 
                	 System.out.println("Digite o saldo da sua conta:(R$) ");
                	 saldo = leia.nextFloat ();
                	 
                	 switch (tipo) {
                	 case 1 -> {
                		 System.out.println("Digite o limite de crédito (R$): ");
                		 limite = leia.nextFloat();
                		 
                		 contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
                		         		 
                	 }
                	 case 2 -> {
                		 System.out.println("Digite o dia do ANIVERSARIO da conta: ");
                		 aniversario = leia.nextInt();
                		 
                		 contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
                	
                	 }
                	 default -> {
                		 System.out.println("Tipo de conta inválido!");
                		 
                	 	}
                	 }
                	 
                	 
                 }else {
                	 System.out.println("A conta não foi encontrada!");
                	 
                 }
                 
            keyPress();
            
      
			break;
			
			case 5:
				System.out.println(Cores.TEXT_WHITE + "Apagar a Conta\n\n");
				
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				
				contas.deletar(numero);
				
			keyPress();
			break;
			
			case 6:
				System.out.println(Cores.TEXT_WHITE + "Saque\n\n");
			break;
			
			case 7:
				System.out.println(Cores.TEXT_WHITE + "Depósito\n\n");
			break;
			
			case 8:
				System.out.println(Cores.TEXT_WHITE + "Transferência entre Contas\n\n");
			break;
			
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
			break;
			
				}
			
			}					
		}
		
		public static void sobre() {
				System.out.println("\n********************************************");
				System.out.println("Projeto Desenvolvido por: ");
				System.out.println("Taylan Souza dos Santos - taylanmf@gmail.com  ");
				System.out.println("https://github.com/Taylanbs");
				System.out.println("**********************************************");
				}

		
		public static void keyPress() {

			try {

				System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
				System.in.read();

			} catch (IOException e) {

				System.out.println("Você pressionou uma tecla diferente de enter!");

			}
		}
							
		}

