package com.marublo.feelcycle.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Generated;
import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanMap;
import org.seasar.extension.jdbc.JdbcManager;

import com.marublo.feelcycle.dto.LessonDataDto;
import com.marublo.feelcycle.dto.LessonShukeiTempDto;
import com.marublo.feelcycle.dto.ShukeiDataDto;
import com.marublo.feelcycle.entity.Lessson;


/**
 * {@link Lessson}のサービスクラスです。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, date = "2015/09/21 17:01:10")
public class LesssonService{

	/*************DI*******************/
	@Resource
	protected JdbcManager jdbcManager;
	/*************DI  *******************/
	
	

	public boolean checkLessonData(LessonDataDto lesson) {
		// TODO 自動生成されたメソッド・スタブ
		
		List<Lessson> result = jdbcManager.from(Lessson.class).where("userId = ? and lessonDate = ? and lessonTimeFrom = ? and lessonTimeTo = ? and lessonTenpo = ? and lessonName = ? ", 
										lesson.getLessonUserId(),lesson.getLessonDate(),lesson.getLessonTimeFrom(),lesson.getLessonTimeTo(),
											lesson.getLessonTenpo(),lesson.getLessonName())
										.getResultList();
		
		if(result.size()>0){
			return false;
		}else{
			return true;
		}
		
		
	}
	public void insertLessonData(LessonDataDto lesson) {
		// TODO 自動生成されたメソッド・スタブ
		Lessson insertLesson = new Lessson();
		insertLesson.instructor = lesson.getLessonInstructor();
		insertLesson.lessonDate = lesson.getLessonDate();
		insertLesson.lessonMashine = lesson.getLessonMashine();
		insertLesson.lessonName = lesson.getLessonName();
		insertLesson.lessonTenpo = lesson.getLessonTenpo();
		insertLesson.lessonTimeFrom = lesson.getLessonTimeFrom();
		insertLesson.lessonTimeTo = lesson.getLessonTimeTo();
		insertLesson.userId = lesson.getLessonUserId();
		
		int count = 
			    jdbcManager
			        .insert(insertLesson)
			        .execute();
		//System.out.println("確認" + count);
	}
	public List<Lessson> getLessonData(Lessson lessson) {
		// TODO 自動生成されたメソッド・スタブ
		
		List<Lessson> result = jdbcManager.from(Lessson.class).where("userId = ? ", lessson.userId).getResultList();
		
		
		return result;
	}
	
	public List<Lessson> getLessonCountInfo(Lessson lessson) {
		
		List<Lessson> result = jdbcManager.selectBySql(Lessson.class,
														"select * FROM LESSSON where USER_ID = ? ORDER BY LESSON_NAME asc", 
														lessson.userId ).getResultList();
		//SELECT * FROM LESSSON WHERE USER_ID = 'yanagisawa.trade@gmail.com' ORDER BY LESSON_NAME asc;
		return result;
	}
	
	
	
	
	
	public List<Lessson> getLessonDataMonthly(Lessson lessson) {
		// TODO 自動生成されたメソッド・スタブ
		//今月の日付取得
		Calendar cal = 	Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		
		List<Lessson> result = jdbcManager.selectBySql(Lessson.class,
														"select * FROM LESSSON where USER_ID = ? AND LESSON_DATE LIKE ?", 
														lessson.userId,  year + "/" + month + '%'  ).getResultList();
		//SELECT * FROM LESSSON WHERE USER_ID = 'yanagisawa.trade@gmail.com' AND LESSON_DATE LIKE '2015/10/%'; 
		
		return result;
	}
	
	
	public List<String> shukeiData(Lessson lessson) {
		//SELECT LESSON_NAME  FROM LESSSON WHERE USER_ID = 'yanagisawa.trade@gmail.com' GROUP BY LESSON_NAME ORDER BY COUNT(*) DESC;	
		//SELECT LESSON_NAME , COUNT(*) AS COUNT_NUMBER FROM LESSSON WHERE USER_ID = 'yanagisawa.trade@gmail.com'  GROUP BY LESSON_NAME ORDER BY COUNT(*) DESC
		List<ShukeiDataDto> shukeiDataDtoList = new ArrayList();
		List<String> tempList = new ArrayList<>();
		System.out.println("");
		//多く受講しているレッスン名取得
		List<String> result = jdbcManager.selectBySql(String.class,
				"SELECT LESSON_NAME , MAX(CO) FROM (SELECT LESSON_NAME, COUNT(*) AS CO FROM LESSSON WHERE USER_ID = ? GROUP BY LESSON_NAME) AS C  GROUP BY C.CO ORDER BY CO DESC",
				lessson.userId).getResultList();
				
		
		//forでまわして一番多い回数が変わるまでaddする
		//for(Lessson lesson : result)
		

		System.out.println("");
		return result;
	}
	
	public List<String> shukeiInstructorData(Lessson lesson){
		//List<ShukeiDataDto> shukeiDataDtoList = new ArrayList();
		List<String> tempList = new ArrayList<>();
		System.out.println("");
		//多く受講しているレッスン名取得
		List<String> result = jdbcManager.selectBySql(String.class,
				"SELECT INSTRUCTOR , MAX(CO) FROM (SELECT INSTRUCTOR, COUNT(*) AS CO FROM LESSSON WHERE USER_ID = ?  GROUP BY INSTRUCTOR) AS C  GROUP BY C.CO ORDER BY CO DESC",
				lesson.userId).getResultList();		
		
		
		return result;
	}
	
	//SELECT INSTRUCTOR , MAX(CO) FROM (SELECT INSTRUCTOR, COUNT(*) AS CO  
	//FROM LESSSON WHERE USER_ID = 'yanagisawa.trade@gmail.com'  GROUP BY INSTRUCTOR) AS C  GROUP BY C.CO ORDER BY CO DESC;
	

	
}