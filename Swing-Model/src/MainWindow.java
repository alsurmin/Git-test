import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {
	private TutorListModel model;
	private JList<String> list;
	private JButton btnRemove;
	private JButton btnAdd;
	public MainWindow()  {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640, 480);
		setResizable(false);
		
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 421, 429);
		getContentPane().add(scrollPane);
		
		model = new TutorListModel();
		
		list = new JList<String>(model);
		scrollPane.setViewportView(list);
		
		btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<String> objects = list.getSelectedValuesList();
				try {
					for (String s: objects) {
						model.removeElement(s);
					}
				} catch (Exception e2) {
				}
				list.clearSelection();
				list.updateUI();
			}
		});
		btnRemove.setBounds(440, 11, 89, 23);
		getContentPane().add(btnRemove);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = JOptionPane.showInputDialog("Enter your string here:");
				model.addElement(s);
				list.updateUI();
			}
		});
		btnAdd.setBounds(441, 45, 89, 23);
		getContentPane().add(btnAdd);
		
		setVisible(true);
		
	}
	public void addElement(String s) {
		model.addElement(s);
	}
	
	public void removeElement(int index) {
		model.removeElement(index);
	}
	
	public void updateUI() {
		list.updateUI();
	}

	
}
