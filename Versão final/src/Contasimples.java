import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class Contasimples extends Cliente{
	
	double saldo;
	int numerodaconta,i = 0,j;
	int validação;
	double[][] extrato = new double [2][500];
	
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

	public int getI ()
	{
		return i;
	}
/// DEPOSITO, SAQUE, EXTRATO E TRANSFERENCIAS
	
	public void depositar(double valor)
	{
		saldo = saldo + valor;
		//System.out.println("Deposito realizado com sucesso! Novo saldo: " + saldo);
		JOptionPane.showMessageDialog(null,"Deposito realizado com sucesso! Novo Saldo"+ saldo,"Sucesso",JOptionPane.INFORMATION_MESSAGE );

		extrato[0][i] = 1;
		extrato[1][i] = valor;
		i = i + 1;
	}
	
	public void sacar (double valor)
	{
		double sf;
		sf = saldo - valor;
		if(sf < 0) //System.out.print("O valor a ser sacado excede o limite\n");
			JOptionPane.showMessageDialog(null,"O valor a ser sacado excede o limite","Erro",JOptionPane.ERROR_MESSAGE );
		else {saldo = sf; //System.out.println("Saque realizado com sucesso! Novo saldo: " + saldo);
		JOptionPane.showMessageDialog(null,"Saque realizado com sucesso! Novo Saldo"+ saldo,"Sucesso",JOptionPane.INFORMATION_MESSAGE );
		}

		extrato[0][i] = 2;
		extrato[1][i] = valor;
		i = i + 1;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void extratocompleto()
	{
		ArrayList<String> lista = new ArrayList<String>();
		
		for(j = 0; j < i; j++)
		{
			if(extrato[0][j] == 1) {
				
				lista.add((j+1)+". Depósito de R$:"+ extrato[1][j]);
				validação=1;
			}
			else
				if(extrato[0][j] == 2) {
				
					lista.add((j+1)+". Saque de R$:"+ extrato[1][j]);
					validação=1;
					
				}
				else 
					if(extrato[0][j] == 3) {
						
						lista.add((j+1)+". Transferência de R$:"+ extrato[1][j]);
					
						validação=1;
						
					}
					else 
						if(extrato[0][j] == 4) {
							
							lista.add((j+1)+". Retirada de R$:"+ extrato[1][j]);
							validação=1;
						}															
		}
		
			if(validação == 0) {
				lista.add("Nenhuma operação foi realizada");
				String nomes = "";
				for(String nome : lista){
					nomes += nome+"\n";
				}
				JOptionPane.showMessageDialog(null, nomes);
				
				return;
			}
				
		
		
			String nomes = "";
			for(String nome : lista){
				nomes += nome+"\n";
			}
			JOptionPane.showMessageDialog(null, nomes);
			
			validação=0;

	}	
	
	public void transferpos(double valor)
	{
		saldo = saldo + valor;
		//System.out.println("Transferência realizada com sucesso! Novo saldo: " + saldo);
		JOptionPane.showMessageDialog(null,"Transferência realizada com sucesso! Novo Saldo "+ saldo,"Sucesso",JOptionPane.INFORMATION_MESSAGE );
		
		extrato[0][i] = 3;
		extrato[1][i] = valor;
		i = i + 1;
	}
	
	public void transferneg(double valor)
	{
		double sf;
		validação = 0;
		sf = saldo - valor;
		if(sf < 0) //System.out.print("O valor a ser sacado excede o limite\n");
			JOptionPane.showMessageDialog(null,"O valor a ser sacado excede o limite","Erro",JOptionPane.ERROR_MESSAGE );
		else {
				saldo = sf; //System.out.println("Transferência realizado com sucesso! Novo saldo: " + saldo);
				JOptionPane.showMessageDialog(null,"Transferência realizada com sucesso! Novo Saldo "+ saldo,"Sucesso",JOptionPane.INFORMATION_MESSAGE );
				extrato[0][i] = 3;
				extrato[1][i] = valor;
				i = i + 1;
				validação = 1;
			} 
	}
/// RETIRADA POR GERENTE
	public void retirada(double valor)
	{
		double sf;
		if(valor > 110000.00)
			{
				sf = saldo - valor;
				if (sf < 0) //System.out.print("O valor a ser retirado excede o limite\n");
					JOptionPane.showMessageDialog(null,"O valor a ser retirado excede o limite","Erro",JOptionPane.ERROR_MESSAGE );
				else {
						saldo = sf;
						//System.out.println("Retirada realizada com sucesso! Novo saldo: " + saldo);
						JOptionPane.showMessageDialog(null,"Retirada realizada com sucesso! Novo Saldo "+ saldo,"Sucesso",JOptionPane.INFORMATION_MESSAGE );
						extrato[0][i] = 4;
						extrato[1][i] = valor;
						i = i + 1;
					}
			}
		
	}
	
	
/// CONSTRUTOR
	
	public Contasimples (String nome, int numero, String novasenha)
	{
		super(nome,novasenha);
		numerodaconta = numero;
	}
	

}
