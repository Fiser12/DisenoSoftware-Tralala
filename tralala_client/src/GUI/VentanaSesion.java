package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import controler.TralalaControler;
import data.dto.cancionDTO;

public class VentanaSesion extends JFrame{

	private static final long serialVersionUID = 1L;

	private TralalaControler control;
	private LinkedList<cancionDTO> listaCanciones;
	
	private int				width			= 800;
	private int				height			= 400;

	private String[] columnNames;
	private JTable table;

	private JScrollPane scrollPane;

	public VentanaSesion(TralalaControler controler)
	{
		this.control = controler;
		this.setMinimumSize(new Dimension(width, height));

		this.setTitle("Tralala");
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		listaCanciones = control.listaCanciones();
		columnNames = new String[] {"Titulo",
                "Duracion",
                "Generos",
                "Precio Compra",
                "Precio Reproduccion",
                "Veces Comprada"};
		String[][] canciones = new String[listaCanciones.size()][6];
		for(int i = 0; i<listaCanciones.size(); i++)
		{
			canciones[i][0]=listaCanciones.get(i).getTitulo();
			canciones[i][1]=listaCanciones.get(i).getDuracion()+"";
			canciones[i][2]=listaCanciones.get(i).getGenero()+"";
			canciones[i][3]=listaCanciones.get(i).getPrecioC()+"";
			canciones[i][4]=listaCanciones.get(i).getPrecioR()+"";
			canciones[i][5]=listaCanciones.get(i).getVecesComprada()+"";
		}
		table = new JTable(canciones, columnNames);
		scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		table.getTableHeader().setReorderingAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JPanel central = new JPanel();
		central.setLayout(new BorderLayout());
		central.add(scrollPane, BorderLayout.CENTER);
		JButton reproducir = new JButton(new ImageIcon("play_button.png"));
		reproducir.setBorder(null);
		reproducir.setMargin(new Insets(0, 0, 0, 0));
		JPanel inferior = new JPanel();
		inferior.add(reproducir);
		central.add(reproducir, BorderLayout.SOUTH);
		reproducir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try
				{
					control.reproducirCancion((String) table.getValueAt(table.getSelectedRow(), 0));
				}
				catch(ArrayIndexOutOfBoundsException E)
				{
				}
			}
		});
		this.getContentPane().add(central);
	}
}
