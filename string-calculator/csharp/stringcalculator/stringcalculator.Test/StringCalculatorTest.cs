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
        }
    }
}
