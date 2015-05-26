using System.Collections.Generic;
using System.Linq;

namespace Stringcalculator
{
    public class StringCalculator
    {
        public static long Add(string csv)
        {
            return IsEmpty(csv) 
                ? 0 
                : TheIndividualElementsOfThe(csv).Sum();
        }

        private static bool IsEmpty(string csv)
        {
            return csv == string.Empty;
        }

        private static IEnumerable<long> TheIndividualElementsOfThe(string numbers)
        {
            return numbers.Split('\n', ',').Select(long.Parse);
        }

        public static void Main()
        {
        }
    }
}