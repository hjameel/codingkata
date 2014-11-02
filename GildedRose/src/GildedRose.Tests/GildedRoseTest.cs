using NUnit.Framework;
using System.Collections.Generic;
using GildedRose.Console;

namespace GildedRose.Tests
{
    public class when_update_items_is_called
    {
        [TestFixture]
        public class given_an_empty_list_of_items
        {
            [Test]
            public void it_should_not_update_the_list()
            {
                var program = new Program();
                program.Items = new List<Item>();
                program.UpdateQuality();
                Assert.That(program.Items, Is.Empty);
            }
        }
    }
}