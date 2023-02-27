package com.firas.projecttwo.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Optional;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.firas.projecttwo.models.Dog;
import com.firas.projecttwo.repositories.DogRepository;

@Service
public class DogService {

    private final DogRepository dogRepo;

    public DogService(DogRepository dogRepo) {
        this.dogRepo = dogRepo;
    }

    public Dog getOne (Long id) {
        Optional<Dog> Dog = dogRepo.findById(id);
        return Dog.isPresent() ? Dog.get() : null;
    }

    public List<Dog> getAll() {
        return (List<Dog>) dogRepo.findAll();
    }

    public Dog create(Dog dojo) {
        return dogRepo.save(dojo);
    }

    public Dog update(Dog dojo) {
        return dogRepo.save(dojo);
    }

    public void delete(Long id) {
        dogRepo.deleteById(id);
    }
    
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
          sb.append((char) cp);
        }
        return sb.toString();
      }
    
    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
          BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
          String jsonText = readAll(rd);
          JSONObject json = new JSONObject(jsonText);
          return json;
        } finally {
          is.close();
        }
      }
    
    public String getDogImg(String name) {
    	try {
			JSONObject json = readJsonFromUrl("https://dog.ceo/api/breed/hound/images/random");
			return (String) json.get("message");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "uh oh";
    }
}