using System.Linq;

namespace Stringcalculator
{
    public class StringCalculator
    {
        public static long Add(string input)
        {
            if (input == string.Empty)
            {
                return 0;
            }

            return input.Split(',').Select(long.Parse).Sum();
        }

        public static void Main()
        {
        }
    }
}