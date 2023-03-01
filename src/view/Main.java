package view;

import javax.swing.JOptionPane;

import controller.KillController;

public class Main {
	public static void main(String[] args)
	{
		KillController KC = new KillController();
		String os = KC.Os();
		int J=0;
		while (J!=4)
		{
			J = Integer.parseInt(JOptionPane.showInputDialog("1- Lista de Processos\n2- Matar por PID\n3- Matar por Nome\n4- Sair"));
			switch (J)
			{
			case 1 -> KC.listaProcessos(os);
			case 4 -> JOptionPane.showMessageDialog(null, "Saindo");
			}
		}
	}
}
