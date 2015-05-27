using System.Collections.Generic;
using System.Linq;

namespace Stringcalculator
{
    public class StringCalculator
    {
        public static long Add(string csvText)
        {
            if (IsEmpty(csvText))
            {
                return 0;
            }
            return TheIndividualElementsOfThe(csvText).Sum();
        }

        private static bool IsEmpty(string csvText)
        {
            return csvText == string.Empty;
        }

        private static IEnumerable<long> TheIndividualElementsOfThe(string csvText)
        {
            return Csv.Read(csvText).GetIndividualElements().ToList();
        }

        /// <summary>
        /// Required for console project
        /// </summary>
        public static void Main()
        {
        }
    }
}