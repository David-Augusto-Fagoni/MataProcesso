
package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

public class KillController 
{
	public KillController()
	{
		super();
	}
	
	public String Os()
	{
		String os = System.getProperty("os.name");
		return os;
	}
	
	public void listaProcessos(String os)
	{
		String processo;
		if (os.contains("Linux"))
		{
			processo = "ps -ef";
		}
		else
		{
			processo = "TASKLIST /FO TABLE";
		}
		try {
			Process p =	Runtime.getRuntime().exec(processo);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null)
			{
				System.out.println(linha);
				linha = buffer.readLine();
			}
		} catch (IOException e) {

			String MsgErro = e.getMessage();
			if(MsgErro.contains("740"))
			{
				StringBuffer buffer = new StringBuffer();
				buffer.append("cmd /c ");
				buffer.append(processo);
			}
			else
			{
			e.printStackTrace();
			}
		}
	}
	
	public void mataPid (String os)
	{
		String processo;
		if (os.contains("Linux"))
		{
			processo = ("kill -9 ");
		}
		else
		{
			processo = ("TASKKILL /PID ");
		}
		processo = (processo +(JOptionPane.showInputDialog("Digite o PID do programa")));
		
	
		try 
		{
			Process p = Runtime.getRuntime().exec(processo);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			if (linha == null)
			{
				System.out.println("PID não encontrado");
			}
			else
			{
				System.out.println("PID encontrado e eliminado");
			}

		} 
		catch (IOException e) {
			String MsgErro = e.getMessage();
			if(MsgErro.contains("740"))
			{
				StringBuffer buffer = new StringBuffer();
				buffer.append("cmd /c ");
				buffer.append(processo);
			}
			else
			{
			e.printStackTrace();
			}
		}
	}
	
	public void mataNome (String os)
	{
		String processo;
		if (os.contains("Linux"))
		{
			processo = ("pkill -f ");
		}
		else
		{
			processo = ("TASKKILL /IM ");
		}
		processo = (processo +(JOptionPane.showInputDialog("Digite o nome do programa")));
		
	
		try 
		{
			Process p = Runtime.getRuntime().exec(processo);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			if (linha == null)
			{
				System.out.println("Programa não encontrado");
			}
			else
			{
				System.out.println("Programa encontrado e eliminado");
			}
		} 
		catch (IOException e) {
			String MsgErro = e.getMessage();
			if(MsgErro.contains("740"))
			{
				StringBuffer buffer = new StringBuffer();
				buffer.append("cmd /c ");
				buffer.append(processo);
			}
			else
			{
				e.printStackTrace();
			}
		}
	}	
}
