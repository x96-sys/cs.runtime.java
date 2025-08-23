stx = 0x2;
etx = 0x3;
tab             = 0x9;
nl              = 0xA;
carriage_return = 0xD;
s               = 0x20;

q            = 0x27;

digit           = [0x30-0x39];

af_up        = [0x41-0x46];
af_low       = [0x61-0x66];

alpha_up        = [0x41-0x5A];
ghost           = 0x5F;
alpha_low       = [0x61-0x7A];

hex_digit    =   ( digit | af_low | af_up );
hex          = @ 0x30 ( 'x' | 'X' ) hex_digit+;

word         = @ !q [0x20-0x7E];
qword        =   q word+ q;

i               = @ ( s | tab | carriage_return | nl );
alpha           =   ( alpha_up | alpha_low );

primor          = @ alpha primor_follow*;
primor_follow   =   ( alpha | digit | ghost );

catalysis = '.' i* primor course*;
carrier   = ( binds | march );

pair        = primor i* ':' i* (trace | hex | qword);
pair_follow = ',' i* pair;

arg = (trace | hex | qword);
arg_follow = ',' i* arg;

mapped_args  = pair i* pair_follow*;
ordered_args = arg i* arg_follow*;

binds     = '{' mapped_args? '}';
march     = '(' ordered_args? ')';

emitter       = primor;
course        = (catalysis | carrier);

trace         = { emitter course* }
pollinate     = '@' i* primor i* '=' i* (trace | hex | qword) i* ';';

signal        = (pollinate | trace);

sc            = stx i* signal_follow+ etx;
signal_follow = signal i*;
