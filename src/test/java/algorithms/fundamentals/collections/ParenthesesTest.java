package algorithms.fundamentals.collections;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ParenthesesTest {

	private Parentheses parentheses;

	@Before
	public void setup() {
		this.parentheses = new Parentheses();
	}

	@Test
	public void itIsBalancedWhenSequenceIsEmpty() {
		assertTrue(parentheses.isBalanced(""));
	}

	@Test
	public void itIsntBalancedWhenSequenceHasAUnmatchParenthes() {
		assertFalse(parentheses.isBalanced("("));
	}

	@Test
	public void itBalancedWhenSequenceHasAMatchParenthes() {
		assertTrue(parentheses.isBalanced("()"));
	}

	@Test
	public void itIsntBalancedWithSquareBrackets() {
		assertFalse(parentheses.isBalanced("()["));
	}

	@Test
	public void itIsntBalancedWithSquareBracketsAndParentheses() {
		assertFalse(parentheses.isBalanced("([)]"));
	}

	@Test
	public void itIsntBalancedWithSquareBracketsParenthesesAndBraces() {
		assertFalse(parentheses.isBalanced("([]{)}"));
	}

	@Test
	public void itIsBalanced() {
		assertTrue(parentheses.isBalanced("[()]{}{[()()]()}"));
	}

}
