package zero;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;

// segment = open_square d* segment_follow+ close_square;
public class Segment extends OpenSquare {

    public Segment(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // term
        push(new OpenSquare(tokenizer).safeVisit());
        // nucleus
        // term
        while (// term
            new D(tokenizer).allowed()) {
            push(new D(tokenizer).safeVisit());
        }
        // nucleus
        // term
        do {
            push(new SegmentFollow(tokenizer).safeVisit());
        } while (// term
            new SegmentFollow(tokenizer).allowed());
        // nucleus
        // term
        push(new CloseSquare(tokenizer).safeVisit());
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // term
        new OpenSquare(tokenizer).allowed()
        ;
    }

    @Override
    public String overKind() {
        return "segment";
    }

}
