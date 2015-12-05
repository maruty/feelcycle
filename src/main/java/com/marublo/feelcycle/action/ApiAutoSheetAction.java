/*
 * Copyright 2004-2008 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package com.marublo.feelcycle.action;

import org.seasar.struts.annotation.Execute;



public class ApiAutoSheetAction {
	
	/*
	 * FEEL CYCLEの座席を自動取得するアクション
	 * submit押された時にGetパラメータで UserId UserPassが飛んでくる
	 * index()
	 * それを基にDBにデータをインサートする（FC_SHEET userId レッスン日次　レッスン時間　レッスン名　取得開始日　取得完了日　取得フラグ　(true/false)
	 * 
	 * 
	 * sheetData() ※jenkinsで3秒に1回常にcurlでアクセスしている状態→これ微妙かも　先にDBにアクセスしてデータがなかったら終了あったらFCにアクセスにする
	 * そうすればAWSのCPU使用量のみで完結する
	 * 
	 * 取得完了日か取得フラグがfalseになっているデータの存在確認、存在していたら取得処理を行う
	 * ※条件add　取得開始日+24h以内だったら処理を行う
	 * 存在していなかったら処理終了
	 * FC_SHEETテーブルに入っているデータを取得（userIdをインナージョインしてパス引っ張ってくる）
	 * そのデータを基にパースして座席情報をとってくる空いていた場合は取得処理を開始する
	 * 返り値は無し
	 * 
	 * showSheetData() ※フロントからajaxで呼び出される
	 * GetパラメータはuserId
	 *  取得開始日が最新のデータのみをひっぱってくる
	 *  存在フラグを確認してTrueだった場合
	 *  Trueをjsonで返す
	 *  ※json側はtrueになったら随時処理を止めるような処理にする
	 *  
	 *  canselSheet() ※フロントから呼び出し
	 *  GetパラメータはuserId レッスン名　レッスン日　レッスン時間
	 *  それを基にDBの値を見る
	 *  Trueの場合　String = 取得済
	 *  Falseの場合　強制的に Trueに書き換え
	 *  
	 *  返り値は・・・・・？ String = キャンセル済
	 *  
	 * 
	 */
	/*************DI*******************/

	/*************DI*******************/
	/*************Param*******************/

	/*************Param*******************/
	
	
    @Execute(validator = false)
	public String index() {
        return "index.jsp";
	}
}
