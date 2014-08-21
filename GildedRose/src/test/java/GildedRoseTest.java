import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.List;
import java.util.LinkedList;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void should_not_add_any_items() {
        List<Item> emptyListOfItems = new LinkedList<Item>();
        GildedRose.updateQuality(emptyListOfItems);
        assertThat(emptyListOfItems.size(), is(0));
    }
}