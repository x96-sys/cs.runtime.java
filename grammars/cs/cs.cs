stx             = 0x2;  # start of text \u0002
etx             = 0x3;  # end of text   \u0003
tab             = 0x9;  # tabulation    \t
nl              = 0xA;  # new line      \n
carriage_return = 0xD;  # enter         \r
s               = 0x20; # space         \s
bang            = 0x21; # exclamation   !
hash            = 0x23; # number sign   #
q               = 0x27; # quote         '

open_paren      = 0x28; # left parenthesis  (
close_paren     = 0x29; # right parenthesis )

asterisk        = 0x2A; # quantifier      * (zero ou mais)
plus            = 0x2B; # quantifier      + (um ou mais)
dash            = 0x2D; # sinal de menos  - (separa range)
zero            = 0x30; # digit zero     0
delimiter       = 0x3B; # ponto e virgula ;
assignor        = 0x3D; # sinal de igual  =
question        = 0x3F; # quantifier      ? (zero ou um)
shell           = 0x40; # arroba          @

open_square     = 0x5B; # left square bracket  [
close_square    = 0x5D; # right square bracket ]

ghost           = 0x5F; # underscore _

open_brace      = 0x7B; # left brace  {
p               = 0x7C; # pipe        |
close_brace     = 0x7D; # right brace }

any             = [0x20-0x7E]; # space and any visible ascii character
digit           = [0x30-0x39]; # digits 0-9

af_up           = [0x41-0x46]; # letras A-F maiusculas
x_up            = 0x58;        # letra X maiuscula

af_low          = [0x61-0x66]; # letras a-f minusculas
x_low           = 0x78;        # letra x minuscula

alpha           = ( alpha_up | alpha_low ); # letras maiusculas e minusculas
alpha_up        = [0x41-0x5A];              # letras A-Z maiusculas
alpha_low       = [0x61-0x7A];              # letras a-z minusculas

hex_digit       = ( digit | af_low | af_up ); # digits e letras A-F

quantifier      = @ ( asterisk | plus | question ); # quantificador

es              = ( s | tab | carriage_return | nl ); # espaco vazio

hexadecimal     = @ zero ( x_up | x_low ) hex_digit+; # literal hexadecimal
range_hex       = hexadecimal dash hexadecimal;       # intervalo hexadecimal
quoted_word     = q word+ q;                          # string entre aspas simples
word            = @ !q any;                           # qualquer coisa que n seja quote e seja any

doc             = @ hash doc_follow*; # comentario
doc_follow      = !nl any;            # qualquer coisa que n seja nova linha e seja any

d               = (doc | es); # doc or empty space

segment         = open_square d* segment_follow+ close_square; # [ ... ]
segment_follow  = axis d*;                                     # conteudo dentro de [ ]

choices         = open_paren d* core d* choices_follow+ close_paren; # ( ... | ... )
choices_follow  = p d* core d*;                                      # alternativas separadas por |

unit            =  bang? glyph quantifier?; # identificador simples, opcionalmente com ! e quantificador

shared          = ( quoted_word | unit | choices | segment ); # construcao basica reutilizavel
core            = ( shared | hexadecimal );                   # nucleo com hex
axis            = ( shared | range_hex );                     # nucleo com range hex

casing          = open_brace d* core_follow+ close_brace; # conteudo dentro de { }
lineage         = core_follow+ delimiter;                 # conteudo finalizado por ;
core_follow     = [core d*];                              # conteudo

modifier        = ( ghost | shell ) d*;                   # atomiza ou oculta

pattern         = modifier? ( lineage | casing );         # facet

glyph           = @ alpha glyph_follow*;     # identifier
glyph_follow    = ( alpha | digit | ghost ); # identifier continuation

passage         = glyph d* assignor d* pattern; # definition

book            = { stx d* book_follow+ etx } # entry point
book_follow     = passage d*;                 # book content
