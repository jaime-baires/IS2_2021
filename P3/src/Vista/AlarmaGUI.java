package Vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;

import Controlador.ControladorAlarma;
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
	private DefaultListModel<Alarma> modelActivas = new DefaultListModel<>();
	private JList<Alarma> alarmasActivasList = new JList<>(modelActivas);
	private DefaultListModel<Alarma> modelDesactivadas = new DefaultListModel<>();
	private JList<Alarma> alarmasDesactivadasList = new JList<>(modelDesactivadas);
	private ControladorAlarma controller = new ControladorAlarma();

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

		SpinnerDateModel model = new SpinnerDateModel(new Date(), null, null, Calendar.HOUR_OF_DAY);
		JSpinner horaAlarmaSpinner = new JSpinner(model);
		horaAlarmaSpinner.setBounds(109, 113, 86, 20);
		frame.getContentPane().add(horaAlarmaSpinner);

		JButton nuevaAlarmaButton = new JButton("Nueva Alarma");
		nuevaAlarmaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Date d = (Date) horaAlarmaSpinner.getValue();
				System.out.println(d);
				String id = idAlarmaTextField.getText();
				Alarma a = new Alarma(id, d);
				controller.NuevaAlarma(a);
				refrescaListas();
			}
		});
		nuevaAlarmaButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		nuevaAlarmaButton.setBounds(24, 162, 171, 23);
		frame.getContentPane().add(nuevaAlarmaButton);

		JButton apagarButton = new JButton("\u00A1APAGAR!");
		apagarButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controller.Apagar(controller.alarmaMasProxima());
				refrescaListas();
			}
		});
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
		offButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Alarma a = alarmasActivasList.getSelectedValue();
				if (a != null) {
					controller.AlarmaOff(a);

				}
				refrescaListas();
			}
		});
		offButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		offButton.setBounds(274, 365, 56, 23);
		frame.getContentPane().add(offButton);

		onButton = new JButton("ON");
		onButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Alarma a = alarmasDesactivadasList.getSelectedValue();
				if (a != null) {
					controller.AlarmaOn(a);

				}
				refrescaListas();
			}
		});
		onButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		onButton.setBounds(344, 365, 56, 23);
		frame.getContentPane().add(onButton);

		eliminarButton = new JButton("ELIMINAR");
		eliminarButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Alarma a = alarmasActivasList.getSelectedValue();
				if (a == null) {
					a = alarmasDesactivadasList.getSelectedValue();
				}
				if (a != null) {
					controller.BorraAlarma(a);
				}
				refrescaListas();
			}
		});
		eliminarButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		eliminarButton.setBounds(274, 397, 126, 23);
		frame.getContentPane().add(eliminarButton);

		// modelActivas.addElement(new Alarma("Levantarse", new Date()));
		alarmasActivasList.setVisible(true);
		alarmasActivasList.setVisibleRowCount(6);
		alarmasActivasList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		alarmasActivasList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		alarmasActivasList.setBounds(274, 79, 126, 100);
		frame.getContentPane().add(alarmasActivasList);

		alarmasDesactivadasList.setVisible(true);
		alarmasDesactivadasList.setVisibleRowCount(6);
		alarmasDesactivadasList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		alarmasDesactivadasList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		alarmasDesactivadasList.setBounds(274, 252, 126, 91);
		frame.getContentPane().add(alarmasDesactivadasList);
	}

	private void refrescaListas() {
		modelActivas.removeAllElements();
		modelDesactivadas.removeAllElements();
		for (Alarma al : controller.alarmasActivas()) {
			modelActivas.addElement(al);
		}
		for (Alarma al : controller.alarmasDesactivadas()) {
			modelDesactivadas.addElement(al);
		}
	}
}
