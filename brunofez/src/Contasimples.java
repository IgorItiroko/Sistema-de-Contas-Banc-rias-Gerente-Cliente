import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class Contasimples extends Cliente{
	
	double saldo;
	int numerodaconta,i = 0,j;
	int valida��o;
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
				{//System.out.printf("%d. Dep�sito de R$ %.2f\n",j + 1, extrato[1][j]);
				DLM1.addElement((j+1)+". Dep�sito de R$:"+ extrato[1][j]);
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
						//System.out.printf("%d. Tranfer�ncia de R$ %.2f\n",j + 1, extrato[1][j]);
						DLM1.addElement((j+1)+". Transfer�ncia de R$:"+ extrato[1][j]);
						list1.setModel(DLM1);
					}
					else 
						if(extrato[0][j] == 4) {
							//System.out.printf("%d. Retirada de R$ %.2f\n",j + 1, extrato[1][j]);
							DLM1.addElement((j+1)+". Retirada de R$:"+ extrato[1][j]);
							list1.setModel(DLM1);
						}
						else {//System.out.printf("Nenhuma opera��o foi realizada");
							JOptionPane.showMessageDialog(null,"Nenhuma opera��o foi realizada","",JOptionPane.INFORMATION_MESSAGE );
							j = i;}
						}
						
		}		
	
	public void transferpos(double valor)
	{
		saldo = saldo + valor;
		//System.out.println("Transfer�ncia realizada com sucesso! Novo saldo: " + saldo);
		JOptionPane.showMessageDialog(null,"Transfer�ncia realizada com sucesso! Novo Saldo "+ saldo,"Sucesso",JOptionPane.INFORMATION_MESSAGE );
		
		extrato[0][i] = 3;
		extrato[1][i] = valor;
		i = i + 1;
	}
	
	public void transferneg(double valor)
	{
		double sf;
		valida��o = 0;
		sf = saldo - valor;
		if(sf < 0) //System.out.print("O valor a ser sacado excede o limite\n");
			JOptionPane.showMessageDialog(null,"O valor a ser sacado excede o limite","Erro",JOptionPane.ERROR_MESSAGE );
		else {
				saldo = sf; //System.out.println("Transfer�ncia realizado com sucesso! Novo saldo: " + saldo);
				JOptionPane.showMessageDialog(null,"Transfer�ncia realizada com sucesso! Novo Saldo "+ saldo,"Sucesso",JOptionPane.INFORMATION_MESSAGE );
				extrato[0][i] = 3;
				extrato[1][i] = valor;
				i = i + 1;
				valida��o = 1;
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
