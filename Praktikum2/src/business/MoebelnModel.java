package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import reader.ConcreteCSVCreator;
import reader.ConcreteTXTCreator;
import reader.Creator;
import reader.Product;

public class MoebelnModel {
	private Moebeln moebeln;
	
	 public Moebeln getMoebeln() {
		return moebeln;
	}
	public void setMoebeln(Moebeln moebeln) {
		this.moebeln = moebeln;
	}


	public void schreibeMoebelnInCsvDatei() throws IOException{
		    BufferedWriter aus = new BufferedWriter(new FileWriter("MoebelnAusgabe.csv", false));
		   	aus.write(this.moebeln.gibMoebeknZurueck(';'));
		    aus.close();
	 	}
	
	public void leseAusDatei(String typ) throws IOException {
//		if ("csv".equals(typ)) {
//			BufferedReader ein = new BufferedReader(new FileReader("MoebelnAusgabe.csv"));
//			String[] zeile = ein.readLine().split(";");
//			this.moebeln = new Moebeln(zeile[0], Float.parseFloat(zeile[1]), zeile[2], Float.parseFloat(zeile[3]), zeile[4].split(";"));
//			ein.close();
//		}
		Creator creator = null;
		if(typ.equals("csv")) {
			creator = new ConcreteCSVCreator();
		}
		else {
			creator = new ConcreteTXTCreator();
		}
		
		Product reader = creator.factoryMethod(typ);
		
		String[] zeile = reader.leseAusDatei();
		this.moebeln = new Moebeln(zeile[0], Float.parseFloat(zeile[1]), zeile[2], Float.parseFloat(zeile[3]), zeile[4].split(";"));
	}

}
