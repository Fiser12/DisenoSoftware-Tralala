package GUI;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controler.TralalaControler;

public class VentanaInicio extends JFrame implements ActionListener{
	
	private TralalaControler controler;

	private int				width			= 300;
	private int				height			= 100;
	
	private JButton			blogin, bregistro;
	private JTextField		mail;
	private JLabel			label;
	
	private static final long serialVersionUID = -4583485024176265664L;

	public VentanaInicio(String ip, String port, String name) {
		try {
			controler = new TralalaControler(ip, port, name);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.setMinimumSize(new Dimension(width, height));
		this.setTitle("Tralala");
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		

		blogin = new JButton ("Log In"); 
		bregistro = new JButton("Registrarse");
		bregistro.setEnabled(false);
		label = new JLabel("Correo Facebook");
		mail = new JTextField(10);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JPanel panelCentral = new JPanel();
		JPanel panelBotones = new JPanel();
		panelBotones.add(blogin);
		panelBotones.add(bregistro);
		JPanel panelText = new JPanel();
		panelText.add(label);
		panelText.add(mail);
		panelCentral.setLayout(new BorderLayout());
		panelCentral.add(panelBotones, BorderLayout.SOUTH);
		
		panelCentral.add(panelText, BorderLayout.CENTER);
		getContentPane().add(panelCentral);
	
		blogin.addActionListener(this);
		bregistro.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(blogin))
		{
			if(controler.login(mail.getText())){
				VentanaSesion sesion = new VentanaSesion(controler);
				sesion.setVisible(true);
				dispose();
			}
			else
				JOptionPane.showMessageDialog(this,
					    "Eggs are not supposed to be green.");
		}
		else if (e.getSource().equals(bregistro))
		{
			
		}
	}
	public static void main(String []args)
	{
		VentanaInicio nueva = new VentanaInicio(args[0], args[1], args[2]);
		nueva.setVisible(true);
	}

}
