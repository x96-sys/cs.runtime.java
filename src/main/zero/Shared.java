package zero;

import org.x96.sys.foundation.cs.lexer.visitor.Visitor;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.router.switcher.Switcher;

// shared = (word | unit | choices | segment);
public class Shared extends Visitor {

    public Shared(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // switch
        Switcher switcher = new Switcher();
        // switch term
        switcher.know(Word.class);
        // switch term
        switcher.know(Unit.class);
        // switch term
        switcher.know(Choices.class);
        // switch term
        switcher.know(Segment.class);
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
        new Word(tokenizer).allowed()
        ||
        // nucleus
        // term
        new Unit(tokenizer).allowed()
        ||
        // nucleus
        // term
        new Choices(tokenizer).allowed()
        ||
        // nucleus
        // term
        new Segment(tokenizer).allowed()
        ;
    }

    @Override
    public String overKind() {
        return "shared";
    }

}
