package Tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.*;

import obj.Recipe;


public class GsonTestRead {
	public static void main(String[] args) {
		final Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		
		try {
			File save = new File("RecipesSaves/gateau.json");
		
			BufferedReader readerB = new BufferedReader(new FileReader(save));
			Recipe r = gson.fromJson(readerB, Recipe.class);
			System.out.println(r.toString());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
