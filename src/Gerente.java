import java.util.Objects;
import java.util.Scanner;

public class Gerente {
	private String senha;
	public String nome;
	int Nclientes = 0, MAX = 500,i,j,aplicaqnt,CLT1,CLT2,CTYPE1,CTYPE2,Client1,Client2,validação = 0;
	Cliente[] GCliente = new Cliente[MAX];	
	Scanner input = new Scanner(System.in);
	
/// CRIA CLIENTE
	public void criacliente(String cnome, String csenha)
	{
		GCliente[Nclientes] = new Cliente(cnome,csenha);
		Nclientes = Nclientes + 1;
	}
	
/// GERA LISTA DE CLIENTES E SUAS CONTAS
	public void listaclientes()
	{
		for(i = 0; i < Nclientes; i++)
		{
			System.out.printf("\nNome do %d cliente: ", i + 1);
			System.out.println(GCliente[i].getnome());
			System.out.println("Numero de contas polpança: " + GCliente[i].getNCP());
			System.out.println("Numero de contas simples: " + GCliente[i].getNCS());			
			System.out.println("Numero de contas especiais: " + GCliente[i].getNCE());
		}
	}

/// APLICA DINHEIRO PARA UM CLIENTE ESPECÍFICO
	public void aplicação(double quantia)
	{
		System.out.println("Digite o nome do cliente o qual você quer aplicar o dinheiro:");
		String aplicanome = input.nextLine();
		for(i = 0; i < Nclientes; i++)
		{
			if(Objects.equals(title(aplicanome), GCliente[i].getnome()))
			{
				System.out.println("Qual das contas desse cliente você gostaria de aplicar? Digite");
				System.out.print("1. Para contas simples\n2. Para conta polpança\n3. Para conta especial\n");
				switch(input.nextInt())
				{
					case 1:
						System.out.print("Qual o numero da conta?");
						int case1nc = input.nextInt();
						for(j = 0; j < GCliente[i].getNCS(); j++)
						{
							if(case1nc == GCliente[i].CS[j].getnumerodaconta())
							{
								GCliente[i].CS[j].depositar(quantia);
								validação = 1;
							}
						}
						break;
						
					case 2:
						System.out.print("Qual o numero da conta?");
						int case2nc = input.nextInt();
						for(j = 0; j < GCliente[i].getNCP(); j++)
						{
							if(case2nc == GCliente[i].CP[j].getnumerodaconta())
							{
								GCliente[i].CP[j].depositar(quantia);
								validação = 1;
							}
						}
						break;
					case 3:
						System.out.print("Qual o numero da conta?");
						int case3nc = input.nextInt();
						for(j = 0; j < GCliente[i].getNCE(); j++)
						{
							if(case3nc == GCliente[i].CE[j].getnumerodaconta())
							{
								GCliente[i].CE[j].depositar(quantia);
								validação = 1;
							}
						}
						break;
				}
			}
		}
		if(validação == 0) System.out.print("Dado digitado está incorreto. Tente novamente\n");
		validação = 0;
	}
	
/// TRANSFERÊNCIA DE DINHEIRO ENTRE CONTAS DE CLIENTES DIFERENTES
	public void transferencia()
	{
		System.out.println("Digite o nome do cliente a dar o dinheiro: ");
		String aplicanome = input.nextLine();
		for(i = 0; i < Nclientes; i++)
		{
			if(Objects.equals(title(aplicanome), GCliente[i].getnome()))
			{
				System.out.println("Para qual das contas desse cliente você gostaria de transferir? Digite");
				System.out.print("1. Para contas simples\n2. Para conta polpança\n3. Para conta especial\n");
				switch(input.nextInt())
				{
				case 1:
					System.out.print("Qual o numero da conta?");
					int case1nc = input.nextInt();
					for(j = 0; j < GCliente[i].getNCS(); j++)
					{
						if(case1nc == GCliente[i].CS[j].getnumerodaconta())
						{
							Client1 = i;
							CTYPE1 = 1;
							CLT1 = j;
							validação = 1;
						}
					}
					break;
					
				case 2:
					System.out.print("Qual o numero da conta?");
					int case2nc = input.nextInt();
					for(j = 0; j < GCliente[i].getNCP(); j++)
					{
						if(case2nc == GCliente[i].CP[j].getnumerodaconta())
						{
							Client1 = i;
							CTYPE1 = 2;
							CLT1 = j;
							validação = 1;
						}
					}
					break;
				case 3:
					System.out.print("Qual o numero da conta?");
					int case3nc = input.nextInt();
					for(j = 0; j < GCliente[i].getNCE(); j++)
					{
						if(case3nc == GCliente[i].CE[j].getnumerodaconta())
						{
							Client1 = i;
							CTYPE1 = 3;
							CLT1 = j;
							validação = 1;
						}
					}
					break;
				default: break;
				}
			}
		}
		if(validação == 0) {System.out.print("Dado digitado está incorreto. Tente novamente"); return;}
		validação = 0;
		input.nextLine();
		System.out.println("Digite o nome do cliente a receber o dinheiro: ");
		aplicanome = input.nextLine();
		for(i = 0; i < Nclientes; i++)
		{
			if(Objects.equals(title(aplicanome),GCliente[i].getnome()))
			{
				System.out.println("Para qual das contas desse cliente você gostaria de transferir? Digite");
				System.out.print("1. Para contas simples\n2. Para conta polpança\n3. Para conta especial\n");
				switch(input.nextInt())
				{
				case 1:
					System.out.print("Qual o numero da conta?");
					int case1nc = input.nextInt();
					for(j = 0; j < GCliente[i].getNCS(); j++)
					{
						if(case1nc == GCliente[i].CS[j].getnumerodaconta())
						{
							Client2 = i;
							CTYPE2 = 1;
							CLT2 = j;
							validação = 1;
						}
					}
					break;
					
				case 2:
					System.out.print("Qual o numero da conta?");
					int case2nc = input.nextInt();
					for(j = 0; j < GCliente[i].getNCP(); j++)
					{
						if(case2nc == GCliente[i].CP[j].getnumerodaconta())
						{
							Client2 = i;
							CTYPE2 = 2;
							CLT2 = j;
							validação = 1;
						}
					}
					break;
				case 3:
					System.out.print("Qual o numero da conta?");
					int case3nc = input.nextInt();
					for(j = 0; j < GCliente[i].getNCE(); j++)
					{
						if(case3nc == GCliente[i].CE[j].getnumerodaconta())
						{
							Client2 = i;
							CTYPE2 = 3;
							CLT2 = j;
							validação = 1;
						}
					}
					break;
				}
			}
		}
		if(validação == 0) {System.out.print("Dado digitado está incorreto. Tente novamente\n"); return;}
		validação = 0;
		input.nextLine();
		
		System.out.println("Qual o valor da transferência? ");
		double quantia = input.nextDouble();
		switch(CTYPE1)
		{
		case 1: 
			GCliente[Client1].CS[CLT1].transferneg(quantia);
			if (GCliente[Client1].CS[CLT1].validação == 0) CTYPE2 = 5;
			break;
		case 2:
			GCliente[Client1].CP[CLT1].transferneg(quantia);
			if (GCliente[Client1].CP[CLT1].validação == 0) CTYPE2 = 5;
			break;
		case 3:
			GCliente[Client1].CE[CLT1].transferneg(quantia);
			if (GCliente[Client1].CE[CLT1].validação == 0) CTYPE2 = 5;
			break;
		default: break;
		}
		
		switch(CTYPE2)
		{
		case 1: 
			GCliente[Client2].CS[CLT2].transferpos(quantia);
			break;
		case 2:
			GCliente[Client2].CP[CLT2].transferpos(quantia);
			break;
		case 3:
			GCliente[Client1].CE[CLT2].transferpos(quantia);
			break;
		default: System.out.print("O saldo de transferência excede o limite da conta que sairá o dinheiro. Tente novamente"); 
				 break;
		}	
		
		
	}
/// GERENCIAMENTO DE CONTA	
	
	public void alterarSenha(String senhaAntiga,String senhaNova)
	{
		if(Objects.equals(senha,senhaAntiga)) {senha = senhaNova; System.out.print("\nSenha alterada com sucesso"); }
		else System.out.print("\nSenha incorreta, tente novamente.");
	}
	
	public int verificarSenha(String senhaInserida)
	{
		if (Objects.equals(senha, senhaInserida)) return 1;
		else {System.out.println("Senha incorreta, tente novamente"); return 0;}
	}
	
	
	public static String title(String text) {
	    if (text == null || text.isEmpty()) {
	        return text;
	    }

	    StringBuilder converted = new StringBuilder();

	    boolean convertNext = true;
	    for (char ch : text.toCharArray()) {
	        if (Character.isSpaceChar(ch)) {
	            convertNext = true;
	        } else if (convertNext) {
	            ch = Character.toTitleCase(ch);
	            convertNext = false;
	        } else {
	            ch = Character.toLowerCase(ch);
	        }
	        converted.append(ch);
	    }

	    return converted.toString();
	}
	
/// CONSTRUTOR
	public Gerente (String novonome, String novasenha)
	{
		senha = novasenha;
		nome = novonome;
	}
	
}
