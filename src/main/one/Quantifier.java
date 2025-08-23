package one;

import org.x96.sys.foundation.cs.lexer.visitor.Visitor;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.router.switcher.Switcher;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.modifier.Shell;

// quantifier = @(asterisk | plus | question);
public class Quantifier extends Visitor {

    public Quantifier(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // switch
        Switcher switcher = new Switcher();
        // switch term
        switcher.know(Asterisk.class);
        // switch term
        switcher.know(Plus.class);
        // switch term
        switcher.know(Question.class);
        push(switcher.stream(tokenizer));
        setMod(new Shell((byte) 0x40));
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
        new Asterisk(tokenizer).allowed()
        ||
        // nucleus
        // term
        new Plus(tokenizer).allowed()
        ||
        // nucleus
        // term
        new Question(tokenizer).allowed()
        ;
    }

    @Override
    public String overKind() {
        return "quantifier";
    }

}
