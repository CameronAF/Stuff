module HalfAdder(Sum, Carry, A, B);
output Sum, Carry;
input A, B;

xor C1(Sum, A, B);
and C2(Carry, A, B);
endmodule
