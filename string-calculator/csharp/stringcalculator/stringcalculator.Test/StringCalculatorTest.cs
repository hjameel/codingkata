using NUnit.Framework;

namespace Stringcalculator.Test
{
    public class StringCalculatorTest
    {
        [TestFixture]
        public class TheAddMethodShould
        {
            [Test]
            public void Return0WhenGivenAnEmptyString()
            {
                Assert.That(StringCalculator.Add(string.Empty), Is.EqualTo(0));
            }

            [TestCase("1", 1)]
            [TestCase("1,2", 3)]
            [TestCase("1,2,3,4", 10)]
            public void SumCommaSeparatedNumbers(string commaSeparatedNumbers, int sum)
            {
                Assert.That(StringCalculator.Add(commaSeparatedNumbers), Is.EqualTo(sum));
            }

            [Test]
            public void SumNumbersSeparatedByNewLines()
            {
                Assert.That(StringCalculator.Add("1\n2,3"), Is.EqualTo(6));
            }
        }
    }
}