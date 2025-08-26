package zero;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;

// segment_follow = axis d*;
public class SegmentFollow extends Axis {

    public SegmentFollow(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // term
        push(new Axis(tokenizer).safeVisit());
        // nucleus
        // term
        while (// term
            new D(tokenizer).allowed()) {
            push(new D(tokenizer).safeVisit());
        }
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // term
        new Axis(tokenizer).allowed()
        ;
    }

    @Override
    public String overKind() {
        return "segment_follow";
    }

}
