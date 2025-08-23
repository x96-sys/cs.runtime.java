stx          = 0x2;
etx          = 0x3;
s            = @ ( 0xA | 0x20 | 0xD | 0x9 );
q            = 0x27;
af_up        = [0x41-0x46];
af_low       = [0x61-0x66];
digit        = [0x30-0x39];
hex_digit    = ( digit | af_low | af_up );

word         = @ !q [0x20-0x7E];

template     = q word+ q;

hex          = @ 0x30 ( 'x' | 'X' ) hex_digit+;

err          = hex s* template;

erros        = { stx s* erros_follow+ etx }
erros_follow = err s*;
