package com.geogym.www;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
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
//			try {
//				getPostExample();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
			System.out.println(getAccessResponseJson());
			
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
		Gson gson = new Gson();
		
		return null;
	}

	private String getAccessResponseJson() {

		String url = "https://api.iamport.kr/users/getToken"; 
		String parameters = "imp_key=" + Property.IAMPORT_API_KEY.toString()
				+ "&imp_secret=" + Property.IAMPORT_API_SECRET.toString();

		URL link = null;
		try {
			link = new URL(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		try {
			HttpURLConnection con = (HttpURLConnection) link.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json");
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

		} catch (IOException e) {
			e.printStackTrace();
		}

		return "";
	}
	
//	private String getPostExample() throws IOException {
//        HttpPost post = new HttpPost("https://api.iamport.kr/users/getToken");
//
//        // add request parameter, form parameters
//        List<NameValuePair> urlParameters = new ArrayList<>();
//        urlParameters.add(new BasicNameValuePair("imp_key", Property.IAMPORT_API_KEY.toString()));
//        urlParameters.add(new BasicNameValuePair("imp_secret", Property.IAMPORT_API_SECRET.toString()));
//
//        post.setEntity(new UrlEncodedFormEntity(urlParameters));
//
//        try (CloseableHttpClient httpClient = HttpClients.createDefault();
//             CloseableHttpResponse response = httpClient.execute(post)) {
//
//            System.out.println(EntityUtils.toString(response.getEntity()));
//        }
//        
//        return null;
//	}
}
