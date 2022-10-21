import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import model.Student;

import java.awt.BorderLayout;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import javax.swing.JCheckBox;
import java.awt.Color;

public class AddStudentGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAddress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudentGUI frame = new AddStudentGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddStudentGUI() {
		setTitle("Student Information System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel actionsPanel = new JPanel();
		actionsPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		actionsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		contentPane.add(actionsPanel, BorderLayout.SOUTH);
		
		Border blackline = BorderFactory.createTitledBorder("New Student");
		JPanel studentPanel = new JPanel();
		studentPanel.setBorder(blackline);
		studentPanel.setLayout(new BorderLayout(0, 0));
		contentPane.add(studentPanel, BorderLayout.CENTER);
		
		
		
		
		JPanel panelAddStudent = new JPanel();
		studentPanel.add(panelAddStudent, BorderLayout.NORTH);
		panelAddStudent.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panelShowStudent = new JPanel();
		panelShowStudent.setToolTipText("");
		panelShowStudent.setBounds(100, 100, 400, 140);
		panelShowStudent.setLayout(new BorderLayout(0, 0));
		panelShowStudent.setBackground(new java.awt.Color(238, 238, 238));
		studentPanel.add(panelShowStudent, BorderLayout.CENTER);
		
		JPanel panelModules = new JPanel();
		studentPanel.add(panelModules, BorderLayout.EAST);
		panelModules.setLayout(new GridLayout(4,1));
		
		
		
		JTextArea textAreaStudent = new JTextArea();
		textAreaStudent.setBackground(new Color(220, 220, 220));
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		
		
		
		
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		txtName = new JTextField();
		txtName.setText("Peter Smith");
		txtName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Address");
		
		txtAddress = new JTextField();
		txtAddress.setText("35 Liffey Street, Dublin 2");
		txtAddress.setColumns(10);
		
		List<Student> studentList = new ArrayList<Student>();
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				System.out.print(txtName.getText());
				System.out.print(txtAddress.getText());
				if(txtName.getText() != "" && txtAddress.getText() != "") {					
					Student student = new Student();
					student.setName(txtName.getText());
					student.setAddress(txtAddress.getText());
					studentList.add(student);
					
					
					textAreaStudent.append(txtName.getText() + ", " + txtAddress.getText() + "\n");
				}
				
			}
		});
		
		
		JButton btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtName.setText("");
				txtAddress.setText("");
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		JTextArea showCheckboxs = new JTextArea();
		showCheckboxs.setBackground(new Color(220, 220, 220));
		
		
		List<String> listCheckboxs = new ArrayList<String>();
		JCheckBox databases = new JCheckBox("Databases");
		databases.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		            listCheckboxs.add("databases");
		        } else {//checkbox has been deselected
		            listCheckboxs.removeIf(c -> c.toString() == "databases");
		        }
				showValueCheckboxs(showCheckboxs, listCheckboxs);
			}
		});
		
		
		JCheckBox java = new JCheckBox("Java");
		java.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		            listCheckboxs.add("java");
		        } else {//checkbox has been deselected
		            listCheckboxs.removeIf(c -> c.toString() == "java");
		        };
		        showValueCheckboxs(showCheckboxs, listCheckboxs);
			}
			
		});
		
		
		JCheckBox accountancy = new JCheckBox("Accountancy");
		accountancy.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		            listCheckboxs.add("accountancy");
		        } else {//checkbox has been deselected
		            listCheckboxs.removeIf(c -> c.toString() == "accountancy");
		        }
				showValueCheckboxs(showCheckboxs, listCheckboxs);
			}
		});
		
		
		JButton finish = new JButton("Finish");
		finish.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		
		JButton clearAll = new JButton("Clear All");
		clearAll.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtName.setText("");
				txtAddress.setText("");
				textAreaStudent.setText("");
				databases.setSelected(false);
				java.setSelected(false);
				accountancy.setSelected(false);
			}
		});
		
		
		
		/* declaration add in panels */
		panelAddStudent.add(lblNewLabel);
		panelAddStudent.add(txtName);
		panelAddStudent.add(lblNewLabel_1);
		panelAddStudent.add(txtAddress);
		panelAddStudent.add(btnNewButton);
		panelAddStudent.add(btnNewButton_1);
		
		
		panelShowStudent.add(textAreaStudent);
		
		
		panelModules.add(databases);
		panelModules.add(java);
		panelModules.add(accountancy);
		panelModules.add(showCheckboxs);
		
		
		actionsPanel.add(finish);
		actionsPanel.add(clearAll);
	}
	
	public void showValueCheckboxs(JTextArea textArea, List<String> list) {
		String modules = "";
		textArea.setText("");
		for (String module : list) {
			modules += module + "\n";
		}
		textArea.append(modules);
	}

}
