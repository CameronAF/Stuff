module Mut2_1(Out, In, sel);
output Out;
input [1:0] In;
input sel;
wire [1:0] W;

and C1(W[0], In[0], (~sel));
and C2(W[1], In[1], sel);
or C3(Out, W[0], W[1]);
endmodule
