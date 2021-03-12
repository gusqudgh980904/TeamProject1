package TeamProject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AnalysisLog1 {
		
	private File fileLog1;
	private List<String> listLog1;
	private Map<String, Integer> keyMap;
	private int java;
	private int javascript;
	private int d8;
	private int jg9k;
	private int front;
	private int jsp;
	private int hadoop;
	private int res;
	private int ora;
	private int mongodb;
	
	private Map<String, Integer> keyMapHours;
	private int nineHours;
	private int tenHours;
	private int elevenHours;
		
	private String namePath;
	
	public String maxKey() throws IOException {//1�� �α�
		fileLog1 = new File(namePath);
		keyMap = new HashMap<String, Integer>();
		String log = "";
		int max = 0;
		String maxName = null;
	
		BufferedReader br = null;
		
		br = new BufferedReader(new FileReader(fileLog1));

		while((log=br.readLine()) != null) {//�� Ű�� �󸶳� ����ִ���
				
			if(log.contains("key=java") && (!log.contains("script"))) {
				java++;
			}//if
			if(log.contains("key=javascript")) {
				javascript++;
			}//if
			if(log.contains("key=d8")) {
				d8++;
			}//if
			if(log.contains("key=jg9k")) {
				jg9k++;
			}//if
			if(log.contains("key=front")) {
				front++;
			}//if
			if(log.contains("key=jsp")) {
				jsp++;
			}//if
			if(log.contains("key=hadoop")) {
				hadoop++;
			}//if
			if(log.contains("key=res")) {
				res++;
			}//if
			if(log.contains("key=ora")) {
				ora++;
			}//if
			if(log.contains("key=mongodb")) {
				mongodb++;
			}//if
		}//while
				
			keyMap.put("java", java);
			keyMap.put("javascript", javascript);
			keyMap.put("jg9k", jg9k);
			keyMap.put("d8", d8);
			keyMap.put("front", front);
			keyMap.put("jsp", jsp);
			keyMap.put("hadoop", hadoop);
			keyMap.put("res", res);
			keyMap.put("ora", ora);
			keyMap.put("mongodb", mongodb);
				
			if(br!=null) {br.close();}//end if
			
			int[] count = {keyMap.get("java"), keyMap.get("javascript"), keyMap.get("jg9k"), keyMap.get("d8"), keyMap.get("front"), keyMap.get("jsp"), keyMap.get("hadoop"),
					keyMap.get("res"), keyMap.get("ora"), keyMap.get("mongodb")};
			
			max = count[0];
			
			for(int i = 1; i < count.length; i++) {
				if(max < count[i]) {
					max = count[i];
				}//end if
			}//end for
			
			if(max == keyMap.get("java")) {
				maxName = "java";
			}//end if

			if(max == keyMap.get("javascript")) {
				maxName = "javascript";
			}//end if
			
			if(max == keyMap.get("jg9k")) {
				maxName = "jg9k";
			}//end if

			if(max == keyMap.get("d8")) {
				maxName = "d8";
			}//end if
			
			if(max == keyMap.get("front")) {
				maxName = "front";
			}//end if
			
			if(max == keyMap.get("jsp")) {
				maxName = "jsp";
			}//end if
			
			if(max == keyMap.get("hadoop")) {
				maxName = "hadoop";
			}//end if
			
			if(max == keyMap.get("res")) {
				maxName = "res";
			}//end if
			
			if(max == keyMap.get("ora")) {
				maxName = "ora";
			}//end if
			
			if(max == keyMap.get("mongodb")) {
				maxName = "mongodb";
			}//end if
			
			
			return "1��\n ��ûȽ���� ���� ���� Ű : " + maxName + " " + max + "ȸ";	
		}//maxKey	
	
	public String GoValue() throws IOException{
		int ie = 0;
		int opera = 0;
		int firefox = 0;
		int chrome = 0;
		int safari = 0;
		
		String temp;
		int Total = 0;
		BufferedReader br = null;
		br = new BufferedReader(new FileReader(fileLog1));

		while((temp = br.readLine()) != null) {
			String[] sTmp = temp.split("\\]\\[");
			switch (sTmp[2]) {
			case "ie": ie++; break;
			case "opera": opera++; break;
			case "firefox": firefox++; break;
			case "Chrome": chrome++; break;
			case "Safari": safari++; break;
			}//end switch
			Total++;
		}//end while
		
		if(br != null) {br.close();}//end if
		
		return  "2��\n ie �� Ƚ�� : " + ie + "ȸ\n" + "opera �� Ƚ�� : " + opera +" ȸ\n" + "firefox �� Ƚ�� : " + firefox + "ȸ\n" +
        "chrome �� Ƚ�� : " + chrome + "ȸ\n"+"Safari �� Ƚ�� : "+safari+"ȸ\n\n"+"ie �� ���� = " + ((float)ie /(float)Total)*100 +" %\n" 
        +  "opera �� ���� = " + ((float)opera /(float)Total)*100 +" %\n"+"firefox �� ���� = " + ((float)firefox /(float)Total)*100 +" %\n" 
        +"chrome �� ���� = " + ((float)chrome /(float)Total)*100 +" %\n"+"Safari �� ���� = " + ((float)safari /(float)Total)*100 +" %\n" ;

	}//GoValue 

	public String DoneValue() throws IOException{
		int success = 0;
		int fail = 0;
		String temp;
		BufferedReader br = null;
		
		br = new BufferedReader(new FileReader(fileLog1));
		while((temp = br.readLine()) != null) {
			if(temp.substring(1,4).equals("200")) {
				success++;
			} else if(temp.substring(1,4).equals("404")){
				fail++;
			}//end else	
		}//end while
		if(br != null) {br.close();}
	
		return "3��\n ���������� ������ Ƚ��(200) : "+success+"ȸ\n����(404) : "+fail+"ȸ";
		
	}//DoneValue
	
	public String MaxRequest() throws IOException {
		keyMapHours = new HashMap<String, Integer>();
		String log = "";
		int max = 0;
		String maxHours = "";
		
		BufferedReader br = null;
		
		br=new BufferedReader(new FileReader(fileLog1));
		while((log=br.readLine())!=null) {
			if(log.substring(log.indexOf("5")+1).contains(" 09")) {
				nineHours++;
			}//if
			if(log.substring(log.indexOf("5")+1).contains(" 10")) {
				tenHours++;
			}//if
			if(log.substring(log.indexOf("5")+1).contains(" 11")) {
				elevenHours++;
			}//if
		}//while
		
		keyMapHours.put("9��", nineHours);
		keyMapHours.put("10��", tenHours);
		keyMapHours.put("11��", elevenHours);
			
		if(br!=null) {br.close();}
		
		int[] count = {keyMapHours.get("9��"), keyMapHours.get("10��"), keyMapHours.get("11��")};
		
		max = count[0];
		
		for(int i = 1; i < count.length; i++) {
			if(max < count[i]) {
				max = count[i];
			}//end if
		}//end for
		
		if(max == keyMapHours.get("9��")) {
			maxHours = "9��";
		}//end if
	
		if(max == keyMapHours.get("10��")) {
			maxHours = "10��";
		}//end if
		
		if(max == keyMapHours.get("11��")) {
			maxHours = "11��";
		}//end if
		
		return "4��\n ��û�ð��� ���� ���� �ð� : "+"["+maxHours+"], "+" " + max + "ȸ";

	}//MaxRequest
	
	public String ErrorValue() throws IOException{
		int success = 0;
		int fail = 0;
		int request =0;
		String temp;
		int sum = 0;
		
		BufferedReader br = null;
		
		br = new BufferedReader(new FileReader(fileLog1));

		while((temp = br.readLine())!=null) {
			if(temp.substring(1,4).equals("200")) {
				success++;
			}
		
			if(temp.substring(1,4).equals("404")){
				fail++;
			}
			
			if(temp.substring(1,4).equals("403")) {
				request++;
			}
			
			sum++;
	
		}//while

		if( br != null) {br.close();}//end if
			
		return "5��\n ���������� ������ Ƚ��(200) : "+success+"ȸ\n������ Ƚ��(404) : "+fail+"ȸ\n���������� ��û�� Ƚ��(403) : " + request + "ȸ\n"
				+ "\n���������� ������ ����(200) = "+(((float)success / (float)sum)*100)+"%"
				+"\n������ ����(404) = "+(((float)fail/(float)sum)*100)+"%"
				+"\n���������� ��û ����(403) = "+(((float)request/sum)*100)+"%";
			
		}// ErrorValue
	
	public String RangeMaxKey(int startLine, int endLine) throws IOException, FileNotFoundException {

		java = 0;
		javascript = 0;
		d8 = 0;
		jg9k = 0;
		front = 0;
		jsp = 0;
		hadoop = 0;
		res = 0;
		ora = 0;
		mongodb = 0;
		
		listLog1 = new ArrayList<String>();  
		Map<String, Integer> keyMap = new HashMap<String, Integer>();
		
		String log1 = null;
		String maxName = null;
		int max = 0;
			
		BufferedReader br = null;
		
		if(fileLog1.exists()) {
			br = new BufferedReader(new FileReader(fileLog1));
			while((log1 = br.readLine()) != null) {

				listLog1.add(log1);
				
			}//end while
			
			for(int i = startLine - 1; i < endLine; i++) {
				if((listLog1.get(i).contains("key=java")) && (!listLog1.get(i).contains("script"))) {
					java++;
				}//end if
				
				if(listLog1.get(i).contains("key=javascript")) {
					javascript++;
				}//end if

				if(listLog1.get(i).contains("key=d8")) {
					d8++;
				}//end if
				
				if(listLog1.get(i).contains("key=jg9k")) {
					jg9k++;
				}//end if

				if(listLog1.get(i).contains("key=front")) {
					front++;
				}//end if
				
				if(listLog1.get(i).contains("key=jsp")) {
					jsp++;
				}//end if
				
				if(listLog1.get(i).contains("key=hadoop")) {
					hadoop++;
				}//end if
				
				if(listLog1.get(i).contains("key=res")) {
					res++;
				}//end if
				
				if(listLog1.get(i).contains("key=ora")) {
					ora++;
				}//end if

				if(listLog1.get(i).contains("key=mongodb")) {
					mongodb++;
				}//end if
				
			}//end for

			keyMap.put("java", java);
			keyMap.put("javascript", javascript);
			keyMap.put("jg9k", jg9k);
			keyMap.put("d8", d8);
			keyMap.put("front", front);
			keyMap.put("jsp", jsp);
			keyMap.put("hadoop", hadoop);
			keyMap.put("res", res);
			keyMap.put("ora", ora);
			keyMap.put("mongodb", mongodb);
			
			int[] count = {keyMap.get("java"), keyMap.get("javascript"), keyMap.get("jg9k"), keyMap.get("d8"), keyMap.get("front"), keyMap.get("jsp"), keyMap.get("hadoop"),
					keyMap.get("res"), keyMap.get("ora"), keyMap.get("mongodb")};
			
			max = count[0];
			
			for(int i = 1; i < count.length; i++) {
				if(max < count[i]) {
					max = count[i];
				}//end if
			}//end for
			
			if(max == keyMap.get("java")) {
				maxName = "java";
			}//end if

			if(max == keyMap.get("javascript")) {
				maxName = "javascript";
			}//end if
			
			if(max == keyMap.get("jg9k")) {
				maxName = "jg9k";
			}//end if

			if(max == keyMap.get("d8")) {
				maxName = "d8";
			}//end if
			
			if(max == keyMap.get("front")) {
				maxName = "front";
			}//end if
			
			if(max == keyMap.get("jsp")) {
				maxName = "jsp";
			}//end if
			
			if(max == keyMap.get("hadoop")) {
				maxName = "hadoop";
			}//end if
			
			if(max == keyMap.get("res")) {
				maxName = "res";
			}//end if
			
			if(max == keyMap.get("ora")) {
				maxName = "ora";
			}//end if
			
			if(max == keyMap.get("mongodb")) {
				maxName = "mongodb";
			}//end if
			
		}//end if
		
		if(br != null) {br.close();};
		
		return "6��\n"+startLine + " ~ " + endLine + " �� ���� �� �ִ� ��� Ű�� �̸� : " + maxName + " / " + max + "ȸ" ;
	}//rangeMaxKey

	/**
	 * @param namePath the namePath to set
	 */
	public void setNamePath(String namePath) {
		this.namePath = namePath;
	}

	/**
	 * @return the namePath
	 */
	public String getNamePath() {
		return namePath;
	}
	

	
	
}//class
			
