
public class Contaespecial extends Cliente{
	
	double saldo;
	int numerodaconta,j,i = 0;
	double limite;
	double[][] extrato = new double [2][500];
	int validação;
	
/// GETTERS
	
	public int getnumerodaconta ()
	{
		return numerodaconta;
	}
	
	public String getnomedocorrentista()
	{
		return nomedocorrentista;
	}
	
	public double getsaldo ()
	{
		return saldo;
	}

	public double getlimite ()
	{
		return limite;
	}
	
/// DEPOSITO E SAQUE
	
	public void depositar(double valor)
	{
		saldo = saldo + valor;
		System.out.println("Deposito realizado com sucesso! Novo saldo: " + saldo);
		extrato[0][i] = 1;
		extrato[1][i] = valor;
		i = i + 1;
	}
	
	public void sacar (double valor)
	{
		double sf;
		sf = saldo - valor;
		if(sf <= (limite * -1)) System.out.print("O valor a ser sacado excede o limite\n");
		else {saldo = sf; System.out.println("Deposito realizado com sucesso! Novo saldo: " + saldo);}
		extrato[0][i] = 2;
		extrato[1][i] = valor;
		i = i + 1;
	}
	
	public void extratocompleto()
	{
		for(j = 0; j < i; j++)
		{
			if(extrato[0][j] == 1)
				System.out.printf("%d. Depósito de R$ %.2f\n",j + 1, extrato[1][j]);
			else
				if(extrato[0][j] == 2) System.out.printf("%d. Saque de R$ %.2f\n",j + 1, extrato[1][j]);
				else 
					if(extrato[0][j] == 3) System.out.printf("%d. tranferência de R$ %.2f\n",j + 1, extrato[1][j]);
					else 
						if(extrato[0][j] == 4) System.out.printf("%d. transferência de R$ %.2f\n",j + 1, extrato[1][j]);
						else
							{System.out.printf("Nenhuma operação foi realizada"); j = i;}
		}
	}
	
	public void transferpos(double valor)
	{
		saldo = saldo + valor;
		System.out.println("Transferência realizada com sucesso! Novo saldo: " + saldo);
		extrato[0][i] = 3;
		extrato[1][i] = valor;
		i = i + 1;
	}
	
	public void transferneg(double valor)
	{
		validação = 0;
		double sf;
		sf = saldo - valor;
		if(sf <= (limite * -1)) System.out.print("O valor a ser sacado excede o limite\n");
		else {
				saldo = sf; System.out.println("Transferência realizado com sucesso! Novo saldo: " + saldo);
				extrato[0][i] = 3;
				extrato[1][i] = valor;
				i = i + 1;
				validação = 1;
			}

	}
/// ALTERAÇÃO DE LIMITE PELO GERENTE
	
	public void alteralimite(float novolimite)
	{
		limite = novolimite;
	}
	
/// RETIRADA POR GERENTE
	public void retirada(double valor)
	{
		double sf;
		if(valor > 110000.00)
			{
				sf = saldo - valor;
				if (sf <= (limite * -1)) System.out.print("O valor a ser retirado excede o limite\n");
				else {
						saldo = sf;
						System.out.println("Retirada realizada com sucesso! Novo saldo: " + saldo);
						extrato[0][i] = 4;
						extrato[1][i] = valor;
						i = i + 1;
					}
			}	
		else System.out.print("Valor muito baixo\n");
	}
/// CONSTRUTOR
	
	public Contaespecial (String nome, int numero, String novasenha, float limiteconta)
	{
		super(nome,novasenha);
		numerodaconta = numero;
		limite = limiteconta;
	}
}
