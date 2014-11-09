
import java.util.*;
import java.awt.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.*;

/**
 * 
 * ListGUI.java
 * @author fmeade
 */
public class ListGUI 
{
	// frame
	private JFrame frame;
	// panels
	private JPanel panel1,panel2,panel3;
	// buttons for AddressList functions
	private JButton isEmpty,addToFront,addToBack,toString,reverseToString,reverse,
					sizeOf,phoneNumberByName,emailByName,nameByPhoneNumber,
					dobByName;
	// text fields to enter input
	private JTextField name,tel,email,addr,dob;
	private JTextField pnByName,emByName,nameByPN,dobByN;
	// area to output data
	private JTextArea textArea;
	// scroll pane
	private JScrollPane scrollPane;
	// AddressList object
	private AddressList list;
	
	/**
	 * Instantiates instance variables and
	 * adds button functions
	 */
	public ListGUI()
	{
		list = new AddressList();
		
		frame = new JFrame();
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		
		/* isEmpty button function */
		isEmpty = new JButton("isEmpty");
		isEmpty.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						textArea.setText("" + list.isEmpty());
					}
				});
		
		/* addToFront button function */
		addToFront = new JButton("addToFront");
		addToFront.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				list.addToFront(name.getText(), tel.getText(), email.getText(), addr.getText(), dob.getText());
			}
		});
		
		/* addToBack button function */
		addToBack = new JButton("addToBack");
		addToBack.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				list.addToBack(name.getText(), tel.getText(), email.getText(), addr.getText(), dob.getText());
			}
		});
		
		/* toString button function */
		toString = new JButton("toString");
		toString.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				textArea.setText(list.toString());
			}
		});
		
		/* reverseToString button function */
		reverseToString = new JButton("reverseToString");
		reverseToString.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				textArea.setText(list.reverseToString());
			}
		});
		
		/* reverse button function */
		reverse = new JButton("reverse");
		reverse.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				list = list.reverse();
			}
		});
		
		/* sizeOf button function */
		sizeOf = new JButton("sizeOf");
		sizeOf.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				textArea.setText("Size: " + list.sizeOf());
			}
		});
		
		/* phoneNumberByName button function */
		phoneNumberByName = new JButton("phoneNumberByName");
		phoneNumberByName.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				textArea.setText(list.phoneNumberByName(pnByName.getText()));
			}
		});
		
		/* emailByName button function */
		emailByName = new JButton("emailByName");
		emailByName.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				textArea.setText(list.emailByName(emByName.getText()));
			}
		});
		
		/* nameByPhoneNumber button function */
		nameByPhoneNumber = new JButton("nameByPhoneNumber");
		nameByPhoneNumber.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				textArea.setText(list.nameByPhoneNumber(nameByPN.getText()));
			}
		});
		
		/* dobByName button function */
		dobByName = new JButton("dobByName");
		dobByName.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				textArea.setText(list.dobByName(dobByN.getText()));
			}
		});
		
		/* text fields for user input */
		name = new JTextField();
		name.setText("Name");
		tel = new JTextField();
		tel.setText("Telephone");
		email = new JTextField();
		email.setText("Email");
		addr = new JTextField();
		addr.setText("Address");
		dob = new JTextField();
		dob.setText("Date of Birth");
		pnByName = new JTextField();
		emByName = new JTextField();
		nameByPN = new JTextField();
		dobByN = new JTextField();
		
		/* text area for output */
		textArea = new JTextArea();
		scrollPane = new JScrollPane(textArea);
		
		
	}
	
	/**
	 * builds GUI
	 */
	public void start()
	{
		frame.setLayout(new GridLayout(2,1));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel1.setLayout(new GridLayout(10,1));
		panel2.setLayout(new GridLayout(10,1));
		panel3.setLayout(new GridLayout(1,2));
		
		panel1.add(name);
		panel1.add(tel);
		panel1.add(email);
		panel1.add(addr);
		panel1.add(dob);
		panel1.add(isEmpty);
		panel1.add(pnByName);
		panel1.add(emByName);
		panel1.add(nameByPN);
		panel1.add(dobByN);
		
		panel2.add(addToFront);
		panel2.add(addToBack);
		panel2.add(toString);
		panel2.add(reverseToString);
		panel2.add(reverse);
		panel2.add(sizeOf);
		panel2.add(phoneNumberByName);
		panel2.add(emailByName);
		panel2.add(nameByPhoneNumber);
		panel2.add(dobByName);
		
		panel3.add(panel1);
		panel3.add(panel2);
		
		frame.add(panel3);
		frame.add(scrollPane);
		
		frame.pack();
		frame.setVisible(true);
	}
}
