import java.time.LocalDate;
import java.time.LocalTime;
import java.util.function.Predicate;


public class Main
{
    public static void main(String[] args)
    {

        FInterfaces.DOMath doMath = (x, y, z) -> x+y+z;
        FInterfaces.DOMath doMathMult = (x, y, z) -> x*y*z;

        FInterfaces.DateTime showdate = () ->
        {
            System.out.println(LocalDate.now());
        };

        FInterfaces.DateTime showtime = () ->
        {
            System.out.println(LocalTime.now());
        };

        FInterfaces.TwoArgument greater = (int x, int y) ->
        {
            if(x > y)
            {
                return x;
            };
            return y;
        };
        FInterfaces.TwoArgument lesser = (int x, int y) ->
        {
            if(x < y)
            {
                return x;
            };
            return y;
        };

        FInterfaces.OneArgument factorial = (int x) ->
        {
          int result = 1;

          for(int i = x; i > 0; i--)
          {
                result *=i;
          }

          return result;
        };

        Predicate<Integer> prime = (x) ->
        {
            for(int i = 2; i < x; i++)
            {
                if(x % i ==0)
                {
                    return  false;
                }
            };
            return true;

        };

        FInterfaces.DOMath maxofthree = (x, y, z) ->
        {
            return Math.max(x, Math.max(y, z));
        };

        FInterfaces.DOMath minofthree = (x, y, z) ->
        {
            return Math.min(x, Math.min(y, z));
        };

        Predicate<Integer> even = (x) -> x % 2 ==0;
        Predicate<Integer> odd = (x) -> x % 2 !=0;

        int maxLength = 10;
        int minLength = 1;

        Predicate<Integer> IsinRange = (x) ->
        {
            return x > minLength && x < maxLength;
        };

        int divider = 2;
        Predicate<Integer> isAliquot = (x) ->
        {
            return divider % x == 0;
        };

        System.out.println(IsinRange.test(5));

    }
}