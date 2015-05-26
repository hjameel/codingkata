using System.Collections.Generic;
using System.Linq;

namespace Stringcalculator
{
    public class StringCalculator
    {
        public static long Add(string csvText)
        {
            return IsEmpty(csvText)
                ? 0
                : TheIndividualElementsOfThe(csvText).Sum();
        }

        private static bool IsEmpty(string csvText)
        {
            return csvText == string.Empty;
        }

        private static IEnumerable<long> TheIndividualElementsOfThe(string csvText)
        {
            return Csv.Read(csvText).GetIndividualElements();
        }

        public static void Main()
        {
        }
    }
}