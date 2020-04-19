package funcoes;

    /* 
    * Copyright (c) 2005 Tiago Fernandez 
    * 
    * Licensed under the Apache License, Version 2.0 (the "License"); 
    * you may not use this file except in compliance with the License. 
    * You may obtain a copy of the License at 
    * 
    * <a target="_blank" href="http://www.apache.org/licenses/LICENSE-2.0">http://www.apache.org/licenses/LICENSE-2.0</a> 
    * 
    * Unless required by applicable law or agreed to in writing, software 
    * distributed under the License is distributed on an "AS IS" BASIS, 
    * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
    * See the License for the specific language governing permissions and 
    * limitations under the License. 
    */  
      
    import java.text.SimpleDateFormat;
import java.util.Calendar;  
import java.util.Date;  
import java.util.GregorianCalendar;  
      
    /** 
     * Offers common utils for managing holidays. 
     *  
     * @author Tiago Fernandez 
     * @see <a target="_blank" href="http://www.tiago182.spyw.com">http://www.tiago182.spyw.com</a> 
     * @since Aug/31/2005 
     */  
    public class HolidayUtils {  
      
        private final static long DAY_IN_MILLIS = 86400000;  
          
        /** 
         * The Carnival falls always 47 days before the Easter. 
         *  
         * @param year to be evaluated 
         * @return the carnival date 
         * @see http://www.inf.ufrgs.br/~cabral/Pascoa.html 
         */  
        public static Date getCarnival(int year) {  
            return getSubtractedDays(getSundayOfEaster(year), 47);  
        }
        
        /** 
         * The Paix�o de Cristo falls always 2 days before the Easter. 
         *  
         * @param year to be evaluated 
         * @return the paix�o de cristo date 
         * @see http://www.inf.ufrgs.br/~cabral/Pascoa.html 
         */  
        public static Date getPaixaoDeCristo(int year) {  
            return getSubtractedDays(getSundayOfEaster(year), 2);  
        } 
      
        /** 
         * The Corpus Christi falls always 60 days after the Easter. 
         *  
         * @param year to be evaluated 
         * @return the corpus christi date 
         * @see http://www.inf.ufrgs.br/~cabral/Pascoa.html 
         */  
        public static Date getCorpusChristi(int year) {  
            return getAddedDays(getSundayOfEaster(year), 60);  
        }  
      
        /** 
         * The sunday of Easter is the first sunday after the first full moon of autumn. Here we'll use the 
         * algorithm created in 1800, for the matematician Carl Gauss: 
         * <br/><br/> 
         * 1) Assumes y be the year (as 1800 or 2001).<br/> 
         * 2) Divides y by 19 and call the rest of a. Ignore the quotient.<br/> 
         * 3) Divides y by 100 to obtain the quotient b and the rest c. <br/> 
         * 4) Divides b by 4 to obtain the quotient d and the rest e. <br/> 
         * 5) Divides 8 * b + 13 by 25 to obtain the quotient g. Ignore the rest.<br/>  
         * 6 ) Divides 19 * a + b - d - g + 15 by 30 to obtain the rest h. Ignore the quotient.<br/>  
         * 7) Divides c by 4 to obtain the quotient j and the rest k. <br/> 
         * <img src="http://javafree.uol.com.br/forum/images/smiles/icon_cool.gif"> Divides a + 11 * h by 319 to obtain the quotient m. Ignore the rest.<br/>  
         * 9) Divides 2 * e + 2 * j - k - h + m + 32 by 7 to obtain the rest r. Ignore the quotient.<br/>  
         * 10) Divides h - m + r + 90 by 25 to obtain the quotient n. Ignore the rest. <br/> 
         * 11) Divides h - m + r + n + 19 by 32 to obtain the rest p. Ignore the quotient.  <br/> 
         * <br/><br/> 
         * Like that, the Easter falls at the day p of the month n. For example, if y is 2001:<br/>  
         * a = 6 <br/> 
         * b = 20 <br/> 
         * c = 1 <br/> 
         * d = 5, e = 0 <br/>  
         * g = 6 <br/> 
         * h = 18 <br/> 
         * j = 0, k = 1 <br/> 
         * m = 0 <br/> 
         * r = 6 <br/> 
         * n = 4 <br/>  
         * p = 15 <br/> 
         * <br/><br/> 
         * So, at 2001, the sunday of easter fell at April/15. 
         *  
         * @param year the year to be evaluated 
         * @return the sunday of easter 
         * @see http://www.inf.ufrgs.br/~cabral/Pascoa.html 
         */  
        public static Date getSundayOfEaster(int year) {  
      
            // step 2  
            int a = year % 19;  
      
            // step 3  
            int b = year / 100;  
            int c = year % 100;  
      
            // step 4  
            int d = b / 4;  
            int e = b % 4;  
      
            // step 5  
            int g = (8 * b + 13) / 25;  
      
            // step 6  
            int h = (19 * a + b - d - g + 15) % 30;  
      
            // step 7  
            int j = c / 4;  
            int k = c % 4;  
      
            // step 8  
            int m = (a + 11 * h) / 319;  
      
            // step 9  
            int r = (2 * e + 2 * j - k - h + m + 32) % 7;  
      
            // step 10  
            int n = (h - m + r + 90) / 25;  
      
            // step 11 (finally)  
            int p = (h - m + r + n + 19) % 32;  
      
            // building the actual date  
            Calendar calendar = new GregorianCalendar();  
            calendar.set(Calendar.YEAR, year);  
            calendar.set(Calendar.MONTH, n - 1);  
            calendar.set(Calendar.DAY_OF_MONTH, p);  
            calendar.set(Calendar.HOUR_OF_DAY, 0);  
            calendar.set(Calendar.MINUTE, 0);  
            calendar.set(Calendar.SECOND, 0);  
            calendar.set(Calendar.MILLISECOND, 0);  
      
            return calendar.getTime();
      
        }  
      
        private static Date getAddedDays(Date date, long numOfDays) {  
            return new Date(date.getTime() + (numOfDays * DAY_IN_MILLIS));  
        }  
      
        private static Date getSubtractedDays(Date date, long numOfDays) {  
            return new Date(date.getTime() - (numOfDays * DAY_IN_MILLIS));  
        } 
        @SuppressWarnings("static-access")
		public String retornaData(int i){
        	SimpleDateFormat sdf = new SimpleDateFormat(
    				"dd'-'MM");
        	SimpleDateFormat year = new SimpleDateFormat("yyyy");
        	int ano = Integer.parseInt(year.format(new Date()));
        	HolidayUtils h = new HolidayUtils();
        	String data = "";
        	if (i==1){
        		data="1-Carnaval-"+sdf.format(h.getCarnival(ano));
        		System.out.println(data);
        	}
        	if (i==2){
        		data="2-Paixao de Cristo-"+sdf.format(h.getPaixaoDeCristo(ano));
        		System.out.println(data);
        	}
        	if (i==3){
        		data="3-Pascoa-"+sdf.format(h.getSundayOfEaster(ano));
        		System.out.println(data);
        	}
        	if (i==4){
        		data="4-Corpus Christi-"+sdf.format(h.getCorpusChristi(ano));
        		System.out.println(data);
        	}
        	
        	return data;

        	
        }
      
    }  