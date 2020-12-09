package com.huiyu.analysis;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.xml.sax.HandlerBase;

import com.huiyu.utils.GetSortNum;


public class Start {
	static char optSingle[]={'+','-','*','/','<','>','='};//��Ŀ�����
	static String optDouble[]={":=","<=","<>",">="};//˫Ŀ�����
	static char End[]={':' ,';' ,'(' , ')' , '#' };//�ս��
	static String keyWords[]={"begin","if","then","while","do","end"};//�ؼ���
	

	/**
	 * ��ȡһ���ļ������ݣ����н����е����ݱ��浽һ��list������
	 * @param filename
	 * @return 
	 * @return
	 * @throws IOException
	 */
	public  List<String> readTestFile(String filename) throws IOException{
		List<String >list=new ArrayList<String>();
		String fileContent="";
		FileReader fread = new FileReader(filename);   
		BufferedReader bf=new BufferedReader(fread);
		String strLine=bf.readLine();
		while(strLine!=null){
			System.out.println("strLine:"+strLine);
			list.add(strLine);
			strLine=bf.readLine();
		}
		bf.close();
		fread.close();
		return list;
	}
	
	/**
	 * �����е��ַ������л���
	 * @param str ����������Ҫ������ַ�
	 * @return ����һ�����ݿո񻮷ֵ�list
	 */
	public String[] Divide(String str){
		String[] list;
		list=str.split(" ");

		return list;
	}
	
	/**
	 * ���������list���л��ֺ��жϣ������жϵĽ�����
	 * @param list
	 */
	
	
}