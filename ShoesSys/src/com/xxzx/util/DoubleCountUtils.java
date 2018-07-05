package com.xxzx.util;

import java.math.BigDecimal;

/** 
* @功能说明：<p>double类型的数字相加减</p>
* @作者：zhaisiqun
* @创建时间：2013-8-29 上午11:43:56 
* @版本：V1.0  
*/   
public class DoubleCountUtils {
	/**
	 * 
	 * @说明:<p>两个double的相加，可以为负</p>
	 * @author: zhaisiqun 2013-8-9
	 * @param double1
	 * @param double2
	 * @return double
	 * @throws
	 */
	public static double addDouble(double double1, double double2) {
		BigDecimal dou1 = new BigDecimal(double1 + "");
		BigDecimal dou2 = new BigDecimal(double2 + "");
		BigDecimal dou3 = dou1.add(dou2);
		return Double.parseDouble(dou3.toString());
	}

	/**
	 * 
	 * @说明:<p>两个double的相减，可以为负</p>
	 * @author: zhaisiqun 2013-8-9
	 * @param double1
	 * @param double2
	 * @return double
	 * @throws
	 */
	public static double subtractDouble1(double double1, double double2) {
		BigDecimal dou1 = new BigDecimal(double1 + "");
		BigDecimal dou2 = new BigDecimal(double2 + "");
		BigDecimal dou3 = dou1.subtract(dou2);
		return Double.parseDouble(dou3.toString());
	}

	/**  
	* @说明:<p>两个double的相/，可以为负</p> 
	* @author: weiming  2013-9-4   
	* @param double1
	* @param double2
	* @return  
	* double 
	* @throws
	*/
	public static double divideDouble(double double1, double double2) {
		BigDecimal dou1 = BigDecimal.valueOf(double1);
		BigDecimal dou2 = BigDecimal.valueOf(double2);
		BigDecimal dou3 = dou1.divide(dou2,2,4);
		if(Double.parseDouble(dou3.toString())!=0){
			dou3.setScale(2, BigDecimal.ROUND_HALF_UP);
		}
		return Double.parseDouble(dou3.toString());
	}
	
	/**  
	* @说明:<p>两个double的相*，可以为负</p> 
	* @author: weiming  2013-9-4   
	* @param double1
	* @param double2
	* @return  
	* double 
	* @throws
	*/
	public static double multiplyDouble(double double1, double double2) {
		BigDecimal dou1 = BigDecimal.valueOf(double1);
		BigDecimal dou2 = BigDecimal.valueOf(double2);
		BigDecimal dou3 = dou1.multiply(dou2);
		dou3.setScale(3, BigDecimal.ROUND_HALF_UP);
		return Double.parseDouble(dou3.toString());
	}

}
