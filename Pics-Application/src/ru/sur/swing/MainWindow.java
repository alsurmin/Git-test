package ru.sur.swing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.Choice;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;

public class MainWindow extends JFrame{

	private JTabbedPane tabbedPane;
	private JPanel panel1;
	private JTextArea txtrEnterUrlHere;
	private JButton btnGetImage;
	private JButton btnNewButton;
	private JButton btnView;
	private Choice choice;
	private JLabel lblNewLabel;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mntmSaveImage;
	private JMenu mnOptions;
	private JMenuItem mntmExit;
	private JScrollPane scrollPane;
	private JLabel imagelabel;

	public MainWindow(int width, int height) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(662, 538);
		getContentPane().setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 32, 626, 456);
		getContentPane().add(tabbedPane);
		setResizable(false);
		
		panel1 = new JPanel(null);
		panel1.setToolTipText("Enter URL here:");
		tabbedPane.addTab("Tab 1", panel1);
		
		txtrEnterUrlHere = new JTextArea();
		txtrEnterUrlHere.setText("Enter URL here...");
		txtrEnterUrlHere.setBounds(10, 47, 601, 164);
		panel1.add(txtrEnterUrlHere);
		
		btnGetImage = new JButton("Get Image");
		btnGetImage.setBounds(10, 11, 103, 23);
		panel1.add(btnGetImage);
		
		btnNewButton = new JButton("Get File");
		btnNewButton.setBounds(522, 11, 89, 23);
		panel1.add(btnNewButton);
		JPanel panel2 = new JPanel(null);
		tabbedPane.addTab("Tab 2", panel2);
		
		btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Main.getImage()==null) {return;}
				imagelabel.setIcon(new ImageIcon(Main.getImage()));
				imagelabel.updateUI();
				
			}
		});
		btnView.setBounds(10, 11, 89, 23);
		panel2.add(btnView);
		
		choice = new Choice();
		choice.setBounds(551, 14, 60, 20);
		panel2.add(choice);
		
		lblNewLabel = new JLabel("Format");
		lblNewLabel.setBounds(499, 20, 46, 14);
		panel2.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 45, 621, 383);
		panel2.add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		imagelabel = new JLabel("");
		panel.add(imagelabel, BorderLayout.CENTER);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 656, 21);
		getContentPane().add(menuBar);
		
		mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		mntmSaveImage = new JMenuItem("Save Image");
		mntmSaveImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				int reply = chooser.showSaveDialog(null);
				if(reply == JFileChooser.APPROVE_OPTION) {
					Main.saveImage(chooser.getSelectedFile(), choice.getSelectedItem());
				}
			}
		});
		mnFile.add(mntmSaveImage);
		
		mnOptions = new JMenu("Options");
		menuBar.add(mnOptions);
		
		mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnOptions.add(mntmExit);
		choice.add("png");
		choice.add("jpg");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				int reply =	chooser.showOpenDialog(null);
				if(reply == JFileChooser.APPROVE_OPTION) {
					//System.out.println("“ÛÚ");
					Main.setImage(chooser.getSelectedFile());
				}
				
				
			}
		});
		
		btnGetImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Main.setImage(new URL(txtrEnterUrlHere.getText()));
					System.out.println(Main.getImage());
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Invalid URL or no internet connection");
				}
			}
		});
		
		setVisible(true);
		//menuBar.repaint();
		//mnFile.updateUI();
		//mnOptions.updateUI();
		
	}
}
