package com.marublo.feelcycle.service;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Generated;
import javax.annotation.Resource;

import org.seasar.extension.jdbc.JdbcManager;

import com.marublo.feelcycle.dto.LessonDataDto;
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
	public List<Lessson> getLessonDataMonthly(Lessson lessson) {
		// TODO 自動生成されたメソッド・スタブ
		//今月の日付取得
		Calendar cal = 	Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		
		List<Lessson> result = jdbcManager.selectBySql(Lessson.class,
														"select * where USER_ID = ? AND LESSON_DATE LILE ?", 
														lessson.userId,  year + "/" + month + "/" + '%'  ).getResultList();
		//SELECT * FROM LESSSON WHERE USER_ID = 'yanagisawa.trade@gmail.com' AND LESSON_DATE LIKE '2015/10/%'; 
		
		return result;
	}
}