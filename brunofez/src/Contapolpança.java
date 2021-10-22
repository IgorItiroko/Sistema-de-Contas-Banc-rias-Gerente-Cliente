import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class Contapolpança extends Cliente{

	double saldo;
	int numerodaconta,j,i = 0;
	double taxadejuros;
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
	
	
/// RENDIMENTO
	
	public void rendimento (int tempodeconta)
	{
		int n,i;		
		n = tempodeconta/30;
		for(i = 0; i < n; i++)
		{
			saldo = saldo + saldo * taxadejuros;
		}
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
		else {saldo = sf;// System.out.println("Saque realizado com sucesso! Novo saldo: " + saldo);
		JOptionPane.showMessageDialog(null,"Saque realizado com sucesso! Novo Saldo"+ saldo,"Sucesso",JOptionPane.INFORMATION_MESSAGE );
		}
		extrato[0][i] = 2;
		extrato[1][i] = valor;
		i = i + 1;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void extratocompleto()
	{
		JFrame frame1 = new JFrame();
		frame1.setSize(300,300);
		frame1.setTitle("Extrato Completo");
		frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JList list1 = new JList();
		list1.setBounds(500, 500, 500,500);	
		frame1.add(list1);
		DefaultListModel DLM1 = new DefaultListModel();
		frame1.setVisible(true);
		for(j = 0; j < i; j++)
		{
			if(extrato[0][j] == 1)
				{//System.out.printf("%d. Depósito de R$ %.2f\n",j + 1, extrato[1][j]);
				DLM1.addElement((j+1)+". Depósito de R$:"+ extrato[1][j]);
				list1.setModel(DLM1);	
				}
			else
				if(extrato[0][j] == 2) { 
					//System.out.printf("%d. Saque de R$ %.2f\n",j + 1, extrato[1][j]);
					DLM1.addElement((j+1)+". Saque de R$:"+ extrato[1][j]);
					list1.setModel(DLM1);	
				}
				else 
					if(extrato[0][j] == 3) {
						//System.out.printf("%d. Tranferência de R$ %.2f\n",j + 1, extrato[1][j]);
						DLM1.addElement((j+1)+". Transferência de R$:"+ extrato[1][j]);
						list1.setModel(DLM1);
					}
					else 
						if(extrato[0][j] == 4) {
							//System.out.printf("%d. Retirada de R$ %.2f\n",j + 1, extrato[1][j]);
							DLM1.addElement((j+1)+". Retirada de R$:"+ extrato[1][j]);
							list1.setModel(DLM1);
						}
						else {//System.out.printf("Nenhuma operação foi realizada");
							JOptionPane.showMessageDialog(null,"Nenhuma operação foi realizada","",JOptionPane.INFORMATION_MESSAGE );
							j = i;}
						}
						
		}		
	
	public void transferpos(double valor)
	{
		saldo = saldo + valor;
		//System.out.println("Transferência realizada com sucesso! Novo saldo: " + saldo);
		JOptionPane.showMessageDialog(null,"Transferência realizado com Sucesso! Novo saldo:"+ saldo,"Sucesso",JOptionPane.INFORMATION_MESSAGE );
		extrato[0][i] = 3;
		extrato[1][i] = valor;
		i = i + 1;
	}
	
	public void transferneg (double valor)
	{
		validação = 0;
		double sf;
		sf = saldo - valor;
		if(sf < 0) //System.out.print("O valor a ser sacado excede o limite\n");
			JOptionPane.showMessageDialog(null,"O valor a ser sacado excede o limite","Erro",JOptionPane.ERROR_MESSAGE );
		else {
				saldo = sf; 
				//System.out.println("Transferência realizado com sucesso! Novo saldo: " + saldo);
				JOptionPane.showMessageDialog(null,"Transferência realizado com Sucesso! Novo saldo:"+ saldo,"Sucesso",JOptionPane.INFORMATION_MESSAGE );
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
						JOptionPane.showMessageDialog(null,"Retirada realizada com Sucesso! Novo saldo:"+ saldo,"Sucesso",JOptionPane.INFORMATION_MESSAGE );
						extrato[0][i] = 4;
						extrato[1][i] = valor;
						i = i + 1;
					}
			}
		
	}
/// ALTERAÇÃO DE TAXA PELO GERENTE
	
	public void alterataxa(double novataxa)
	{
		taxadejuros = novataxa;
		//System.out.println("Taxa alterada com sucesso! ");
		JOptionPane.showMessageDialog(null,"Taxa alterada com Sucesso!","Sucesso",JOptionPane.INFORMATION_MESSAGE );
	}
	
/// CONSTRUTOR
	
	public Contapolpança (String nome, int numero, String novasenha, double taxa)
	{
		super(nome,novasenha);
		numerodaconta = numero;
		taxadejuros = taxa;
	}
}
