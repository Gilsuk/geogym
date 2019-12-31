package com.geogym.calendar.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.geogym.calendar.dao.CalendarDao;
import com.geogym.calendar.dto.Calendar_Memo;
import com.geogym.calendar.dto.Day;
import com.geogym.calendar.dto.Holiday;
import com.geogym.calendar.service.CalendarService;
import com.geogym.schedule.dto.BusinessDay;
@Service
public class CalendarServiceImpl implements CalendarService {
	
	@Autowired CalendarDao calendarDao;
	private static final Logger logger = LoggerFactory.getLogger(CalendarServiceImpl.class);
	@Override
	public void insertholiday(String url) {
		// TODO Auto-generated method stub
		
		List<String> nameList = new ArrayList<String>();
		List<LocalDate> dateList = new ArrayList<LocalDate>();
		
		//DocumentBuilderFactory 생성
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;
        try {
            // xml 파싱하기
            String result =url; 
            InputSource is = new InputSource(new StringReader(result));
            builder = factory.newDocumentBuilder();
            doc = builder.parse(is);
            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();
            // XPathExpression expr = xpath.compile("/response/body/items/item");
            XPathExpression expr = xpath.compile("/items/item");
            NodeList nodeList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < nodeList.getLength(); i++) {
                NodeList child = nodeList.item(i).getChildNodes();
                for (int j = 0; j < child.getLength(); j++) {
                    Node node = child.item(j);
                    System.out.println("현재 노드 이름 : " + node.getNodeName());
                    String name = node.getNodeName();
                    System.out.println(name); 
                    System.out.println("현재 노드 값 : " + node.getTextContent());
                    
                    
                   
                    if(name =="dateName") {
                    	nameList.add(node.getTextContent());
                    	
                    	
                    }
                    
                    if(name=="locdate") {
                    	LocalDate holiday_date=LocalDate.parse(node.getTextContent(),DateTimeFormatter.BASIC_ISO_DATE);
                    	
                    	dateList.add(holiday_date);
                    }
                    
                  
                    
                   
                    
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        

        for (int i = 0; i < nameList.size(); i++) {
			Holiday holiday = new Holiday();
			
			holiday.setHoliday_name(nameList.get(i));
			holiday.setHoliday_date(dateList.get(i));
			
			
        	calendarDao.deleteholiday(holiday);
			calendarDao.insertholiday(holiday);
		}
        
        
        
        
        
	}
	
	@Override
	public String geturl(String solYear, String solMonth) {
		
		
		String url= "http://apis.data.go.kr/B090041/openapi/service/SpcdeInfoService/getHoliDeInfo?";
		url += "solYear="+solYear;
		url += "&";
		url += "solMonth="+solMonth;
		url += "&ServiceKey=xt2lcxKJD81UXkvlTIQlPE7fH5kFYdg21OkxYW6bbJxXEz1AMe212NBZbm6xHbqu45NjmHnmg4OwIQdF26I%2F8w%3D%3D";
		
		System.out.println(url);
		URL link = null;
			try {
				link = new URL(url);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				HttpURLConnection con = (HttpURLConnection)link.openConnection();
				con.setRequestMethod("GET");
				con.setRequestProperty("accept-language", "ko-KR");
				
				StringBuilder sb = new StringBuilder();
				if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
					BufferedReader br = new BufferedReader(
							new InputStreamReader(con.getInputStream(), "utf-8"));
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		return "";
		
	}
	
	@Override
	public List<Holiday> selectholiday() {
		// TODO Auto-generated method stub
		return calendarDao.selectholiday();
	}

	@Override
	public List<Day> getDayList(LocalDate month) {
		
		int curmonth = month.getMonthValue();
		int curyear = month.getYear();
		List<Day> list = new ArrayList<>();
		for(int j = curyear; j<=curyear+1; j++) {
			
			
			for(int z = curmonth; z<13 ; z++) {
				
				for (int i = 0; i < month.lengthOfMonth(); i++) {
					Day day = new Day();
					LocalDate tmp = LocalDate.of(month.getYear(), month.getMonthValue(), i+1);
					day.setDay(tmp.getDayOfWeek().toString());
					day.setDate(tmp);
					
				
					list.add(day);		
				}
				month=month.plusMonths(1);
				
			}
			curmonth= month.getMonthValue();
			
				
		}

		//시영이형이 해주신거
//		for (int i = 0; i < month.lengthOfMonth(); i++) {
//			Day day = new Day();
//			LocalDate tmp = LocalDate.of(month.getYear(), month.getMonthValue(), i+1);
//			day.setDay(tmp.getDayOfWeek().toString());
//			day.setDate(tmp);
//			
//		
//			list.add(day);		
//		}
		
		List<Holiday> holidayList = calendarDao.selectholiday();
		
		//business_day 조회 
		List<BusinessDay> businessDayList = calendarDao.selectbusiness();
		
		
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < holidayList.size(); j++) {
				if(list.get(i).getDate().isEqual(holidayList.get(j).getHoliday_date())) {
					list.get(i).setHoliday(true);
					list.get(i).setName(holidayList.get(j).getHoliday_name());
				}
				
			
			}
		}
		
		
		
		
//		for (int i = 0; i < list.size(); i++) {
//			for (int j = 0; j < businessDayList.size(); j++) {
//				if(!(list.get(i).getDate().isEqual(businessDayList.get(j).getBusiness_day_date()))) {
//					
//					list.get(i).setContent("break");
//					i++;
//				}
//	
//			}
//		}
		
		
		
		
		
		return list;
	}

	
	@Override
	public void insertMemo(Calendar_Memo calendar_Memo) {
		
		calendarDao.deletememo(calendar_Memo);
		calendarDao.insertmemo(calendar_Memo);
		
	}
	
	@Override
	public List<Calendar_Memo> memoList() {
		// TODO Auto-generated method stub
		return calendarDao.selectmemo();
	}
	
	
	
	@Override
	public Calendar_Memo memoview(Calendar_Memo calendar_Memo) {
		// TODO Auto-generated method stub
		return calendarDao.memoview(calendar_Memo);
	}
	
	@Override
	public void updatememo(Calendar_Memo calendar_Memo) {
		// TODO Auto-generated method stub
		calendarDao.updatememo(calendar_Memo);
	}
	
}
