
module dataflow(out, In);
output out;
input [3:0] In;
wire [1:0] W;

assign W[0] = In[0] && In[1];
assign W[1] = In[2] && In[3];
assign out = W[0] || W[1]; 
/*
assign out = In[0] ^ In[1]; // this is xor gate
assign out = In[0] ~^ In[1]; // this is xnor gate
assign out = In[0] ~& In[1]; // this is nand gate
assign out = In[0] ~| In[1]; // this is nor gate
assign out = ~W[0]; // this is not gate


Arthematic Operation:
module arthematic_operations (out1, out2, A, B);
output [7:0] out1;
output [4:0] out2;
input [3:0] A;
input [3:0] B;

assign out1 = A * B; //multiplication
assign out2 = A + B; //addition
assign out2 = A - B; //subtraction
assign out2 = A % B; //modulus
assign out2 = A / B; //devision
assign out2 = A ** B; //expomemt


Relation Operation:
> : greater than
< : less then
>= : greater than or equal
<= : less then or equal
== : equality sign
!= : inequality sign
=== : case equality sign
!== : case inequality sign


Bitwise Operation:
output [3:0] out3;
input [3:0] A, B;

assign out3 = A & B; //bitwise AND
assign out3 = A | B; //bitwise OR
assign out3 = A ^ B; //bitwise XOR
assign out3 = A ~^ B; //bitwise XNOR


Concatnation Operation:
module concat_adder(carry, sum, A, B);
output carry, sum;
input A, B;

assign {carry, sum} = A + B;

Replication Operation
reg A;
reg [1:0] B, C;
reg [2:0] D;
A = 1'b1;
B = 2'b00;
C = 2'b10;
D = 3'b110;

Y = {4{A}}; // 1111
Y = {4{A}, 2{B}}; // 11110000
Y = {4{A}, 2{B}, C} // 11110000110
*/
endmodule
