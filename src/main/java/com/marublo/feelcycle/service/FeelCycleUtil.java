package com.marublo.feelcycle.service;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * FeelCycle用ユーティルクラス
 *
 * @author Y.Yanagisawa / tiritiri / maruty
 * @version 1.0
 */

public class FeelCycleUtil {
	/**
	 * 処理日から1週間の日程を返却する

	 * @return mm/dd 形式のArrayList<String>
	 */
	public static ArrayList<String> calendarDayOfWeekList(){
        Calendar calendar = Calendar.getInstance();
        //int baseYear = calendar.get(Calendar.YEAR);
        int baseMonth = calendar.get(Calendar.MONTH) + 1;
        int baseDay = calendar.get(Calendar.DATE);

        ArrayList<String>dayArray = new ArrayList<String>();
        dayArray.add(baseMonth + "/" + baseDay);
        for(int i=0; i < 6; i++){
        	calendar.add(Calendar.DATE, + 1);
        //	dayArray.add((calendar.get(calendar.MONTH) + 1) + "/" + calendar.get(calendar.DATE));
        }

		return dayArray;
	}

	/**
	 * FeelCycleのクッキー渡す際の文字列変換ユーティリティ
	 * @param loginId （メールアドレス hoge@example.com)
	 * @param loginPass（ログインパスワード password）
	 * @return Shoge%40example.com%2Cpassword
	 * 上記のような形で返却する
	 */
	public static String getFsCookie(String loginId,String loginPass) {
		String FsCookie = loginId.replaceAll("@", "%40") + "%2C" + loginPass;
		return FsCookie;
	}

	/**
	 * 文字列存在チェック用のユーティリティ
	 * @param baseStr 確認用元データ
	 * @param compStr 確認したい文字列
	 * @return boolean
	 *
	 * 存在していたらtrue 存在していなかったらfalseを返却する
	 */
	public static boolean containStr(String baseStr,String compStr){
		boolean containFlag = false;
		if(baseStr.indexOf(compStr) != -1){
			containFlag = true;
		}

		return containFlag;
	}

	/**
	 * 日付文字列変更ユーティリティ
	 * 2015/10/20 => 2015-10-20
	 * のように変更する
	 * @param baseStr 変更用元データ
	 * @param compStr 確認したい文字列
	 * @return boolean
	 *
	 * 存在していたらtrue 存在していなかったらfalseを返却する
	 */
	public static String changeStrDate(String baseStr){
		String tempStr = "";
		tempStr = baseStr.replaceAll("/", "-");

		return tempStr;
	}

	/**
	 * 時間文字列変更ユーティリティ
	 * 07:00?07:45 => 07:00&&07:45のように返却する
	 *
	 * @param baseStr 変更用元データ
	 * @return String
	 *
	 * 存在していたらtrue 存在していなかったらfalseを返却する
	 */
	public static String changeStrTime(String baseStr){
		String tempStr = "";
		tempStr = baseStr.replaceAll("\\?", "&&");

		return tempStr;
	}

	//今年を返却する
	public static int thisYearData(){
		Calendar calendar = Calendar.getInstance();

		return calendar.get(Calendar.YEAR);
	}

	/**
	 * sheet.php削除ユーティリティ
	 * sheet.php?を削除する
	 *
	 * @param baseStr 変更用元データ
	 * @return String
	 *
	 * 存在していたらtrue 存在していなかったらfalseを返却する
	 */
	public static String removeSheetStr(String baseStr){
		String tempStr = "";
		tempStr = baseStr.replaceAll("sheet.php?", "");

		return tempStr;
	}
	
	/**
	 * 文字分割用ユーティリティ
	 * 10:00〜10:45
	 * みたいなものを [10:00,10:45]という形で返却する
	 *
	 * @param baseStr 変更用元データ
	 * @return String
	 *
	 * 存在していたらtrue 存在していなかったらfalseを返却する
	 */
	public static String[] spliteTime(String baseStr){

		String[] spliteArray = baseStr.split("～", 0);

		return spliteArray;
	}

}
