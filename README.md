# CS

build self visitors

`org.x96.sys.cs.lexer.visitors.Book` is a handcraft visitor on lib `cs.lexer`

```bash
make run ARGS="build grammars/cs/cs.cs org.x96.sys.cs.lexer.visitors.Book org.x96.sys.cs.lexer.visitors.synthetic"
```

now

`org.x96.sys.cs.lexer.visitors.synthetic.Book` is a synthetic visitor for same
grammar/dsl

use handcraft visitor to tokenize self

```bash
make run ARGS="tokenize grammars/cs/cs.cs org.x96.sys.cs.lexer.visitors.Book"
```

run generated visitors to tokenize self

```bash
make run ARGS="tokenize grammars/cs/cs.cs org.x96.sys.cs.lexer.visitors.synthetic.Book"
```

## Usage

### Err

Com a DSL `Err` queremos delimitar códigos de erros e templates de mensagens;

| Código | Mensagem        |
| ------ | --------------- |
| 0xE1   | Erro de sintaxe |
| 0xE2   | Erro de tipo    |
| 0xE3   | Erro de valor   |

Gramática `Err.cs`

```cs-grammar
# grammars/err/err.cs
stx = 0x2;
etx = 0x3;

i   = @ (0xA | 0x20 | 0xD | 0x9);

q   = 0x27;

digit  = [0x30-0x39];
af_up  = [0x41-0x46];
af_low = [0x61-0x66];

hex_digit = (digit | af_up | af_low);

hex = @ 0x30 ('x' | 'X') hex_digit+;

any          = [0x20-0x7E];
word         = !q any;
template_msg = @ q word+ q;

err        = hex i* template_msg;
err_follow = err i*;

errs = stx i* err_follow+ etx;
```

tokenize for shure

```bash
make run ARGS="tokenize grammars/err/err.cs org.x96.sys.cs.lexer.visitors.synthetic.Book"
```

build visitors for a new dsl

```bash
make run ARGS="build grammars/err/err.cs org.x96.sys.cs.lexer.visitors.synthetic.Book org.x96.sys.err.lexer.visitors.synthetic"
```

create artifacts `grammars/err/artifacts/sample.err.cs`

```cs-grammar
0x1 'hello, %s; this is your first err'
0x2 'goodbye, %s; this is your last err'
```

tokenize artifacts with synthetic visitor

```bash
make run ARGS="tokenize grammars/err/artifacts/sample.err.cs org.x96.sys.err.lexer.visitors.synthetic.Errs"
```
