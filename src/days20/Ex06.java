package days20;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author sangmun
 * @date 2023. 8. 9. - 오후 12:42:22
 * @subject	
 * @content
 */
public class Ex06 {

	public static void main(String[] args) {
		// 2023, 8
		Calendar c  = new GregorianCalendar(2023, 8-1, 1);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		c.add(Calendar.DATE, -dayOfWeek+1);
		
		System.out.println(Ex05.getPatternDate(c, "yyyy-MM-dd"));
		
	}

}
