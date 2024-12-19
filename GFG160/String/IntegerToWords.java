package GFG160.String;

public class IntegerToWords {
    public static void main(String[] args) {
        int n = 20000;
        System.out.println(Integer.toString(199));
        // System.out.println(convertToWords(n));
    }

    public static String convertToWords(int n) {
        if (n == 0) {
            return "Zero";
        }

        String multiplier[] = { "", "Thousand", "Million", "Billion" };
        String units[] = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
                "Eighteen", "Nineteen" };
        String tens[] = { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
                "Ninety" };

        String res = "";
        int group = 0;

        while (n > 0) {
            if (n % 1000 != 0) {
                int value = n % 1000;
                String temp = "";

                // handle 3 digits
                if (value >= 100) {
                    temp = units[value / 100] + " Hundred ";
                    value %= 100;
                }

                // handling 2 digits
                if (value >= 20) {
                    temp += tens[value / 10] + " ";
                    value %= 10;
                }

                // handle unit number
                if (value >= 0) {
                    temp += units[value] + " ";
                }
                temp += multiplier[group] + " ";
                res = temp + res;
            }

            n /= 1000;
            group++;

        }
        return res.trim();
    }

}
