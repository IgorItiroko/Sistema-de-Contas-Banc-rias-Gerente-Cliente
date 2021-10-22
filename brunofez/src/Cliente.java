import java.util.Objects;

import javax.swing.JOptionPane;

public class Cliente{
	
	private String senha;
	public String nomedocorrentista;
	int MAX = 50, NCP = 0, NCS = 0, NCE = 0, i = 0;
	Contapolpan�a[] CP = new Contapolpan�a[MAX];
	Contasimples[] CS = new Contasimples[MAX];
	Contaespecial[] CE = new Contaespecial[MAX];
	
	
/// GETTERS

	public String getnome()
	{
		return nomedocorrentista;
	}
	
	public int getNCP()
	{
		return NCP;
	}
	
	public int getNCS() {
		return NCS;
	}
	
	public int getNCE() 
	{
		return NCE;
	}
	

/// CRIA��O DE CONTAS CLIENTE
	
	public void criacp(String novonome, int numero, String novasenha, double taxa)
	{
		CP[NCP] = new Contapolpan�a(novonome,numero,novasenha,taxa);
		NCP = NCP + 1;
	}
	
	public void criacs(String nome, int numero, String novasenha)
	{
		CS[NCS] = new Contasimples(nome,numero,novasenha);
		NCS = NCS + 1;
	}
	
	public void criace(String nome, int numero, String novasenha, float limiteconta)
	{
		CE[NCE] = new Contaespecial(nome,numero,novasenha,limiteconta);
		NCE = NCE + 1;
	}
	
/// GERENCIAMENTEO DE SENHA
	
	public void alterarSenha(String senhaAntiga,String senhaNova)
	{
		if(Objects.equals(senha,senhaAntiga)) {senha = senhaNova; //System.out.print("\nSenha alterada com sucesso"); 
		JOptionPane.showMessageDialog(null,"Senha alterada com sucesso","Sucesso",JOptionPane.INFORMATION_MESSAGE);
		}
		else //System.out.print("\nSenha incorreta, tente novamente.");
			JOptionPane.showMessageDialog(null,"Senha Incorreta","Erro",JOptionPane.ERROR_MESSAGE);
	}
	
