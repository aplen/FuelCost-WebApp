package secondVersion;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicScrollPaneUI.VSBChangeListener;
class MyPanel extends JPanel { 												// klasa definiuj¹ca obiekty MyPanel czyli nasze karty
	JRadioButton [] select;
	JButton backButton = new JButton("Wstecz");
	JButton nextButton = new JButton("Dalej");
	JButton calcButton = new JButton("Oblicz");
	JButton exitButton = new JButton("Koniec");
	JTextField[] textResponse;
	String toView;
	JLabel showAnswer;
	
	MyPanel() {
		this("", new String[0]);
	}

	MyPanel(String ques, String[] textData) {
		this(ques, new String[0], 0, textData);
	}

	MyPanel(String ques, String[] resp, int def) {
		this(ques, resp, def, new String[0]);
	}

	MyPanel(String ques, String[] resp, int def, String[] textData) {
		super();
		setSize(640, 480);
		 		
		textResponse = new JTextField[textData.length];
		select = new JRadioButton[resp.length]; 							// obiekt button przechowuj¹cy opcje do wyboru
		JPanel upperPart = new JPanel(); 									
		JLabel quesLabel = new JLabel(ques); 							// Tytu³ ka¿dej karty
		upperPart.add(quesLabel);											// dodanie pytania do górnej czêœci tworzonej karty
		
		ButtonGroup group = new ButtonGroup(); 
		JPanel middlePart = new JPanel();

		for (int i = 0; i < resp.length; i++) {							 // pêtla tworzy grupê radiobuttonów z "i" iloœci¹ opcji
			if (def == i) { 											// oraz domyœlnym zaznaczeniem na pozycji def
				select[i] = new JRadioButton(resp[i], false);
			} else {
				select[i] = new JRadioButton(resp[i], false);
			}
			group.add(select[i]); 
			middlePart.add(select[i]); 
		}
		for (int j = 0; j < textData.length; j++) {
			{
				middlePart.setLayout(new GridLayout(2, 2, 5, 5));
				textResponse[j] = new JTextField(10);
				JLabel txtFieldsDescr = new JLabel("podaj wartoœæ " + j);
				middlePart.add(txtFieldsDescr);
				middlePart.add(textResponse[j]); 									// dodanie opcji do œrodkowej czêœci karty
			}
		}
		if (def == 666) {
				
			showAnswer = new JLabel(toView);
			
			middlePart.add(showAnswer);
			
		}

		JPanel bottomPart = new JPanel();
		bottomPart.setLayout(new GridLayout(1, 3, 30, 30));
		backButton.setEnabled(true);
		bottomPart.add(backButton);
		nextButton.setEnabled(false);
		bottomPart.add(nextButton); 
		calcButton.setEnabled(false);
		bottomPart.add(calcButton);
		exitButton.setEnabled(true);
		bottomPart.add(exitButton);

		GridLayout grid = new GridLayout(3, 1, 20, 20); 			// rozmieszczenie paneli
		setLayout(grid);
		add(upperPart);
		upperPart.setPreferredSize(new Dimension(20,20));
		
		JScrollPane scroll = new JScrollPane(middlePart);
		
		scroll.setPreferredSize(new Dimension(300,300));
		
		add(scroll);
				
		add(bottomPart);
		
	}

	

	void setFinalQuestion(boolean isFinalQuestion) { 
		if (isFinalQuestion) {
			nextButton.setEnabled(false);
			calcButton.setEnabled(true);
		}
	}
		
		void setActiveNextButton(boolean isRightFormat) { 
			if (isRightFormat) {
				nextButton.setEnabled(true);
			}
			else {
				nextButton.setEnabled(false);
			}
	}
		
		
}
