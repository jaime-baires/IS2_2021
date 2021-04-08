package Vista;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import Modelo.Alarma;

public class AlarmaGUI {

	private JFrame frame;
	private JTextField idAlarmaTextField;
	private JLabel lblHoraAlarma;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton offButton;
	private JButton onButton;
	private JButton eliminarButton;
	private JList<Alarma> alarmasActivasList;
	private JList<Alarma> alarmasDesactivadasList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlarmaGUI window = new AlarmaGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AlarmaGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		idAlarmaTextField = new JTextField();
		idAlarmaTextField.setBounds(109, 77, 86, 20);
		frame.getContentPane().add(idAlarmaTextField);
		idAlarmaTextField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Id Alarma");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(24, 80, 56, 14);
		frame.getContentPane().add(lblNewLabel);

		lblHoraAlarma = new JLabel("Hora Alarma");
		lblHoraAlarma.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHoraAlarma.setBounds(24, 116, 71, 14);
		frame.getContentPane().add(lblHoraAlarma);

		JSpinner horaAlarmaSpinner = new JSpinner();
		horaAlarmaSpinner.setBounds(109, 113, 86, 20);
		frame.getContentPane().add(horaAlarmaSpinner);

		JButton nuevaAlarmaButton = new JButton("Nueva Alarma");
		nuevaAlarmaButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		nuevaAlarmaButton.setBounds(24, 162, 171, 23);
		frame.getContentPane().add(nuevaAlarmaButton);

		JButton apagarButton = new JButton("\u00A1APAGAR!");
		apagarButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		apagarButton.setBounds(24, 196, 171, 43);
		frame.getContentPane().add(apagarButton);

		lblNewLabel_1 = new JLabel("Alarmas Activas");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(274, 52, 126, 14);
		frame.getContentPane().add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Alarmas Desactivadas");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(274, 225, 126, 14);
		frame.getContentPane().add(lblNewLabel_2);

		offButton = new JButton("OFF");
		offButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		offButton.setBounds(274, 365, 56, 23);
		frame.getContentPane().add(offButton);

		onButton = new JButton("ON");
		onButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		onButton.setBounds(344, 365, 56, 23);
		frame.getContentPane().add(onButton);

		eliminarButton = new JButton("ELIMINAR");
		eliminarButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		eliminarButton.setBounds(274, 397, 126, 23);
		frame.getContentPane().add(eliminarButton);

		alarmasActivasList = new JList<Alarma>();
		alarmasActivasList.setVisibleRowCount(-1);
		alarmasActivasList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		alarmasActivasList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		alarmasActivasList.setToolTipText("");
		// JScrollPane listScroller = new JScrollPane(alarmasActivasList);
		// listScroller.setPreferredSize(new Dimension(250, 80));

		alarmasActivasList.setBounds(274, 196, 126, -100);
		frame.getContentPane().add(alarmasActivasList);

		alarmasDesactivadasList = new JList<Alarma>();
		alarmasDesactivadasList.setVisibleRowCount(-1);
		alarmasDesactivadasList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		alarmasDesactivadasList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		alarmasDesactivadasList.setToolTipText("");
		alarmasDesactivadasList.setBounds(274, 342, 126, -91);
		// JScrollPane listScroller2 = new JScrollPane(alarmasDesactivadasList);
		// listScroller2.setPreferredSize(new Dimension(250, 80));
		frame.getContentPane().add(alarmasDesactivadasList);
	}
}
