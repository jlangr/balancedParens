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

    @Ignore
    @Test
    public void unbalanced_with_only_left_paren() {
        assertFalse(parser.isBalanced("("));
    }

    @Ignore
    @Test
    public void balanced_with_left_and_right_paren() {
        assertTrue(parser.isBalanced("()"));
    }

    @Ignore
    @Test
    public void not_balanced_with_left_and_right_paren_reversed() {
        assertFalse(parser.isBalanced(")("));
    }

    @Ignore
    @Test
    public void not_balanced_with_differnt_left_and_right_paren() {
        assertFalse(parser.isBalanced("(}"));
    }

    @Ignore
    @Test
    public void balanced_with_LL_RR_paren() {
        assertTrue(parser.isBalanced("(())"));
    }

    @Ignore
    @Test
    public void not_balanced_with_LRR_paren() {
        assertFalse(parser.isBalanced("())"));
    }
}