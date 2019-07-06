package Tests;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.*;

import obj.Ingredient;
import obj.Recipe;


public class GsonTestWrite {

	public static void main(String[] args) {
		//final GsonBuilder builder = new GsonBuilder();
		//final Gson gson = builder.create();
		
		final Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		Ingredient i0 = new Ingredient("Lait", 2.05f, "L");
		Ingredient i1 = new Ingredient("Sel", 3, "g");
		Ingredient i2 = new Ingredient("Farine", 200, "g");
		
		Ingredient[] tab = {i0, i1, i2};
		String content = new String("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec porta odio non nibh dapibus mattis. Nullam aliquet velit non nunc mattis tempus. Integer faucibus diam sit amet nibh egestas, et tempor purus eleifend. Sed ut consectetur diam. Phasellus gravida maximus faucibus. Cras feugiat arcu ac quam malesuada rhoncus. Quisque finibus in purus ut ultrices.\n" + 
				"\n" + 
				"Curabitur ultricies consectetur arcu in lobortis. Duis faucibus vestibulum fermentum. Curabitur sodales lacinia tempor. Nulla nisl tortor, tincidunt a malesuada in, auctor a dolor. Donec vestibulum arcu sodales ligula sodales consequat quis posuere sem. Vestibulum interdum placerat rutrum. Suspendisse et iaculis purus. Phasellus turpis dolor, hendrerit quis massa et, convallis sodales enim. Nunc sapien nunc, consequat in nisl a, viverra interdum purus. Integer ullamcorper vulputate ligula, ac sollicitudin lectus dignissim eget. Donec et ipsum consectetur tellus bibendum consectetur.\n" + 
				"\n" + 
				"Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Quisque varius, erat aliquet gravida dictum, lacus leo venenatis massa, sed laoreet velit diam ac quam. Duis in facilisis risus. Ut luctus vel elit lacinia convallis. Nunc eget nisi tortor. Sed lacus lorem, accumsan vitae fringilla nec, sollicitudin sit amet justo. Sed in elementum felis. Maecenas lacinia malesuada lacus, sed blandit augue malesuada sed. Nam euismod nisl quis libero suscipit lobortis. Sed vel ornare lorem. Nam pellentesque mauris porttitor dolor auctor porta.\n" + 
				"\n" + 
				"Nulla non justo odio. Maecenas id arcu condimentum, vulputate quam pretium, lacinia velit. Aliquam vitae augue et nisl ultricies cursus. Phasellus a nibh nec augue gravida euismod ut sit amet turpis. In at nunc tempor, tristique ante sit amet, condimentum lorem. Aliquam lobortis odio eu est tempor maximus. Nunc et hendrerit dolor. Vivamus eget nisl id dui imperdiet posuere. Quisque porttitor eget sem id varius. Integer pretium feugiat felis, eget varius felis vulputate non. Vivamus egestas dictum feugiat. Lorem ipsum dolor sit amet, consectetur adipiscing elit. In iaculis, dolor sit amet molestie molestie, lectus leo volutpat elit, id sodales est enim in ligula. Quisque pretium tellus id mauris euismod maximus. Donec varius luctus risus, eu blandit tortor commodo at. Mauris feugiat lectus vitae turpis auctor, et rutrum orci iaculis.\n" + 
				"\n" + 
				"Pellentesque rutrum, lorem id sagittis commodo, est nunc hendrerit orci, ut mollis mi arcu nec tortor. Sed orci erat, egestas vel dapibus eget, commodo id diam. Donec hendrerit felis eu felis ultricies malesuada. Duis pretium nulla eu sapien sagittis, non semper neque convallis. Cras quis aliquam sem. Sed commodo justo ut lacus sodales, vitae rhoncus enim volutpat. Donec mauris arcu, porttitor vitae nisl eu, viverra sollicitudin ipsum. In quis lorem massa. Nulla facilisi. Curabitur faucibus quam at tortor tristique sagittis. Sed eu gravida urna, ac vehicula turpis. Fusce lacinia pharetra gravida.");
		
		Recipe r1 = new Recipe("Chon mariné", 45, 4.5f, 1, true, true, content);
		
		//System.out.println("Affichage toString : "+i0.toString());
		//System.out.println(gson.toJson(i0));
		//System.out.println(gson.toJson(tab));
		r1.addIngredient(i0);
		r1.addIngredient(i1);
		r1.addIngredient(i2);
		
		try {
			File save = new File("RecipesSaves/gateau.json");
			//save.createNewFile();
			FileWriter writer = new FileWriter(save);
			BufferedWriter writerB =  new BufferedWriter(writer);
			writerB.write(gson.toJson(r1));
			writerB.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
