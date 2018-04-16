/**
 * Sample Skeleton for 'Anagrammi.fxml' Controller Class
 */

package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.db.AnagrammaDAO;
import it.polito.tdp.anagrammi.model.Anagramma;
import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {

	private Model model;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtLog"
    private TextField txtLog; // Value injected by FXMLLoader

    @FXML // fx:id="txtCorr"
    private TextArea txtCorr; // Value injected by FXMLLoader

    @FXML // fx:id="txtErr"
    private TextArea txtErr; // Value injected by FXMLLoader

    @FXML
    void handleCalcola(ActionEvent event) {
    	txtCorr.clear();
    	txtErr.clear();
    	for(Anagramma a : model.getAnagrammi(txtLog.getText())) { 
    		if(model.isCorrect(a))
    			txtCorr.appendText(a.toString()+"\n");
    		else
    			txtErr.appendText(a.toString()+"\n");
    	}
    }

    @FXML
    void handleReset(ActionEvent event) {
    	txtLog.clear();
    	txtCorr.clear();
    	txtErr.clear();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtLog != null : "fx:id=\"txtLog\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtCorr != null : "fx:id=\"txtCorr\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtErr != null : "fx:id=\"txtErr\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }

	public void setModel(Model model2) {
		this.model= model2;
	}
}
