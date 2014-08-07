package com.middleware;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RegistrationController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(method=RequestMethod.POST)
    @ResponseStatus( HttpStatus.CREATED )
    public void register(
            @RequestParam(value = "name", required = true) String name) {
    	
    	Registration registration = new Registration(counter.incrementAndGet(),
                String.format(template, name));
    	
    	System.out.println(registration);
    	
    	//panggil surveyor minta question
        
        StringBuilder sb = new StringBuilder();
		try {
		    URL url = new URL("http://localhost:8383/getQuestion");
		    URLConnection urlConnection = setUsernamePassword(url);
		    BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		    String line;
		    while ((line = reader.readLine()) != null) {
		        sb.append(line);
		    }
		    reader.close();
		
		    System.out.println("ini dari rest sebelah");
		    System.out.println(sb.toString()); // parse json ini ke object
		    System.out.println("-------------------------------------------");
		} catch (Exception e) {
		    throw new RuntimeException(e);
		}
       
    }

    private URLConnection setUsernamePassword(URL url) throws IOException {
        URLConnection urlConnection = url.openConnection();
        String authString = "user" + ":" + "password";
        String authStringEnc = new String(Base64.encodeBase64(authString.getBytes()));
        urlConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);
        return urlConnection;
    }
}
