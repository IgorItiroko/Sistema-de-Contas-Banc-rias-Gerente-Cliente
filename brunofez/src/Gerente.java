import java.util.Objects;
import java.util.Scanner;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class Gerente {
	private String senha;
	//private int senha;
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void listaclientes()
	{
		JFrame frame1 = new JFrame();
		frame1.setSize(500,500);
		frame1.setTitle("Extrato Completo");
		frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JList list1 = new JList();
		list1.setBounds(500, 500, 500,500);	
		frame1.add(list1);
		DefaultListModel DLM1 = new DefaultListModel();
		frame1.setVisible(true);
		for(i = 0; i < Nclientes; i++)
		{
			//System.out.printf("\nNome do %d cliente: ", i + 1);
			DLM1.addElement("Nome do"+(i+1)+"cliente:" );	
			//System.out.println(GCliente[i].getnome());
			DLM1.addElement(""+GCliente[i].getnome());
			//System.out.println("Numero de contas polpança: " + GCliente[i].getNCP());
			DLM1.addElement("Numero de contas polpança: "+ GCliente[i].getNCP());
			//System.out.println("Numero de contas simples: " + GCliente[i].getNCS());
			DLM1.addElement("Numero de contas simples: "+GCliente[i].getNCS());
			//System.out.println("Numero de contas especiais: " + GCliente[i].getNCE());
			DLM1.addElement("Numero de contas especiais: "+GCliente[i].getNCE());
		}
		
		list1.setModel(DLM1);
		
		
	}

/// APLICA DINHEIRO PARA UM CLIENTE ESPECÍFICO
	public void aplicação(double quantia)
	{
		//System.out.println("Digite o nome do cliente o qual você quer aplicar o dinheiro:");
		String aplicanome = JOptionPane.showInputDialog("Digite o nome do cliente a aplicar o dinheiro: ");
		for(i = 0; i < Nclientes; i++)
		{
			if(Objects.equals(title(aplicanome), GCliente[i].getnome()))
			{
				//System.out.println("Qual das contas desse cliente você gostaria de aplicar? Digite");
				//System.out.print("1. Para contas simples\n2. Para conta polpança\n3. Para conta especial\n");
				
			    String escolha = JOptionPane.showInputDialog("Para qual das contas desse cliente você gostaria de aplicar?\n 1. Para contas simples \n2. Para conta polpança \n3. Para conta especial\n");
			    int result = Integer.parseInt(escolha);
			    switch(result)
				{
					case 1:
						//System.out.print("Qual o numero da conta?");
						String conta = JOptionPane.showInputDialog("Numero da conta:");
						int case1nc = Integer.parseInt(conta);
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
						//System.out.print("Qual o numero da conta?");
						String conta2 = JOptionPane.showInputDialog("Numero da conta:");
						int case2nc = Integer.parseInt(conta2);
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
						//System.out.print("Qual o numero da conta?");
						String conta3 = JOptionPane.showInputDialog("Numero da conta:");
						int case3nc = Integer.parseInt(conta3);
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
		if(validação == 0)/* System.out.print("Dado digitado está incorreto. Tente novamente\n")*/
		JOptionPane.showMessageDialog(null,"Dado digitado está incorreto.","Erro",JOptionPane.ERROR_MESSAGE );
		validação = 0;
	}
	
/// TRANSFERÊNCIA DE DINHEIRO ENTRE CONTAS DE CLIENTES DIFERENTES
	public void transferencia()
	{
		//System.out.println("Digite o nome do cliente a dar o dinheiro: ");
		
		String aplicanome = JOptionPane.showInputDialog("Digite o nome do cliente a dar o dinheiro: ");
		for(i = 0; i < Nclientes; i++)
		{
			if(Objects.equals(title(aplicanome), GCliente[i].getnome()))
			{
				//System.out.println("Para qual das contas desse cliente você gostaria de transferir? Digite");
				//System.out.print("1. Para contas simples\n2. Para conta polpança\n3. Para conta especial\n");
				String escolha = JOptionPane.showInputDialog("Para qual das contas desse cliente você gostaria de transferir?\n 1. Para contas simples \n2. Para conta polpança \n3. Para conta especial\n");
				int result = Integer.parseInt(escolha);
				switch(result)
				{
				case 1:
					//System.out.print("Qual o numero da conta?");
					String conta = JOptionPane.showInputDialog("Numero da conta:");
					int case1nc = Integer.parseInt(conta);
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
					//System.out.print("Qual o numero da conta?");
					String conta2 = JOptionPane.showInputDialog("Numero da conta:");
					int case2nc = Integer.parseInt(conta2);
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
					//System.out.print("Qual o numero da conta?");
					String conta3 = JOptionPane.showInputDialog("Numero da conta:");
					int case3nc = Integer.parseInt(conta3);
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
				if(validação == 0)/* System.out.print("Dado digitado está incorreto. Tente novamente\n")*/
					JOptionPane.showMessageDialog(null,"Dado digitado está incorreto.","Erro",JOptionPane.ERROR_MESSAGE );
					validação = 0;
			}
		}
		if(validação == 0) {/*System.out.print("Dado digitado está incorreto. Tente novamente");*/JOptionPane.showMessageDialog(null,"Dado digitado está incorreto.","Erro",JOptionPane.ERROR_MESSAGE ); return;}
		validação = 0;
		//input.nextLine();
		//System.out.println("Digite o nome do cliente a receber o dinheiro: ");
		String aplicanome1 = JOptionPane.showInputDialog("Nome do cliente a receber:"); 
		for(i = 0; i < Nclientes; i++)
		{
			if(Objects.equals(title(aplicanome1),GCliente[i].getnome()))
			{
				//System.out.println("Para qual das contas desse cliente você gostaria de transferir? Digite");
				//System.out.print("1. Para contas simples\n2. Para conta polpança\n3. Para conta especial\n");
				String escolha = JOptionPane.showInputDialog("Para qual das contas desse cliente você gostaria de transferir?\n 1. Para contas simples \n2. Para conta polpança \n3. Para conta especial\n");
				int result = Integer.parseInt(escolha);
				switch(result)
				{
				case 1:
					//System.out.print("Qual o numero da conta?");
					String conta = JOptionPane.showInputDialog("Numero da conta:");
					int case1nc = Integer.parseInt(conta);
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
					//System.out.print("Qual o numero da conta?");
					String conta2 = JOptionPane.showInputDialog("Numero da conta:");
					int case2nc = Integer.parseInt(conta2);
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
					//System.out.print("Qual o numero da conta?");
					String conta3 = JOptionPane.showInputDialog("Numero da conta:");
					int case3nc = Integer.parseInt(conta3);
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
		if(validação == 0) {/*System.out.print("Dado digitado está incorreto. Tente novamente\n")*/ JOptionPane.showMessageDialog(null,"Dado digitado está incorreto.","Erro",JOptionPane.ERROR_MESSAGE ); return;}
		validação = 0;
		//input.nextLine();
		
		//System.out.println("Qual o valor da transferência? ");
		String valor = JOptionPane.showInputDialog("Valor da transferência:");
		double quantia = Integer.parseInt(valor);
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
		default: /*System.out.print("O saldo de transferência excede o limite da conta que sairá o dinheiro. Tente novamente");*/
			JOptionPane.showMessageDialog(null,"Saldo de tranferência excede o limite da conta de saída","Erro",JOptionPane.ERROR_MESSAGE );
				 break;
		}	
		
		
	}
/// GERENCIAMENTO DE CONTA	
	
	public void alterarSenha(String senhaAntiga,String senhaNova)
	{
		if(Objects.equals(senha,senhaAntiga)) {//senha = senhaNova; System.out.print("\nSenha alterada com sucesso"); 
		JOptionPane.showMessageDialog(null,"Senha Alterada com Sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE); }
		else //System.out.print("\nSenha incorreta, tente novamente.");
			JOptionPane.showMessageDialog(null,"Senha incorreta, tente novamente", "Erro", JOptionPane.ERROR_MESSAGE);
	}

	
	public boolean verificarSenha(String senhaInserida)
	{	
		if (Objects.equals(senha, senhaInserida)) return true;
		else {/*System.out.println("Senha incorreta, tente novamente");*/ JOptionPane.showMessageDialog(null,"Senha incorreta, tente novamente", "Erro", JOptionPane.ERROR_MESSAGE); return false;}
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
	
	/// VERIFICAR INFORMAÇÕES
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public void verificainfo()
		{		
		JFrame frame1 = new JFrame();
		frame1.setSize(500,500);
		frame1.setTitle("Extrato Completo");
		frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JList list1 = new JList();
		list1.setBounds(500, 500, 500,500);	
		frame1.add(list1);
		DefaultListModel DLM1 = new DefaultListModel();
		frame1.setVisible(true);
			for(i = 0; i < Nclientes; i++)
			{
				//System.out.printf("\nNome do %d cliente: ", i + 1);
				DLM1.addElement("Nome do"+(i+1)+"cliente:" );	
				//System.out.println(GCliente[i].getnome());
				DLM1.addElement(""+GCliente[i].getnome());
				for(j = 0; j < GCliente[i].NCS; j++)
				{
					//System.out.println("Conta Simples\nNumero " + GCliente[i].CS[j].numerodaconta);
					DLM1.addElement("Conta Simples, numero:"+GCliente[i].CS[j].numerodaconta);
					GCliente[i].CS[j].extratocompleto();
				}
				for(j = 0; j < GCliente[i].NCP; j++)
				{
					//System.out.println("Conta Polpança\nNumero " + GCliente[i].CP[j].numerodaconta);
					DLM1.addElement("Conta Polpança, numero:"+GCliente[i].CS[j].numerodaconta);
					GCliente[i].CP[j].extratocompleto();
				}
				for(j = 0; j < GCliente[i].NCE; j++)
				{
					//System.out.println("Conta Especial\nNumero " + GCliente[i].CE[j].numerodaconta);
					DLM1.addElement("Conta Especial, numero:"+GCliente[i].CS[j].numerodaconta);
					GCliente[i].CE[j].extratocompleto();
				}
			}
			
			frame1.dispose();
		}
public void retgerente(int escG)
		{
			int opt = escG;
			//System.out.println("Digite o nome do cliente: ");
			String aplicanome = JOptionPane.showInputDialog("Nome do Cliente:");
			for(i = 0; i < Nclientes; i++)
			{
				if(Objects.equals(title(aplicanome), GCliente[i].getnome()))
				{
					//System.out.println("Qual das contas desse cliente você gostaria de retirar? Digite");
					//System.out.print("1. Para contas simples\n2. Para conta polpança\n3. Para conta especial\n");
					switch(opt)
					{
						case 1:
							//System.out.print("Qual o numero da conta?");
							int case1nc = Integer.parseInt(JOptionPane.showInputDialog("Numero da conta:"));
							for(j = 0; j < GCliente[i].getNCS(); j++)
							{
								if(case1nc == GCliente[i].CS[j].getnumerodaconta())
								{
									//System.out.println("Qual vai ser o valor da retirada? ");
									double ret = Double.parseDouble(JOptionPane.showInputDialog("Valor da retirada:"));
									GCliente[i].CS[j].retirada(ret);
									validação = 1;
								}
							}
							break;
							
						case 2:
							//System.out.print("Qual o numero da conta?");
							int case2nc = Integer.parseInt(JOptionPane.showInputDialog("Numero da conta:"));
							for(j = 0; j < GCliente[i].getNCE(); j++)
							{
								if(case2nc == GCliente[i].CE[j].getnumerodaconta())
								{
									//System.out.println("Qual vai ser o valor da retirada? ");
									double ret = Double.parseDouble(JOptionPane.showInputDialog("Valor da retirada:"));
									GCliente[i].CE[j].retirada(ret);
									validação = 1;
								}
							}

							break;
						case 3:
							//System.out.print("Qual o numero da conta?");
							int case3nc = Integer.parseInt(JOptionPane.showInputDialog("Numero da conta:"));
							for(j = 0; j < GCliente[i].getNCP(); j++)
							{
								if(case3nc == GCliente[i].CP[j].getnumerodaconta())
								{
									//System.out.println("Qual vai ser o valor da retirada? ");
									double ret = Double.parseDouble(JOptionPane.showInputDialog("Valor da retirada:"));
									GCliente[i].CP[j].retirada(ret);
									validação = 1;
								}
							}
							break;
						default:break;
					}
				}
			}
			if(validação == 0)// System.out.print("Dado digitado está incorreto. Tente novamente\n");
				JOptionPane.showMessageDialog(null,"Dado ditiado está incorreto.","ERRO",JOptionPane.ERROR_MESSAGE );
			validação = 0;
		}
//
public void taxager()
{
	//System.out.println("Digite o nome do cliente: ");
	String aplicanome = JOptionPane.showInputDialog("Nome do Cliente:");
	for(i = 0; i < Nclientes; i++)
	{
		if(Objects.equals(title(aplicanome), GCliente[i].getnome()))
		{
			//System.out.println("Qual o numero da conta polpança onde será alterada a taxa? ");
			int numerocp = Integer.parseInt(JOptionPane.showInputDialog("Numero da conta:"));
			for(j = 0 ; j < GCliente[i].getNCP(); j++)
			{
				if(numerocp == GCliente[i].CP[j].getnumerodaconta())
				{
					//System.out.println("Valor da nova taxa: ");
					double tax =Double.parseDouble(JOptionPane.showInputDialog("Valor da nova taxa:"));
					GCliente[i].CP[j].alterataxa(tax);
					validação = 1;
				}
			}
		}
	}
	if(validação == 0) //System.out.print("Dado digitado está incorreto. Tente novamente\n");
		JOptionPane.showMessageDialog(null,"Dado ditiado está incorreto.","ERRO",JOptionPane.ERROR_MESSAGE );
	validação = 0;
}

public void limiteger()
{
	//System.out.println("Digite o nome do cliente: ");
	String aplicanome =JOptionPane.showInputDialog("Nome do Cliente:");
	for(i = 0; i < Nclientes; i++)
	{
		if(Objects.equals(title(aplicanome), GCliente[i].getnome()))
		{
			//System.out.println("Qual o numero da conta especial onde será alterada o limite? ");
			int numeroce = Integer.parseInt(JOptionPane.showInputDialog("Numero da conta:"));
			for(j = 0 ; j < GCliente[i].getNCE(); j++)
			{
				if(numeroce == GCliente[i].CE[j].getnumerodaconta())
				{
					//System.out.println("Valor do novo limite: ");
					double limt =Double.parseDouble(JOptionPane.showInputDialog("Valor do novo limite:"));
					GCliente[i].CE[j].alteralimite(limt);
					validação = 1;
				}
			}
		}
	}
	if(validação == 0) //System.out.print("Dado digitado está incorreto. Tente novamente\n");
		JOptionPane.showMessageDialog(null,"Dado ditiado está incorreto.","ERRO",JOptionPane.ERROR_MESSAGE );
	validação = 0;
}
/// CONSTRUTOR
	public Gerente (String novonome, String novasenha)
	{
		senha = novasenha;
		nome = novonome;
	}
	
}
