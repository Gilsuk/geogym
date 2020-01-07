package com.geogym.www;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.geogym.common.enumeration.Property;
import com.geogym.user.dto.User;
import com.geogym.user.exception.UserNotFoundException;
import com.geogym.user.service.UserService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Controller
public class PaymentController {
	
	@Autowired
	private UserService userSrv;

	@RequestMapping(value = "/payment/form", method = RequestMethod.GET)
	public String paymentForm(Model model, HttpServletRequest req) {
		try {
			User user = userSrv.getLoggedInUser();
			model.addAttribute("user", user);
			model.addAttribute("domain_url", "http://" + req.getHeader("Host"));

			System.out.println(getAccessKey());
			
			return "/payment/form";
		} catch (UserNotFoundException e) {
			return "/user/login";
		}
	}

	@RequestMapping(value = "/payment/complete")
	public String paymentComplete(Model model, HttpServletRequest req) {
			Enumeration<String> names = req.getParameterNames();
			while(names.hasMoreElements()) {
				String name = names.nextElement();
				System.out.println(name + ": " + req.getParameter(name));
			}
			
			return "/payment/form";
	}
	
	private String getAccessKey() {
		String jsonString = getAccessResponseJson();

		JsonObject jo = new JsonObject();
		
		jo.addProperty("code", 0);
		jo.add("message", null);
		
		JsonObject response = new JsonObject();
		response.addProperty("access_token", "e0bc4ce87cd7553c2a122b3b886202a49806e1db");
		response.addProperty("now", 1578290495);
		response.addProperty("expired_at", 1578291402);
		
		jo.add("response", response);

		Gson gson = new Gson();
		JsonObject jjj = gson.fromJson(jsonString, jo.getClass());

		return jjj.getAsJsonObject("response").get("access_token").getAsString();
	}

	private String getAccessResponseJson() {
		String url = "https://api.iamport.kr/users/getToken"; 
		String parameters = "imp_key=" + Property.IAMPORT_API_KEY.toString()
				+ "&imp_secret=" + Property.IAMPORT_API_SECRET.toString();
		
		URL link = null;
		try {
			link = new URL(url);
		} catch (MalformedURLException e) { }

		try {
			HttpsURLConnection con = (HttpsURLConnection) link.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			con.setDoOutput(true);

			// Send post request 
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(parameters);
			wr.flush();
			wr.close();

			StringBuilder sb = new StringBuilder();
			if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
				String line;
				while ((line = br.readLine()) != null) {
					sb.append(line).append("\n");
				}
				br.close();
			} else {
				System.out.println(con.getResponseMessage());
			}
			
			return sb.toString();

		} catch (IOException e) { return ""; }

	}
	
}
