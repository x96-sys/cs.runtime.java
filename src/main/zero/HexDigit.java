package zero;

import org.x96.sys.foundation.cs.lexer.visitor.Visitor;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.router.switcher.Switcher;

// hex_digit = (digit | af_low | af_up);
public class HexDigit extends Visitor {

    public HexDigit(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // switch
        Switcher switcher = new Switcher();
        // switch term
        switcher.know(Digit.class);
        // switch term
        switcher.know(AfLow.class);
        // switch term
        switcher.know(AfUp.class);
        push(switcher.stream(tokenizer));
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // switch
        // nucleus
        // term
        new Digit(tokenizer).allowed()
        ||
        // nucleus
        // term
        new AfLow(tokenizer).allowed()
        ||
        // nucleus
        // term
        new AfUp(tokenizer).allowed()
        ;
    }

    @Override
    public String overKind() {
        return "hex_digit";
    }

}
