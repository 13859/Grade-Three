package com.huiyu.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IsNumberOrChar {
		GetSortNum g=new GetSortNum();
		
		/**
		 * ����������ֺõ�list�����жϣ��ж��Ƿ��ǺϷ����Ӵ�
		 * @param list
		 * @return
		 */
		@SuppressWarnings("rawtypes")
		public List<Map> GetStringAndSortNum(String[] list) {
			char firstChar;//���ڼ�¼��һ�����ַ�
			String keyword="",sortNum="";//��Ҫ������صĹؼ��֣��ֱ���
			String cType,word;//��һ�����ַ�������
			
			//mlist���ڷ�������List�ж���ɺ�ĺ��е��ַ����ֱ���
			List<Map> mList=new ArrayList<Map>();

			for(int i=0;i<list.length;i++){
				Map<String,String>map=new HashMap<String,String>();//m���ڱ�����󷵻ص��Ѿ��б�ɹ����ֺ��ֱ���
				//word������Ҫ���д����жϵ���
				word=list[i];
				//�ж�word�ǲ��ǿյĴ�����Ϊ�п��ܸ��ݿո�ָ�Ĵ����пյĻ��з����߿մ��������д���
				if(word==""||word==null||word.trim()=="")continue;
				
				firstChar=word.charAt(0);
				//��ȡ����ַ�������
				cType=GetCharType(firstChar);
				
				Object jTextArea1;
				if(cType=="letter"){
					if(firstChar=='w'||firstChar=='i'||firstChar=='b'||firstChar=='d'||firstChar=='e'||firstChar=='t'){
						//���keyword��
						Map<String,String>m=new HashMap<String,String>();//m���ڱ�����󷵻ص��Ѿ��б�ɹ����ֺ��ֱ���
						m=GetKeyWord(word);
						//ȡ��m��ֵ������ǹؼ���
						if(m!=null){
							keyword=m.get("keyword");
							sortNum=m.get("sortNum");
						}
						//���ǹؼ��֣����ǰ����ؼ��ֵ�ǰһ���ַ���
						else{
							if(IsID(word)){
								keyword=word;
								sortNum=g.getSortNum("ID")+"";
							}
							else{
								System.out.println("���"+word+"���ǺϷ���ID�ַ������ڵ�λ���ڣ���"+(i+1)+"������"+"\r\n");
							}
						}
					}
					else{//����ĸΪ�ַ���������Ҫ��һ���ж��ǲ��ǺϷ���ID
						if(IsID(word)){
							keyword=word;
							sortNum=g.getSortNum("ID")+"";
						}
						else{
							System.out.println("���"+word+"���ǺϷ���ID�ַ������ڵ�λ���ڣ���"+(i+1)+"������"+"\r\n");
						}
					}
				}
				if(cType=="digit"){
					if(IsNum(word)){
						keyword=word;
						sortNum=g.getSortNum("NUM")+"";
					}
					else{
						System.out.println("���"+word+"���ǺϷ���NUM�ַ������ڵ�λ���ڣ���"+(i+1)+"������"+"\r\n");
					}
				}
				if(cType=="opts"){
					//��ȡ���word�ĳ��ȣ������һ�����е���������жϣ������2���ж���������ж�
					int len=word.length();
					if(len==1){
						if(IsSingleOpt(word)){
							keyword=word;
							sortNum=g.getSortNum(word)+"";
						}
						else if(IsEndOpt(word)){
							keyword=word;
							sortNum=g.getSortNum(word)+"";
						}
						else{
							System.out.println("���"+word+"���ǺϷ���NUM�ַ������ڵ�λ���ڣ���"+(i+1)+"������"+"\r\n");
						}
					}
					else if(len==2){
						if(IsDoubleOpt(word)){
							keyword=word;
							sortNum=g.getSortNum(word)+"";
						}
						else{
							System.out.println("���"+word+"���ǺϷ���NUM�ַ������ڵ�λ���ڣ���"+(i+1)+"������"+"\r\n");
						}
					}
					else{
						System.out.println("���"+word+"���ǺϷ���NUM�ַ������ڵ�λ���ڣ���"+(i+1)+"������"+"\r\n");
					}
				}
				if(keyword.equals("")||sortNum.equals("")||keyword==""||sortNum=="")
					continue;
				else{
					map.put("keyword", keyword);
					map.put("sortNum", sortNum);
					mList.add(map);	
					keyword="";
					sortNum="";
				}
			}
			return mList;
		}


		/**
		 * �����ַ��ж�����ַ���ʲô����
		 * @param c
		 * @return
		 */
		public String GetCharType(char c){
			String type="";
			
			//('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z') || ('0' <= ch && ch <= '9');
			if(('a'<=c&&c<='z')||('A' <= c && c <= 'Z')){
				type="letter";
			}
			else if('0'<=c&&c<='9'){
				type="digit";
			}else{
				type="opts";
			}
			return type;
		}
		
		/**
		 * �жϴ�����index��ʼ�Ƿ��ǹؼ���
		 * @param String word
		 * @return Map<String,String>
		 */
		public Map<String,String> GetKeyWord(String word) {
			Map<String ,String> m=new HashMap<String ,String>();
			char firstChar=word.charAt(0);
			switch(firstChar){
			case 'b':
				if(word=="begin"||word.equals("begin")){
					String sortNum=g.getSortNum(word)+"";
					m.put("sortNum",sortNum);
					m.put("keyword", "begin");
				}
				break;
				
			case 'i':
				if(word=="if"||word.equals("if")){
					String sortNum=g.getSortNum(word)+"";
					m.put("sortNum",sortNum);
					m.put("keyword", "if");
				}
				break;
			
			case 't':
				if(word=="then"||word.equals("then"))
				{
					String sortNum=g.getSortNum(word)+"";
					m.put("sortNum",sortNum);
					m.put("keyword", "then");
				}
				break;
			
			case 'w':
				if(word=="while"||word.equals("while")){
					String sortNum=g.getSortNum(word)+"";
					m.put("sortNum",sortNum);
					m.put("keyword", "while");
				}
				break;
			
			case 'd':
				if(word=="do"||word.equals("do"))
				{
					String sortNum=g.getSortNum(word)+"";
					m.put("sortNum",sortNum);
					m.put("keyword", "do");
				}
				break;
			
			case 'e':
				if(word=="end"||word.equals("end")){
					String sortNum=g.getSortNum(word)+"";
					m.put("sortNum",sortNum);
					m.put("keyword", "end");
				}
				break;
			}
			return m;
		}

		/**
		 * �ж�һ���ַ��ǲ��ǺϷ���ID,����ǣ��򷵻�true�����򣬷������word�Ĵ�����false
		 * @param string word
		 * @return boolean
		 */
		public boolean IsID(String word) {
			char c;
			char firstChar=word.charAt(0);//��ȡ��һ���ַ�
			
			if(GetCharType(firstChar)=="letter"){//�жϵ�һ���ַ��ǲ���letter������϶����ǺϷ���
				for(int i=1;i<word.length();i++){//�ӵڶ����ַ���ʼ
					c=word.charAt(i);
					if(GetCharType(c)=="letter")//�����letter,��һ���ַ�
						continue;
					else if(GetCharType(c)=="digit")//�����digit,��һ���ַ�
						continue;
					else//���򱨴�
						return false;
				}
				return true;
			}
			return false;
		}
		

		/**
		 * �ж�һ�����ǲ��ǺϷ���digit
		 * @param word
		 * @return
		 */
		public boolean IsNum(String word) {
			char c;
			char firstChar=word.charAt(0);//��ȡ��һ���ַ�
			
			if(GetCharType(firstChar)=="digit"){//�жϵ�һ���ַ��ǲ���digit������϶����ǺϷ���
				for(int i=1;i<word.length();i++){//�ӵڶ����ַ���ʼ
					c=word.charAt(i);
					if(GetCharType(c)=="digit")//�����digit,��һ���ַ�
						continue;
					else//���򱨴�
						return false;
				}
				return true;
			}
			return false;
		}


		/**
		 * �ж��Ƿ���˫Ŀ�����
		 * @param word
		 * @return
		 */
		private boolean IsDoubleOpt(String word) {
			String optDouble[]={":=","<=","<>",">="};//˫Ŀ�����
			for(int i=0;i<optDouble.length;i++)
				if(word.equals(optDouble[i]))return true;
			return false;
		}

		/**
		 * �ж��Ƿ��ǵ�Ŀ�����
		 * @param word
		 * @return
		 */
		private boolean IsSingleOpt(String word) {
			char optSingle[]={'+','-','*','/','<','>','='};//��Ŀ�����
			for(int i=0;i<optSingle.length;i++)
				if(word.equals(optSingle[i]+""))return true;
			return false;
		}

		/**
		 * �ж��Ƿ����ս��
		 * @param word
		 * @return
		 */
		private boolean IsEndOpt(String word) {
			char End[]={':' ,';' ,'(' , ')' , '#' };//�ս��
			for(int i=0;i<End.length;i++)
				if(word.equals(End[i]+""))return true;
			return false;
		}
	}
