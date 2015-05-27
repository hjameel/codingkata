using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

namespace Stringcalculator
{
    public abstract class Csv
    {
        private static readonly string InitialValue = null;
        private const string CustomDelimiterIndicator = "//";
        protected string CsvText;

        protected Csv(string csvText)
        {
            CsvText = csvText;
        }

        public static Csv Read(string csvText)
        {
            if (csvText.StartsWith(CustomDelimiterIndicator))
            {
                return new CustomDelimitedCsv(csvText);
            }
            return new DefaultDelimitedCsv(csvText);
        }

        public abstract char[] Delimiters { get; }

        public abstract string Text { get; }

        public IEnumerable<long> GetIndividualElements()
        {
            ValidateThatThereAreNoNegativesIn(ReadElements());
            return ReadElements();
        }

        private IEnumerable<long> ReadElements()
        {
            return Text.Split(Delimiters).Select(long.Parse).ToList();
        }

        public void ValidateThatThereAreNoNegativesIn(IEnumerable<long> elements)
        {
            var negatives = elements.Where(IsNegative).ToList();

            if (negatives.Count() != 0)
            {
                throw new ArgumentException(
                    string.Format("negatives not allowed: {0}",
                        negatives.Select(AsString).Aggregate(InitialValue, CommaSeparatedList)));
            }
        }

        private string CommaSeparatedList(string negativesList, string elem)
        {
            return negativesList == InitialValue ? elem : negativesList + ", " + elem;
        }

        private string AsString(long x)
        {
            return x.ToString();
        }

        private bool IsNegative(long elem)
        {
            return elem < 0;
        }
    }


    public class DefaultDelimitedCsv : Csv
    {
        private static readonly char[] DefaultDelimiters = {'\n', ','};

        public DefaultDelimitedCsv(string csvText)
            : base(csvText)
        {
        }

        public override char[] Delimiters
        {
            get { return DefaultDelimiters; }
        }

        public override string Text
        {
            get { return CsvText; }
        }
    }

    public class CustomDelimitedCsv : Csv
    {
        private const int DelimiterSpecifierLength = 4;
        private static readonly Regex CustomDelimiterCapture = new Regex(@"//(.)\n");

        public CustomDelimitedCsv(string csvText)
            : base(csvText)
        {
        }

        public override char[] Delimiters
        {
            get { return GetCustomDelimiter(CsvText); }
        }

        public override string Text
        {
            get { return CsvText.Substring(DelimiterSpecifierLength); }
        }

        private static char[] GetCustomDelimiter(string csv)
        {
            return CustomDelimiterCapture.Match(csv).Captures[0].Value.ToCharArray();
        }
    }
}