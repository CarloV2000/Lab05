package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import it.polito.tdp.anagrammi.model.Parola;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Model model;
		
	    @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private TextArea txtAnagrammiCorretti;

	    @FXML
	    private TextArea txtAnagrammiErrati;

	    @FXML
	    private TextField txtParola;

	    @FXML
	    void doCalcolaAnagrammi(ActionEvent event) {
	    	this.txtAnagrammiCorretti.clear();
	    	this.txtAnagrammiErrati.clear();
	    	String inputParola = this.txtParola.getText().strip();
	    	for(Parola x : model.creaParoleDaAnagrammi(model.calcolaAnagrammi(inputParola))) {
	    		if(x.isCorretta()) {
	    			this.txtAnagrammiCorretti.appendText(x.getNome()+'\n');
	    		}else {
	    			this.txtAnagrammiErrati.appendText(x.getNome()+'\n');
	    		}
	    	}

	    }

	    @FXML
	    void doReset(ActionEvent event) {
	    	this.txtParola.clear();
	    	this.txtAnagrammiCorretti.clear();
	    	this.txtAnagrammiErrati.clear();
	    }

	    @FXML
	    void initialize() {
	        assert txtAnagrammiCorretti != null : "fx:id=\"txtAnagrammiCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
	        assert txtAnagrammiErrati != null : "fx:id=\"txtAnagrammiErrati\" was not injected: check your FXML file 'Scene.fxml'.";
	        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
	        
	    }

	    public void setModel(Model model) {
	    	 this.model = model;
	    }
	}

