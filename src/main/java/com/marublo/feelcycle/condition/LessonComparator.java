package com.marublo.feelcycle.condition;

import java.util.Comparator;


import com.marublo.feelcycle.entity.Lessson;

public class LessonComparator implements Comparator<Lessson>{

	@Override
	public int compare(Lessson o1, Lessson o2) {
		// TODO 自動生成されたメソッド・スタブ
		String val1 = o1.getlessonDate();
		String val2 = o2.getlessonDate();
		
        if (val1.compareTo(val2) > -1) {
            return 1;

        } else if (val1.compareTo(val2) == 0) {
            return 0;

        } else {
            return -1;

        }

	}



}
