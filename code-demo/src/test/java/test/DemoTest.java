package test;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class DemoTest {
  @BeforeAll
  static void initAll() {
  }

  @BeforeEach
  void init() {
  }

  @Test
  void succeedingTest() {
  }

  @Test
  void failingTest() {
    fail("a failing test");
  }

  @Test
  @Disabled
  void skippedTest() {
  }

  @AfterEach
  void tearDown() {
  }

  @AfterAll
  static void tearDowmAll() {
  }
}
