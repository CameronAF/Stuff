
module first_circuit(F, A, B, C, D);
output F;
input A, B, C, D;
wire G, H;

and C1(G, A, B);
and C2(H, C, D);
or C3(F, G, H);
endmodule
/*
module first_circuit(F, In);
output F;
input [3:0] In;
wire [1:0] W;

and C1(W[0], In[0], In[1]);
and C2(W[1], In[2], In[3]);
or C3(F, W[0], W[1]);
endmodule;
*/