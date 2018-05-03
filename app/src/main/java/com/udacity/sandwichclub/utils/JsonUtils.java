package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException{

        JSONObject rtObject = new JSONObject(json); //Create JSONObject
        JSONObject SbObject = rtObject.getJSONObject("name"); //Get name

        String mainName = SbObject.getString("mainName"); //Get main name
        String placeOfOrigin = rtObject.getString("placeOfOrigin"); //Get place of origin
        String description = rtObject.getString("description"); //Get description
        String imagePath = rtObject.getString("image"); //Get image path

        JSONArray alsoKnownAs = SbObject.getJSONArray("alsoKnownAs"); //Get also known as values
        List<String> alsoKnownAsList = new ArrayList<>();
        if (alsoKnownAs.length() == 0){
            alsoKnownAsList.add("Not available");
        }   else {
            for (int i = 0; i < alsoKnownAs.length(); i++) {
                String also_known_as = alsoKnownAs.getString(i);
                alsoKnownAsList.add(also_known_as);
            }
        }
        JSONArray ingredientArray = rtObject.getJSONArray("ingredients"); //Get ingredients values
        List<String> ingredientList = new ArrayList<>();
        if (ingredientArray.length() == 0) {
            ingredientList.add("Not available");
        }   else {
            for (int i = 0; i < ingredientArray.length(); i++) {
                ingredientList.add(ingredientArray.getString(i));
            }
        }

        Log.v("my_tag", "mainName is: " + mainName);
        Log.v("my_tag", "placeOfOrigin is: " + placeOfOrigin);
        Log.v("my_tag", "description is: " + description);
        Log.v("my_tag", "image is: " + imagePath);
        Log.v("my_tag", "also known as:" + alsoKnownAs.toString());
        Log.v("my_tag", "ingredients:" + ingredientArray.toString());

        return new Sandwich(mainName, alsoKnownAsList, placeOfOrigin, description, imagePath, ingredientList);
    }
}