	public boolean verificarSenha(String senhaInserida)
	{
		if (Objects.equals(senha, senhaInserida)) return true;
		else {//System.out.println("Senha incorreta, tente novamente"); 
			JOptionPane.showMessageDialog(null,"Senha Incorreta","Erro",JOptionPane.ERROR_MESSAGE);
		return false;}
	}
	
	
///
	public void cdeposito(int eCD)
	{ 
		int esc = eCD;
		int valida��o = 0,j;
		//System.out.println("Qual das suas contas voc� gostaria de depositar? Digite");
		//System.out.print("1. Para contas simples\n2. Para conta polpan�a\n3. Para conta especial\n"); ///PODE SER BOT�O
		
		switch(esc)
		{
		case 1:
			//System.out.print("Qual o numero da conta?");
			int case1nc = Integer.parseInt(JOptionPane.showInputDialog("Numero da conta:"));
			for(j = 0; j < NCS; j++)
			{
				if(case1nc == CS[j].getnumerodaconta())
				{
					//System.out.println("Qual vai ser o valor do deposito? ");
					double dep = Double.parseDouble(JOptionPane.showInputDialog("Valor do deposito:"));
					CS[j].depositar(dep);
					valida��o = 1;
				}
			}
			break;
			
		case 2:
			//System.out.print("Qual o numero da conta?");
			int case3nc = Integer.parseInt(JOptionPane.showInputDialog("Numero da conta:"));
			for(j = 0; j < NCE; j++)
			{
				if(case3nc == CE[j].getnumerodaconta())
				{
					//System.out.println("Qual vai ser o valor do deposito? ");
					double dep = Double.parseDouble(JOptionPane.showInputDialog("Valor do deposito:"));
					CE[j].depositar(dep);
					valida��o = 1;
				}
			}

			break;
		case 3:
			//System.out.print("Qual o numero da conta?");
			int case2nc = Integer.parseInt(JOptionPane.showInputDialog("Numero da conta:"));
			for(j = 0; j < NCP; j++)
			{
				if(case2nc == CP[j].getnumerodaconta())
				{
					//System.out.println("Qual vai ser o valor do deposito? ");
					double dep = Double.parseDouble(JOptionPane.showInputDialog("Valor do deposito:"));
					CP[j].depositar(dep);
					valida��o = 1;
				}
			}

			break;
		
		}
		if(valida��o == 0)/* System.out.print("Dado digitado est� incorreto. Tente novamente\n")*/
			JOptionPane.showMessageDialog(null,"Dado digitado est� incorreto.","Erro",JOptionPane.ERROR_MESSAGE );
			valida��o = 0;
	}

public void csaque(int eCS)
{
	int esc = eCS;
	int j,valida��o=0;
	//System.out.println("Qual das suas contas voc� gostaria de sacar? Digite");
	//System.out.print("1. Para contas simples\n2. Para conta polpan�a\n3. Para conta especial\n"); ///PODE SER BOT�O
	switch(esc)
	{
	case 1:
		//System.out.print("Qual o numero da conta?");
		int case1nc = Integer.parseInt(JOptionPane.showInputDialog("Numero da conta:"));
		for(j = 0; j < NCS; j++)
		{
			if(case1nc == CS[j].getnumerodaconta())
			{
				//System.out.println("Qual vai ser o valor do saque? ");
				double dep = Double.parseDouble(JOptionPane.showInputDialog("Valor do saque:"));
				CS[j].sacar(dep);
				valida��o = 1;
			}
		}
		break;
		
	case 2:
		//System.out.print("Qual o numero da conta?");
		int case2nc = Integer.parseInt(JOptionPane.showInputDialog("Numero da conta:"));
		for(j = 0; j < NCE; j++)
		{
			if(case2nc == CE[j].getnumerodaconta())
			{
				//System.out.println("Qual vai ser o valor do saque? ");
				double dep = Double.parseDouble(JOptionPane.showInputDialog("Valor do deposito:"));
				CE[j].sacar(dep);
				valida��o = 1;
			}
		}

		break;
	case 3:
		//System.out.print("Qual o numero da conta?");
		int case3nc = Integer.parseInt(JOptionPane.showInputDialog("Numero da conta:"));
		for(j = 0; j < NCP; j++)
		{
			if(case3nc == CP[j].getnumerodaconta())
			{
				//System.out.println("Qual vai ser o valor do saque? ");
				double dep = Double.parseDouble(JOptionPane.showInputDialog("Valor do deposito:"));
				CP[j].sacar(dep);
				valida��o = 1;
			}
		}
				break;
			
	}
	if(valida��o == 0)/* System.out.print("Dado digitado est� incorreto. Tente novamente\n")*/
		JOptionPane.showMessageDialog(null,"Dado digitado est� incorreto.","Erro",JOptionPane.ERROR_MESSAGE );
		
}

public void getSaldo(int escolhaS)
{
	int escolha = escolhaS,j,valida��o = 0;
	//System.out.println("Qual o tipo de conta em que se deseja ver o saldo? ");
	switch(escolha)
	{
	case 1:
		//System.out.print("Qual o numero da conta?");
		int case1nc =Integer.parseInt(JOptionPane.showInputDialog("Numero da conta:"));
		for(j = 0; j < NCS; j++)
		{
			if(case1nc == CS[j].getnumerodaconta())
			{
				//System.out.println("O saldo da conta " + case1nc + " � " + CS[j].getsaldo());
				JOptionPane.showMessageDialog(null, "Saldo da conta " + case1nc +" � " + CS[j].getsaldo() );
				valida��o = 1;
			}
		}
		break;
		
	case 2:
		//System.out.print("Qual o numero da conta?");
		int case2nc = Integer.parseInt(JOptionPane.showInputDialog("Numero da conta:"));
		for(j = 0; j < NCE; j++)
		{
			if(case2nc == CE[j].getnumerodaconta())
			{
				//System.out.println("O saldo da conta " + case3nc + " � " + CE[j].getsaldo());
				JOptionPane.showMessageDialog(null, "Saldo da conta " + case2nc +" � " + CE[j].getsaldo() );
				valida��o = 1;
			}
		}
		break;
	case 3:
		//System.out.print("Qual o numero da conta?");
		int case3nc = Integer.parseInt(JOptionPane.showInputDialog("Numero da conta:"));
		for(j = 0; j < NCP; j++)
		{
			if(case3nc == CP[j].getnumerodaconta())
			{
				//System.out.println("O saldo da conta " + case2nc + " � " + CP[j].getsaldo());
				JOptionPane.showMessageDialog(null, "Saldo da conta " + case3nc +" � " + CP[j].getsaldo() );
				valida��o = 1;
			}
		}
		
		break;
	
	}
	if(valida��o == 0) System.out.print("Dado digitado est� incorreto. Tente novamente\n");
	valida��o = 0;
}
/// CONSTRUTOR
	
	public Cliente (String nome, String novasenha)
	{
		senha = novasenha;
		nomedocorrentista = nome;
	}


}
