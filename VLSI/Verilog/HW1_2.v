module Mut4_1(Out, In, sel);
output Out;
input [3:0] In;
input [1:0] sel;
wire [1:0] W;

Mut2_1 M1(W[0], In[1:0], sel[0]);
Mut2_1 M2(W[1], In[3:2], sel[0]);
Mut2_1 M3(Out, W, sel[1]);
endmodule
