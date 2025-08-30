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
