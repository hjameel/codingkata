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
            
            [Test]
            public void ReturnTheSumOfASingleNumber()
            {
                Assert.That(StringCalculator.Add("1"), Is.EqualTo(1));
            }
            
            [Test]
            public void ReturnTheSumOfTwoNumbers()
            {
                Assert.That(StringCalculator.Add("1,2"), Is.EqualTo(3));
            }
        }
    }
}
