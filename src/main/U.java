import org.x96.sys.foundation.cs.lexer.token.Token;

import java.util.StringJoiner;

public class U {
    public static void q(Token[] tokens) {
        System.out.printf("assertEquals(%s, tokens.length);%n", tokens.length);
        for (int i = 0; i < tokens.length; i++) {
            Token t = tokens[i];
            System.out.printf(
                    "// [0x%X] [%s] [%s] %n", t.lexeme().b(), t.kind(), h(t.lexeme().b()));
            System.out.printf(
                    """
                    assertEquals("%s", tokens[%s].toString());
                    """,
                    t.toString(), i);
            System.out.printf(
                    """
                    assertEquals("%s", tokens[%s].kind().toString());
                    """,
                    t.kind().toString(), i);
            if (t.overKind == null) {
                System.out.printf(
                        """
                        assertNull(tokens[%s].overKind);
                        """,
                        i);
            } else {
                System.out.printf(
                        """
                        assertEquals("%s", tokens[%s].overKind);
                        """,
                        t.overKind, i);
            }

            System.out.printf(
                    """
                    assertEquals(%s, tokens[%s].span().start().line());
                    """,
                    t.span().start().line(), i);
            System.out.printf(
                    """
                    assertEquals(%s, tokens[%s].span().start().column());
                    """,
                    t.span().start().column(), i);
            System.out.printf(
                    """
                    assertEquals(%s, tokens[%s].span().start().offset());
                    """,
                    t.span().start().offset(), i);

            System.out.printf(
                    """
                    assertEquals(%s, tokens[%s].span().end().line());
                    """,
                    t.span().end().line(), i);
            System.out.printf(
                    """
                    assertEquals(%s, tokens[%s].span().end().column());
                    """,
                    t.span().end().column(), i);
            System.out.printf(
                    """
                    assertEquals(%s, tokens[%s].span().start().offset());
                        %n\
                    """,
                    t.span().start().offset(), i);
        }
    }

    private static String h(byte b) {
        return switch (b) {
            case 0x2 -> // Start of Text (STX)
                    "\\u0002";
            case 0x3 -> // Start of Text (STX)
                    "\\u0003";
            case 0x0A -> // Line Feed (LF)
                    "\\n";
            case 0x09 -> // opcional: Tab
                    "\\t";
            default ->
                    // converte normalmente para String usando o byte
                    new String(new byte[] {b}, java.nio.charset.StandardCharsets.UTF_8);
        };
    }

    public static void p(Token[] t) {
        StringJoiner joiner = new StringJoiner(", ");
        for (int i = 0; i < t.length; i++) {
            byte b = t[i].lexeme().b();
            System.out.printf(
                    """
                    Token t%s = new Token(
                    Kind.%s,
                    new Lexeme((byte) 0x%X),
                    new Span(
                    new Position(%s, %s, %s),
                    new Position(%s, %s, %s)));
                    t%s.overKind("%s");
                    %n\
                    """,
                    i,
                    t[i].kind().toString(),
                    b,
                    t[i].span().start().line(),
                    t[i].span().start().column(),
                    t[i].span().start().offset(),
                    t[i].span().end().line(),
                    t[i].span().end().column(),
                    t[i].span().end().offset(),
                    i,
                    t[i].overKind);
            joiner.add("t" + i);
        }

        System.out.printf("Token[] t = new Token[]{%s};%n", joiner);
    }
}
