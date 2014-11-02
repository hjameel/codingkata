using NUnit.Framework;
using System.Collections.Generic;
using GildedRose.Console;
using System.Linq;

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
                var items = new Item[] { };
                UpdateQualityFor(items);
                Assert.That(items, Is.Empty);
            }
        }

        [TestFixture]
        public class given_a_standard_item
        {
            [Test]
            public void it_should_decrease_the_sellin_value_by_one()
            {
                var item = new Item() { SellIn = 1, Quality = 1 };
                UpdateQualityFor(item);
                Assert.That(item.SellIn, Is.EqualTo(0));
            }
        }

        public static void UpdateQualityFor(params Item[] items)
        {
            var program = new Program();
            program.Items = items;
            program.UpdateQuality();
        }
    }
}