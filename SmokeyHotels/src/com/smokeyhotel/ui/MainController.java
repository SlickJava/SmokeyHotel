package com.smokeyhotel.ui;

import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {
	
	@FXML
	private Label testMessage;
	
	public void generateRandom(ActionEvent event)
	{
		Random rand = new Random();
		int chicken = rand.nextInt(100) + 1;
		testMessage.setText(Integer.toString(chicken));
		System.out.println(Integer.toString(chicken));
	}

}
