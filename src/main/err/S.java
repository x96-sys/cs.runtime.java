package err;

import org.x96.sys.foundation.cs.lexer.visitor.Visitor;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.router.switcher.Switcher;
import org.x96.sys.foundation.cs.lexer.visitor.entry.terminals.c0.Lf;
import org.x96.sys.foundation.cs.lexer.visitor.entry.terminals.c2.Space;
import org.x96.sys.foundation.cs.lexer.visitor.entry.terminals.c0.Cr;
import org.x96.sys.foundation.cs.lexer.visitor.entry.terminals.c0.Ht;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.modifier.Shell;

// s = @(0xA | 0x20 | 0xD | 0x9);
public class S extends Visitor {

    public S(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // switch
        Switcher switcher = new Switcher();
        // switch natural
        switcher.know(Lf.class);
        // switch natural
        switcher.know(Space.class);
        // switch natural
        switcher.know(Cr.class);
        // switch natural
        switcher.know(Ht.class);
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
        // natural
        look() == 0xA
        ||
        // nucleus
        // natural
        look() == 0x20
        ||
        // nucleus
        // natural
        look() == 0xD
        ||
        // nucleus
        // natural
        look() == 0x9
        ;
    }

    @Override
    public String overKind() {
        return "s";
    }

}
