package com.marublo.feelcycle.service;

import com.marublo.feelcycle.dto.LessonDataDto;
import com.marublo.feelcycle.entity.User;



import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.annotation.Resource;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.http.ParseException;
import org.seasar.extension.jdbc.JdbcManager;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.tidy.Tidy;




/**
 * {@link User}のサービスクラスです。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, date = "2015/09/21 17:01:10")
public class FeelcycleService{
	
	/*************DI*******************/
	@Resource
	protected JdbcManager jdbcManager;
	
	
	public HtmlGetService htmlGetService;
	/*************DI *******************/
	private String userId = "";
	private String html = "";

	private Tidy tidy = new Tidy();
	private NodeList nodeList;

	private Document doc;
	private XPath xpath;
	
	FeelcycleService(){
        this.tidy.setQuiet(true);
        this.tidy.setInputEncoding("utf-8");
        this.tidy.setOutputEncoding("utf-8");
        this.tidy.setShowErrors(0);
        this.tidy.setShowWarnings(false);
        this.tidy.setForceOutput(true);
        
	}
	
	

	
	private void initTidy() {
		// TODO 自動生成されたメソッド・スタブ
        InputStream loginAfterString = new ByteArrayInputStream(this.html.getBytes());
        this.doc = this.tidy.parseDOM(loginAfterString,null);
        XPathFactory xpf = XPathFactory.newInstance();
        this.xpath = xpf.newXPath();
	}




	public String getPage(String pageParam) throws IOException{
		return pageParam;
	}
	
	
	public List<LessonDataDto> getPage(String userIdFeelcycle, String userPassFeelcycle,String userId) throws IOException, XPathExpressionException, ParseException {
		//HtmlGetService htmlGetService = new HtmlGetService();
		this.userId = userId;
		htmlGetService.gethtmlInit(userIdFeelcycle,userPassFeelcycle);
		List<LessonDataDto> lessonDataDto = parseLessonData(htmlGetService.gethtml("MyPage"));


		return lessonDataDto;
	}

	private List<LessonDataDto> parseLessonData(String executeGetHtml) throws XPathExpressionException {
		this.html = executeGetHtml;
		initTidy();
		
		//int lessonMaxCount = parseUrlList.size();
		//int lessonMaxCountControl = 0;
		//List<FeelCycleDataDto> feelCycleDataDtoList = new ArrayList<FeelCycleDataDto>();
		//for(int i=0; i<dayArray.size();i++){
		
		//操作用の配列
		List<String> tempLessonList = new ArrayList<String>();
		
		this.nodeList = (NodeList)this.xpath.evaluate(
									"//tr/td/text()",
												this.doc, XPathConstants.NODESET);
		for(int j=0; j < nodeList.getLength(); j++){
			org.w3c.dom.Node TagNode =  nodeList.item(j);
			tempLessonList.add(TagNode.getNodeValue().toString());
			//System.out.println(TagNode.getNodeValue().toString());
		}
		
		//個数をカウントして予約状況画面と受講履歴にデータがあるのか、　受講履歴なのかの判断をする
		//キーは利用チケットこれが２つある時は両方が表示しているので２回めの時以降のデータ取得
		//1個の時は受講履歴のみなので受講履歴をそのまま取得
		int displayCount = 0;
		//int lessonCount = 0;
		int tempCoutOne = 0;
		//int tempCountTwo= 0;
		int tempCountTwoDisplayCount = 0;
		for(String s : tempLessonList){
			if(s.equals("利用チケット")){
				displayCount++;
			}
		}
		//displayCountが1だった場合はそれ以降のすべてを配列にぶちこむ
		
		if(displayCount == 1){
			for(String s : tempLessonList){
				if(s.equals("利用チケット")){
					break;
				}
				tempCoutOne++;
			}
			
		}else if(displayCount == 2){
			for(String s : tempLessonList){
				if(s.equals("利用チケット")){
					tempCountTwoDisplayCount++;
				}
				
				if(s.equals("利用チケット") && tempCountTwoDisplayCount == 2){
					break;
				}
				tempCoutOne++;
			}
		}else{
			
		}
			
		//配列のX番目に利用チケットと書いてあることが分かったのでそれ+1の配列が全てレッスンデータなので詰めてあげる
		//しかしJavaは0がインデックスなので28だったら　28でOK
		List<String> tempLessonListAll = new ArrayList<String>();
		for(int i=0; i < tempLessonList.size(); i++){
			if(i > tempCoutOne){
				tempLessonListAll.add(tempLessonList.get(i));
			}
		}
		
		List<String> tempLessonListCancelPerge = new ArrayList<String>();
		//無断キャンセルはレッスン実績にaddしない為、配列から削除する
		for(int i=0; i < tempLessonListAll.size(); i++){
			tempLessonListCancelPerge.add(tempLessonListAll.get(i));
			if(tempLessonListAll.get(i).equals("無断ｷｬﾝｾﾙ")){
				//8要素削除することでキャンセル枠の情報を消去する
				for(int j=8; j > 0; j--){
					tempLessonListCancelPerge.remove(tempLessonListCancelPerge.size()-1);
				}
				
			}
		}
		
		//dtoに詰めていく
		//その場で予約した時は座席がない場合があるのでその要素が数字でなかった場合はスキップする仕様とする
		
		
		
		List<LessonDataDto> lessonDataDtoList = new ArrayList<LessonDataDto>();
		
		int modCount = 0;
		LessonDataDto lessonDataDto = new LessonDataDto();
		for(int i=0; i < tempLessonListCancelPerge.size(); i++){
			
			modCount = i % 7;
			
			switch(modCount){
			case 0:
				lessonDataDto.setLessonUserId(this.userId);
				lessonDataDto.setLessonDate(tempLessonListCancelPerge.get(i));
				break;
			case 1:
				//変換ミスのバリデーションを後でいれること
				String timeArray[] = new String[1];
				timeArray = FeelCycleUtil.spliteTime(tempLessonListCancelPerge.get(i));
				lessonDataDto.setLessonTimeFrom(timeArray[0]);
				lessonDataDto.setLessonTimeTo(timeArray[1]);
				break;
			case 2:
				lessonDataDto.setLessonTenpo(tempLessonListCancelPerge.get(i));
				break;
			case 3:
				lessonDataDto.setLessonMashine(tempLessonListCancelPerge.get(i));
				break;
			case 4:
				lessonDataDto.setLessonName(tempLessonListCancelPerge.get(i));
				break;
			case 5:
				lessonDataDto.setLessonInstructor(tempLessonListCancelPerge.get(i));
				break;
			case 6:
				lessonDataDtoList.add(lessonDataDto);
				lessonDataDto = new LessonDataDto();
				break;
			default:
				break;
			}
			
		}
		
		//System.out.println("確認用");
			
			//FeelCycleDataDto feelcycleOneLessonData = new FeelCycleDataDto();
			/*
			for(int j=0; j < nodeList.getLength(); j++){
                org.w3c.dom.Node TagNode =  nodeList.item(j);
                int lessonArrayControl = j%3;
                switch(lessonArrayControl){
            	case 0:
            		feelcycleOneLessonData.setLessonTime(TagNode.getNodeValue().toString());
            		break;
            	case 1:
            		feelcycleOneLessonData.setLessonName(TagNode.getNodeValue().toString());
            		break;
            	case 2:
            		feelcycleOneLessonData.setLessonInstructor(TagNode.getNodeValue().toString());
            		break;
                }
                if(lessonArrayControl == 2){
	               
	                feelcycleOneLessonData.setLessonDate(dayArray.get(i));
	                if(lessonMaxCountControl < parseUrlList.size()){
		                feelcycleOneLessonData.setLessonUrl( parseUrlList.get(lessonMaxCountControl));
	                }
	                feelCycleDataDtoList.add(feelcycleOneLessonData);
	                lessonMaxCountControl++;
	                feelcycleOneLessonData = new FeelCycleDataDto();
                }
			}
		}
		*/
		return  lessonDataDtoList;

		

	}





}