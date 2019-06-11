module FullAdder(Sum, Carry, A, B, C);
output Sum, Carry;
input A, B, C;
wire [2:0] W;

xor C1(Sum, A, B, C);
and C2(W[0], A, B);
and C3(W[1], A, C);
and C4(W[2], B, C);
or C5(Carry, W[0], W[1], W[2]);
endmodule
