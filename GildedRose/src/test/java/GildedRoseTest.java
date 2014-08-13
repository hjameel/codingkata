import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

public class GildedRoseTest {

	@Test
	public void should_not_add_any_items() {
		List<Item> items = new ArrayList<Item>();
		
		GildedRose.updateQuality(items);
		
		assertEquals(0, items.size());
	}
}