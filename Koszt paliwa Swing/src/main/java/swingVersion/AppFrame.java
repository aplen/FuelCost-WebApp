package swingVersion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class AppFrame extends JFrame implements FocusListener, Consumptiable {

	private static final long serialVersionUID = 1L;
	private JTextField lpgOn100km, lpgPrice, kmOnLPG, pb95On100km, pb95Price, kmOnPB95, solution;
	private double dlpgOn100km, dlpgPrice, dkmOnLPG, dpb95On100km, dpb95Price, dkmOnPB95;
	private JLabel title, title1, lpgOn100kmDesc, lpgPriceDesc, kmOnLPGDesc, pb95On100kmDesc, pb95PriceDesc,
			kmOnPB95Desc, solutionDesc;
	private JButton solveButton, exitButton, saveButton, loadButton;
	private JPanel titlePart, centerPart, bottomPart;

	@Override
	public Insets getInsets() {// ramka okna
		return new Insets(40, 20, 20, 20);
	}

	private AppFrame() {// konstruktor okna
		super("Kalkulator spalania");
		setBounds(200, 10, 640, 480);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		title = new JLabel("WprowadŸ dane:");
		title1 = new JLabel("");
		lpgOn100km = new JTextField("0", 10);
		lpgOn100kmDesc = new JLabel("Spalanie LPG w l/100km:");
		lpgPrice = new JTextField("0", 10);
		lpgPriceDesc = new JLabel("Cena LPG:");
		kmOnLPG = new JTextField("0", 10);
		kmOnLPGDesc = new JLabel("D³ugoœæ trasy w km na LPG:");
		pb95On100km = new JTextField("0", 10);
		pb95On100kmDesc = new JLabel("Spalanie PB95/ON w l/100km:");
		pb95Price = new JTextField("0", 10);
		pb95PriceDesc = new JLabel("Cena PB95/ON:");
		kmOnPB95 = new JTextField("0", 10);
		kmOnPB95Desc = new JLabel("D³ugoœæ trasy w km na PB95/ON:");
		solution = new JTextField("0", 10);
		solutionDesc = new JLabel("Koszt trasy o podanych parametrach wyniesie:");
		solveButton = new JButton("Oblicz");
		solveButton.setPreferredSize(new Dimension(80, 60));
		exitButton = new JButton("Wyjœcie");
		exitButton.setPreferredSize(new Dimension(80, 60));
		saveButton = new JButton("Zapisz");
		saveButton.setPreferredSize(new Dimension(80, 60));
		loadButton = new JButton("Wczytaj");
		loadButton.setPreferredSize(new Dimension(80, 60));
		solution.setEditable(false);

		lpgOn100km.addFocusListener(this); // tworzenie reakcji na klikanie oraz aktywacjê/deaktywacjê pól
		lpgPrice.addFocusListener(this);
		kmOnLPG.addFocusListener(this);
		pb95On100km.addFocusListener(this);
		pb95Price.addFocusListener(this);
		kmOnPB95.addFocusListener(this);

		solveButton.addActionListener(listen);
		exitButton.addActionListener(listen);
		saveButton.addActionListener(listen);
		loadButton.addActionListener(listen);

		titlePart = new JPanel(); // rozmieszcznie elementów w trzech grupach w okreslonej kolejnoœci
		titlePart.add(title1);
		titlePart.add(title);

		centerPart = new JPanel();
		GridLayout grid = new GridLayout(6, 2, 1, 10);
		centerPart.setLayout(grid);
		centerPart.add(lpgOn100kmDesc);
		centerPart.add(lpgOn100km);
		centerPart.add(lpgPriceDesc);
		centerPart.add(lpgPrice);
		centerPart.add(kmOnLPGDesc);
		centerPart.add(kmOnLPG);
		centerPart.add(pb95On100kmDesc);
		centerPart.add(pb95On100km);
		centerPart.add(pb95PriceDesc);
		centerPart.add(pb95Price);
		centerPart.add(kmOnPB95Desc);
		centerPart.add(kmOnPB95);

		bottomPart = new JPanel();
		bottomPart.add(solveButton);
		bottomPart.add(loadButton);
		bottomPart.add(saveButton);
		bottomPart.add(exitButton);
		bottomPart.add(solutionDesc);
		bottomPart.add(solution);

		setLayout(new BorderLayout(10, 10));
		add(titlePart, BorderLayout.NORTH);
		add(centerPart, BorderLayout.CENTER);
		add(bottomPart, BorderLayout.SOUTH);
		bottomPart.setPreferredSize(new Dimension(100, 100));

		setVisible(true);
	}

	public static void main(String[] arguments) {
		new AppFrame();
	}

	private ActionListener listen = (ActionEvent e) -> {// test lambdy - reakcja na wciœniêcie przyisków
		//title.setText(" ");
		//title1.setText("");
		Object source = e.getSource();
		if (source == solveButton) {
			parseInput();
			fuelCost();
		}
		if (source == exitButton) {
			System.exit(0);
		}
		if (source == saveButton) {
			saveToTxt();
			saveToDB();
		}
		if (source == loadButton) {
			readFromDB();
		}
	};

	@Override
	public void focusGained(FocusEvent e1e) {// reakcja na aktywacjê elementu

	}

	@Override
	public void focusLost(FocusEvent e1e) {// reakcja na wyjœcie z elementu
		
		parseInput();
	}

	private void parseInput() {// zamiana danych wprowadzonych przez usera na wartoœci double + obs³uga formatu
	    title1.setText("");
		title.setText(" ");
		try {
			dlpgOn100km = Double.parseDouble(lpgOn100km.getText());
		} catch (NumberFormatException ww) {
			title.setText("B³êdny format danych! WprowadŸ ponownie:");
			lpgOn100km.setText("0.00");
		}
		try {
			dlpgPrice = Double.parseDouble(lpgPrice.getText());
		} catch (NumberFormatException ww) {
			title.setText("B³êdny format danych! WprowadŸ ponownie:");
			lpgPrice.setText("0.00");
		}
		try {
			dkmOnLPG = Double.parseDouble(kmOnLPG.getText());
		} catch (NumberFormatException ww) {
			title.setText("B³êdny format danych! WprowadŸ ponownie:");
			kmOnLPG.setText("0.00");
		}
		try {
			dpb95On100km = Double.parseDouble(pb95On100km.getText());
		} catch (NumberFormatException ww) {
			title.setText("B³êdny format danych! WprowadŸ ponownie:");
			pb95On100km.setText("0.00");
		}
		try {
			dpb95Price = Double.parseDouble(pb95Price.getText());
		} catch (NumberFormatException ww) {
			title.setText("B³êdny format danych! WprowadŸ ponownie:");
			pb95Price.setText("0.00");
		}
		try {
			dkmOnPB95 = Double.parseDouble(kmOnPB95.getText());
		} catch (NumberFormatException ww) {
			title.setText("B³êdny format danych! WprowadŸ ponownie:");
			kmOnPB95.setText("0.00");
		}

	}

	@Override
	public void fuelCost() {// obliczanie wyniku
		Double result = (Math.round(
				(dlpgOn100km * dlpgPrice * dkmOnLPG / 100 + dpb95On100km * dpb95Price * dkmOnPB95 / 100) * 1000.0))
				/ 1000.0;
		solution.setText("" + result);
		title.setText("Wykonano obliczenia. WprowadŸ nowe dane:");
	}

	private void saveToTxt() {// zapis do pliku txt
		Path plik = Paths.get("Dane.txt");
		try (BufferedWriter pw1 = Files.newBufferedWriter(plik, StandardCharsets.UTF_16);
		// PrintWriter pw = new PrintWriter(new BufferedWriter(new
		// FileWriter("Dane.txt")));
		) {
			pw1.write("Spalanie LPG na 100km: " + this.lpgOn100km.getText() + "\n" + "Cena LPG:"
					+ this.lpgPrice.getText() + "\n" + "Iloœæ kilometrów na LPG: " + this.kmOnLPG.getText() + "\n"
					+ "Spalanie pb95 na 100km: " + this.pb95On100km.getText() + "\n" + "Cena PB95: "
					+ this.pb95Price.getText() + "\n" + "Iloœæ kilometrów na pb95: " + this.kmOnPB95.getText() + "\n"
					+ "Koszt trasy wyniesie: " + this.solution.getText());

		} catch (IOException e) {
			System.err.println("B³¹d we/wy");
			e.printStackTrace();
		}

	}

	private void saveToDB() {// zapis do bazy danych
		
	    try (
			Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/D:/Databases/Baza Adama",
				"Adam", "1234")) {
			Statement mkTable = conn.createStatement();
			mkTable.executeUpdate(
					"CREATE TABLE cardata(dlpgOn100km double, dlpgPrice double, dkmOnLPG double, dpb95On100km double, dpb95Price double, dkmOnPB95 double)");
		} catch (SQLException ole) {
			System.out.println(ole.getMessage());
		}
		try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/D:/Databases/Baza Adama",
				"Adam", "1234");
				PreparedStatement upTable = conn.prepareStatement("INSERT INTO "
						+ "ADAM.CARDATA(dlpgOn100km, dlpgPrice, dkmOnLPG, dpb95On100km, dpb95Price, dkmOnPB95)\r\n"
						+ "VALUES(?,?,?,?,?,?)"))
		// "UPDATE ADAM.CARDATA SET DLPGON100KM=?" gdy chcemy nadpisaæ wszystkie wiersze
		// lub wybieramy wg klucza z WHERE. Nie dzia³a, gdy brak wierszy
		{
			upTable.setDouble(1, dlpgOn100km);
			upTable.setDouble(2, dlpgPrice);
			upTable.setDouble(3, dkmOnLPG);
			upTable.setDouble(4, dpb95On100km);
			upTable.setDouble(5, dpb95Price);
			upTable.setDouble(6, dkmOnPB95);
			upTable.executeUpdate();
			title.setText("Wartoœci zosta³y zapisane w bazie danych");
		} catch (SQLException ole) {
		    JOptionPane.showMessageDialog(null, "B³¹d zapisu danych");	
		    System.out.println(ole.getMessage());
		}
	}

	private void readFromDB() {
	    
		try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/D:/Databases/Baza Adama",
				"Adam", "1234"); PreparedStatement upTable = conn.prepareStatement("SELECT*FROM ADAM.CARDATA")) {
			ResultSet result = upTable.executeQuery();

			while (result.next()) {
				lpgOn100km.setText("" + result.getDouble("DLPGON100KM"));
				lpgPrice.setText("" + result.getDouble("DLPGPRICE"));
				kmOnLPG.setText("" + result.getDouble("DKMONLPG"));
				pb95On100km.setText("" + result.getDouble("DPB95ON100KM"));
				pb95Price.setText("" + result.getDouble("DPB95PRICE"));
				kmOnPB95.setText("" + result.getDouble("DKMONPB95"));

			}
			title.setText("Wczytano ostatnio zapisane dane");
		}

		catch (SQLException ole) {
			System.out.println(ole.getMessage());
			title.setText("Brak rekordów, najpierw wykonaj zapis danych!");
		}

	}
}