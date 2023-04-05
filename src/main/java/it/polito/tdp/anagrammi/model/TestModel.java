package it.polito.tdp.anagrammi.model;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
		System.out.println(model.anagrammiCorretti("sai"));
		System.out.println('\n');
		
		System.out.println(model.creaParoleDaAnagrammi(model.calcolaAnagrammi("sai")).toString());
	}

}
