package secondVersion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyCards extends JPanel implements ActionListener, FocusListener {
	int currentCard = 0;
	CardLayout cards = new CardLayout(); 					// obiekt uk³adu kartowego java.awt.CardLayout tworz¹cego przechodz¹ce karty
	MyPanel[] step = new MyPanel[5]; 						// tablica przechowuj¹ca obiekty klasy MyPanel,
	CarData newCar = new CarData();
	public Insets getInsets() {
		return new Insets(40, 50, 50, 50);
	}

	
	public MyCards() { 									// Tworzenie kart na podstawie konstruktora MyPanel
		super();
		setLayout(cards);

		String question0 = "Jakie paliwo stosujesz w samochodzie?";
		String[] resp0 = { "benzyna lub olej napedowy", "benzyna + LPG" };
		step[0] = new MyPanel(question0, resp0, 0 );

		String question1 = "Podaj spalanie oraz koszt 1 litra PB95";
		String[] resp1 = new String[2];
		step[1] = new MyPanel(question1, resp1);

		String question2 = "Podaj spalanie oraz koszt 1 litra LPG (je¿li nie u¿ywasz, wpisz 0)";
		String[] resp2 = new String[2];
		step[2] = new MyPanel(question2, resp2);

		String question3 = "Podaj kolejno iloœæ km do przejechania na benzynie i LPG";
		String[] resp3 = new String[2];
		step[3] = new MyPanel(question3, resp3);
		step[3].setFinalQuestion(true);

		String answer = "Twój wynik";
		String[] answers = new String[0];
		step[4] = new MyPanel(answer, answers, 666);
				
		
		
		for (int i = 0; i < step.length; i++) {
			add(step[i], "Czêœæ" + i); 
			step[i].backButton.addActionListener(this);
			step[i].nextButton.addActionListener(this); 			// tworzenie obs³ugi akcji do przycisków
			step[i].calcButton.addActionListener(this);
			step[i].exitButton.addActionListener(this);
			
										// dodawanie karty pod okreœlon¹ nazw¹
		}
		step[0].select[0].addActionListener(this);
		step[0].select[1].addActionListener(this);
		
		step[1].textResponse[0].addFocusListener(this);
		step[1].textResponse[1].addFocusListener(this);
		step[2].textResponse[0].addFocusListener(this);
		step[2].textResponse[1].addFocusListener(this);
		step[3].textResponse[0].addFocusListener(this);
		step[3].textResponse[1].addFocusListener(this);

		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent evt) { 				// metoda z interfejsu ActionListener
		Object source = evt.getSource();
		
		if(source==step[0].select[0])
			step[0].nextButton.setEnabled(true);
		if(source==step[0].select[1])
			step[0].nextButton.setEnabled(true);
		
		for (int i = 0; i < step.length; i++) {

			if (source == step[i].backButton) {
				currentCard--;
				if (currentCard < step.length) {
					cards.show(this, "Czêœæ" + currentCard);	 // wyœwietlanie okreœlonej karty (this=kontener rodzic
																 // czyli ramka stosuj¹ca karty)
				}
			}

			if (source == step[i].nextButton) {
				currentCard++;
				if (currentCard < step.length) {
					cards.show(this, "Czêœæ" + currentCard);	 // wyœwietlanie okreœlonej karty (this=kontener rodzic
																	// czyli ramka stosuj¹ca karty)
				}
			}
			if (source == step[i].exitButton) {
				System.exit(0);
			}
			if (source == step[i].calcButton) {

				
				step[4].showAnswer.setText("<html><b> Podane parametry: <br> Spalanie PB95/ON na 100km: "+ newCar.getPb95On100km() + "l<br>Koszt 1 litra PB95/ON: " + newCar.getPb95Price()
						+ "PLN <br> Spalanie LPG:" + newCar.getLpgOn100km() + " l<br>Koszt 1 litra LPG: " + newCar.getLpgPrice() + "PLN<br>Iloœæ kilometrów przejechanych na PB95/ON: " + newCar.getKmOnPB95() + "km<br>Iloœæ kilometrów przejechanych na LPG: " + newCar.getKmOnLPG() +
						
						"km<br>Koszt trasy o zadanych parametrach to: " +newCar.calcResult() + " PLN </b></html>"
						);
				
							
				cards.show(this, "Czêœæ" + 4);
				
	}
		}}

	@Override
	public void focusGained(FocusEvent e) {
	}

	@Override
	public void focusLost(FocusEvent e) {
		Object source = e.getSource();
		
				
		if (source == step[1].textResponse[0]) { 
		try {
			newCar.setPb95On100km(Double.parseDouble(step[1].textResponse[0].getText()));
			step[1].setActiveNextButton(true);
			}
		catch 
			 (NumberFormatException e1) {step[1].textResponse[0].setText("0.00");
			 step[1].setActiveNextButton(false);
			}
		}
		
		if (source == step[1].textResponse[1]) { 
			try {
				newCar.setPb95Price(Double.parseDouble(step[1].textResponse[1].getText()));
				step[1].setActiveNextButton(true);
				}
			catch 
				 (NumberFormatException e1) {step[1].textResponse[1].setText("0.00");
				 step[1].setActiveNextButton(false);
				}
			}
		
		if (source == step[2].textResponse[0]) { 
			try {
				newCar.setLpgOn100km(Double.parseDouble(step[2].textResponse[0].getText()));
				step[2].setActiveNextButton(true);
				}
			catch 
				 (NumberFormatException e1) {step[2].textResponse[0].setText("0.00");
				 step[2].setActiveNextButton(false);
				}
			}
		if (source == step[2].textResponse[1]) { 
			try {
				newCar.setLpgPrice(Double.parseDouble(step[2].textResponse[1].getText()));
				step[2].setActiveNextButton(true);
				}
			catch 
				 (NumberFormatException e1) {step[2].textResponse[1].setText("0.00");
				 step[2].setActiveNextButton(false);
				}
			}
		if (source == step[3].textResponse[0]) { 
			try {
				newCar.setKmOnPB95(Double.parseDouble(step[3].textResponse[0].getText()));
				
				}
			catch 
				 (NumberFormatException e1) {step[3].textResponse[0].setText("0.00");
				
				}
			}
		if (source == step[3].textResponse[1]) { 
			try {
				newCar.setKmOnLPG(Double.parseDouble(step[3].textResponse[1].getText()));
				
				}
			catch 
				 (NumberFormatException e1) {step[3].textResponse[1].setText("0.00");
				 
				}
			}
		
		


	}
}


