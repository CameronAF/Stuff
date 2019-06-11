module Mut8_1(Out, In, sel);
output Out;
input [7:0] In;
input [2:0] sel;
wire [1:0] W;

Mut4_1 M1(W[0], In[3:0], sel[1:0]);
Mut4_1 M2(W[1], In[7:4], sel[1:0]);
Mut2_1 M3(Out, W, sel[2]);
endmodule
