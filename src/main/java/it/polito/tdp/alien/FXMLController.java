package it.polito.tdp.alien;

import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;

import it.polito.tdp.model.Dizionario;
import it.polito.tdp.model.Parole;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Dizionario model;
	private TreeMap<String, Parole> mappaParole = new TreeMap<String, Parole>();
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnTraduci;

    @FXML
    private TextArea txtDizionario;

    @FXML
    private TextField txtParole;
    
    @FXML
    private Label lblStato;

    @FXML
    void handleTraduci(ActionEvent event) {
    	txtDizionario.setText("");
    	String testo = txtParole.getText();
    	boolean ok = true;
    	if(testo != null) {
    		lblStato.setText("");
    		if(testo.toLowerCase().matches("[a-z]+") == false)
    			lblStato.setText("Errore, inserire solo lettere");
    		if(testo.contains(" ")) {
        		String parolaAliena = testo.split(" ")[0].toLowerCase();
        		String traduzione = testo.split(" ")[1].toLowerCase();
        		//System.out.println(parolaAliena);
        		if(mappaParole.containsKey(parolaAliena)) {
        			mappaParole.get(parolaAliena).setTraduzione(traduzione);
        		}
        		else {
        			Parole p = new Parole(parolaAliena);
            		ok = model.addParola(p);
            		p.setTraduzione(traduzione);
            		mappaParole.put(parolaAliena, p);
        		}
        		
        		if(ok) {
        			lblStato.setText("Parola inserita nel dizionario");
        		}
        		else {
        			lblStato.setText("Errore nell'inserimento");
        		}     
        	}
        	else {
        		LinkedList<String> trad = model.traduci(testo);
        		if(trad.size() != 0) {
        			for(String s : trad) {
        				txtDizionario.appendText(s + "\n");
        			}
        		}
        		else
        			lblStato.setText("Non esiste una traduzione per questa parola");
        	}
    		
    	}
    	else {
    		lblStato.setText("ERRORE, inserire una parola");
    	}
    	
    	txtParole.setText("");
    }
    
    public void setModel(Dizionario model) {
		// TODO Auto-generated method stub
		this.model = model;
	}

    @FXML
    void initialize() {
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTraduci != null : "fx:id=\"btnTraduci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtDizionario != null : "fx:id=\"txtDizionario\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtParole != null : "fx:id=\"txtParole\" was not injected: check your FXML file 'Scene.fxml'.";

    }

}


