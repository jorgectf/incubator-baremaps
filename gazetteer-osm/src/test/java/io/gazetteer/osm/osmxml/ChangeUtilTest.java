package io.gazetteer.osm.osmxml;

import io.gazetteer.osm.util.Accumulator;
import org.junit.jupiter.api.Test;

import java.util.Spliterator;

import static io.gazetteer.osm.OSMTestUtil.oscXmlData;
import static io.gazetteer.osm.osmxml.ChangeUtil.spliterator;
import static org.junit.jupiter.api.Assertions.*;

public class ChangeUtilTest {

  @Test
  public void tryAdvance() throws Exception {
    Spliterator<Change> spliterator = spliterator(oscXmlData());
    for (int i = 0; i < 51; i++) {
      assertTrue(spliterator.tryAdvance(block -> {}));
    }
    assertFalse(spliterator.tryAdvance(block -> {}));
  }

  @Test
  public void forEachRemaining() throws Exception {
    Spliterator<Change> spliterator = spliterator(oscXmlData());
    Accumulator<Change> accumulator = new Accumulator<>();
    spliterator.forEachRemaining(accumulator);
    assertEquals(accumulator.acc.size(), 51);
  }
}
