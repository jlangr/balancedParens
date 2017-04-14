import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ParserTest {

    Parser parser = new Parser();

    @Test
    public void balanced_with_empty_string() {
        assertTrue(parser.isBalanced(""));
    }

    @Test
    public void unbalanced_with_only_left_paren() {
        assertFalse(parser.isBalanced("("));
    }

    @Test
    public void balanced_with_left_and_right_paren() {
        assertTrue(parser.isBalanced("()"));
    }

    @Test
    public void not_balanced_with_left_and_right_paren_reversed() {
        assertFalse(parser.isBalanced(")("));
    }

    @Test
    public void not_balanced_with_differnt_left_and_right_paren() {
        assertFalse(parser.isBalanced("(}"));
    }

    @Test
    public void balanced_with_LL_RR_paren() {
        assertTrue(parser.isBalanced("(())"));
    }

    @Test
    public void not_balanced_with_LLLR_paren() {
        assertFalse(parser.isBalanced("((()"));
    }

    // Passes already
    @Test
    public void balanced_with_LRLR_paren() {
        assertTrue(parser.isBalanced("()()"));
    }

    @Test
    public void not_balanced_with_brace_mismatch() {
        assertFalse(parser.isBalanced("{"));
    }

    @Test
    public void not_balanced_when_types_cross() {
        assertFalse(parser.isBalanced("({)}"));
    }

    @Test
    public void not_balanced_when_types_cross_2() {
        assertFalse(parser.isBalanced("{(})"));
    }

    @Test
    public void balanced_with_mixed_types() {
        assertTrue(parser.isBalanced("{({}())}"));
    }
}